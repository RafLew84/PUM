package pl.udu.uwr.pum.verynobleappjava.repository;

import pl.udu.uwr.pum.verynobleappjava.api.RetrofitInstance;
import pl.udu.uwr.pum.verynobleappjava.data.NobelAwardsResponse;
import retrofit2.Call;

public class NobelRepository {
    public Call<NobelAwardsResponse> getNobelPrizes (
            int limit,
            String sort,
            int yearFrom,
            int yearTo,
            String category){
        return RetrofitInstance.getApi().getNobelPrizes(
                limit, sort, yearFrom, yearTo, category);
    }
}
