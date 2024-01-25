package br.com.digitadasistemas.lista.repository;

import br.com.digitadasistemas.lista.model.Lista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ListaRepository extends JpaRepository<Lista, Long> {

    Optional<Lista> findByIdAndAtivo(Long id, boolean ativo);

}
