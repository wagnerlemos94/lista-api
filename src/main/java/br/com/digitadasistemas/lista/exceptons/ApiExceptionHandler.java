package br.com.digitadasistemas.lista.exceptons;

import br.com.digitadasistemas.lista.exceptons.model.Erro;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;


@ControllerAdvice
@RequiredArgsConstructor
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidGrantException.class)
    public ResponseEntity<Object> handleInternalAuthenticationServiceException(InternalAuthenticationServiceException ex, WebRequest request) {
        return handle(HttpStatus.NOT_FOUND, ex, request);
    }

    @ExceptionHandler(RegraDeNegocioException.class)
    public ResponseEntity<Object> handleRegraDeNegocioException(RegraDeNegocioException ex, WebRequest request) {
        return handle(HttpStatus.NOT_FOUND, ex, request);
    }

    @ExceptionHandler(ObjetoNaoEncontradoException.class)
    public ResponseEntity<Object> handleRecursoNaoEncontradoException(ObjetoNaoEncontradoException ex, WebRequest request) {
        return handle(HttpStatus.NOT_FOUND, ex, request);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Object> handleNullPointExecption(NullPointerException ex, WebRequest request) {
        return handle(HttpStatus.INTERNAL_SERVER_ERROR, ex, request);
    }

    private ResponseEntity<Object> handle(HttpStatus status, Exception ex, WebRequest request) {

        var erro = new Erro.Builder()
                .comStatus(status.value())
                .comDetalhe(ex.getMessage())
                .build();
        return ResponseEntity.status(status).body(erro);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        String errorMessage = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        List<String> validationList = ex.getBindingResult().getFieldErrors().stream().map(fieldError -> fieldError.getDefaultMessage()).collect(Collectors.toList());
        LOGGER.info("Validation error list : " + validationList);

        var erro = new Erro.Builder()
                .comStatus(status.value())
                .comDetalhe(errorMessage)
                .build();
        return ResponseEntity.status(status).body(erro);
    }
}
