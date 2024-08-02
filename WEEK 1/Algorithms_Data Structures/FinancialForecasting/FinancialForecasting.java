public class FinancialForecasting {
    
    public static double calculateFutureValue(double initialValue, double growthRate, int years) {
        if (years == 0) {
            return initialValue;
        }
        double previousValue = calculateFutureValue(initialValue, growthRate, years - 1);
        return previousValue * (1 + growthRate);
    }

    public static void main(String[] args) {
        double initialValue = 1000.0;
        double growthRate = 0.05;
        int years = 10;

        double futureValue = calculateFutureValue(initialValue, growthRate, years);
        System.out.println("Future Value after " + years + " years: " + futureValue);
    }
}
