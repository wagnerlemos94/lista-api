package br.com.digitadasistemas.starterpack.repository;

import br.com.digitadasistemas.starterpack.model.Lista;
import br.com.digitadasistemas.starterpack.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ListaRepository extends JpaRepository<Lista, Long> {

}
