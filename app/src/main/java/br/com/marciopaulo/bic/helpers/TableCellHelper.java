package br.com.marciopaulo.bic.helpers;

import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.TextView;

import br.com.marciopaulo.bic.R;
import br.com.marciopaulo.bic.util.Constantes;

/**
 * Created by marci on 30/12/2016.
 */

public class TableCellHelper {

    public static TextView createCenterCell(Context context,String texto){
        TextView tv =createCell(context,texto);
        tv.setGravity(Gravity.CENTER);
        return  tv;
    }

    public static TextView createBoldCell(Context context,String texto){
        TextView tv =createCell(context,texto);
        tv.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
        return  tv;
    }

    public static TextView createCell(Context context, String texto){
        TextView tv = new TextView(context);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP,12);
        tv.setPadding(Constantes.CELULA_PADDING,Constantes.CELULA_PADDING,Constantes.CELULA_PADDING,Constantes.CELULA_PADDING);
        tv.setBackgroundResource(R.drawable.celula);
        tv.setText(texto);
        return tv;
    }
}
