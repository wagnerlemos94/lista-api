package br.com.digitadasistemas.lista.model.dto.intem;

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
public class ItemInput {

    private String produto;
    private String nome;

    public static Itens to(ItemInput itemInput){
        Itens itens = new Itens();
        itens.setNome(itemInput.getNome());
        itens.setProduto(itemInput.getProduto());
        return itens;
    }

}
