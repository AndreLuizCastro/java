package com.teste.teste.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.teste.model.Produto;
import com.teste.teste.repository.RepositorioProduto;
@Service
public class ProdutoService 
{
     @Autowired
     private RepositorioProduto RepositorioProduto;

     public List<Produto> ObterTodos()
     {
          return RepositorioProduto.ObterTodos();
     }

     public Produto adicionar (Produto produto)
     {
          return RepositorioProduto.adicionar(produto);
     }

     public void deletar(Integer id)
     {
          RepositorioProduto.deletar(id);
     }

     public Produto atualizar(Integer id,Produto produto)
     {
          produto.setId(id);
          return RepositorioProduto.atualizar(produto);
        
     }
}
