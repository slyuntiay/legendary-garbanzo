package commissariat.population;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Random;

@Getter
public class Population {
    private ArrayList<Human> humans;
    private int id;

    public void addHumans(int limit) {
        if (limit < 1) return;
        if (humans == null) {
            humans = new ArrayList<>();
            id = -1;
        }
        Random random = new Random();
        while (humans.size() < limit) {
            ++id;
            Human human = new Human(id, random.nextInt(0, 66), random.nextInt());
            human.setGender();
            humans.add(human);
        }
    }
}



