package br.com.digitadasistemas.lista.controller;

import br.com.digitadasistemas.lista.model.dto.intem.ItemConsulta;
import br.com.digitadasistemas.lista.model.dto.intem.ItemInput;
import br.com.digitadasistemas.lista.service.ItensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/item")
@RestController
public class ItemController {

    @Autowired
    private ItensService itemService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemConsulta cadastrar(@RequestBody ItemInput itemInput){
        return ItemConsulta.to(this.itemService.cadastrar(ItemInput.to(itemInput)));
    }

    @GetMapping
    public List<ItemConsulta> buscar(){
        return ItemConsulta.to(this.itemService.buscar());
    }

    @GetMapping("/{id}")
    public ItemConsulta buscar(@PathVariable Long id){
        return ItemConsulta.to(this.itemService.buscar(id));
    }

    @PutMapping("/{id}")
    public ItemConsulta editar(@RequestBody ItemInput itensInput, @PathVariable Long id){
        return ItemConsulta.to(this.itemService.editar(itensInput, id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id){
        itemService.deletar(id);
    }
}
