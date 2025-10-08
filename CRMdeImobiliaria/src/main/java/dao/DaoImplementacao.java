package dao;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public abstract class DaoImplementacao<T, ID> implements DaoGenerico<T,ID> {
    private final Class<T> tipo;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaPU");

    public DaoImplementacao(Class<T> tipo) {
        this.tipo = tipo;
    }

    public void add(T valor) {
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

    public void alter(T valor) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(valor);
            em.getTransaction().commit();

        }finally{
            em.close();
        }
    }


    public List<T> buscaTodos(){
        EntityManager em = emf.createEntityManager();
        String sql = "SELECT t FROM "+tipo.getName()+" t ";
        List<T> lista = em.createQuery(sql).getResultList();
        em.close();

        return lista;
    }

    public T buscaPorId(ID id) {
        EntityManager em = emf.createEntityManager();
        T cat = em.find(tipo, id);
        em.close();
        return cat;
    }

    public List<T> buscarPorNomePars(String nome){
        EntityManager em = emf.createEntityManager();
        String sql = "SELECT t FROM "+tipo.getName()+" t WHERE LOWER(c.nome) LIKE LOWER(:nome) ";
        List<T> lista = em.createQuery(sql, tipo).setParameter("nome", nome).getResultList();
        em.close();

        return lista;
    }

    public void removerPorId(ID id) {
        EntityManager em = emf.createEntityManager();
        T cat = buscaPorId(id);
        if(cat != null) {
            em.remove(cat);
        }
        em.close();
    }
}
