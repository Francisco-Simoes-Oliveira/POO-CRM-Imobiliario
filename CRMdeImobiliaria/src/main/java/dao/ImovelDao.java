package dao;

import modelo.Imovel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ImovelDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaPU");

    public void add(Imovel valor) {
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

    public void alter(Imovel valor) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(valor);
            em.getTransaction().commit();

        }finally{
            em.close();
        }
    }


    public List<Imovel> buscaTodos(){
        EntityManager em = emf.createEntityManager();

        List<Imovel> lista = em.createQuery("SELECT c FROM Imovel c").getResultList();
        em.close();

        return lista;
    }

    public Imovel buscaPorId(long id) {
        EntityManager em = emf.createEntityManager();
        Imovel imovel = em.find(Imovel.class, id);
        em.close();
        return imovel;
    }

    public List<Imovel> buscarPorNomePars(String nome){
        EntityManager em = emf.createEntityManager();
        String sql = "SELECT c FROM Imovel c WHERE LOWER(c.nome) LIKE LOWER(:nome) ";
        List<Imovel> lista = em.createQuery(sql, Imovel.class).setParameter("nome", nome).getResultList();
        em.close();

        return lista;
    }

    public void removerPorId(long id) {
        EntityManager em = emf.createEntityManager();
        Imovel imovel = buscaPorId(id);
        if(imovel != null) {
            em.remove(imovel);
        }
        em.close();
    }
}
