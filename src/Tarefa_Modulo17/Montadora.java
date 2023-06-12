package Tarefa_Modulo17;

import java.util.ArrayList;
import java.util.List;

public class Montadora<T> {
    private final String marca;
    private final List<T> modelos;

    public Montadora(String marca) {
        this.marca = marca;
        this.modelos = new ArrayList<>();
    }

    public String getMarca() {
        return marca;
    }

    public List<T> getModelos() {
        return modelos;
    }

    public void addModelo(T modelo) {
        modelos.add(modelo);
    }
}
