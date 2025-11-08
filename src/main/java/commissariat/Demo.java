package commissariat;

import commissariat.population.Population;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Population population = new Population();
        population.addHumans(scanner.nextInt());
        System.out.println(population.getHumans());
    }
}
