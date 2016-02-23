package chV.project.dao;

import chV.project.models.Authors;
import chV.project.models.Files;
import org.hibernate.*;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.List;


@Repository


public class FileDAO {
    @Autowired
    AuthorDAO authorService;

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void insert(Files file, String authorName) {
        Session session = sessionFactory.getCurrentSession();


        Criteria criteria = session.createCriteria(Authors.class);
        criteria.add(Restrictions.eq("nameAuthor", authorName));
        criteria.setFetchMode("files", FetchMode.JOIN);


        Authors author = (Authors) criteria.uniqueResult();
        if (author == null) {
            author = new Authors();
            author.setNameAuthor(authorName);
            insert(author, session);
        }
        file.setAuthor(author);
        author.getFiles().add(file);
        session.save(file);

    }

    @Transactional
    public int delete(String code) {
        Session session = sessionFactory.getCurrentSession();


        Criteria criteria = session.createCriteria(Files.class);
        criteria.add(Restrictions.eq("code", code));

        Files file = (Files) criteria.uniqueResult();
        if (file == null) {

            return 1;
        }
        Authors authors = file.getAuthor();
        if (filesCountByAuthor(authors) == 1) {
            authorService.deleteByAuthor(authors.getNameAuthor());
            return 0;
        }
        session.delete(file);

        return 0;
    }

    @Transactional
    public void insert(Authors authors, Session session) {
        session.save(authors);
    }

    @Transactional(readOnly = true)
    public int download(int id) throws IOException {
        Session session = sessionFactory.getCurrentSession();

        Files files = session.get(Files.class, id);

        if (files != null) {

            File dir = new File("C:\\DownloadsFromProject");

            if (!dir.exists()) {
                dir.mkdirs();
            }

            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(dir.getAbsolutePath() + File.separator + files.getFileName()));
            stream.write(files.getFile());
            stream.flush();
            stream.close();



            return 0;

        }

        return 1;
    }

    @Transactional(readOnly = true)
    public List<Files> getFilesListByAuthor(Authors author, Integer offset, Integer maxResults) {
        Session session = sessionFactory.getCurrentSession();

        return session
                .createCriteria(Files.class)
                .add(Restrictions.eq("author", author))
                .setFirstResult(offset != null ? offset : 0)
                .setMaxResults(maxResults != null ? maxResults : 10)
                .list();
    }

    @Transactional(readOnly = true)
    public List<Files> listFiles(Integer offset, Integer maxResults) {
        Session session = sessionFactory.getCurrentSession();

        return session
                .createCriteria(Files.class)
                .setFirstResult(offset != null ? offset : 0)
                .setMaxResults(maxResults != null ? maxResults : 10)
                .list();

    }

    @Transactional(readOnly = true)
    public Long filesCount() {
        Session session = sessionFactory.getCurrentSession();

        return (long) (Long) session.createCriteria(Files.class)
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }
    @Transactional(readOnly = true)
    public Long filesCountByAuthor(Authors authors) {
        Session session = sessionFactory.getCurrentSession();

        return (long) (Long) session.createCriteria(Files.class)
                .add(Restrictions.eq("author", authors))
                .setProjection(Projections.rowCount())
                .uniqueResult();
    }


}
