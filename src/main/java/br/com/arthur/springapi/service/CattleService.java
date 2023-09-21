package br.com.arthur.springapi.service;

import java.util.List;

import br.com.arthur.springapi.dto.CattleDto;
import br.com.arthur.springapi.model.Cattle;

public interface CattleService {
  
  Cattle createCattle(final CattleDto cattleData);
  
  List<Cattle> readCattle();

  Cattle updateCattle(final CattleDto cattleData, final long id);

  void deleteCattle(final long id);
  
}
