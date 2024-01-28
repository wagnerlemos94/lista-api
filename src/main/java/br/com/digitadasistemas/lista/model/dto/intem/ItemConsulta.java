package br.com.digitadasistemas.lista.model.dto.intem;

import br.com.digitadasistemas.lista.model.Itens;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemConsulta {

    private String produto;
    private String nome;

    public static ItemConsulta to(Itens item) {
        return new ItemConsulta(item.getProduto(), item.getNome());
    }

    public static List<ItemConsulta> to(List<Itens> itens){
        return itens.stream().map(ItemConsulta::to).collect(Collectors.toList());
    }

}
