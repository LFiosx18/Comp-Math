package functions;

import interpolation.Interpolation;

import static java.lang.Math.*;

public class ThirdF implements Function{
    @Override
    public String showFunction() {
        return "3*sqrt(0.5*x) + 2*sin(x)";
    }

    @Override
    public double getFunction(double x) {
        return 3*sqrt(0.5*x)+2*sin(x);
    }

    @Override
    public double getFNoise(double x) {
        if (Interpolation.noise)
            return 3*sqrt(0.5*x)+2*sin(x)+(random()-0.5);
        return 3*sqrt(0.5*x)+2*sin(x);
    }
}
