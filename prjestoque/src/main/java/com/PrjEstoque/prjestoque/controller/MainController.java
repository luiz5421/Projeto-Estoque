package com.PrjEstoque.prjestoque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.PrjEstoque.prjestoque.model.Produto;
import com.PrjEstoque.prjestoque.model.ProdutoService;


@Controller
public class MainController {

    @Autowired
    ApplicationContext ctx;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/sucesso")
    public String sucesso(){
        return "sucesso";
    }

    @GetMapping("/formulario")
    public String form(Model model){
        //QUERO UM CLIENTE VAZIO NA INICIALIZACAO DO FORM
        model.addAttribute("produto", new Produto());
        model.addAttribute("titulo", "CADASTRO DE PRODUTOS");
        model.addAttribute("link", "/cadastro");
        model.addAttribute("valor", "Cadastrar");
        return "formulario";
    }
    @GetMapping("/editar/{id}")
    public String editar(Model model, @PathVariable int id){
        ProdutoService ps = ctx.getBean(ProdutoService.class);
        Produto velho = ps.puxarProduto(id);
        model.addAttribute("produto", velho);
        model.addAttribute("titulo", "EDITAR PRODUTOS");
        model.addAttribute("link", "/editar/" + id);
        model.addAttribute("valor", "Editar");
        return "formulario";
    }

    @PostMapping("/editar/{id}")
    public String editar(Model model, 
                         @ModelAttribute Produto prod, 
                         @PathVariable int id){
        ProdutoService ps = ctx.getBean(ProdutoService.class);
        ps.atualizarProduto(id, prod);
        return "redirect:/listar";
    }

    @PostMapping("/cadastro")
    public String cadastro(Model model, @ModelAttribute Produto prod){
        ProdutoService ps = ctx.getBean(ProdutoService.class);
        ps.inserirProduto(prod);
        return "redirect:listar";
    }

    @GetMapping("/listar")
    public String listar(Model model){
        ProdutoService ps = ctx.getBean(ProdutoService.class);
        List<Produto> lista = ps.puxarTodosProdutos();
        model.addAttribute("produtos", lista);
        return "listar";
    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable int id){
        ProdutoService ps = ctx.getBean(ProdutoService.class);
        ps.deletar(id);
        return "redirect:/listar";
    }

}
