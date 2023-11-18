package br.com.digitadasistemas.lista.model.dto.lista;

import br.com.digitadasistemas.lista.model.Itens;
import br.com.digitadasistemas.lista.model.Lista;
import br.com.digitadasistemas.lista.model.dto.usuario.UsuarioConsultaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaConsulta {

    private Long id;
    private String nome;
    private Boolean ativo;
    private List<Itens> itens = new ArrayList<Itens>();
    private UsuarioConsultaDTO usuario;
    public static ListaConsulta to(Lista lista){
        ListaConsulta listaConsulta = new ListaConsulta();
        listaConsulta.setId(lista.getId());
        listaConsulta.setNome(lista.getNome());
        listaConsulta.setAtivo(lista.getAtivo());
        listaConsulta.setItens(lista.getItens());
        listaConsulta.setUsuario(new UsuarioConsultaDTO(lista.getUsuario()));
        return listaConsulta;
    }

    public static List<ListaConsulta> to(List<Lista> listas){
        return listas.stream().map(lista -> to(lista)).collect(Collectors.toList());
    }

}
