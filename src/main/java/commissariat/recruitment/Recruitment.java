package commissariat.recruitment;

import commissariat.human.Human;

import java.util.ArrayList;
import java.util.List;

public class Recruitment {
List<Human> humans = new ArrayList<Human>();

    public void addRecruit(Human human) {
        if (human.isMilitaryService()) {
            return;
        }
        if (human.getGender().equals("female") || human.getAge() < 16) {
            return;
        }
        humans.add(human);
    }

    public void remove(Human human) {

    }

    public void update(Human human) {

    }

    public void print() {

    }
}
