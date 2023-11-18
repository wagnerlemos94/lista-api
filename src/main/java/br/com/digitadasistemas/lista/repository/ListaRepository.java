package br.com.digitadasistemas.lista.repository;

import br.com.digitadasistemas.lista.model.Lista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaRepository extends JpaRepository<Lista, Long> {

}
