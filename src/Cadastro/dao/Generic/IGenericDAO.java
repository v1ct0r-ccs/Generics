package Cadastro.dao.Generic;

import Cadastro.domain.IPersistente;

import java.util.Collection;

public interface IGenericDAO <T extends IPersistente> {
    public Boolean cadastrar(T entity);

    public boolean excluir(String valor);

    public void alterar(T entity);

    public T consultar(Long valor);

    public Collection<T> buscarTodos();
}