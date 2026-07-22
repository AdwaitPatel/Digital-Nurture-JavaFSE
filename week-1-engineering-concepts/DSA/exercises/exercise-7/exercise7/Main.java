package cognizant.dsa.exercise7;

public class Main {

    public static void main(String[] args) {

        double currentValue = 10000;
        double growthRate = 0.10; // -> 10%
        int years = 5;

        double futureValue = FinancialForecast.calculateFutureValue(
                currentValue,
                growthRate,
                years
        );

        System.out.println("Current Value : " + currentValue);
        System.out.println("Growth Rate   : " + (growthRate * 100) + "%");
        System.out.println("Years         : " + years);
        System.out.printf("Future Value  : %.2f%n", futureValue);
    }
}
