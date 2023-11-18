package br.com.digitadasistemas.lista.service;

import br.com.digitadasistemas.lista.model.Itens;
import br.com.digitadasistemas.lista.repository.ItensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItensService {

    @Autowired
    private ItensRepository itensRepository;

    public List<Itens> cadastrar(List<Itens> itens){
        return itensRepository.saveAll(itens);
    }
}
