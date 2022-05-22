package integrals;

import static java.lang.Math.pow;

public class FirstInt implements Equation {
    @Override
    public String showEquation() {
        return "0.5*x^3 + 2*x^2 - 2";
    }

    @Override
    public Double getEquation(double x) {
        return (0.5*pow(x, 3)+2*pow(x, 2)-2);
    }

    @Override
    public double secondDerivative(double x) {
        return (3*x+4);
    }

    @Override
    public Double F(double x) {
        return pow(x, 4)/8+2*pow(x, 3)/3-2*x;
    }

    @Override
    public boolean checkGap(double a, double b) {
        return false;
    }
}
