package commissariat;

import commissariat.recruitment.Recruitment;
import population.Recruit;

public class Commissariat {

    private Recruitment recruitment;

    public static void main(String[] args) {
        Commissariat commissariat = new Commissariat();
        Recruitment recruitment = new Recruitment();

        Recruit recruit1 = new Recruit(1, "Иван", 20, "male");
        Recruit recruit2 = new Recruit(2, "Олег", 22, "female");
        Recruit recruit3 = new Recruit(3, "ХЗ", 17, "male");

        commissariat.recruitment.addRecruit(recruit1);
        commissariat.recruitment.addRecruit(recruit2);
        commissariat.recruitment.addRecruit(recruit3);

        commissariat.recruitment.print();
    }
}