package br.com.digitadasistemas.lista.model.dto.lista;

import br.com.digitadasistemas.lista.model.Itens;
import br.com.digitadasistemas.lista.model.Lista;
import br.com.digitadasistemas.lista.model.dto.usuario.UsuarioConsultaDTO;
import br.com.digitadasistemas.lista.model.enums.TipoLista;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListaConsulta {

    private Long id;
    private String nome;
    private String descricao;
    private Boolean ativo;
    private TipoLista tipoLista;
    private List<Itens> itens = new ArrayList<Itens>();
    private UsuarioConsultaDTO usuario;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date inicio;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fim;
    private boolean aberta;
    public static ListaConsulta to(Lista lista){
        ListaConsulta listaConsulta = new ListaConsulta();
        listaConsulta.setId(lista.getId());
        listaConsulta.setNome(lista.getNome());
        listaConsulta.setAtivo(lista.getAtivo());
        listaConsulta.setItens(lista.getItens());
        listaConsulta.setUsuario(new UsuarioConsultaDTO(lista.getUsuario()));
        listaConsulta.setTipoLista(TipoLista.find(lista.getTipoLista().getId()));
        listaConsulta.setDescricao(lista.getDescricao());
        listaConsulta.setInicio(lista.getInicio());
        listaConsulta.setFim(lista.getFim());
        listaConsulta.setAtivo(lista.isAberta());
        return listaConsulta;
    }

    public static List<ListaConsulta> to(List<Lista> listas){
        return listas.stream().map(lista -> to(lista)).collect(Collectors.toList());
    }

}
