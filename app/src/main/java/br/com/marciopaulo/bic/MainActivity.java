package br.com.marciopaulo.bic;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import br.com.marciopaulo.bic.dao.IndicadorDao;
import br.com.marciopaulo.bic.dao.TematicaDao;
import br.com.marciopaulo.bic.helpers.DialogHelper;
import br.com.marciopaulo.bic.helpers.NetworkHelper;

public class MainActivity extends AppCompatActivity {

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);

        if(!NetworkHelper.isAvailable(this)){

            DialogHelper.MakeAlert(this,"Aviso","É necessário estar conectado para pesquisar.");
        }

    }

    public void displayInfomacoesDemograficas(View view) {
        Intent i = new Intent(this, BuscaDemograficaActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mnNotasTecnicas) {

            startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.bic.osasco.sp.gov.br/Content/assets/upload/Glossario.pdf")));
        } else if (id == R.id.mnSobreMenu) {

            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
            dialog = new Dialog(this);
            dialog.setContentView(R.layout.sobrenos);
            dialog.setTitle("Sobre nós");
            dialog.getWindow().getAttributes().width = lp.width;
            dialog.getWindow().getAttributes().height = lp.height;
            dialog.show();

            Button btnFechar = (Button) dialog.findViewById(R.id.btnFechar);

            btnFechar.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
        }

        return super.onOptionsItemSelected(item);
    }
}