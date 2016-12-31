package br.com.marciopaulo.bic.helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by marci on 11/12/2016.
 */

public class SqlHelper extends SQLiteOpenHelper {


    private static final String NOME_BANCO = "bic.db";
    private static final int VERSAO = 1;

    public SqlHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="CREATE TABLE AreaPonderacao (_id integer primary key autoincrement, descricao TEXT);";
        sql +="CREATE TABLE Secretaria (_id integer primary key autoincrement, nome,sigla);";
        sql+="CREATE TABLE Indicador(_id integer primary key autoincrement,nome TEXT, temaId INTEGER)";
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
