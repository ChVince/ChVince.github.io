package chV.project.dao;


import chV.project.models.Authors;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Charley on 7/02/2016.
 */
@Repository
public class AuthorDAO {


    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public int deleteByAuthor(String authorName) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Authors where nameAuthor = :name").setParameter("name", authorName);
        Authors author = (Authors) query.uniqueResult();
        if (author == null) {
            return 1;
        }
        session.delete(author);

        return 0;
    }

    @Transactional(readOnly = true)
    public Authors getAuthorByName(String author) {
        Session session = sessionFactory.getCurrentSession();

        return (Authors) session.createQuery("from Authors where nameAuthor =:name").setParameter("name", author).uniqueResult();
    }

    @Transactional(readOnly = true)
    public List<Authors> listAuthors(Integer offset, Integer maxResults) {
        Session session = sessionFactory.getCurrentSession();

        return session
                .createCriteria(Authors.class)
                .setFirstResult(offset != null ? offset : 0)
                .setMaxResults(maxResults != null ? maxResults : 10)
                .list();
    }
    @Transactional(readOnly = true)
    public Long authorsCount() {
        Session session = sessionFactory.getCurrentSession();

        return (long) (Long) session.createCriteria(Authors.class)
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }


}
