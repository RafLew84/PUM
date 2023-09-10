package com.example.roombasicsjava.util;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutors {
    private static final Object LOCK = new Object();
    private static AppExecutors instance;
    private final Executor dbIO;

    private AppExecutors(Executor dbIO) {
        this.dbIO = dbIO;
    }

    public static AppExecutors getInstance() {
        if (instance == null) {
            synchronized (LOCK) {
                instance = new AppExecutors(Executors.newSingleThreadExecutor());
            }
        }
        return instance;
    }

    public Executor dbIO() {
        return dbIO;
    }
}
