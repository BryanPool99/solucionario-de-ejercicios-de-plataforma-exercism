public class CarsAssemble {

    public double productionRatePerHour(int speed) {
        final int PRODUCT_CONST = 221;
        double result = 0;
        if (speed >= 1 && speed <= 4) {
            result = speed * PRODUCT_CONST;
        } else if (speed >= 5 && speed <= 8) {
            result = speed * PRODUCT_CONST * 0.9;
        } else if (speed==9) {
            result = speed * PRODUCT_CONST * 0.8;
        } else if (speed == 10) {
            result = speed * PRODUCT_CONST * 0.77;
        }
        return result;
    }

    public int workingItemsPerMinute(int speed) {
        return (int) productionRatePerHour(speed) /60;
    }
}
