package br.com.arthur.springapi.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CattleDto {
  
  @NotEmpty(message = "Name cannot be empty")
  @Size(min=3, message = "Name must be heigher than 3 characters")
  @Size(max=120, message = "Name must be lower than 120 characters")
  private String name;

  @NotEmpty(message = "Race cannot be empty")
  @Size(min=3, message = "Race must be heigher than 3 characters")
  @Size(max=50, message = "Race must be lower than 50 characters")
  private String race;

  @NotNull(message = "Age cannot be null")
  private int age;

  @NotNull(message = "Price cannot be empty")
  @DecimalMin(value = "0.01", message = "Value must be higher than 0.01")
  private Float price;

  @NotEmpty(message = "City cannot be empty")
  @Size(min=4, message = "City must be heigher than 3 characters")
  @Size(max=50, message = "City must be lower than 120 characters")
  private String city;

  @NotEmpty(message = "State cannot be empty")
  @Size(min=2, message = "The state must be 2 characters long")
  @Size(max=2, message = "The state must be 2 characters long")
  private String state;

  @NotEmpty(message = "Photo cannot be empty")
  private String photo;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRace() {
    return race;
  }

  public void setRace(String race) {
    this.race = race;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  

}
