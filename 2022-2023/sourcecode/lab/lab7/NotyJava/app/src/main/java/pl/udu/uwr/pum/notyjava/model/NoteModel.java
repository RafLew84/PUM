package pl.udu.uwr.pum.notyjava.model;

import android.graphics.Color;

import java.time.LocalTime;

public class NoteModel {
    private int id = 0;
    private String textNote;
    private final LocalTime time;
    private int color = Color.BLACK;

    public NoteModel(String textNote, LocalTime date) {
        this.textNote = textNote;
        this.time = date;
    }

//    public NoteModel(int id, String textNote, LocalTime time) {
//        this(textNote, time);
//        this.id = id;
//    }

    public NoteModel(int id, String textNote, LocalTime time, int color) {
        this(textNote, time);
        this.id = id;
        this.color = color;
    }

    public String getTextNote() {
        return textNote;
    }

    public LocalTime getTime() {
        return time;
    }

    public int getId() {
        return id;
    }

    public void setTextNote(String textNote) {
        this.textNote = textNote;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
