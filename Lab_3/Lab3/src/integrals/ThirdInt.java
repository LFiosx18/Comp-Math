package integrals;

import static java.lang.Math.*;

public class ThirdInt implements Equation {
    @Override
    public String showEquation() {
        return "1/x";
    }

    @Override
    public Double getEquation(double x) {
        if (x!=0)
            return 1/x;
        return null;
    }
    @Override
    public double secondDerivative(double x) {
        return 2/pow(x, 3);
    }

    @Override
    public Double F(double x) {
        return log(abs(x));
    }

    @Override
    public boolean checkGap(double a, double b) {
        return a <= 0 && b >= 0;
    }
}
