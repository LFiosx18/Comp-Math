package integrals;

public interface Equation {
    String showEquation();
    Double getEquation(double x);

    double secondDerivative(double x);
    Double F(double x);
    boolean checkGap(double a, double b);
}
