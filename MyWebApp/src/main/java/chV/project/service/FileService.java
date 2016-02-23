package chV.project.service;

import chV.project.dao.FileDAO;
import chV.project.models.Authors;
import chV.project.models.Files;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * Created by Charley on 30/01/2016.
 */
@Service
public class FileService {
    @Autowired
    private FileDAO fileDAO;


    public int download(int id) throws IOException {
        return fileDAO.download(id);
    }

    public void insert(Files file, String authorName) {
        fileDAO.insert(file, authorName);
    }

    public int delete(String code) {
        return fileDAO.delete(code);
    }

    public void insert(Authors author, Session session) {
        fileDAO.insert(author, session);
    }

    public List<Files> getFilesListByAuthor(Authors author, Integer offset, Integer maxResults) {
        return fileDAO.getFilesListByAuthor(author, offset, maxResults);
    }

    public List<Files> listFiles(Integer offset, Integer maxResults) {
        return fileDAO.listFiles(offset, maxResults);
    }

    public Long filesCount() {
        return fileDAO.filesCount();
    }

    public Long filesCountByAuthor(Authors author) {
        return fileDAO.filesCountByAuthor(author);
    }
}
