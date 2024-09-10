package domain;

import data_sources.ReceiverApiDataSource;
import models.InRadiusDto;
import models.Receiver;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

public class ReceiverService {
    final ReceiverApiDataSource receiverApiDataSource;

    private int currentPage = 0;
    private final int pageSize = 10;
    public ReceiverService(ReceiverApiDataSource receiverApiDataSource) {
        this.receiverApiDataSource = receiverApiDataSource;
    }

  public  void fetch(float latitude, float longitude, int radiusKm) throws IOException {
       int lastCount = 10;
        while(lastCount== pageSize) {
           InRadiusDto dto = new InRadiusDto(latitude, longitude, radiusKm, currentPage, 10);
           Call<List<Receiver>> repos = receiverApiDataSource.listRepos(dto.toString());
           Response<List<Receiver>> res = null;
           res = repos.execute();
           assert  res.body() != null;
           currentPage++;
           lastCount = res.body().size();
            for (Receiver receiver: res.body())
                 {
                     System.out.println(receiver);
            }
       }
        }
    }



