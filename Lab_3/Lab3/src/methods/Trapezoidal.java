package methods;

import integrals.Equation;
import integrals.Equations;
import utils.UserIO;

import static java.lang.Math.*;

public class Trapezoidal {
    public static void start(double[] params) {
        Equation eq = Equations.getEquation((int)params[0]);
        double e = abs(params[1]);
        double a = params[2];
        double b = params[3];

        if (eq.checkGap(a, b)) {
            if (!closeGap((int)params[0])) {
                UserIO.errGap();
                return;
            }
            else
                UserIO.okGap();
        }

        int n = getN(eq, e, a, b);
        Double res = trapeziodalRun(eq, n, a, b);
        if (res!=null) {
            UserIO.printRes(res, n);
            Double accurateRes = checkInt(eq, a, b);
            if (accurateRes!=null)
                UserIO.printNewton(accurateRes, res);
            else
                UserIO.errAccurate();
        }
        else
            UserIO.printErr();
    }

    private static Double trapeziodalRun(Equation eq, int n, double a, double b) {
        double s=0;
        double step = (b-a)/n;
        for (int i=0; i<n; i++) {
            s+=((eq.getEquation(a)+eq.getEquation(a+step))/2*step);
            a+=step;
        }
        return s;
    }

    private static int getN(Equation eq, double e, double a, double b) {
        double maxDivision = getMaxDivision(eq, a, b);
        return (int)sqrt(maxDivision*pow((b-a), 3)/(12*e)) + 1;
    }

    private static double getMaxDivision(Equation eq, double a, double b) {
        double max = 0;
        double x = a;
        while (x<=b) {
            if (abs(eq.secondDerivative(x))>max)
                max = abs(eq.secondDerivative(x));
            x+=0.01;
        }
        return max;
    }

    private static Double checkInt(Equation eq, double a, double b) {
        if (eq.F(b)==null || eq.F(a)==null)
            return null;
        return (eq.F(b)-eq.F(a));
    }

    private static boolean closeGap(int num) {
        return num==2;
    }
}
