package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {

    List<Ciudad> ciudades = new ArrayList<>();

    ciudades.add(new Ciudad("Madrid", "Madrid", 3000));
    ciudades.add(new Ciudad("Madrid", "Madrid", 500));
    ciudades.add(new Ciudad("Barcelona", "Cataluña", 1500));
    ciudades.add(new Ciudad("Sevilla", "Andalucía", 10100));
    ciudades.add(new Ciudad("Valencia", "Comunidad Valenciana", 2000));
    ciudades.add(new Ciudad("Bilbao", "País Vasco", 5000));
    ciudades.add(new Ciudad("Sevilla", "Andalucía", 1031));

    System.out.println("Total ciudades: " + ciudades.stream().count());

    System.out.println(
        "Ciudades de Madrid con más de 1000 habitantes: "
            + ciudades.stream()
                .filter(
                    ciudad ->
                        ciudad.getProvincia().equals("Madrid") && ciudad.getHabitantes() > 1000)
                .count());

    String provincia =
        ciudades.stream()
            .map(Ciudad::getProvincia) // ciudad -> ciudad.getProvincia!!
            .distinct()
            .collect(
                Collectors.joining(
                    ", ")); // Quita las comas del final y evita tener que hacer un foreach.
    System.out.print("Provincias de las ciudades: " + provincia);

    long totalProvinciasDiferentes =
        ciudades.stream().map(ciudad -> ciudad.getProvincia()).distinct().count();
    System.out.println(
        "\nTotal de provincias diferentes: "
            + totalProvinciasDiferentes
            + " -> Estas provincias son: "
            + provincia);

    boolean ciudadMadridMasCincuentaMilHabitantes =
        ciudades.stream()
            .anyMatch(
                ciudad -> ciudad.getProvincia().equals("Madrid") && ciudad.getHabitantes() > 50000);
    System.out.println(
        "Hay alguna ciudad de Madrid con mas de 50000 habitantes: "
            + ciudadMadridMasCincuentaMilHabitantes);

    // Ejercicio completado.

    System.out.println("--------------------");

    // Cosas extras para practicar.

    boolean todasCiudadSevillaMAsMilHabitantes =
        (int)
                ciudades.stream()
                    .filter(
                        ciudad ->
                            ciudad.getProvincia().equals("Sevilla")
                                && ciudad.getHabitantes() <= 1000)
                    .count()
            == 0;
    System.out.println(
        "Tienen todas las ciudades de Sevilla mas de 1000 habitantes: "
            + todasCiudadSevillaMAsMilHabitantes);

    ciudades.stream()
        .max(Comparator.comparing(Ciudad::getHabitantes))
        .ifPresent(
            ciudad -> System.out.println("Provincia con mas habitantes: " + ciudad.getProvincia()));

    ciudades.stream()
        .min(Comparator.comparing(Ciudad::getHabitantes))
        .ifPresent(
            ciudad ->
                System.out.println("Provincia con menos habitantes: " + ciudad.getProvincia()));

    System.out.println(
        "Total de habitantes: "
            + ciudades.stream().mapToInt(Ciudad::getHabitantes).sum()
            + " habitantes");

    // Sacar toda la informacion de las ciudades.
    ciudades.forEach(System.out::println);
    
  }
}
