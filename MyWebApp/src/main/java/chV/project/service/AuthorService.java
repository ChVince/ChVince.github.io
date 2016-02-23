package chV.project.service;

import chV.project.dao.AuthorDAO;
import chV.project.models.Authors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Charley on 7/02/2016.
 */
@Service
public class AuthorService {
    @Autowired
    private AuthorDAO authorDAO;

    public int deleteByAuthor(String author) {
        return authorDAO.deleteByAuthor(author);
    }

    public Authors getAuthorByName(String author) {
        return authorDAO.getAuthorByName(author);
    }

    public List<Authors> listAuthors(Integer offset, Integer maxResults) {
        return authorDAO.listAuthors(offset, maxResults);
    }

    public Long authorsCount() {
        return authorDAO.authorsCount();
    }
}
