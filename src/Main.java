import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    StepTracker st = new StepTracker();
    int intentSteps = 10000;
    MonthData monthData;
    st.MonthsCreate();

        while(true) {
            printMenu();
            int userInput = scanner.nextInt();
            if (userInput == 1) {
                System.out.println("Выберите месяц: 0-Jan, 1-Feb 2-Mar 3-Apr 4-May 5-Jun 6-Jul " +
                    "7-Aug 8-Sep 9-Oct 10-Nov 11-Dec");
                int mh = scanner.nextInt();
                while (mh < 0 || mh > 11) {
                    System.out.println("Ошибка! Выберите месяц: 0-Jan, 1-Feb 2-Mar 3-Apr 4-May 5-Jun 6-Jul " +
                                "7-Aug 8-Sep 9-Oct 10-Nov 11-Dec");
                        mh = scanner.nextInt();
                }
                monthData = st.getMonths(mh);
                String monthName = monthData.name;
                System.out.println("В какое число (1-30) месяца " + monthName + " вы хотите ввести шаги?");
                int dayOfMonth = scanner.nextInt();
                while (dayOfMonth < 1 || dayOfMonth > 30) {
                    System.out.println("Ошибка! Введите число в диапазоне от 1 до 30!");
                    dayOfMonth = scanner.nextInt();
                }
                System.out.println("Сколько шагов вы прошли?");
                int steps = scanner.nextInt();
                while (steps < 0) {
                    System.out.println("Ошибка! Введите положительное число!");
                    steps = scanner.nextInt();
                }
                monthData.setStepsInDay(dayOfMonth,steps);
             } else if (userInput == 2) {
                System.out.println("Выберите месяц: 0-Jan, 1-Feb 2-Mar 3-Apr 4-May 5-Jun 6-Jul " +
                        "7-Aug 8-Sep 9-Oct 10-Nov 11-Dec");
                int mh = scanner.nextInt();
                int sumSteps = st.printSumSteps(mh);
                Converter converter = new Converter(sumSteps);
                System.out.println("Статистика за месяц " + st.getMonths(mh).name + ":");
                System.out.println("Всего шагов за данный месяц: " + sumSteps);
                System.out.println("Среднее количество шагов за указанный месяц: " +
                        st.printMeanSteps(sumSteps));
                System.out.println("Максимальное пройденное кол-во шагов за день: " + st.findMaxSteps(mh));
                System.out.println("Пройденная дистанция составила " + converter.convertToKm(sumSteps) + " км");
                System.out.println("Вы успешно сожгли " + converter.convertToCcal(sumSteps) + " килокалорий!");
                System.out.println("Вы достигали своей цели по кол-ву шагов " + st.findBestSeries(mh, intentSteps) +
                        " дней подряд!");
                st.printDays(mh);
             } else if (userInput == 3) {
                System.out.println("Ваша цель " + intentSteps + " шагов в день!");
                intentSteps = st.saveIntSteps();
            } else if (userInput == 0) {
                System.out.println("Программа завершена");
                break;
            } else {
                System.out.println("Извините, такой команды нет.");
            }
    }
}
    private static void printMenu() {
        System.out.println("Выберите действие: ");
        System.out.println("1 - Ввести количество шагов за определенный день");
        System.out.println("2 - Напечатать статистику за определенный месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Завершить программу");
    }
}


