package com.teste.teste.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.teste.teste.model.Produto;

@Repository
public class RepositorioProduto 
{
     /**metodo que retorna todos os produtos
     * 
     * @param id
     * @return
     */
    private ArrayList<Produto> produtos= new ArrayList<Produto>();
    private Integer ultimoId=0;

    public List <Produto> ObterTodos()
    {
        return produtos;
    }
    /**encotra o produto pelo id
     * 
     * @param id do produto será encontraado
     * @return produto
     */

    public Optional <Produto> ObterId(Integer id)
    {
        return produtos.stream().filter(produto ->produto.getId() == id).findFirst();
    }

    /**produtos a serem adicionados
     * 
     * @param produto
     * @return
     */
    public Produto adicionar (Produto produto)
    {
        ultimoId ++;
        produto.setId(ultimoId);
        produtos.add(produto);
        return produto;
    }
        /**metodo para deletar
         * 
         * @param id irá ser deletado
         */
    public void deletar (Integer id)
    {
        produtos.removeIf(produto-> produto.getId()==id);
    }

    /**metodo que atualiza o produto
     * 
     * @param produto
     * @return
     */

    public Produto atualizar(Produto produto)
    {
        Optional <Produto> ProdutoEncontrado =ObterId(produto.getId());
        if (ProdutoEncontrado.isEmpty())
        {
        throw new InputMismatchException("produto não encontrado");
        }
        deletar(produto.getId());
        produtos.add(produto);

        return produto;
    }
}
