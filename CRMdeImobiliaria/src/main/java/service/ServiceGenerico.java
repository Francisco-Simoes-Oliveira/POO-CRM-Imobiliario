package service;

import modelo.Cliente;

import java.util.List;

public interface ServiceGenerico<DAO,T,ID> {
    void add(T objeto);
    void add(List<T> objetos);
    void alter(T objeto);

    List<T> buscarTodos();
    T buscaPorId(ID id);
    T buscarPorNome(String nome);
}
