package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Неверная команда. Введите 1, 2, 3.");
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("*".repeat(35));
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();

        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        boolean isAdded = dc.addNewDish(dishType, dishName);
        if (isAdded) {
            System.out.println("Блюдо " + dishName + " было добавлено в категорию " + dishType);
        } else {
            System.out.println("Блюдо " + dishName + " уже есть в в меню.");
        }
    }

    private static void generateDishCombo() {
        ArrayList<String> types = new ArrayList<>();

        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();

        //реализуйте ввод типов блюд
        while (!nextItem.isEmpty()) {
            if (dc.checkType(nextItem)) {
                types.add(nextItem);
            } else {
                System.out.println("Введеный тип блюд не существует.");
            }
            nextItem = scanner.nextLine();
        }

        // сгенерируйте комбинации блюд и выведите на экран
        ArrayList<ArrayList<String>> combos = dc.generateCombos(numberOfCombos, types);
        for (ArrayList<String> combo : combos) {
            System.out.println("Комбо обед - " + combo);
        }
    }
}
