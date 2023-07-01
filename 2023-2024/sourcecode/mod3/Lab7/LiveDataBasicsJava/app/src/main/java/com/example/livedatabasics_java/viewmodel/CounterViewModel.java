package com.example.livedatabasics_java.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CounterViewModel extends ViewModel {
    private final MutableLiveData<Integer> counter = new MutableLiveData<>(0);

    public LiveData<Integer> getCounter() {
        return counter;
    }

    public void increase(){
        if (counter.getValue() != null)
            counter.setValue(counter.getValue() + 1);
    }

    public void decrease(){
        if (counter.getValue() != null)
            counter.setValue(counter.getValue() - 1);
    }

    public void clear(){
        if (counter.getValue() != null)
            counter.setValue(0);
    }
}
