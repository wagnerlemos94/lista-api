package br.com.digitadasistemas.lista.service;

import br.com.digitadasistemas.lista.config.UsuarioLogado;
import br.com.digitadasistemas.lista.config.UsuarioLogadoService;
import br.com.digitadasistemas.lista.exceptons.ObjetoNaoEncontradoException;
import br.com.digitadasistemas.lista.exceptons.RegraDeNegocioException;
import br.com.digitadasistemas.lista.model.Itens;
import br.com.digitadasistemas.lista.model.Lista;
import br.com.digitadasistemas.lista.model.dto.intem.ItemInput;
import br.com.digitadasistemas.lista.model.dto.lista.ListaInput;
import br.com.digitadasistemas.lista.model.dto.usuario.UsuarioInputDTO;
import br.com.digitadasistemas.lista.model.enums.TipoLista;
import br.com.digitadasistemas.lista.repository.ListaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ListaService {

    @Autowired
    private ListaRepository listaRepository;
    @Autowired
    private UsuarioLogadoService usuarioLogadoService;

    public Lista cadastrar(ListaInput listaInput){
        listaInput.setUsuario(new UsuarioInputDTO(usuarioLogadoService.getUsuario().getId()));
        return listaRepository.save(ListaInput.to(listaInput));
    }

    public Lista buscar(Long id){

        Date dataAtual =  new Date();

        var lista = listaRepository.findById(id).
                orElseThrow(() -> new ObjetoNaoEncontradoException("Lista não encontrado "));
        if(usuarioLogadoService.getUsuario() == null){
            if(!lista.getAtivo() || (lista.getFim() != null && lista.getFim().before(dataAtual))){
                lista.setAtivo(false);
                listaRepository.save(lista);
                throw new RegraDeNegocioException("Lista ja encerrada!");
            }

            if(lista.getInicio() != null && lista.getInicio().after(dataAtual)){
                throw new RegraDeNegocioException("Lista ainda não foi iniciada!");
            }
        }

        return lista;
    }

    public List<Lista> buscar(){
        return listaRepository.findAll();
    }

    public Lista editar(ListaInput listaInput, Long id){
        Lista lista = this.editar(this.buscar(id),listaInput);
        return listaRepository.save(lista);
    }

    public Lista editar(Long id, Itens item){
        Lista lista = this.buscar(id);
        lista.getItens().add(item);
        return listaRepository.save(lista);
    }

    public Lista editar(Lista listaAtual, ListaInput listaInput){
        listaAtual.setNome(listaInput.getNome());
        listaAtual.setItens(listaInput.getItens());
        listaAtual.setDescricao(listaInput.getDescricao());
        listaAtual.setTipoLista(TipoLista.find(listaInput.getTipoLista()));
        listaAtual.setInicio(listaInput.getInicio());
        listaAtual.setFim(listaInput.getFim());
        return listaAtual;
    }

    public void ativo(Long id, boolean ativo){
        Lista lista = buscar(id);
        lista.setAtivo(ativo);

        listaRepository.save(lista);
    }

    public void assinar(Long id, ItemInput itemInput){
        Lista lista = buscar(id);
        lista.getItens().add(ItemInput.to(itemInput));
        listaRepository.save(lista);
    }

}
