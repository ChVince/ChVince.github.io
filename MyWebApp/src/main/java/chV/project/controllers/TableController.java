package chV.project.controllers;

import chV.project.models.Authors;
import chV.project.service.AuthorService;
import chV.project.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Charley on 9/02/2016.
 */
@Controller
public class TableController {
    @Autowired
    FileService fileService;
    @Autowired
    AuthorService authorService;



    @RequestMapping(value="/table/list")
    public String list(Model model, Integer offset, Integer maxResults){
        model.addAttribute("files", fileService.listFiles(offset, maxResults));
        model.addAttribute("count", fileService.filesCount());
        model.addAttribute("offset", offset);
        return "tables/list";
    }


    @RequestMapping(value = "table/viewFilesAsModerator", method = RequestMethod.GET)
    public String moderatorsTable(Model model, Integer offset, Integer maxResults) {
        model.addAttribute("authors", authorService.listAuthors(offset, maxResults));
        model.addAttribute("count", authorService.authorsCount());
        model.addAttribute("offset", offset);
        return "tables/authorsTable";
    }

    @RequestMapping(value = "table/viewAllFilesByAuthor", method = RequestMethod.GET)
    public String FilesByAuthor(HttpServletRequest request, Model model, Integer offset, Integer maxResults) {
        Authors author = authorService.getAuthorByName(request.getParameter("author"));
        model.addAttribute("filesByAuthor", fileService.getFilesListByAuthor(author,offset, maxResults));
        model.addAttribute("count", fileService.filesCountByAuthor(author));
        model.addAttribute("offset", offset);
        return "tables/table";
    }
}
