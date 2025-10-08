package dao;

import java.util.List;

public interface DaoGenerico<T,ID> {
    void add(T valor);
    void alter(T valor);
    List<T> buscaTodos();
    T buscaPorId(ID id);
    List<T> buscarPorNomePars(String nome);
    void removerPorId(ID id);
}
