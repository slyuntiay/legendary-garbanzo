package population;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Random;

//@Getter
public class Population {
    private static ArrayList<Human> humans = new ArrayList<>();
    private static Random random = new Random();
    private static int humanId = -1;
    private Human human;

    public void addHumans(int limit) {
        if (limit < 1) return;
        while (humans.size() < limit) {
            ++humanId;
            human = new Human(humanId, random.nextInt(0, 66), random.nextInt());
            human.setGender();
            humans.add(human);
        }
    }

    public static ArrayList<Human> getHumans() {
        return humans;
    }
}



