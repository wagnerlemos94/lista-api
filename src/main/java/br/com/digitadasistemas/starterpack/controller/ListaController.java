package br.com.digitadasistemas.starterpack.controller;

import br.com.digitadasistemas.starterpack.model.Lista;
import br.com.digitadasistemas.starterpack.model.dto.UsuarioConsultaDTO;
import br.com.digitadasistemas.starterpack.model.dto.UsuarioInputDTO;
import br.com.digitadasistemas.starterpack.service.ListaService;
import br.com.digitadasistemas.starterpack.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RequestMapping(path = "/lista")
@RestController
public class ListaController {

    @Autowired
    private ListaService listaService;
    @PostMapping
    public Lista cadastrar(@RequestBody Lista lista){
        return this.listaService.cadastrar(lista);
    }

    @GetMapping
    public List<Lista> buscar(){
        return this.listaService.buscar();
    }

    @GetMapping("/{id}")
    public Lista buscar(@PathVariable Long id){
        return this.listaService.buscar(id);
    }

}
