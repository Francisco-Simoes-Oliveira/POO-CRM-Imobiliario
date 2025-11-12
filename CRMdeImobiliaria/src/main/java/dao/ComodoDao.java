package dao;

import modelo.Comodos;
import modelo.Imovel;

public class ComodoDao extends DaoImplementacao<Comodos,Long> {
    public ComodoDao() {
        super(Comodos.class);
    }
}
