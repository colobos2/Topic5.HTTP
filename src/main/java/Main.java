import com.google.gson.Gson;
import data_sources.ReceiverApiDataSource;
import domain.ReceiverService;
import models.InRadiusDto;
import models.Receiver;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main (String[] args) throws IOException {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://receivers.api.ecohub.eco/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        System.out.println(retrofit);
        ReceiverApiDataSource receiverApiDataSource = retrofit.create(ReceiverApiDataSource.class);
        ReceiverService service = new ReceiverService(receiverApiDataSource);
        service.fetch(0,0,10000);
    }







}
