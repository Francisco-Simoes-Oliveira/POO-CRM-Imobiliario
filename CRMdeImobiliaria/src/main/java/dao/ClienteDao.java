package dao;

import javax.persistence.*;
import modelo.Cliente;

import java.util.List;

public class ClienteDao extends DaoImplementacao<Cliente,Long>{
    public ClienteDao() {
        super(Cliente.class);
    }
}
