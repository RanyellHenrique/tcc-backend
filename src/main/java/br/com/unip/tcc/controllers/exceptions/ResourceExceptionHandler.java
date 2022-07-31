package br.com.unip.tcc.controllers.exceptions;

import br.com.unip.tcc.dtos.exceptions.StandardError;
import br.com.unip.tcc.dtos.exceptions.ValidationError;
import br.com.unip.tcc.services.exceptions.ForbiddenException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ValidationError err =  new ValidationError();
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Validation exception");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());

        for(FieldError f : e.getBindingResult().getFieldErrors()) {
            err.addError(f.getField(), f.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<StandardError> database(ForbiddenException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err =  new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Forbidden exception");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
