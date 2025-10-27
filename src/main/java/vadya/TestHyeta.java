package vadya;

import java.util.Scanner;

public class TestHyeta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //scanner.useDelimiter("\n");
        Hyeta hyeta = new Hyeta(scanner.nextInt());
        System.out.print("размер массива");

        for(int i = 0; i < hyeta.getChars().length; i++ ) {
            String input = scanner.nextLine();
            int charIndex = scanner.nextInt();
            if(charIndex < 0 || charIndex > input.length() -1 ){
                System.out.println("выход за пределы строки, присвою 0");
            }
            hyeta.getChars()[i] = scanner.next().charAt(charIndex);
            scanner.nextLine();
        }
        for (Character character : hyeta) {
            System.out.print(character);
        }


    }
}
