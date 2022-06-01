package functions;

import interpolation.Interpolation;

import static java.lang.Math.pow;
import static java.lang.Math.random;

public class FirstF implements Function{
    @Override
    public String showFunction() {
        return "x^2";
    }

    @Override
    public double getFunction(double x) {
        return pow(x, 2);
    }

    @Override
    public double getFNoise(double x) {
        if (Interpolation.noise)
            return pow(x, 2)+(random()-0.5);
        return pow(x, 2);
    }
}
