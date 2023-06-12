package Cadastro.dao.Produto;


import Cadastro.dao.Generic.IGenericDAO;
import Cadastro.domain.Produto.Produto;

import java.util.Collection;

public interface IProdutoDAO extends IGenericDAO<Produto> {
    public Boolean cadastrar(Produto produto);

    public boolean excluir(Long codigo);

    public void alterar(Produto produto);

    public Produto consultar(Long codigo);

    public Collection<Produto> buscarTodos();
}
