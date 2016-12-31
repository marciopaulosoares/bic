package br.com.marciopaulo.bic;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


import br.com.marciopaulo.bic.adapter.IndicadorAdapter;
import br.com.marciopaulo.bic.adapter.TematicaAdapter;
import br.com.marciopaulo.bic.api.AnoAPI;

import br.com.marciopaulo.bic.helpers.ConverterHelper;
import br.com.marciopaulo.bic.helpers.DialogHelper;
import br.com.marciopaulo.bic.helpers.ProgressDialogHelper;
import br.com.marciopaulo.bic.model.AnoModel;
import br.com.marciopaulo.bic.model.Indicador;
import br.com.marciopaulo.bic.model.Tema;
import br.com.marciopaulo.bic.util.Constantes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BuscaDemograficaActivity extends AppCompatActivity implements Callback<AnoModel> {


    ListView lvItens;
    Dialog dialog;

    ArrayList<Integer> tematicasSelecionadas = new ArrayList<>();
    ArrayList<Integer> indicadoresSelecionados=new ArrayList<>();
    ArrayList<Integer> anosSelecionados=new ArrayList<>();

    Retrofit retrofit;

    WindowManager.LayoutParams layoutParams;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        tematicasSelecionadas= new ArrayList<>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_busca_demografica);
        layoutParams= new WindowManager.LayoutParams();
        dialog = new Dialog(this);

        retrofit= new Retrofit
                        .Builder()
                        .baseUrl(Constantes.URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);
    }

    public void loadTematicas(View view) {


        dialog.setContentView(R.layout.item_info);
        dialog.setTitle("Temáticas");
        dialog.getWindow().getAttributes().width = layoutParams.width;
        dialog.getWindow().getAttributes().height = layoutParams.height;

        lvItens = (ListView) dialog.findViewById(R.id.lvItens);
        lvItens.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        TematicaAdapter adapter = new TematicaAdapter();
        lvItens.setAdapter(adapter.Carregar(getBaseContext()));

        for(int i=0; i< lvItens.getCount(); i++){
            Tema tema =(Tema) lvItens.getItemAtPosition(i);
            for(int id :tematicasSelecionadas){
                if(id ==tema.getId()){

                    lvItens.setItemChecked(i,true);
                }
            }
        }



        Button btnLimpar=(Button) dialog.findViewById(R.id.btnLimpar);
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            if (lvItens.getCheckedItemCount() > 0) {

                SparseBooleanArray checked = lvItens.getCheckedItemPositions();

                for (int i = 0; i < checked.size(); i++) {
                    if (checked.valueAt(i)) {
                        int position = checked.keyAt(i);

                        lvItens.setItemChecked(i,false);
                    }
                }
                tematicasSelecionadas= new ArrayList<Integer>();
            }
            }
        });


        Button btnFechar = (Button) dialog.findViewById(R.id.btnFechar);
        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<Integer> selecionados = new ArrayList<Integer>();
                if (lvItens.getCheckedItemCount() > 0) {

                    SparseBooleanArray checked = lvItens.getCheckedItemPositions();

                    for (int i = 0; i < checked.size(); i++) {
                        if (checked.valueAt(i)) {
                            int position = checked.keyAt(i);
                            Tema tema = (Tema) lvItens.getItemAtPosition(position);
                            selecionados.add(tema.getId());
                        }
                    }

                    tematicasSelecionadas=selecionados;

                }

                dialog.dismiss();
            }
        });

        dialog.show();
    }


    public void loadIndicadores(View view) {


        if(tematicasSelecionadas ==null || tematicasSelecionadas.size() ==0){
            DialogHelper.MakeAlert(this,"Aviso","Selecione pelo menos uma temática.");
            return;
        }


        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();

        dialog.setContentView(R.layout.item_info);
        dialog.setTitle("Indicadores");

        dialog.getWindow().getAttributes().width=lp.width;
        dialog.getWindow().getAttributes().height=lp.height;

        lvItens=(ListView) dialog.findViewById(R.id.lvItens);
        lvItens.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        IndicadorAdapter adapter = new IndicadorAdapter();
        lvItens.setAdapter(adapter.Carregar(getBaseContext(),tematicasSelecionadas));

        Button btnFechar = (Button) dialog.findViewById(R.id.btnFechar);
        btnFechar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            ArrayList<Integer> selecionados = new ArrayList<Integer>();
            if (lvItens !=null && lvItens.getCheckedItemCount() > 0) {

                SparseBooleanArray checked = lvItens.getCheckedItemPositions();

                for (int i = 0; i < checked.size(); i++) {
                    if (checked.valueAt(i)) {
                        int position = checked.keyAt(i);
                        Indicador indicador = (Indicador) lvItens.getItemAtPosition(position);
                        selecionados.add(indicador.getId());
                    }
                }

                indicadoresSelecionados = selecionados;
            }

            dialog.dismiss();
        }});

        Button btnLimpar=(Button) dialog.findViewById(R.id.btnLimpar);
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (lvItens !=null && lvItens.getCheckedItemCount() > 0) {

                    SparseBooleanArray checked = lvItens.getCheckedItemPositions();

                    for (int i = 0; i < checked.size(); i++) {
                        if (checked.valueAt(i)) {
                            int position = checked.keyAt(i);

                            lvItens.setItemChecked(i,false);
                        }
                    }
                    indicadoresSelecionados = new ArrayList<Integer>();
                }
            }
        });

        dialog.show();


    }

    public void loadAnos(View view) {


        if(indicadoresSelecionados==null || indicadoresSelecionados.size()==0){

            DialogHelper.MakeAlert(this,"Aviso","Selecione pelo menos um indicador");
            return;
        }



        AnoAPI api = retrofit.create(AnoAPI.class);
        Call<AnoModel> call=api.getAnos(ConverterHelper.toIntArray(indicadoresSelecionados));
        call.enqueue(this);
        progressDialog= ProgressDialogHelper.Show(this,"Busca de Periodos","Buscando");
    }


    @Override
    public void onResponse(Call<AnoModel> call, Response<AnoModel> response) {

        progressDialog.dismiss();



        dialog.setContentView(R.layout.item_info);
        dialog.setTitle("Anos");
        dialog.getWindow().getAttributes().width = layoutParams.width;
        dialog.getWindow().getAttributes().height = layoutParams.height;

        lvItens = (ListView) dialog.findViewById(R.id.lvItens);
        lvItens.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        ArrayAdapter<Integer> adapter= new ArrayAdapter<Integer>(this,android.R.layout.select_dialog_multichoice,response.body().getAnos() );

        lvItens.setAdapter(adapter);
        dialog.show();

        Button btnFechar = (Button) dialog.findViewById(R.id.btnFechar);
        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ArrayList<Integer> selecionados = new ArrayList<Integer>();
                if (lvItens !=null && lvItens.getCheckedItemCount() > 0) {

                    SparseBooleanArray checked = lvItens.getCheckedItemPositions();

                    for (int i = 0; i < checked.size(); i++) {
                        if (checked.valueAt(i)) {
                            int position = checked.keyAt(i);
                            int ano = (int) lvItens.getItemAtPosition(position);
                            selecionados.add(ano);
                        }
                    }

                    anosSelecionados = selecionados;
                }

                dialog.dismiss();
            }});

        Button btnLimpar=(Button) dialog.findViewById(R.id.btnLimpar);
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (lvItens.getCheckedItemCount() > 0) {

                    SparseBooleanArray checked = lvItens.getCheckedItemPositions();

                    for (int i = 0; i < checked.size(); i++) {
                        if (checked.valueAt(i)) {
                            int position = checked.keyAt(i);

                            lvItens.setItemChecked(i,false);
                        }
                    }
                    anosSelecionados = new ArrayList<Integer>();
                }
            }
        });

    }

    @Override
    public void onFailure(Call<AnoModel> call, Throwable t) {
        progressDialog.dismiss();
        Toast.makeText(this,Constantes.ERRO_ACESSO, Toast.LENGTH_LONG).show();
    }

    public void buscar(View view) {

        if(indicadoresSelecionados.size() == 0|| anosSelecionados.size()==0){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Selecione pelo menos um indicador e um ano para pesquisar")
                    .setTitle("Aviso");

            AlertDialog dialog = builder.create();
            dialog.show();
            return;

        }

        Intent i = new Intent(this,ResultadoBuscaDemograficaActivity.class);
        i.putExtra(Constantes.INDICADORES,ConverterHelper.toIntArray(indicadoresSelecionados));
        i.putExtra(Constantes.ANOS,ConverterHelper.toIntArray(anosSelecionados));
        startActivity(i);
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
