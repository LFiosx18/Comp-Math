package equations;

import static java.lang.Math.*;

public class SecondEquation implements Equation{

    @Override
    public String showEquation() { return "sin(2x) * 5cos(x) + 1 = 0"; }

    @Override
    public double getEquation(double x) {
        return (sin(2*x)*5*cos(x)+1);
    }

    @Override
    public double firstDerivative(double x) {
        return (10*cos(2*x)*cos(x)-5*sin(2*x)*sin(x));
    }

    @Override
    public double secondDerivative(double x) {
        return (-25*sin(2*x)*cos(x)-20*cos(2*x)*sin(x));
    }
}
