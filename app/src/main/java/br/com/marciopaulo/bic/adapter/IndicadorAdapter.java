package br.com.marciopaulo.bic.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import br.com.marciopaulo.bic.dao.IndicadorDao;
import br.com.marciopaulo.bic.dao.TematicaDao;
import br.com.marciopaulo.bic.model.Indicador;
import br.com.marciopaulo.bic.model.Item;

/**
 * Created by marcio on 07/12/2016.
 */

public class IndicadorAdapter {

    public ArrayAdapter<Indicador> Carregar(
                                                    Context context,
                                                    ArrayList<Integer> temas
                                            )
    {
        IndicadorDao indicadorDao = new IndicadorDao();
        List<Indicador> i=  indicadorDao.Listar(temas);
        return new ArrayAdapter<Indicador>(context,android.R.layout.select_dialog_multichoice,i);
    }
}
