package br.com.digitadasistemas.starterpack.service;

import br.com.digitadasistemas.starterpack.model.Usuario;
import br.com.digitadasistemas.starterpack.model.dto.UsuarioInputDTO;
import br.com.digitadasistemas.starterpack.repository.UsuarioRepository;
import br.com.digitadasistemas.starterpack.exceptons.ObjetoNaoEncontrado;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return usuarioRepository.findByLogin(login).
                orElseThrow(() -> new ObjetoNaoEncontrado("Usuario ou Senha inválidos: "));
    }

    public Usuario buscar(String login) {
        Usuario usuario = usuarioRepository.findByLogin(login).
                orElseThrow(() -> new ObjetoNaoEncontrado("Usuario não encontrado "));
        return usuario;
    }

    public Usuario buscar(Long id) {
        Usuario usuario = usuarioRepository.findById(id).
                orElseThrow(() -> new ObjetoNaoEncontrado("Usuario não encontrado "));
        return usuario;
    }

    public List<Usuario> buscar() {
        return usuarioRepository.findAll();
    }

    public Usuario cadastrar(UsuarioInputDTO usuarioInputDTO) {
        usuarioInputDTO.setSenha(passwordEncoder.encode(usuarioInputDTO.getSenha()));
        Usuario usuario = usuarioRepository.save(UsuarioInputDTO.to(usuarioInputDTO));
        return usuario;
    }
}
