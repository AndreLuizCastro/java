package com.teste.teste.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.teste.model.Produto;
import com.teste.teste.services.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController 
{
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List <Produto> obterTProdutos()
   {
    return produtoService.ObterTodos();
   }
}
