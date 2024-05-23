package org.example;

public class Ciudad {

  private String nombre;
  private String provincia;
  private int habitantes;

  public Ciudad(String provincia, String nombre, int habitantes) {
    this.nombre = nombre;
    this.provincia = provincia;
    this.habitantes = habitantes;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getProvincia() {
    return provincia;
  }

  public void setProvincia(String provincia) {
    this.provincia = provincia;
  }

  public int getHabitantes() {
    return habitantes;
  }

  public void setHabitantes(int habitantes) {
    this.habitantes = habitantes;
  }

  @Override
  public String toString() {
    return "Ciudad{" +
            "nombre='" + nombre + '\'' +
            ", provincia='" + provincia + '\'' +
            ", habitantes=" + habitantes +
            '}';
  }
}
