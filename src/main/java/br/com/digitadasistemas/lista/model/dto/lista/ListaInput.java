package br.com.digitadasistemas.lista.model.dto.lista;

import br.com.digitadasistemas.lista.model.Itens;
import br.com.digitadasistemas.lista.model.Lista;
import br.com.digitadasistemas.lista.model.dto.usuario.UsuarioInputDTO;
import br.com.digitadasistemas.lista.model.enums.TipoLista;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaInput {

    private Long id;
    private String nome;
    private List<Itens> itens = new ArrayList<Itens>();
    private UsuarioInputDTO usuario;
    private Integer tipoLista;
    private String descricao;
    private Date inicio;
    private Date fim;

    public static Lista to(ListaInput listaInput){
        Lista lista = new Lista();
        lista.setUsuario(UsuarioInputDTO.to(listaInput.getUsuario()));
        lista.setItens(listaInput.getItens());
        lista.setNome(listaInput.getNome());
        lista.setTipoLista(TipoLista.find(listaInput.getTipoLista()));
        lista.setDescricao(listaInput.getDescricao());
        lista.setInicio(listaInput.getInicio());
        lista.setFim(listaInput.getFim());
        return lista;
    }

}
