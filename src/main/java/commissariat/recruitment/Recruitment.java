//package commissariat.recruitment;
//
//import population.Human;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Recruitment {
//    private ArrayList<Human> x;// ТУТ ОТСОРТИРОВАНЫ ХУМАНЫ ОТ ЖЕНЩИН И КОТОРЫЕ ПОДХОДЯТ ПО ВОЗРАСТУ (не придумал название листа)
//
//    public Recruitment() {
//    }
//
//    public Recruitment(ArrayList<Human> x) {
//        this.x = x;
//    }
//
//    public void addRecruit(Human human) {
//        if (human.getAge() >= 18 && human.getAge() <= 30 && human.getGender().equals("male")) {
//            x.add(human);
//        }
//        return;
//    }
//
//    public void remove(Human human) {
//        x.remove(human);
//    }
//
//    public void update(Human human) {
//
//    }
//
//    public void print() {
//        for (Human human : x) {
//            if (human != null) {
//                System.out.println("ID: " + human.getId() + ", Name: " + human.getName() + ", Age: " + human.getAge());
//                //хз тут запутался
//            }
//        }
//    }
//}
