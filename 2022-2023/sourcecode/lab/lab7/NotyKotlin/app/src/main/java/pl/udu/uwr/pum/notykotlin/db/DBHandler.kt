package pl.udu.uwr.pum.notykotlin.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.graphics.Color
import pl.udu.uwr.pum.notykotlin.model.NoteModel
import java.time.LocalTime

class DBHandler(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_STUDENTS_TABLE = "CREATE TABLE " +
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
                ")"
        db.execSQL(CREATE_STUDENTS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $NOTES_TABLE")
        onCreate(db)
    }

    fun addNote(note: NoteModel) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.apply {
            put(COLUMN_TEXT, note.textNote)
            put(COLUMN_TIME, note.time.toString())
            put(COLUMN_COLOR, note.color)
        }
        db.insert(NOTES_TABLE, null, values)
        db.close()
    }

    val notes: List<NoteModel>
        get() {
            val notes = mutableListOf<NoteModel>()
            val db = this.readableDatabase
            val cursor = db.rawQuery("SELECT * FROM $NOTES_TABLE", null)
            if (cursor.moveToFirst()) {
                do {
                    notes.add(
                        NoteModel(
                            cursor.getInt(0),
                            cursor.getString(1),
                            LocalTime.parse(cursor.getString(2)),
                            cursor.getInt(3)
                        )
                    )
                } while (cursor.moveToNext())
            }
            db.close()
            cursor.close()
            return notes
        }

    fun getNote(id: Int): NoteModel? {
        var note: NoteModel? = null
        val db = this.readableDatabase
        val cursor =
            db.rawQuery("SELECT * FROM $NOTES_TABLE WHERE $COLUMN_ID = $id", null)
        if (cursor.moveToFirst()) {
            do {
                note = NoteModel(
                    cursor.getInt(0),
                    cursor.getString(1),
                    LocalTime.parse(cursor.getString(2)),
                    cursor.getInt(3)
                )
            } while (cursor.moveToNext())
        }
        db.close()
        cursor.close()
        return note
    }

    fun updateNote(id: Int) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COLUMN_COLOR, Color.CYAN)
        db.update(
            NOTES_TABLE,
            contentValues,
            "$COLUMN_ID=$id",
            null
        )
        db.close()
    }

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "notesBDo.db"
        private const val NOTES_TABLE = "NotesTable"

        private const val COLUMN_ID = "_id"
        private const val COLUMN_TEXT = "text"
        private const val COLUMN_TIME = "time"
        private const val COLUMN_COLOR = "color"
    }
}
