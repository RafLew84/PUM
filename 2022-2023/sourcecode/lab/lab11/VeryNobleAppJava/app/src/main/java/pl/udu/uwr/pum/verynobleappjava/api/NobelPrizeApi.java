package pl.udu.uwr.pum.verynobleappjava.api;

import pl.udu.uwr.pum.verynobleappjava.data.laureateresponse.LaureateResponse;
import pl.udu.uwr.pum.verynobleappjava.data.nobelprizeresponse.NobelAwardsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NobelPrizeApi {
    @GET("2.1/nobelPrizes")
    Call<NobelAwardsResponse> getNobelPrizes(
            @Query("limit") int limit,
            @Query("sort") String sort,
            @Query("nobelPrizeYear") int yearFrom,
            @Query("yearTo") int yearTo,
            @Query("nobelPrizeCategory") String category
    );

    @GET("2.1/nobelPrizes")
    Call<NobelAwardsResponse> getNobelPrize(
            @Query("nobelPrizeYear") int year,
            @Query("nobelPrizeCategory") String category
    );

    @GET("2.1/laureate/{laureateID}")
    Call<LaureateResponse> getLaureates(@Path("laureateID") String id);
}
