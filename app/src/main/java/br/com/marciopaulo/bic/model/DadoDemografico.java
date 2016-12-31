package br.com.marciopaulo.bic.model;

import com.facebook.stetho.json.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by marci on 26/12/2016.
 */

public class DadoDemografico {


    private String tema;
    private String subTema;
    private Indicador indicador;
    private List<Dados> dados;
    private int[]anos;
    private int[]ids;

    public DadoDemografico() {
    }


    public String getTema() {
        return tema;
    }
    public void setTema(String tema) {
        this.tema = tema;
    }
    public String getSubTema() {
        return subTema;
    }
    public void setSubTema(String subTema) {
        this.subTema = subTema;
    }
    public Indicador getIndicador() {
        return indicador;
    }
    public void setIndicador(Indicador indicador) {
        this.indicador = indicador;
    }
    public List<Dados> getDados() {
        return dados;
    }
    public void setDados(List<Dados> dados) {
        this.dados = dados;
    }

    public int[] getAnos() {
        return anos;
    }

    public void setAnos(int[] anos) {
        this.anos = anos;
    }

    public int[] getIds() {
        return ids;
    }

    public void setIds(int[] ids) {
        this.ids = ids;
    }

    public class Dados{

        public int ano;
        public String valor;


        public int getAno() {
            return ano;
        }
        public void setAno(int ano) {
            this.ano = ano;
        }
        public String getValor() {
            return valor;
        }
        public void setValor(String valor) {
            this.valor = valor;
        }
    }

    public class Indicador{


        @SerializedName("ID")
        private int id;
        private String nome;
        private int periodicidadeId;
        private String fonte;
        private int tipo;
        private String  unidade;

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getNome() {
            return nome;
        }
        public void setNome(String nome) {
            this.nome = nome;
        }
        public int getPeriodicidadeId() {
            return periodicidadeId;
        }
        public void setPeriodicidadeId(int periodicidadeId) {
            this.periodicidadeId = periodicidadeId;
        }
        public String getFonte() {
            return fonte;
        }
        public void setFonte(String fonte) {
            this.fonte = fonte;
        }
        public int getTipo() {
            return tipo;
        }
        public void setTipo(int tipo) {
            this.tipo = tipo;
        }
        public String getUnidade() {
            return unidade;
        }
        public void setUnidade(String unidade) {
            this.unidade = unidade;
        }


    }
}
