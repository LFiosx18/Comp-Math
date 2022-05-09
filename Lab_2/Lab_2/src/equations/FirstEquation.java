package equations;

import static java.lang.Math.exp;
import static java.lang.Math.pow;

public class FirstEquation implements Equation{

    @Override
    public String showEquation() {
        return "0.5x^4 - x*e^x + 10 = 0";
    }

    @Override
    public double getEquation(double x) {
        return (0.5*pow(x, 4)-x*pow(exp(1), x)+10);
    }

    @Override
    public double firstDerivative(double x) {
        return (2*pow(x, 3)-pow(exp(1), x)-x*pow(exp(1), x));
    }

    @Override
    public double secondDerivative(double x) {
        return (6*pow(x, 2)-2*pow(exp(1), x)-x*pow(exp(1), x));
    }
}
