import population.Population;

public class Demo {
    public static void main(String[] args) {
        Population population = new Population();
        population.addHumans(50);
        System.out.println(population.getHumans());
    }
}
