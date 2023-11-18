package br.com.digitadasistemas.lista.model.dto.lista;

import br.com.digitadasistemas.lista.model.Itens;
import br.com.digitadasistemas.lista.model.Lista;
import br.com.digitadasistemas.lista.model.dto.usuario.UsuarioInputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaInput {

    private Long id;
    private String nome;
    private List<Itens> itens = new ArrayList<Itens>();
    private UsuarioInputDTO usuario;

    public static Lista to(ListaInput listaInput){
        Lista lista = new Lista();
        lista.setUsuario(UsuarioInputDTO.to(listaInput.getUsuario()));
        lista.setItens(listaInput.getItens());
        lista.setNome(listaInput.getNome());
        return lista;
    }

}
