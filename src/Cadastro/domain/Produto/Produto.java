package Cadastro.domain.Produto;


import Cadastro.domain.IPersistente;

public class Produto implements IPersistente {

    private Long codigo;
    private String nome;
    private double preco;
    private Integer quant;

    public Produto (Long codigo, String nome, double preco, Integer quant){
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quant = quant;
    }

    @Override
    public Long getCodigo() {
       return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Integer getQuant() {
        return quant;
    }

    public void setQuant(Integer quant) {
        this.quant = quant;
    }
}
