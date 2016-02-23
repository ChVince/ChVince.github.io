package chV.project.controllers;

import chV.project.models.Files;
import chV.project.models.UploadedFile;
import chV.project.service.AuthorService;
import chV.project.service.FileService;
import chV.project.validator.FileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Locale;
import java.util.Random;


@Controller
@SessionAttributes({"file"})
public class DBController {
    @Autowired
    FileValidator fileValidator;
    @Autowired
    AuthorService authorService;
    @Autowired
    FileService fileService;


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@Valid @ModelAttribute("uploadedFile") UploadedFile uploadedFile, BindingResult result, Locale locale, Model model) throws IOException {

        fileValidator.setLocale(locale);
        fileValidator.validate(uploadedFile, result);
        if (result.hasErrors()) {
            return "dropFile";
        } else {

            Random random = new Random();
            Files files = new Files();

            files.setFile(uploadedFile.getFile().getBytes());
            files.setDescription(uploadedFile.getDescription());
            files.setSize(uploadedFile.getFile().getBytes().length);
            files.setFileName(uploadedFile.getFile().getOriginalFilename());
            files.setCode(random.nextInt() + "" + files.getFileName().hashCode());

            fileService.insert(files, uploadedFile.getAuthor());
            model.addAttribute("file", files);
            return "redirect:/uploadView";
        }
    }

    @RequestMapping(value = "/uploadView", method = RequestMethod.GET)
    public String goToUpload() {
        return "result";
    }

    @RequestMapping(value = "table/delete", method = RequestMethod.GET)
    public String delete(HttpServletRequest request, Locale locale, Model model) {

        fileValidator.goTo(request.getParameter("role"), locale,model);
        if (fileService.delete(request.getParameter("code")) == 0) {

            String message = fileValidator.i18n("successDelete", locale);
            model.addAttribute("message", message);
            return "downloads_view/fileStatus";
        }
        String message = fileValidator.i18n("failDelete", locale);
        model.addAttribute("message", message);

        return "downloads_view/fileStatus";
    }

    @RequestMapping(value = "table/download", method = RequestMethod.GET)
    public String download(HttpServletRequest request, Locale locale, Model model) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        fileValidator.goTo(request.getParameter("role"), locale,model);
        if (fileService.download(id) == 0) {

            String message = fileValidator.i18n("successDownload", locale);
            model.addAttribute("message", message);
            return "downloads_view/fileStatus";
        }
        String message = fileValidator.i18n("failDownload", locale);
        model.addAttribute("message", message);

        return "downloads_view/fileStatus";
    }

    @RequestMapping(value = "table/deleteByAuthor", method = RequestMethod.GET)
    public String DeleteByAuthor(HttpServletRequest request, Locale locale, Model model) {
        int status = authorService.deleteByAuthor(request.getParameter("author"));

        if (status == 1) {
            String message = fileValidator.i18n("userFDelete", locale);
            model.addAttribute("message", message);
            return "downloads_view/authorStatus";
        }
        String message = fileValidator.i18n("userSDelete", locale);
        model.addAttribute("message", message);
        return "downloads_view/authorStatus";
    }

}
