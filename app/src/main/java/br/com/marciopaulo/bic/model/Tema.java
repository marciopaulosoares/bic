package br.com.marciopaulo.bic.model;

/**
 * Created by marci on 21/12/2016.
 */

public class Tema {
    public final static String NOME_TABELA              ="tema";
    public final static String COLUNA_ID                ="_id";
    public final static String COLUNA_DESCRICAO         ="descricao";
    public final static String COLUNA_TEMA_PAI_ID       ="temaPaiID";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTemaPaiID() {
        return temaPaiID;
    }

    public void setTemaPaiID(int temaPaiID) {
        this.temaPaiID = temaPaiID;
    }

    private int id;
    private String descricao;
    private int temaPaiID;

    @Override
    public String toString() {
        return descricao;
    }
}
