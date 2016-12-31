package br.com.marciopaulo.bic.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.List;

import br.com.marciopaulo.bic.dao.TematicaDao;
import br.com.marciopaulo.bic.model.Item;
import br.com.marciopaulo.bic.model.Tema;

/**
 * Created by marci on 07/12/2016.
 */

public class TematicaAdapter {

    public ArrayAdapter<Tema> Carregar(Context context){
        TematicaDao tematicaDao = new TematicaDao();
        return new ArrayAdapter<Tema>(context,android.R.layout.select_dialog_multichoice,tematicaDao.Listar());
    }
}
