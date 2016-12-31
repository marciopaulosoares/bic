package br.com.marciopaulo.bic.helpers;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import br.com.marciopaulo.bic.App;
import br.com.marciopaulo.bic.dao.IndicadorDao;
import br.com.marciopaulo.bic.dao.TematicaDao;
import br.com.marciopaulo.bic.model.Indicador;
import br.com.marciopaulo.bic.model.Tema;

/**
 * Created by marci on 21/12/2016.
 */

public class DBHelper extends SQLiteOpenHelper  {
    public static String NOME_BANCO="bic.db";
    public static int VERSAO_BANCO=3;
    private static App instance;

    public DBHelper() {

        super(App.getContext(), NOME_BANCO, null, VERSAO_BANCO);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(IndicadorDao.createTable());
        db.execSQL(TematicaDao.createTable());



        PopulaTabelas(db,IndicadorDao.Carga());
        PopulaTabelas(db,TematicaDao.Carga());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DELETE FROM "+ Indicador.NOME_TABELA);
        db.execSQL("DELETE FROM " + Tema.NOME_TABELA);

        PopulaTabelas(db,IndicadorDao.Carga());
        PopulaTabelas(db,TematicaDao.Carga());
    }


    void PopulaTabelas(SQLiteDatabase db, String sql){

        String[] sqlArray=sql.split(";");
        for (String q :sqlArray){
            db.execSQL(q);
        }

    }
}
