package br.com.digitadasistemas.lista.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoLista {

    NORMAL(0,"NORMAL", "lISTA DE NORMAL"),
    ITENS(1,"ITENS","LISTA DE ITENS");

    private Integer id;
    private String nome;
    private String descricao;

    public static TipoLista find(Integer id){

        if(id == null){
            return null;
        }

        for (TipoLista tipoLista: TipoLista.values()) {
            if(tipoLista.id.equals(id)){
                return tipoLista;
            }
        }
        throw new IllegalArgumentException("Tipo de lista não encontrado");
    }

    public static TipoLista find(String descricao){

        if(descricao == null){
            return null;
        }

        for (TipoLista tipoLista: TipoLista.values()) {
            if(tipoLista.descricao.equalsIgnoreCase(descricao)){
                return tipoLista;
            }
        }

        throw new IllegalArgumentException("Tipo de lista não encontrado");

    }

}
