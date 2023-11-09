package br.com.digitadasistemas.starterpack.repository;

import br.com.digitadasistemas.starterpack.model.Itens;
import br.com.digitadasistemas.starterpack.model.Lista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensRepository extends JpaRepository<Itens, Long> {

}
