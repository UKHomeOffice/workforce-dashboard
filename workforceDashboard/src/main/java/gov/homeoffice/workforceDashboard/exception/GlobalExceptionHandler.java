package gov.homeoffice.workforceDashboard.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler()
    public String fileExceptionError(MultipartException mpe, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", "Error! Upload has exceeded the maximum file size of 2MB. \n" +
                "Contact Administrator.");
        return "redirect:/welcome";
    }
}
