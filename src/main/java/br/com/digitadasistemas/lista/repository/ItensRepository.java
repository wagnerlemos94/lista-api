package br.com.digitadasistemas.lista.repository;

import br.com.digitadasistemas.lista.model.Itens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensRepository extends JpaRepository<Itens, Long> {

}
