package system;


import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class FirstEqSystem implements EquationSystem {

    @Override
    public String showEquation() {
        return "2*x^2 - xy -5x + 1 = 0";
    }

    @Override
    public double getEquation(double x, double y) {
        return (sqrt((x*(y+5)-1)/2));
    }
}
