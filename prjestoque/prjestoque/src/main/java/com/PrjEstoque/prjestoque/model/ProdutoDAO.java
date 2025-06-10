

package com.PrjEstoque.prjestoque.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class ProdutoDAO {

    @Autowired //CONSTROI AUTOMATICAMENTE
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}

    public void inserirProduto(Produto prod){
        String sql = "INSERT INTO produto(nome,valor,categoria,quantidade) VALUES(?,?,?,?)";
        Object[] parametros = new Object[4]; //Um para cada ?
        parametros[0] = prod.getNome();
        parametros[1] = prod.getValor();
        parametros[2] = prod.getCategoria();
        parametros[3] = prod.getQuantidade();
        jdbc.update(sql,parametros);
    }

    public List<Map<String,Object>> puxarTodosProdutos(){
        String sql = "SELECT * FROM produto;";
        return jdbc.queryForList(sql);
    }

    public Map<String,Object> puxarProduto(int id){
        String sql = "SELECT * from produto WHERE id = ?";
        return jdbc.queryForMap(sql, id);
    }

    public void atualizarProduto(int id, Produto novo){
        String sql = "UPDATE produto SET nome = ?, valor = ?, categoria = ?, quantidade = ? WHERE id = ?";
        Object[] parametros = new Object[5];
        parametros[0] = novo.getNome();
        parametros[1] = novo.getValor();
        parametros[2] = novo.getCategoria();
        parametros[3] = novo.getQuantidade();
        parametros[4] = id;
        jdbc.update(sql,parametros);
    }

    public void deletar(int id){
        String sql = "DELETE FROM produto WHERE id = ?";
        jdbc.update(sql,id);
    }

}
