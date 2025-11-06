package commissariat.recruitment;

import commissariat.human.Human;

public class Recruitment {

    public void add(Human human) {
        if (human.isMilitaryService()) {
            return;
        }
        if (human.getGender().equals("female") || human.getAge() < 16) {
            return;
        }
        //
    }

    public void remove(Human human) {

    }

    public void update(Human human) {

    }

    public void print() {

    }
}
