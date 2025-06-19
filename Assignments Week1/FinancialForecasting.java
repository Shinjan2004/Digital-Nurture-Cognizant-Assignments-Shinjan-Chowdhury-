import java.util.*;

public class FinancialForecasting {
    public static double recursiveForecast(double initialValue, double[] growthRates, int period) {
        if (period == 0) {
            return initialValue;
        }
        return recursiveForecast(initialValue, growthRates, period - 1)
               * (1 + growthRates[period - 1]);
    }

    public static void main(String[] args) {
        double initialValue = 1000.0;
        double[] pastGrowth = { 0.05, 0.03, 0.04, 0.02 }; // e.g. last 4 years

        // Forecast year-by-year up to 4 years ahead
        for (int year = 1; year <= pastGrowth.length; year++) {
            double fv = recursiveForecast(initialValue, pastGrowth, year);
            System.out.printf("Year %d forecasted value: %.2f%n", year, fv);
        }
    }
}
