package desenvolvimento.nassau.exemplo013;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulo on 21/03/2017.
 */

public class Produto {
    private String nome;
    private String descricao;
    private double valorUnitario;

    public Produto() {
    }

    public Produto(String nome, String descricao, double valorUnitario) {
        this.nome = nome;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public List<Produto> getProdutos()
    {
        List<Produto> produtos = new ArrayList<Produto>();
        produtos.add(new Produto("Lapis", "Serve para escrever", 1.23));
        produtos.add(new Produto("Caderno", "Onde se escreve", 4.23));
        produtos.add(new Produto("Borracha", "Apaga o que está escrito", 7.23));
        produtos.add(new Produto("Apontador", "Faz a ponta do lápis", 11.23));
        return produtos;
    }
}
