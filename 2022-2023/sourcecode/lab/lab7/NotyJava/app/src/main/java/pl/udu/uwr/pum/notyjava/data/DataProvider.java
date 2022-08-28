package pl.udu.uwr.pum.notyjava.data;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

import pl.udu.uwr.pum.notyjava.model.NoteModel;

public final class DataProvider {
    private DataProvider(){}

    public static final String[] data = {"notatka 1", "notatka 2", "notatka 3", "notatka 4", "notatka 5", "notatka 6", "notatka 7", "notatka 8", "notatka 9"};
    public static String s = "12:11";
    public static LocalTime localTime = LocalTime.parse(s);

    public static ArrayList<String> dummyData = new ArrayList<>(Arrays.asList(data));

    private static final NoteModel[] notes = {
            new NoteModel("notatka 1", LocalTime.of(12, 0)),
            new NoteModel("notatka 2", LocalTime.of(13, 0)),
            new NoteModel("notatka 3", LocalTime.of(21, 0)),
            new NoteModel("notatka 4", LocalTime.of(9, 9)),
            new NoteModel("notatka 5", LocalTime.of(22, 34)),
            new NoteModel("notatka 6", LocalTime.of(11, 22)),
            new NoteModel("notatka 7", localTime)
    };

    public static ArrayList<NoteModel> dummyData2 = new ArrayList<>(Arrays.asList(notes));
}
