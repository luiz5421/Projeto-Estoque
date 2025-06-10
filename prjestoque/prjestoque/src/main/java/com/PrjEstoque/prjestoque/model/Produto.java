
package com.PrjEstoque.prjestoque.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Produto {
    private int id, quantidade;
    private float valor;
    private String nome, categoria;

    public Produto(){}

    //CADASTRO
    public Produto(String nome,float valor, String categoria,  int quantidade) {
        this.categoria = categoria;
        this.nome = nome;
        this.quantidade = quantidade;
        this.valor = valor;
    }
    
    //Mostrar
    public Produto(int id,String nome,float valor, String categoria,  int quantidade) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public static Produto converter(Map<String, Object> registro) {
    int id = (Integer) registro.get("id");
    String nome = (String) registro.get("nome");
    float valor = ((Number) registro.get("valor")).floatValue();
    String categoria = (String) registro.get("categoria");
    int quantidade = (Integer) registro.get("quantidade");

    return new Produto(id,nome,valor,categoria, quantidade);
    }

    public static List<Produto> converterVarios(List<Map<String,Object>> registros){
        ArrayList<Produto> lista = new ArrayList<Produto>();
        for(Map<String,Object> reg : registros){
            lista.add(converter(reg));
        }
        return lista;
    }
}
