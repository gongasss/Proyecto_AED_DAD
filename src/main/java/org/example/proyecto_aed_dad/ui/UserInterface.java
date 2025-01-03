package org.example.proyecto_aed_dad.ui;

import org.example.proyecto_aed_dad.dao.Mediator;
import org.example.proyecto_aed_dad.entity.Circuit;
import org.example.proyecto_aed_dad.entity.Constructor;
import org.example.proyecto_aed_dad.entity.Driver;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Mediator mediator;
    private Scanner scanner;

    public UserInterface(Mediator mediator) {
        this.mediator = mediator;
        this.scanner = new Scanner(System.in);
    }

    public void mainLoop() {
        while (true) {
            showMainMenu();
            int option = getValidOption();
            if (option == 0) {
                System.out.println("Saliendo del programa...");
                System.exit(0);
            }
            showHQLMenu();
            option = getValidOption();
            showHQL(option);
        }
    }

    private int getValidOption() {
        System.out.print("Escribe la opción que deseas realizar: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, introduce un número válido.");
            scanner.next();
        }
        int option = scanner.nextInt();
        scanner.nextLine();
        if (option < 0 || option > 7) {
            System.out.println("Opción no válida. Por favor, elige una opción entre 0 y 1.");
            return getValidOption();
        }
        return option;
    }

    public void showMainMenu() {
        System.out.println("\n===============================");
        System.out.println("     Bienvenido a AED");
        System.out.println("===============================");
        System.out.println("\n-----MENU-----");
        System.out.println("1. Consultas HQL");
        System.out.println("0. Salir");
    }

    public void showHQLMenu() {
        System.out.println("\n-----CONSULTAS HQL-----");
        System.out.println("1. Pilotos que hayan quedado más veces en el Top10 en un circuito dado.");
        System.out.println("2. Circuitos con más número de carreras celebradas.");
        System.out.println("3. Equipos con más victorias por país.");
        System.out.println("4. Equipos con más victorias en un circuito dado.");
        System.out.println("5. Pilotos con más carreras.");
        System.out.println("6. Pilotos con más carreras en un circuito dado.");
        System.out.println("7. Pilotos con más victorias.");
        System.out.print("Selecciona una opción: ");
    }

    public void showHQL(int option) {
        try {
            switch (option) {
                case 1:
                    showDriversWithMostTop10();
                    break;
                case 2:
                    showTracksWithMostRaces();
                    break;
                case 3:
                    showConstructorsByCountry();
                    break;
                case 4:
                    showConstructorsWithMostWinsInCircuit();
                    break;
                case 5:
                    showDriversWithMostRaces();
                    break;
                case 6:
                    showDriversWithMostRacesInCircuit();
                    break;
                case 7:
                    showDriversWithMostWins();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción entre 1 y 7.");
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error inesperado: " + e.getMessage());
        }
    }

    private void showDriversWithMostTop10() {
        List<Object[]> drivers = mediator.driversWithMostTop10ItalyCircuits();
        System.out.println("\n-----PILOTOS CON MÁS TOP10 EN ITALIA-----");
        for (Object[] result : drivers) {
            Driver driver = (Driver) result[0];
            long count = (long) result[1];
            System.out.printf("%-20s%-20s | %d\n", driver.getForename(), driver.getSurname(), count);
        }
    }

    private void showTracksWithMostRaces() {
        List<Object[]> tracks = mediator.tracksWithMostRaces();
        System.out.println("\n-----CIRCUITOS CON MÁS CARRERAS-----");
        for (Object[] result : tracks) {
            Circuit circuit = (Circuit) result[0];
            long count = (long) result[1];
            System.out.printf("%-20s | %d grandes premios celebrados.\n", circuit.getName(), count);
        }
    }

    private void showConstructorsByCountry() {
        System.out.print("Escribe el país que deseas consultar (en inglés): ");
        String country = scanner.nextLine().trim();

        if (country.isEmpty()) {
            System.out.println("El país no puede estar vacío.");
            return;
        }

        List<Object[]> constructors = mediator.constructorsWithMostWinsByCountry(country);
        System.out.println("\n-----CONSTRUCTORES CON MÁS VICTORIAS EN " + country.toUpperCase() + "-----");
        if (constructors.isEmpty()) {
            System.out.println("No se encontraron resultados para el país " + country);
        } else {
            for (Object[] result : constructors) {
                Constructor constructor = (Constructor) result[0];
                long count = (long) result[1];
                System.out.printf("%-30s | %d victorias\n", constructor.getConstructorRef(), count);
            }
        }
    }

    private void showConstructorsWithMostWinsInCircuit() {
        showAllCircuits();
        int circuitId = getValidCircuitId();
        if (circuitId == -1) return;

        Circuit circuit = mediator.getCircuitDao().getById(circuitId);
        List<Object[]> constructorsWithMostWinsByCircuit = mediator.constructorsWithMostWinsByCircuit(circuit);
        System.out.println("\n-----EQUIPOS CON MÁS VICTORIAS EN " + circuit.getCircuitRef() + " -----");
        for (Object[] result : constructorsWithMostWinsByCircuit) {
            Constructor constructor = (Constructor) result[0];
            long count = (long) result[1];
            System.out.printf("%-30s | %d victorias\n", constructor.getConstructorRef(), count);
        }
    }

    private void showDriversWithMostRaces() {
        List<Object[]> driversWithMostRaces = mediator.driversWithMostRaces();
        System.out.println("\n-----PILOTOS CON MÁS CARRERAS-----");
        for (Object[] result : driversWithMostRaces) {
            Driver driver = (Driver) result[0];
            long count = (long) result[1];
            System.out.printf("%-20s%-20s | %d grandes premios comenzados.\n", driver.getForename(), driver.getSurname(), count);
        }
    }

    private void showDriversWithMostRacesInCircuit() {
        showAllCircuits();
        int circuitId = getValidCircuitId();
        if (circuitId == -1) return;

        Circuit circuit = mediator.getCircuitDao().getById(circuitId);
        List<Object[]> driversWithMostRacesByCircuit = mediator.driversWithMostRacesByCircuit(circuit);
        System.out.println("\n-----PILOTOS CON MÁS CARRERAS EN " + circuit.getCircuitRef() + " -----");
        for (Object[] result : driversWithMostRacesByCircuit) {
            Driver driver = (Driver) result[0];
            long count = (long) result[1];
            System.out.printf("%-20s%-20s | %d carreras\n", driver.getForename(), driver.getSurname(), count);
        }
    }

    private void showDriversWithMostWins() {
        List<Object[]> driversWithMostWins = mediator.driversWithMostWins();
        System.out.println("\n-----PILOTOS CON MÁS VICTORIAS-----");
        for (Object[] result : driversWithMostWins) {
            Driver driver = (Driver) result[0];
            long count = (long) result[1];
            System.out.printf("%-20s%-20s | %d victorias\n", driver.getForename(), driver.getSurname(), count);
        }
    }

    private void showAllCircuits() {
        List<Circuit> circuits = mediator.getCircuitDao().findAll();
        System.out.println("\n-----LISTA DE CIRCUITOS-----");
        for (Circuit circuit : circuits) {
            System.out.printf("%d. %-20s | %s\n", circuit.getId(), circuit.getCircuitRef(), circuit.getName());
        }
    }

    private int getValidCircuitId() {
        System.out.print("Escribe el id del circuito que deseas consultar: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, introduce un número válido.");
            scanner.next(); // Limpiar el buffer
            System.out.print("Escribe el id del circuito que deseas consultar: ");
        }
        int circuitId = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de la línea
        if (circuitId <= 0) {
            System.out.println("ID de circuito no válido. Debe ser un número mayor que 0.");
            return -1;
        }
        return circuitId;
    }
}
