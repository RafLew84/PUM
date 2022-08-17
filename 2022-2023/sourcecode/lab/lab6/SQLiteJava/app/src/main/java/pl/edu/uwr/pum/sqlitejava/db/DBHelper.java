package pl.edu.uwr.pum.sqlitejava.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import pl.edu.uwr.pum.sqlitejava.model.Student;

public class DBHelper extends SQLiteOpenHelper {

    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "studentsDBJava.db";
    private static final String TABLE_STUDENTS = "StudentTable";

    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_INDEX = "indexNumber";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_STUDENTS_TABLE = "CREATE TABLE " +
                TABLE_STUDENTS +
                "(" +
                COLUMN_ID + " " +
                "INTEGER PRIMARY KEY," +
                COLUMN_NAME +
                " TEXT," +
                COLUMN_INDEX +
                " INTEGER" +
                ")";

        db.execSQL(CREATE_STUDENTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);
        onCreate(db);
    }

    public void addStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, student.getName());
        values.put(COLUMN_INDEX, student.getIndex());

        db.insert(TABLE_STUDENTS, null, values);
        db.close();
    }

    public void deleteStudent(Student student){
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(
                TABLE_STUDENTS,
                COLUMN_ID + "=" + student.getId(),
                null);
        db.close();
    }

    public void updateStudent (int id, String name, int index){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_INDEX, index);

        db.update(TABLE_STUDENTS,
                contentValues,
                COLUMN_ID + "=" + id,
                null);

        db.close();
    }

    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_STUDENTS, null);

        if (cursor.moveToFirst()) {
            do {
                students.add(new Student(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2)));
            } while (cursor.moveToNext());
        }

        db.close();
        cursor.close();
        return students;
    }
}
