package functions;

import interpolation.Interpolation;

import static java.lang.Math.*;

public class SecondF implements Function{
    @Override
    public String showFunction() {
        return "2*sin(x)";
    }

    @Override
    public double getFunction(double x) {
        return 2*sin(x);
    }

    @Override
    public double getFNoise(double x) {
        if (Interpolation.noise)
            return 2*sin(x)+(random()-0.5);
        return 2*sin(x);
    }
}
