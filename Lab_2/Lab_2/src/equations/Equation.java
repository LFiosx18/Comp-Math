package equations;

public interface Equation {
    String showEquation();
    double getEquation(double x);

    double firstDerivative(double x);
    double secondDerivative(double x);
}
