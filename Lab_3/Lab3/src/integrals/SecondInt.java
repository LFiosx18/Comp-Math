package integrals;

import static java.lang.Math.*;

public class SecondInt implements Equation {
    @Override
    public String showEquation() {
        return "sin(x)/x";
    }

    @Override
    public Double getEquation(double x) {
        if (x!=0)
            return sin(x)/x;
        return 1.0;
    }

    @Override
    public double secondDerivative(double x) {
        return (-pow(x, 2)*sin(x)-2*x*cos(x)+2*sin(x))/pow(x, 3);
    }

    @Override
    public Double F(double x) {
        return null;
    }

    @Override
    public boolean checkGap(double a, double b) {
        return a <= 0 && b >= 0;
    }
}
