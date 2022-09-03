package pl.udu.uwr.pum.roombasicsjava.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import pl.udu.uwr.pum.roombasicsjava.model.Word;
import pl.udu.uwr.pum.roombasicsjava.model.WordRoomDatabase;

public class WordViewModel extends AndroidViewModel {

    private final WordRoomDatabase db;

    private final LiveData<List<Word>> allWords;

    public WordViewModel (Application application) {
        super(application);
        db = WordRoomDatabase.getDatabase(application);
        allWords = db.wordDao().getAlphabetizedWords();
    }

    public LiveData<List<Word>> getAllWords() { return allWords; }

    public void insert(Word word) {
        WordRoomDatabase.databaseWriteExecutor.execute(() -> db.wordDao().insert(word));
    }
}
