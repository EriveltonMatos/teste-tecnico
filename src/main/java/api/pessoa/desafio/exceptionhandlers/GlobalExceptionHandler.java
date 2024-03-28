package api.pessoa.desafio.exceptionhandlers;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import api.pessoa.desafio.exceptions.PessoaNotFoundException;
import api.pessoa.desafio.exceptions.StatusNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StatusNotFoundException.class)
    public ResponseEntity<?> handleException(StatusNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    
    @ExceptionHandler(PessoaNotFoundException.class)
    public ResponseEntity<?> handleException(PessoaNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    // Exceções genericas
    public ResponseEntity<?> handleException(Exception e) {
        return ResponseEntity.status(Response.SC_INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

    public ResponseEntity<?> handleException(RuntimeException e) {
        return ResponseEntity.status(Response.SC_INTERNAL_SERVER_ERROR).body(e.getMessage());
    }

    public ResponseEntity<?> handleException(IllegalArgumentException e) {
        return ResponseEntity.status(Response.SC_BAD_REQUEST).body(e.getMessage());
    }
    
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<?> handleException(NoResourceFoundException e) {
        return ResponseEntity.status(Response.SC_BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleException(MethodArgumentNotValidException e) {
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        String errorMessage = fieldErrors.stream()
            .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
            .collect(Collectors.joining(", "));
        return ResponseEntity.status(Response.SC_BAD_REQUEST).body(errorMessage);
    }
}
