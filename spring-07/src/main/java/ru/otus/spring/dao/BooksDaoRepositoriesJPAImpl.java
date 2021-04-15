package ru.otus.spring.dao;

import org.springframework.stereotype.Repository;
import ru.otus.spring.domain.Books;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BooksDaoRepositoriesJPAImpl implements BooksDaoRepositoriesJPA {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Integer count() {
        TypedQuery<Books> query = em.createQuery("select b from books b" ,Books.class);
        return query.getResultList().size();

    }

    @Override
    public Books insert(Books book) {
        if (!book.getId().equals(0l)) {
            em.persist(book);
            return book;
        }
        else
            return em.merge(book);
    }

    @Override
    public Books getById(Long id) {

        TypedQuery<Books> query = em.createQuery("select b from books b" +
                " where id=:id", Books.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void delete(long id) {
        Query query=em.createQuery("delete  from books where id=:id");
        query.setParameter("id",id);
        query.executeUpdate();
    }

    @Override
    public void update(String title,long id) {
        Query query = em.createQuery("update books" +
                " set title=:title" +
                " where id=:id");
        query.setParameter("title",title);
        query.setParameter("id",id);
        query.executeUpdate();
    }


    @Override
    public List<Books> getAll() {
        TypedQuery<Books> query = em.createQuery("select b from books b" ,Books.class);
        return query.getResultList();
    }
}

