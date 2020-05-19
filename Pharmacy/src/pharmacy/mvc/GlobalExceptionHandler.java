package pharmacy.mvc;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    /*@ResponseStatus(code = HttpStatus.FORBIDDEN)
    @ExceptionHandler(value = Exception.class)
    public String error() {
        return "error";
    }*/
}
