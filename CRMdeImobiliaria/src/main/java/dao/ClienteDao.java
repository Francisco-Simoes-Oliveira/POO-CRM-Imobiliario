package dao;

import javax.persistence.*;
import modelo.Cliente;

import java.util.List;

public class ClienteDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaPU");

    public void add(Cliente valor) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(valor);
            em.getTransaction().commit();
            System.out.println("Salvo com sucesso");
        }finally{
            em.close();
        }
    }

    public void alter(Cliente valor) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(valor);
            em.getTransaction().commit();

        }finally{
            em.close();
        }
    }


    public List<Cliente> buscaTodos(){
        EntityManager em = emf.createEntityManager();

        List<Cliente> lista = em.createQuery("SELECT c FROM Cliente c").getResultList();
        em.close();

        return lista;
    }

    public Cliente buscaPorId(long id) {
        EntityManager em = emf.createEntityManager();
        Cliente cat = em.find(Cliente.class, id);
        em.close();
        return cat;
    }

    public List<Cliente> buscarPorNomePars(String nome){
        EntityManager em = emf.createEntityManager();
        String sql = "SELECT c FROM Cliente c WHERE LOWER(c.nome) LIKE LOWER(:nome) ";
        List<Cliente> lista = em.createQuery(sql, Cliente.class).setParameter("nome", nome).getResultList();
        em.close();

        return lista;
    }

    public void removerPorId(long id) {
        EntityManager em = emf.createEntityManager();
        Cliente cat = buscaPorId(id);
        if(cat != null) {
            em.remove(cat);
        }
        em.close();
    }
}
