package spring_test;

import lombok.Setter;

public class Person {
    //@Setter
    private Pet pet;

    public Person(Pet pet) {
        this.pet = pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void callMyPet() {
        System.out.println("Hello my lovely friend!");
        pet.voice();
    }
}
