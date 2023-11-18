package br.com.digitadasistemas.lista.service;

import br.com.digitadasistemas.lista.exceptons.ObjetoNaoEncontrado;
import br.com.digitadasistemas.lista.model.Lista;
import br.com.digitadasistemas.lista.model.dto.lista.ListaInput;
import br.com.digitadasistemas.lista.repository.ListaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaService {

    @Autowired
    private ListaRepository listaRepository;

    public Lista cadastrar(ListaInput listaInput){
        return listaRepository.save(ListaInput.to(listaInput));
    }

    public Lista buscar(Long id){
        return listaRepository.findById(id).
                orElseThrow(() -> new ObjetoNaoEncontrado("Usuario não encontrado "));
    }

    public List<Lista> buscar(){
        return listaRepository.findAll();
    }

    public Lista editar(ListaInput listaInput, Long id){
        Lista lista = this.editar(this.buscar(id),listaInput);
        return listaRepository.save(lista);
    }

    public Lista editar(Lista listaAtual, ListaInput listaInput){
        listaAtual.setNome(listaInput.getNome());
        listaAtual.setItens(listaInput.getItens());
        return listaAtual;
    }

}
