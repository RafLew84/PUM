package pl.udu.uwr.pum.offlinecachingbasicsjava.data.remote;

import java.util.List;

import pl.udu.uwr.pum.offlinecachingbasicsjava.data.User;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RandomApi {
    @GET("users?size=20")
    Call<List<User>> users();
}
