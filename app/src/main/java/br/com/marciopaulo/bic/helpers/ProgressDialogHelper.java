package br.com.marciopaulo.bic.helpers;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by marci on 30/12/2016.
 */

public class ProgressDialogHelper {

    public static ProgressDialog Show(Context context, String titulo, String mensagem){

        ProgressDialog progressDialog= new ProgressDialog(context);
        progressDialog.setTitle(titulo);
        progressDialog.setMessage(mensagem);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.show();
        return progressDialog;

    }
}
