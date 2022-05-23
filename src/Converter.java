public class Converter {
    int sumSteps;

    Converter(int steps) {
       sumSteps = steps;
    }

    int convertToKm(int sumSteps) {
        int km = (sumSteps * 75) / 100000;
        return km;
    }
    int convertToCcal(int sumSteps) {
        int ccal = (sumSteps * 50) / 1000;
        return ccal;
    }

}
