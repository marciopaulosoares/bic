package br.com.marciopaulo.bic.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.marciopaulo.bic.model.Indicador;
import br.com.marciopaulo.bic.model.Item;
import br.com.marciopaulo.bic.model.Tema;

/**
 * Created by marci on 23/11/2016.
 */

public class TematicaDao {

    private SQLiteDatabase db;
    public static String createTable(){
        return  "CREATE TABLE "+ Tema.NOME_TABELA +" ("
                + Tema.COLUNA_ID +" INTEGER , "
                + Tema.COLUNA_DESCRICAO + " TEXT, "
                + Tema.COLUNA_TEMA_PAI_ID + " INTEGER); ";
    }
    public static String Carga(){
        String sql="INSERT INTO tema (_id, descricao, temaPaiID) VALUES (1, 'Demografia', NULL);";
        sql+="INSERT INTO tema (_id, descricao, temaPaiID) VALUES (2, 'Educação', NULL);";
        sql+="INSERT INTO tema (_id, descricao, temaPaiID) VALUES (3, 'Saúde', NULL);";
        sql+="INSERT INTO tema (_id, descricao, temaPaiID) VALUES (4, 'Economia', NULL);";
        sql+="INSERT INTO tema (_id, descricao, temaPaiID) VALUES (5, 'Meio-Ambiente', NULL);";
        sql+="INSERT INTO tema (_id, descricao, temaPaiID) VALUES (6, 'Qualidade de Vida e Segurança', NULL);";
        sql+="INSERT INTO tema (_id, descricao, temaPaiID) VALUES (7, 'População', 1);";
        sql+="INSERT INTO tema (_id, descricao, temaPaiID) VALUES (8, 'Migração', 1);";
        sql+="INSERT INTO tema (_id, descricao, temaPaiID) VALUES (9, 'Religião', 1);";
        sql+="INSERT INTO tema (_id, descricao, temaPaiID) VALUES (10, 'Educação Infantil', 2);";
        sql+="INSERT INTO tema (_id, descricao, temaPaiID) VALUES (11, 'Educação Fundamental I', 2);";
        sql+="INSERT INTO tema (_id, descricao, temaPaiID) VALUES (12, 'Educação Fundamental II', 2);";
        sql+="INSERT INTO tema (_id, descricao, temaPaiID) VALUES (13, 'Ensino Médio', 2);";
        sql+="INSERT INTO tema (_id, descricao, temaPaiID) VALUES (14, 'Ensino Superior', 2);";
        sql+="INSERT INTO tema (_id, descricao, temaPaiID) VALUES (15, 'Ensino de Jovens e Adultos', 2);";
        sql+="INSERT INTO tema (_id, descricao, temaPaiID) VALUES (16, 'Rede Assistencial', 3);";
        sql+="INSERT INTO tema (_id, descricao, temaPaiID) VALUES (17, 'Estatísticas Vitais e Mortalidade', 3);";
        sql+="INSERT INTO tema (_id, descricao, temaPaiID) VALUES (18, 'Epidemiológicas e Morbidade', 3);";
        sql+="INSERT INTO tema (_id, descricao, temaPaiID) VALUES (19, 'Recursos Humanos', 3);";
        sql+="INSERT INTO tema (_id, descricao, temaPaiID) VALUES (20, 'Mercado de Trabalho', 4);";
        sql+="INSERT INTO tema (_id, descricao, temaPaiID) VALUES (21, 'Produto Interno Bruto', 4);";
        sql+="INSERT INTO tema (_id, descricao, temaPaiID) VALUES (23, 'Qualidade do Ar', 5);";
        sql+="INSERT INTO tema (_id, descricao, temaPaiID) VALUES (25, 'Resíduos sólidos', 5);";
        sql+="INSERT INTO tema (_id, descricao, temaPaiID) VALUES (26, 'Saneamento', 5);";
        sql+="INSERT INTO tema (_id, descricao, temaPaiID) VALUES (27, 'IDH desagregado', 6);";
        sql+="INSERT INTO tema (_id, descricao, temaPaiID) VALUES (28, 'Índice de Gini', 6);";
        sql+="INSERT INTO tema (_id, descricao, temaPaiID) VALUES (29, 'Domicílios pobres', 6);";
        sql+="INSERT INTO tema (_id, descricao, temaPaiID) VALUES (30, 'Infraestrutura domiciliar', 6);";
        sql+="INSERT INTO tema (_id, descricao, temaPaiID) VALUES (31, 'Segurança', 6);";

        return  sql;

    }

    public List<Tema> Listar() {
        List<Tema> tematicas = new ArrayList<>();

        Cursor cursor;
        String[] campos = {Tema.COLUNA_ID, Tema.COLUNA_DESCRICAO, Tema.COLUNA_TEMA_PAI_ID};
        String orderBy= Tema.COLUNA_DESCRICAO + " ASC";

        db = DatabaseManager.getInstance().openDatabase(true);

        cursor = db.query(Tema.NOME_TABELA, campos, null, null, null, null, orderBy, null);

        if (cursor != null) {
            if(cursor.moveToFirst()){
                do {
                    Tema tema = new Tema();

                    tema.setId(cursor.getInt(cursor.getColumnIndex(Tema.COLUNA_ID)));
                    tema.setDescricao(cursor.getString(cursor.getColumnIndex(Tema.COLUNA_DESCRICAO)));

                    if(!cursor.isNull(cursor.getColumnIndex(Tema.COLUNA_TEMA_PAI_ID))){
                        tema.setTemaPaiID(cursor.getInt(cursor.getColumnIndex(Tema.COLUNA_TEMA_PAI_ID)));
                    }

                    tematicas.add(tema);


                } while(cursor.moveToNext());
            }
        }
        DatabaseManager.getInstance().closeDatabase();
        return tematicas;
    }
}
