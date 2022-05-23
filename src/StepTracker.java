import java.util.Scanner;
public class StepTracker {
    Scanner scanner = new Scanner(System.in);
    String[] monthsNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    int saveIntSteps() {
        while (true) {
            System.out.println("Укажите целевое количество шагов в день:");
            int intSteps = scanner.nextInt();
            if (intSteps <= 0) {
                System.out.println("Ошибка! Число должно быть больше 0!");
            } else {
                System.out.println("Успех! Теперь ваша цель " + intSteps + " шагов в день!");
                return intSteps;
            }
        }
    }

    MonthData[] monthToData;

    public void MonthsCreate() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData(monthsNames[i]);
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
                bestSave = best;
            } else {
                best = 0;
            }
        }
        return Math.max(best, bestSave);
    }
}









