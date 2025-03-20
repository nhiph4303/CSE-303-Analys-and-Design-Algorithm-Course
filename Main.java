import java.util.*;

class Main {

    static StringBuilder sb = new StringBuilder();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        double year = sc.nextDouble();
        double initialValue = sc.nextDouble();
        double residualValue = sc.nextDouble();
        double left = 0;
        double rate = 0;
        double right = 1;
        
        while (right - left > 0.00000001) {
            double mid = left + (right - left) / 2;
            double tempInitialValue = calculateResidualValue(mid, year, initialValue);
            
            if (tempInitialValue >= residualValue) {
                left = mid + 0.00000001;
            } else {
                right = mid - 0.00000001;
            }
            rate = mid;
        }
        
        System.out.println(String.format("%.7f\n", rate));
    }

    static double calculateResidualValue(double rate, double year, double tempInitialValue) {
        double tempRate = rate;
        for (double i = 0; i < year; i++) {
            tempRate = (rate - (rate * (i / year)));
            tempInitialValue = (1 - tempRate) * tempInitialValue;
        }
        return tempInitialValue;
    }
}
