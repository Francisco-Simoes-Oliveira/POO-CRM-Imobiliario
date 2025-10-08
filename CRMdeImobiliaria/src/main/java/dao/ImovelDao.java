package dao;

import modelo.Imovel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ImovelDao extends DaoImplementacao<Imovel,Long> {
    public ImovelDao() {
        super(Imovel.class);
    }
}
