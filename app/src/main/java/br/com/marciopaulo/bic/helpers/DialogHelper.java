package br.com.marciopaulo.bic.helpers;

import android.content.Context;
import android.support.v7.app.AlertDialog;

/**
 * Created by marci on 31/12/2016.
 */

public class DialogHelper {

    public static void MakeAlert(Context context, String titulo, String mensagem){

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(mensagem)
                .setTitle(titulo);

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
