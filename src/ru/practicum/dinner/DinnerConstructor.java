package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    Random random;
    HashMap<String, ArrayList<String>> dishByType;

    public DinnerConstructor() {
        random = new Random();
        dishByType = new HashMap<>();
    }

    boolean addNewDish(String type, String name) {
        ArrayList<String> dishes = dishByType.get(type);
        if (dishes == null) {
            dishes = new ArrayList<>();
            dishByType.put(type, dishes);
        }
        if (dishes.contains(name)) {
            return false;
        } else {
            dishes.add(name);
            return true;
        }
    }

    boolean checkType(String type) {
        return dishByType.containsKey(type);
    }

    ArrayList<ArrayList<String>> generateCombos(int numberOfCombos, ArrayList<String> types) {
        ArrayList<ArrayList<String>> combos = new ArrayList<>();

        for (int i = 0; i < numberOfCombos; i++) {
            ArrayList<String> combo = new ArrayList<>();
            for (String type : types) {
                ArrayList<String> dishes = dishByType.get(type);
                if (dishes != null && !dishes.isEmpty()) {
                    int randomIndex = random.nextInt(dishes.size());
                    combo.add(dishes.get(randomIndex));
                } else {
                    System.out.println("В категории " + type + " нет блюд.");
                }
            }
            combos.add(combo);
        }
        return combos;
    }
}
