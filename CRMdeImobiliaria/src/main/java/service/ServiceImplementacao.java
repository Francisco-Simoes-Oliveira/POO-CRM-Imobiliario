package service;

import dao.DaoGenerico;

import java.lang.reflect.InvocationTargetException;

public abstract class ServiceImplementacao<DAO extends DaoGenerico<T, ID>, T, ID> implements ServiceGenerico<DAO, T, ID> {

    protected DAO dao;

    public ServiceImplementacao(Class<DAO> daoClass) {
        try {
            this.dao = daoClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException("Erro ao instanciar DAO: " + daoClass.getSimpleName(), e);
        }
    }

}
