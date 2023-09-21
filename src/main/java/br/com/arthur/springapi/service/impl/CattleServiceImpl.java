package br.com.arthur.springapi.service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.com.arthur.springapi.dto.CattleDto;
import br.com.arthur.springapi.exception.AppException;
import br.com.arthur.springapi.model.Cattle;
import br.com.arthur.springapi.repository.CattleRepository;
import br.com.arthur.springapi.service.CattleService;

@Service
public class CattleServiceImpl implements CattleService{
  
  private final CattleRepository cattleRepository;

  public CattleServiceImpl(CattleRepository cattleRepository) {
    this.cattleRepository = cattleRepository;
  }

  private void checkName(final CattleDto cattleData) {
    if (cattleRepository.existsACattleByName(cattleData.getName())) {
      throw new AppException("Name already exists", HttpStatus.CONFLICT);
    }
  }

  public Cattle createCattle(final CattleDto cattleData) {

    checkName(cattleData);

    final Cattle cattle = new Cattle(cattleData.getName(), cattleData.getRace(), cattleData.getAge(), cattleData.getPrice(), cattleData.getCity(), cattleData.getState(), cattleData.getPhoto());

    return cattleRepository.save(cattle);
  }

  public List<Cattle> readCattle() {
    return cattleRepository.findAll();
  }

  public Cattle retrieveCattle(final long id) {
    
    return cattleRepository.findById(id).orElseThrow(() -> new AppException("Id not found", HttpStatus.NOT_FOUND));

  }
  
  public Cattle updateCattle(final CattleDto cattleData, final long id) {
    
    checkName(cattleData);

    final Cattle cattle = cattleRepository.findById(id).orElseThrow(() -> new AppException("Id not found", HttpStatus.NOT_FOUND));

    cattle.setName(cattleData.getName());
    cattle.setRace(cattleData.getRace());
    cattle.setAge(cattleData.getAge());
    cattle.setPrice(cattleData.getPrice());
    cattle.setCity(cattleData.getCity());
    cattle.setState(cattleData.getState());
    cattle.setPhoto(cattleData.getPhoto());
    
    return cattleRepository.save(cattle);
  }

  public void deleteCattle(final long id) {
    final Cattle cattle = cattleRepository.findById(id).orElseThrow(() -> new AppException("Id not found!", HttpStatus.NOT_FOUND));

    cattleRepository.delete(cattle);
  }
  
}
