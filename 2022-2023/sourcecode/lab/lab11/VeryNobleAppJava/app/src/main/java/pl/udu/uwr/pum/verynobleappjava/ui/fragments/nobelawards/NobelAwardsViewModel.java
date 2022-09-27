package pl.udu.uwr.pum.verynobleappjava.ui.fragments.nobelawards;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import pl.udu.uwr.pum.verynobleappjava.data.nobelprizeresponse.NobelAwardsResponse;
import pl.udu.uwr.pum.verynobleappjava.repository.NobelRepository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NobelAwardsViewModel extends ViewModel {
    private final NobelRepository repository = new NobelRepository();
    private final MutableLiveData<NobelAwardsResponse> nobelPrizes = new MutableLiveData<>();

    private final String TAG = "NobelAwardsViewModel";

    public NobelAwardsViewModel(){
        getNobelPrizes(200, "desc", 1901, 2022, "phy");
    }

    public void getNobelPrizes(
            int limit,
            String sort,
            int yearFrom,
            int yearTo,
            String category){
            Call<NobelAwardsResponse> call = repository.getNobelPrizes(
                    limit, sort, yearFrom, yearTo, category);

            call.enqueue(new Callback<NobelAwardsResponse>() {
                @Override
                public void onResponse(@NonNull Call<NobelAwardsResponse> call, @NonNull Response<NobelAwardsResponse> response) {
                    if (response.isSuccessful()){
                        NobelAwardsResponse nobelAwards = response.body();
                        if (nobelAwards != null)
                            nobelPrizes.postValue(nobelAwards);
                    }
                }

                @Override
                public void onFailure(@NonNull Call<NobelAwardsResponse> call, @NonNull Throwable t) {
                    Log.e(TAG, "error: " + t.getMessage() + "at " + TAG);
                }
            });
    }

    public LiveData<NobelAwardsResponse> getNobelPrizes() {
        return nobelPrizes;
    }
}
