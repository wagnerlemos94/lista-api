package br.com.digitadasistemas.starterpack.service;

import br.com.digitadasistemas.starterpack.model.Itens;
import br.com.digitadasistemas.starterpack.repository.ItensRepository;
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
