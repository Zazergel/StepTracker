public class MonthData {
    String name;
    int[] stepPerDay = new int[30];

    public MonthData(String monthName) {
        name = monthName;
    }
    public void setStepsInDay(int day, int steps) {
        stepPerDay[day-1] = stepPerDay[day-1] + steps;
    }
    public int getStepsByDay(int day) {

        return stepPerDay[day];
    }

}
