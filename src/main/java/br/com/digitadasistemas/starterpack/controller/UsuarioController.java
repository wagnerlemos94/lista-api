package br.com.digitadasistemas.starterpack.controller;

import br.com.digitadasistemas.starterpack.model.dto.UsuarioConsultaDTO;
import br.com.digitadasistemas.starterpack.model.dto.UsuarioInputDTO;
import br.com.digitadasistemas.starterpack.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RequestMapping(path = "/usuario")
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @PostMapping
    public UsuarioConsultaDTO cadastrar(@RequestBody UsuarioInputDTO usuarioInputDTO){
        return new UsuarioConsultaDTO(this.usuarioService.cadastrar(usuarioInputDTO));
    }

    @GetMapping
    public List<UsuarioConsultaDTO> buscar(){
        return UsuarioConsultaDTO.to(this.usuarioService.buscar());
    }

    @GetMapping("/{id}")
    public UsuarioConsultaDTO buscar(@PathVariable Long id){
        return new UsuarioConsultaDTO(this.usuarioService.buscar(id));
    }

    @GetMapping("/login")
    public UsuarioConsultaDTO buscar(@PathParam("login") String login){
        return new UsuarioConsultaDTO(this.usuarioService.buscar(login));
    }

}
