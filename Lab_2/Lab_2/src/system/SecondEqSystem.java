package system;

import static java.lang.Math.*;

public class SecondEqSystem implements EquationSystem {

    @Override
    public String showEquation() {
        return "x + 3*lg(x) - y^2 = 0";
    }

    @Override
    public double getEquation(double x, double y) {
        if (y>0)
            return (sqrt(x+3*log10(x)));
        return (-sqrt(x+3*log10(x)));
    }
}
