package br.com.digitadasistemas.lista.model;

import br.com.digitadasistemas.lista.model.enums.TipoLista;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Lista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Itens> itens = new ArrayList<Itens>();
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;
    private Boolean ativo = true;
    @Enumerated(EnumType.ORDINAL)
    private TipoLista tipoLista;
    private String descricao;
    private Date inicio = new Date();
    private Date fim;

}
