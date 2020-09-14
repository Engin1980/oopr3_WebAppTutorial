package cz.osu.books.db;

import cz.osu.books.db.entities.BookEntity;
import org.eclipse.persistence.jpa.jpql.tools.model.query.MaxFunctionStateObject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class BookDAO {
    //region Initialization
    private static final String PERSISTENCE_UNIT_NAME = "BooksPU";
    private static EntityManagerFactory emf = null;
    private EntityManager em = null;

    private EntityManager getEm() {
        if (emf == null) initEmf();
        if (em == null) initEm();
        return em;
    }

    private void initEmf() {
        try {
            emf = javax.persistence.Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        } catch (Exception e) {
            throw new DbException(
                    "Failed to initialize EntityManagerFactory.", e);
        }
    }

    private void initEm() {
        try {
            this.em = emf.createEntityManager();
        } catch (Exception e) {
            throw new DbException(
                    "Failed to initialize EntityManager.", e);
        }
    }
    //endregion

    public void insert(BookEntity book) {
        if (book == null) throw new IllegalArgumentException("Book cannot be null.");

        EntityManager em = this.getEm();
        try {
            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new DbException("Failed to do 'insert'.", e);
        }
    }

    public void delete(int bookId) {
        EntityManager em = this.getEm();
        try {
            BookEntity book = em.getReference(BookEntity.class, bookId);
            em.getTransaction().begin();
            em.remove(book);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            throw new DbException("Failed to do 'delete' for id " + bookId, e);
        }
    }

    public List<BookEntity> getAll() {
        List<BookEntity> ret;

        EntityManager em = this.getEm();
        try {
            TypedQuery<BookEntity> q = em
                    .createQuery("select b from BookEntity b order by b.title", BookEntity.class);
            ret = q.getResultList();
        } catch (Exception e) {
            throw new DbException("Failed to do 'getAll'.", e);
        }
        return ret;
    }
}
