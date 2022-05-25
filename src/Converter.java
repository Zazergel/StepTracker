public class Converter {
    int sumSteps;

    Converter(int steps) {
       sumSteps = steps;
    }

    //Конвертация шагов в километры
    double convertToKm(int sumSteps) {
        return (sumSteps * 75f) / 100000;
    }

    //Конвертация шагов в килокалории
    double convertToCcal(int sumSteps) {
        return (sumSteps * 50f) / 1000;
    }

}
