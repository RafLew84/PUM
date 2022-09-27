package pl.udu.uwr.pum.verynobleappjava.ui.fragments.laureate;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.LaureateResponse;
import pl.udu.uwr.pum.verynobleappjava.repository.NobelRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaureateViewModel extends ViewModel {
    private final NobelRepository repository = new NobelRepository();
    private final MutableLiveData<LaureateResponse> laureate = new MutableLiveData<>();

    private final String TAG = "LaureateViewModel";

    public void getLaureate(String id){
        Call<LaureateResponse> call = repository.getLaureate(id);

        call.enqueue(new Callback<LaureateResponse>() {
            @Override
            public void onResponse(@NonNull Call<LaureateResponse> call, @NonNull Response<LaureateResponse> response) {
                if (response.isSuccessful()){
                    LaureateResponse laureateResponse = response.body();
                    if (laureateResponse != null)
                        laureate.postValue(laureateResponse);
                }
            }

            @Override
            public void onFailure(@NonNull Call<LaureateResponse> call, @NonNull Throwable t) {
                Log.e(TAG, "error: " + t.getMessage() + "at " + TAG);
            }
        });
    }

    public LiveData<LaureateResponse> getLaureate() {
        return laureate;
    }
}
