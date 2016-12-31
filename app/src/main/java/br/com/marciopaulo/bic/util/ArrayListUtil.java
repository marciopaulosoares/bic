package br.com.marciopaulo.bic.util;

import android.util.SparseBooleanArray;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.marciopaulo.bic.model.Item;

/**
 * Created by marci on 30/11/2016.
 */

public class ArrayListUtil {




    public static ArrayList<Object> ListViewToArrayList(ListView lista){
        ArrayList<Object> selecionados = new ArrayList<>();
        if (lista.getCheckedItemCount() > 0) {

            SparseBooleanArray checked= lista.getCheckedItemPositions();

            for (int i=0; i < checked.size(); i++){
                if(checked.valueAt(i)){
                    int position = checked.keyAt(i);
                    selecionados.add(lista.getItemAtPosition(position));
                }
            }
        }

        return  selecionados;
    }
}
