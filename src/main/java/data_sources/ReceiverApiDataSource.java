package data_sources;

import models.Receiver;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

public interface ReceiverApiDataSource {
    @POST("inRudius")
    Call<List<Receiver>> listRepos(@Body String user);
}