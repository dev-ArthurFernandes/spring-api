package br.com.arthur.springapi.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.arthur.springapi.dto.CattleDto;
import br.com.arthur.springapi.model.Cattle;
import br.com.arthur.springapi.service.impl.CattleServiceImpl;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200/register")
@RequestMapping("/cattle")
public class CattleControler {
  private final CattleServiceImpl cattleService;

  public CattleControler(CattleServiceImpl cattleService) {
    this.cattleService = cattleService;
  }

  @PostMapping
  public ResponseEntity<Cattle> createCattle(@Valid @RequestBody final CattleDto data) {
      
    Cattle createCattle = cattleService.createCattle(data);
      
    return new ResponseEntity<>(createCattle, null, HttpStatus.CREATED);
  }
  
  @GetMapping
  public ResponseEntity<List<Cattle>> readCattle() {
    final List<Cattle> allCattle = cattleService.readCattle();

    return new ResponseEntity<>(allCattle, null, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Cattle> retrieveCattle(@PathVariable final String id)  {
    final Cattle cattle = cattleService.retrieveCattle(Long.parseLong(id));

    return new ResponseEntity<>(cattle, null, HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Cattle> updateCattle(@Valid @RequestBody final CattleDto cattleData, @PathVariable final String id)  {
    final Cattle cattle = cattleService.updateCattle(cattleData, Long.parseLong(id));

    return new ResponseEntity<>(cattle, null, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCattle(@PathVariable final String id) {
    cattleService.deleteCattle(Long.parseLong(id));

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
