package br.com.digitadasistemas.lista.model.dto.usuario;

import br.com.digitadasistemas.lista.model.Usuario;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioInputDTO {

    private Long id;
    private String login;
    private String nome;
    private String senha;

    public UsuarioInputDTO(Long id){
        this.id = id;
    }

    public static Usuario to(UsuarioInputDTO usuarioInputDTO){
        Usuario usuario = new Usuario();
        usuario.setId(usuarioInputDTO.getId());
        usuario.setNome(usuarioInputDTO.getNome());
        usuario.setLogin(usuarioInputDTO.getLogin());
        usuario.setSenha(usuarioInputDTO.getSenha());
        return usuario;
    }

}
