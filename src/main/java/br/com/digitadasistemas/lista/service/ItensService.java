package br.com.digitadasistemas.lista.service;

import br.com.digitadasistemas.lista.exceptons.ObjetoNaoEncontradoException;
import br.com.digitadasistemas.lista.model.Itens;
import br.com.digitadasistemas.lista.model.dto.intem.ItemInput;
import br.com.digitadasistemas.lista.repository.ItensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ItensService {

    @Autowired
    private ItensRepository itensRepository;

    public List<Itens> cadastrar(List<Itens> itens){
        return itensRepository.saveAll(itens);
    }

    public Itens cadastrar(Itens itens){
        return itensRepository.save(itens);
    }

    public Itens buscar(Long id){

        Date dataAtual =  new Date();

        var itens = itensRepository.findById(id).
                orElseThrow(() -> new ObjetoNaoEncontradoException("Lista não encontrado "));
        return itens;
    }

    public List<Itens> buscar(){
        return itensRepository.findAll();
    }

    public Itens editar(ItemInput itemInput, Long id){
        Itens iten = this.editar(this.buscar(id),itemInput);
        return itensRepository.save(iten);
    }

    public Itens editar(Itens itemAtual, ItemInput itemInput){
        itemAtual.setNome(itemInput.getNome());
        itemAtual.setProduto(itemInput.getProduto());
        return itemAtual;
    }

    public void deletar(Long id){
        itensRepository.delete(buscar(id));
    }

}
