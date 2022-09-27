package pl.udu.uwr.pum.verynobleappjava.ui.fragments.nobelaward;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import pl.udu.uwr.pum.verynobleappjava.data.NobelAwardsResponse;
import pl.udu.uwr.pum.verynobleappjava.repository.NobelRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NobelAwardViewModel extends ViewModel {
    private final NobelRepository repository = new NobelRepository();
    private final MutableLiveData<NobelAwardsResponse> nobelPrize = new MutableLiveData<>();

    private final String TAG = "NobelAwardViewModel";

    public void getNobelPrize(
            int year,
            String category){
        Call<NobelAwardsResponse> call = repository.getNobelPrize(year, category);

        call.enqueue(new Callback<NobelAwardsResponse>() {
            @Override
            public void onResponse(@NonNull Call<NobelAwardsResponse> call, @NonNull Response<NobelAwardsResponse> response) {
                if (response.isSuccessful()){
                    NobelAwardsResponse nobelAwards = response.body();
                    if (nobelAwards != null)
                        nobelPrize.postValue(nobelAwards);
                }
            }

            @Override
            public void onFailure(@NonNull Call<NobelAwardsResponse> call, @NonNull Throwable t) {
                Log.e(TAG, "error: " + t.getMessage() + "at " + TAG);
            }
        });
    }

    public LiveData<NobelAwardsResponse> getNobelPrize() {
        return nobelPrize;
    }
}
