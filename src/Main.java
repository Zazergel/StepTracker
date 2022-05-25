import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    StepTracker st = new StepTracker(scanner);

        while(true) {
            printMenu();
            int userInput = scanner.nextInt();
            if (userInput == 1) {
                st.printSaveIntSteps();
             } else if (userInput == 2) {
                st.printStatistic();
             } else if (userInput == 3) {
                st.saveIntSteps();
            } else if (userInput == 0) {
                System.out.println("Программа завершена");
                break;
            } else {
                System.out.println("Извините, такой команды нет.");
            }
    }
}

//Печать интерфейса главного меню
    private static void printMenu() {
        System.out.println("\n Выберите действие: ");
        System.out.println("1 - Ввести количество шагов за определенный день");
        System.out.println("2 - Напечатать статистику за определенный месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Завершить программу");
    }
}


