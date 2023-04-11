package dao;

import entities.Email;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EmailDAO {
    public static void save(Email email) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(email);
        em.getTransaction().commit();
        em.close();
    }

    public static void delete(Email email) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        email = em.find(Email.class, email.getId());
        em.remove(email);
        em.getTransaction().commit();
        em.close();
    }

    public static void update(Email email) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(email);
        em.getTransaction().commit();
        em.close();
    }

    public static List getAll() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT e FROM Email e");
        List emails = query.getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return emails;
    }

    public static Integer getCountOfEmails() {
        EntityManager entityManager = JPAUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT e FROM Email e");
        Integer size = query.getResultList().size();
        entityManager.getTransaction().commit();
        entityManager.close();
        return size;
    }
}
