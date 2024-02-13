public class Converter {
    int sumSteps;

    Converter(int steps) {
        sumSteps = steps;
    }

    double convertToKm(int sumSteps) {
        return (sumSteps * 75f) / 100000;
    }

    double convertToCcal(int sumSteps) {
        return (sumSteps * 50f) / 1000;
    }

}
