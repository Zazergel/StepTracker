import java.util.Scanner;

public class StepTracker {
    String[] monthsNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    MonthData[] monthToData;
    Scanner scanner;
    int intentSteps = 10000;

    public StepTracker(Scanner scanner) {
        this.scanner = scanner;
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData(monthsNames[i]);
        }
    }

    void saveIntSteps() {
        System.out.println("Ваша текущая цель " + intentSteps + " шагов в день!");
        while (true) {
            System.out.println("Укажите целевое количество шагов в день:");
            int intSteps = scanner.nextInt();
            if (intSteps <= 0) {
                System.out.println("Ошибка! Число должно быть больше 0!");
            } else {
                System.out.println("Успех! Теперь ваша цель " + intSteps + " шагов в день!");
                intentSteps = intSteps;
                break;
            }
        }
    }

    public MonthData getMonths(int monthNum) {

        return monthToData[monthNum];
    }

    public void printDays(int mh) {

        for (int i = 0; i < 30; i++) {
            System.out.print("День: " + (i + 1) + " шагов: " + getMonths(mh).getStepsByDay(i) + ", ");
        }
    }

    public int printSumSteps(int mh) {
        int sumSteps = 0;
        for (int i = 0; i < 30; i++) {
            sumSteps = getMonths(mh).getStepsByDay(i) + sumSteps;
        }
        return sumSteps;

    }

    public int findMaxSteps(int mh) {
        int maxSteps = 0;
        for (int i = 0; i < 30; i++) {
            if (getMonths(mh).getStepsByDay(i) > maxSteps) {
                maxSteps = getMonths(mh).getStepsByDay(i);
            }
        }
        return maxSteps;
    }

    public int printMeanSteps(int sum) {
        return sum / 30;
    }

    public int findBestSeries(int mh, int intentSteps) {
        int best = 0;
        int bestSave = 0;
        for (int i = 0; i < 30; i++) {
            if (getMonths(mh).getStepsByDay(i) >= intentSteps) {
                best = best + 1;
            } else {
                best = 0;
            }
            if (best > bestSave) {
                bestSave = best;
            }
        }
        return bestSave;
    }

    public void printSaveIntSteps() {
        System.out.println("Выберите месяц: 0-Jan, 1-Feb 2-Mar 3-Apr 4-May 5-Jun 6-Jul " +
                           "7-Aug 8-Sep 9-Oct 10-Nov 11-Dec");
        int mh = scanner.nextInt();
        while (mh < 0 || mh > 11) {
            System.out.println("Ошибка! Выберите месяц: 0-Jan, 1-Feb 2-Mar 3-Apr 4-May 5-Jun 6-Jul " +
                               "7-Aug 8-Sep 9-Oct 10-Nov 11-Dec");
            mh = scanner.nextInt();
        }
        MonthData monthData = getMonths(mh);
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
        monthData.setStepsInDay(dayOfMonth, steps);
    }

    public void printStatistic() {
        System.out.println("Выберите месяц: 0-Jan, 1-Feb 2-Mar 3-Apr 4-May 5-Jun 6-Jul " +
                           "7-Aug 8-Sep 9-Oct 10-Nov 11-Dec");
        int mh = scanner.nextInt();
        while (mh < 0 || mh > 11) {
            System.out.println("Ошибка! Выберите месяц: 0-Jan, 1-Feb 2-Mar 3-Apr 4-May 5-Jun 6-Jul " +
                               "7-Aug 8-Sep 9-Oct 10-Nov 11-Dec");
            mh = scanner.nextInt();
        }
        int sumSteps = printSumSteps(mh);
        Converter converter = new Converter(sumSteps);
        System.out.println("Статистика за месяц " + getMonths(mh).name + ":");
        System.out.println("Всего шагов за данный месяц: " + sumSteps);
        System.out.println("Среднее количество шагов за указанный месяц: " +
                           printMeanSteps(sumSteps));
        System.out.println("Максимальное пройденное кол-во шагов за день: " + findMaxSteps(mh));
        System.out.println("Пройденная дистанция составила " + converter.convertToKm(sumSteps) + " км");
        System.out.println("Вы успешно сожгли " + converter.convertToCcal(sumSteps) + " килокалорий!");
        System.out.println("Вы достигали своей цели по кол-ву шагов " + findBestSeries(mh, intentSteps) +
                           " дней подряд!");
        printDays(mh);
    }
}









