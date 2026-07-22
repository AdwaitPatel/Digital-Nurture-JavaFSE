package cognizant.dsa.exercise7;

public class FinancialForecast {

    public static double calculateFutureValue(double currentValue, double growthRate, int years) {

        // base case condn
        if (years == 0) {
            return currentValue;
        }

        // recursive case
        return calculateFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }
}