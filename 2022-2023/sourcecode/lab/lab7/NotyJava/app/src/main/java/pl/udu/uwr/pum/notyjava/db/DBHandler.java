package pl.udu.uwr.pum.notyjava.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.util.Log;

import androidx.annotation.Nullable;

import java.time.LocalTime;
import java.util.ArrayList;

import pl.udu.uwr.pum.notyjava.model.NoteModel;

public class DBHandler extends SQLiteOpenHelper {

    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "notesBDo.db";
    private static final String NOTES_TABLE = "NotesTable";

    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TEXT = "text";
    private static final String COLUMN_TIME = "time";
    private static final String COLUMN_COLOR = "color";

    public DBHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_STUDENTS_TABLE = "CREATE TABLE " +
                NOTES_TABLE +
                "(" +
                COLUMN_ID + " " +
                "INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                COLUMN_TEXT +
                " TEXT," +
                COLUMN_TIME +
                " TEXT," +
                COLUMN_COLOR +
                " INTEGER" +
                ")";

        db.execSQL(CREATE_STUDENTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + NOTES_TABLE);
        onCreate(db);
    }

    public void addNote(NoteModel note){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_TEXT, note.getTextNote());
        values.put(COLUMN_TIME, note.getTime().toString());
        values.put(COLUMN_COLOR, note.getColor());

        db.insert(NOTES_TABLE, null, values);
        db.close();
    }

    public ArrayList<NoteModel>  getNotes() {
        ArrayList<NoteModel> notes = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + NOTES_TABLE, null);

        if (cursor.moveToFirst()) {
            do {
                notes.add(new NoteModel(
                        cursor.getInt(0),
                        cursor.getString(1),
                        LocalTime.parse(cursor.getString(2)),
                        cursor.getInt(3)));
            } while (cursor.moveToNext());
        }

        db.close();
        cursor.close();
        return notes;
    }

    public NoteModel getNote(int id) {
        NoteModel note = null;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + NOTES_TABLE + " WHERE " + COLUMN_ID + " = " + id, null);

        if (cursor.moveToFirst()) {
            do {
                note = new NoteModel(
                        cursor.getInt(0),
                        cursor.getString(1),
                        LocalTime.parse(cursor.getString(2)),
                        cursor.getInt(3));
            } while (cursor.moveToNext());
        }

        db.close();
        cursor.close();
        return note;
    }

    public void updateNote (int id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_COLOR, Color.CYAN);

        db.update(NOTES_TABLE,
                contentValues,
                COLUMN_ID + "=" + id,
                null);

        db.close();
    }
}
