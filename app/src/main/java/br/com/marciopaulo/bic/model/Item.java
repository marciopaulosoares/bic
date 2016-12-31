package br.com.marciopaulo.bic.model;

/**
 * Created by marciopaulo on 11/10/16.
 */

public class Item {

    long id;
    String descricao;
    boolean selected = false;

    public Item(long id, String descricao, boolean selected) {
        this.id = id;
        this.descricao = descricao;
        this.selected = selected;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
