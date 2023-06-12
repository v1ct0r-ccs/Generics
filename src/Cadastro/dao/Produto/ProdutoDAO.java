package Cadastro.dao.Produto;

import Cadastro.dao.Generic.GenericDAO;

import Cadastro.domain.Cliente.Cliente;
import Cadastro.domain.Produto.Produto;

import java.util.HashMap;
import java.util.Map;

import static javax.swing.UIManager.get;


public class ProdutoDAO extends GenericDAO<Produto> implements IProdutoDAO  {

    public ProdutoDAO() {
        super();
        Map<Long, Produto> mapaInterno = this.map.get(getTipoClasse());
        if (mapaInterno == null) {
            mapaInterno = new HashMap<>();
            this.map.put(getTipoClasse(), mapaInterno);
        }
    }

    @Override
    public Class<Produto> getTipoClasse() {
        return Produto.class;
    }

    @Override
    public void atualizarDados(Produto entity, Produto entityCadastrado) {
        if (entityCadastrado != null && entity.getCodigo().equals(entityCadastrado.getCodigo())) {
            entityCadastrado.setNome(entity.getNome());
            entityCadastrado.setPreco(entity.getPreco());
            entityCadastrado.setQuant(entity.getQuant());
        }
    }

    @Override
    public boolean excluir(Long codigo) {
        Map<Long, Produto> mapaInterno = this.map.get(getTipoClasse());
        Produto produto = mapaInterno.remove(codigo);
        return produto != null;
    }

    @Override
    public Produto consultar(Long codigo) {
        Map<Long, Produto> mapaInterno = this.map.get(getTipoClasse());
        return mapaInterno.get(codigo);
    }
}
