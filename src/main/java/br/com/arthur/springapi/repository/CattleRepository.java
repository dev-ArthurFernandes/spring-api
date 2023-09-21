package br.com.arthur.springapi.repository;

import br.com.arthur.springapi.model.Cattle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CattleRepository extends JpaRepository<Cattle, Long>{

  boolean existsACattleByName(final String name);
  
}
