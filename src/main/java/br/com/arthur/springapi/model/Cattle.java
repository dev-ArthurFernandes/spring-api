package br.com.arthur.springapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cattles")
public class Cattle {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(length = 120, nullable = false)
  private String name;

  @Column(length = 50, nullable = false)
  private String race;

  @Column(nullable = false)
  private Number age;

  @Column(columnDefinition = "DECIMAL DEFAULT 0.0", nullable = false)
  private Float price;

  @Column(length = 50, nullable = false)
  private String city;

  @Column(length = 2, nullable = false)
  private String state;

  @Column(nullable = false)
  private String photo;

  public long getId() {
    return id;
  }

  public Cattle() {}

  public Cattle(String name, String race, Number age , Float price, String city, String state, String photo) {
    this.name = name;
    this.race = race;
    this.age = age;
    this.price = price;
    this.city = city;
    this.state = state;
    this.photo = photo;
  }

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

  public Number getAge() {
    return age;
  }

  public void setAge(Number age){
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

  public String getPhoto(){
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  @Override
  public String toString() {
    return "Cattle [id=" + id + ", name=" + name + ", race=" + race + ", age=" + age + ", price=" + price + ", city="
        + city + ", state=" + state + ", photo=" + photo + "]";
  }

}
