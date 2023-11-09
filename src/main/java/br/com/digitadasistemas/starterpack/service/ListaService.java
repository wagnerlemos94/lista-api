package br.com.digitadasistemas.starterpack.service;

import br.com.digitadasistemas.starterpack.exceptons.ObjetoNaoEncontrado;
import br.com.digitadasistemas.starterpack.model.Itens;
import br.com.digitadasistemas.starterpack.model.Lista;
import br.com.digitadasistemas.starterpack.repository.ListaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaService {

    @Autowired
    private ListaRepository listaRepository;

    public Lista cadastrar(Lista lista){
        lista = listaRepository.save(lista);
        return lista;
    }

    public Lista buscar(Long id){
        return listaRepository.findById(id).
                orElseThrow(() -> new ObjetoNaoEncontrado("Usuario não encontrado "));
    }

    public List<Lista> buscar(){
        return listaRepository.findAll();
    }

}
