
package com.PrjEstoque.prjestoque.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    ProdutoDAO pdao;

    public void inserirProduto(Produto prod){
        pdao.inserirProduto(prod);
    }

    public List<Produto> puxarTodosProdutos(){
        return Produto.converterVarios(pdao.puxarTodosProdutos());
    }

    public void atualizarProduto(int id, Produto novo){
        pdao.atualizarProduto(id, novo);
    }

    public Produto puxarProduto(int id){
        return Produto.converter(pdao.puxarProduto(id));
    }

    public void deletar(int id){
        pdao.deletar(id);
    }

}
