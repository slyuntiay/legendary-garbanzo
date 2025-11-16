package vaDick;

import java.util.HashMap;

public class UniqueArrayElement {
    public static void main(String[] args) {
        HashMap<Integer, Integer> mapElement = new HashMap<Integer, Integer>();
        int [] arrayElement = {2,3,4,5,6,7,8,9,10,10,20,30,20,11,25,6346,647,2,1,325,2,3,5,6,77,8};
        for (int i : arrayElement) {
            if (!mapElement.containsKey(i)) {
                mapElement.put(i, 1);
            }else{
                mapElement.put(i, mapElement.get(i) + 1);
            }

           }
        for(int i : arrayElement){
            if(mapElement.get(i) == 1) {
                System.out.print(i + " первый уникальный");
                break;
            }
        }
    }
}
