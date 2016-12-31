package br.com.marciopaulo.bic.api;

import java.util.List;

import br.com.marciopaulo.bic.model.DadoDemografico;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface BuscaDemograficaAPI {
    //@GET("/home/BuscaDemograficaJson")
    @GET("586160c61000006b0df394f8")
    Call<List<DadoDemografico>> buscar(@Query("indicadores") int[] indicadores, @Query("anos") int... anos);
}
