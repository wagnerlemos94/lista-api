package br.com.digitadasistemas.lista.controller;

import br.com.digitadasistemas.lista.model.dto.lista.ListaConsulta;
import br.com.digitadasistemas.lista.model.dto.lista.ListaInput;
import br.com.digitadasistemas.lista.service.ListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/lista")
@RestController
public class ListaController {

    @Autowired
    private ListaService listaService;
    @PostMapping
    public ListaConsulta cadastrar(@RequestBody ListaInput listaInput){
        return ListaConsulta.to(this.listaService.cadastrar(listaInput));
    }

    @GetMapping
    public List<ListaConsulta> buscar(){
        return ListaConsulta.to(this.listaService.buscar());
    }

    @GetMapping("/{id}")
    public ListaConsulta buscar(@PathVariable Long id){
        return ListaConsulta.to(this.listaService.buscar(id));
    }

    @PutMapping("/{id}")
    public ListaConsulta editar(@RequestBody ListaInput listaInput,@PathVariable Long id){
        return ListaConsulta.to(this.listaService.editar(listaInput, id));
    }

}
