package chV.project.validator;


import chV.project.models.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Locale;

/**
 * Created by Charley on 4/02/2016.
 */
@Component
public class FileValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Autowired
    private MessageSource messageSource;

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    private Locale locale;

    @Override
    public void validate(Object uploadedFile, Errors errors) {
        UploadedFile file = (UploadedFile) uploadedFile;
        if (file.getFile().getSize() == 0) {
            String message = i18n("dropFile.error");
            errors.rejectValue("file", "uploadFile.file", message);
        }else if (file.getFile().getSize() >5055555){
            String message = i18n("dropFile.sizeError");
            errors.rejectValue("file", "uploadFile.file", message);
        }
    }

    private String i18n(String messageKey) {
        return messageSource.getMessage(messageKey, null, getLocale());
    }

    public String i18n(String messageKey, Locale locale) {
        return messageSource.getMessage(messageKey, null, locale);
    }

     public Model goTo(String role ,Locale locale, Model model){
         String goTo;
         String path;
         if (role.equals("admin")) {
             goTo = i18n("moderatorTitle", locale);
             path ="../moderator";
         } else {
             goTo = i18n("home", locale);
             path ="/";
         }
         model.addAttribute("goTo", goTo);
         model.addAttribute("path",path);
         return model;
     }
}
