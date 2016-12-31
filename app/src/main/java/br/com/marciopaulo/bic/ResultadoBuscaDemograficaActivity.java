package br.com.marciopaulo.bic;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import br.com.marciopaulo.bic.api.BuscaDemograficaAPI;
import br.com.marciopaulo.bic.helpers.ProgressDialogHelper;
import br.com.marciopaulo.bic.helpers.TableCellHelper;
import br.com.marciopaulo.bic.model.DadoDemografico;
import br.com.marciopaulo.bic.util.Constantes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResultadoBuscaDemograficaActivity extends AppCompatActivity implements Callback<List<DadoDemografico>> {

    private TableLayout summaryTable;
    private TableLayout frozenTable;
    private TableLayout contentTable;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_busca_demografica);


        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        if(bundle.getIntArray(Constantes.INDICADORES) !=null && bundle.getIntArray(Constantes.ANOS)!=null){
            Buscar(bundle.getIntArray(Constantes.INDICADORES),bundle.getIntArray(Constantes.ANOS));
        }
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);

    }

    public  void Buscar(int[] indicadores, int[] anos){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        BuscaDemograficaAPI api = retrofit.create(BuscaDemograficaAPI.class);
        Call<List<DadoDemografico>> call = api.buscar(indicadores,anos);
        call.enqueue(this);

        progressDialog= ProgressDialogHelper.Show(this,"Busca Dados Demográficos","Buscando");
    }

    private void PopularTabela(List<DadoDemografico> dadosList) {

        try{
                if(dadosList.size() > 0){

                int[] anos=dadosList.get(0).getAnos();
                Arrays.sort(anos);

                TableLayout tbIndicador = (TableLayout) this.findViewById(R.id.tbIndicador);
                tbIndicador.setPadding(Constantes.TABELA_PADDING,Constantes.TABELA_PADDING,Constantes.TABELA_PADDING,Constantes.TABELA_PADDING);


                TableRow tr = new TableRow(this);
                tr.addView(TableCellHelper.createBoldCell(this," "));
                tr.addView(TableCellHelper.createBoldCell(this," "));
                tr.addView(TableCellHelper.createBoldCell(this," "));
                tr.addView(TableCellHelper.createBoldCell(this,"UNIDADE"));

                for(int ano:anos){
                    tr.addView(TableCellHelper.createBoldCell(this,Integer.toString(ano)));
                }
                tr.addView(TableCellHelper.createBoldCell(this,"FONTE"));
                tbIndicador.addView(tr);


                for(DadoDemografico dado:dadosList){
                    TableRow tr2 = new TableRow(this);
                    tr2.addView(TableCellHelper.createCell(this,dado.getTema()));
                    tr2.addView(TableCellHelper.createCell(this,dado.getSubTema()));
                    tr2.addView(TableCellHelper.createCell(this,dado.getIndicador().getNome()));
                    tr2.addView(TableCellHelper.createCenterCell(this,dado.getIndicador().getUnidade()));

                    for(DadoDemografico.Dados d :dado.getDados()){

                        tr2.addView(TableCellHelper.createCell(this,d.getValor()));
                    }
                    tr2.addView(TableCellHelper.createCell(this,dado.getIndicador().getFonte()));
                    tbIndicador.addView(tr2);
                }
            }
        }catch (Exception ex){
            Toast.makeText(this,Constantes.ERRO_ACESSO,Toast.LENGTH_LONG).show();
        }
    }



    @Override
    public void onResponse(Call<List<DadoDemografico>> call, Response<List<DadoDemografico>> response) {
        PopularTabela(response.body());
        progressDialog.dismiss();
    }

    @Override
    public void onFailure(Call<List<DadoDemografico>> call, Throwable t) {
        Toast.makeText(this,Constantes.ERRO_ACESSO,Toast.LENGTH_LONG).show();
        progressDialog.dismiss();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
