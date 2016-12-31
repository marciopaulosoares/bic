package br.com.marciopaulo.bic.api;


import java.util.ArrayList;
import java.util.List;

import br.com.marciopaulo.bic.model.Ano;
import br.com.marciopaulo.bic.model.AnoModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by marci on 23/11/2016.
 */

public interface AnoAPI {

    @FormUrlEncoded
    //@POST("/Home/BuscarDatasJson/")
    @POST("5866614f1200001a09b7cc75")
    Call<AnoModel> getAnos(@Field("indicadores[]") int[] indicadores);
}
