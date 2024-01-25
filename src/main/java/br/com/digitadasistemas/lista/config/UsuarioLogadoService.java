package br.com.digitadasistemas.lista.config;

import br.com.digitadasistemas.lista.model.Usuario;
import br.com.digitadasistemas.lista.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
public class UsuarioLogadoService {

    @Autowired
    private UsuarioService usuarioService;

    public UsuarioLogado getUsuarioLogado() {
        return (UsuarioLogado) getHttpServletRequest().getAttribute(SecurityFilter.USUARIO_LOGADO);
    }

    private HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }

    public Usuario getUsuario(){
        return usuarioService.buscar(getUsuarioLogado().getUsuario());
    }
}
