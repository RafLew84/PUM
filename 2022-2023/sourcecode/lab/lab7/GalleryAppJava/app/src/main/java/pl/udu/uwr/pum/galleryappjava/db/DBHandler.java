package pl.udu.uwr.pum.galleryappjava.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import pl.udu.uwr.pum.galleryappjava.model.PictureModel;

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "galleryDBJava";
    private static final String TABLE_GALLERY = "GalleryTablString";

    private static final String KEY_ID = "_id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_IMAGE = "image";

    private final Context context;

    public DBHandler(@Nullable Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_GALLERY_TABLE = "CREATE TABLE " +
                TABLE_GALLERY +
                "(" +
                KEY_ID + " " +
                "INTEGER PRIMARY KEY," +
                KEY_TITLE +
                " TEXT," +
                KEY_IMAGE +
                " TEXT" +
                ")";

        db.execSQL(CREATE_GALLERY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GALLERY);
        onCreate(db);
    }

    public long addToGallery(PictureModel singleItem){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_TITLE, singleItem.getTitle());
        contentValues.put(KEY_IMAGE, singleItem.getImage());

        long result = db.insert(TABLE_GALLERY, null, contentValues);
        db.close();
        return result;
    }

    public ArrayList<PictureModel> getAllItems(){
        ArrayList<PictureModel> itemList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_GALLERY;

        SQLiteDatabase db = this.getReadableDatabase();

        try{
            Cursor cursor = db.rawQuery(selectQuery, null);
            if(cursor.moveToFirst()){
                do{
                    PictureModel place = new PictureModel(
                            cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getString(2)
                    );
                    itemList.add(place);
                } while (cursor.moveToNext());
            }
            cursor.close();
        } catch (SQLiteException e){
            e.printStackTrace();
            return new ArrayList<>();
        }

        return itemList;
    }
}