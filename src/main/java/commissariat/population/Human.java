package commissariat.population;

public class Human {
    private int id;
    private int age;
    private int genderId;
    private String gender;

    public Human(int id, int age, int genderId) {
        this.id = id;
        this.age = age;
        this.genderId = genderId;
    }

    public void setGender() {
        if (genderId % 2 == 0) {
            this.gender = "female";
        } else {
            this.gender = "male";
        }
    }

    @Override
    public String toString() {
        return id + ";" + age + ";" + gender;
    }
}

