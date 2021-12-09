package com.wb.negocio;

import java.util.List;
import com.wb.modelo.ProdutoConsumido;

public class ListarProdutoConsumido extends Listagem {
    private List<ProdutoConsumido> produtosConsumidos;

    public ListarProdutoConsumido(List<ProdutoConsumido> produtosConsumidos) {
        this.produtosConsumidos = produtosConsumidos;
    }

    public void listar() {
        System.out.println("Lista de todos os serviços:");
		for (ProdutoConsumido produtoConsumido : produtosConsumidos) {
			System.out.println("Produto: " + produtoConsumido.getNome());
            System.out.println("Preço: " + produtoConsumido.getPreco());
		}
    }
}
