package br.com.digitadasistemas.starterpack.model.dto;

import br.com.digitadasistemas.starterpack.model.Usuario;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioInputDTO {

    private String login;
    private String nome;
    private String senha;

    public static Usuario to(UsuarioInputDTO usuarioInputDTO){
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioInputDTO.getNome());
        usuario.setLogin(usuarioInputDTO.getLogin());
        usuario.setSenha(usuarioInputDTO.getSenha());
        return usuario;
    }

}
