package Cadastro.dao.Generic;

import Cadastro.domain.Cliente.Cliente;
import Cadastro.domain.IPersistente;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class GenericDAO<T extends IPersistente> implements IGenericDAO<T>{

    protected Map<Class, Map<Long, T>> map;

    public abstract Class<T> getTipoClasse();

    public abstract void atualizarDados(T entity, T entityCadastrado);

    public GenericDAO() {
        if (this.map == null) {
            this.map = new HashMap<>();
        }

    }

    @Override
    public Boolean cadastrar(T entity) {
        Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
        if (mapaInterno.containsKey(entity.getCodigo())) {
            return false;
        }
        mapaInterno.put(entity.getCodigo(), entity);
        return true;
    }

    @Override
    public boolean excluir(String valor) {
        Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
        for (Map.Entry<Long, T> entry : mapaInterno.entrySet()) {
            T objetoCadastrado = entry.getValue();
            if (objetoCadastrado instanceof Cliente) {
                Cliente cliente = (Cliente) objetoCadastrado;

                if (cliente.getCpf().equals(valor)) {
                    mapaInterno.remove(entry.getKey());
                    break;
                }
            }
        }
        return false;
    }

    @Override
    public void alterar(T entity) {
        Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
        T objetoCadastrado = mapaInterno.get(entity.getCodigo());
        if (objetoCadastrado != null) {
            atualizarDados(entity, objetoCadastrado);
        }
    }

    @Override
    public T consultar(Long valor) {
        Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
        return mapaInterno.get(valor);
    }

    @Override
    public Collection<T> buscarTodos() {
        Map<Long, T> mapaInterno = this.map.get(getTipoClasse());
        return mapaInterno.values();
    }
}
