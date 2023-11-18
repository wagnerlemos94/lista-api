package br.com.digitadasistemas.lista.model.dto.usuario;

import br.com.digitadasistemas.lista.model.Usuario;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class UsuarioConsultaDTO {

    private Long id;
    private String nome;
    private String login;
    private boolean ativo;

    public UsuarioConsultaDTO(Usuario usuario){
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.login = usuario.getLogin();
        this.ativo = usuario.isAtivo();
    }

    public static Usuario to(UsuarioConsultaDTO usuarioConsultaDTO){
        Usuario usuario = new Usuario();
        usuario.setId(usuarioConsultaDTO.getId());
        usuario.setNome(usuarioConsultaDTO.getNome());
        usuario.setLogin(usuarioConsultaDTO.getLogin());;
        usuario.setAtivo(usuarioConsultaDTO.isAtivo());
        return usuario;
    }

    public static List<UsuarioConsultaDTO> to(List<Usuario> usuarios){
        return usuarios.stream().map(usuario -> new UsuarioConsultaDTO(usuario)).collect(Collectors.toList());
    }

}
