package equations;

import static java.lang.Math.*;
import static java.lang.Math.cos;

public class ThirdEquation implements Equation{

    @Override
    public String showEquation() { return "1/x - 2*sin(x) + 2^(-x) = 0"; }

    @Override
    public double getEquation(double x) {
        return (1/x-2*sin(x)+pow(2, -x));
    }

    @Override
    public double firstDerivative(double x) {
        return (-1/pow(x, 2)-2*cos(x)-log(2)/pow(2, x));
    }

    @Override
    public double secondDerivative(double x) {
        return (2/pow(x, 3)+2*sin(x)+(log(pow(2, 2))/pow(2, x)));
    }
}