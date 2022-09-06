package pl.udu.uwr.pum.mvvmbasicsjava;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private final MutableLiveData<String> myData = new MutableLiveData<>();

    public LiveData<String> getMyData() {
        return myData;
    }

    public MyViewModel(){
        myData.setValue(getModel().getData());
    }

    private Model getModel() {
        return new Model("text", 1, 2);
    }
}
