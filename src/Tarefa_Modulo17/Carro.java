package Tarefa_Modulo17;

public class Carro<T> {
    private final String modelo;
    private final T nome;
    protected Carro(String modelo, T nome) {
        this.modelo = modelo;
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public T getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return modelo + " - " + nome.toString();
    }
}
