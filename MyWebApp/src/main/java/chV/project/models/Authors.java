package chV.project.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Charley on 1/02/2016.
 */
@Entity
public class Authors {
    private int idAuthors;
    private String nameAuthor;

    private List<Files> files = new LinkedList<Files>();


    @OneToMany(mappedBy = "author",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    public List<Files> getFiles() {
        return files;
    }

    public void setFiles(List<Files> files) {
        this.files = files;
    }

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id_authors", nullable = false)
    public int getIdAuthors() {
        return idAuthors;
    }

    public void setIdAuthors(int idAuthors) {
        this.idAuthors = idAuthors;
    }

    @Basic
    @Column(name = "name_author", nullable = false, length = 45)
    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Authors authors = (Authors) o;

        if (idAuthors != authors.idAuthors) return false;
        if (nameAuthor != null ? !nameAuthor.equals(authors.nameAuthor) : authors.nameAuthor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAuthors;
        result = 31 * result + (nameAuthor != null ? nameAuthor.hashCode() : 0);
        return result;
    }
}
