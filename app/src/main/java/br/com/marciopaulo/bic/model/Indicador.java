package br.com.marciopaulo.bic.model;

/**
 * Created by marci on 21/12/2016.
 */

public class Indicador {

    public final static String NOME_TABELA  ="indicador";
    public final static String COLUNA_ID           ="_id";
    public final static String COLUNA_NOME       ="nome";
    public final static String COLUNA_TEMA_ID        ="temaID";

    private  int id;
    private int temaID;
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTemaID() {
        return temaID;
    }

    public void setTemaID(int temaID) {
        this.temaID = temaID;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
