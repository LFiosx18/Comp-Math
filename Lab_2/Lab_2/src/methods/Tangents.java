package methods;

import equations.Equation;
import equations.Equations;
import exeptions.BorderExeption;
import exeptions.TanBorderExeption;
import utils.UserIO;

import static java.lang.Math.abs;

public class Tangents {
    public static double tanRes;

    public static void tangentsStart(double[] params) throws BorderExeption {
        double e = params[1];
        double[] borders = {params[2], params[3]};
        Double x = tangents(e, borders[0], borders[1], (int)params[0]);
        if (x!=null) {
            UserIO.printName(2);
            UserIO.printRes(x);
            tanRes = x;
        }
    }


    private static Double tangents(double e, double left, double right, int num) throws BorderExeption {
        Equation eq = Equations.getEquation(num);
        if (checkBorder(left, right, eq)!=null) {
            if (eq.getEquation(left)==0 || eq.getEquation(right)==0) {
                if (eq.getEquation(left)==0)
                    return left;
                else
                    return  right;
            }
            Double x = checkBorder(left, right, eq);

            while (abs(eq.getEquation(x))>e) {
                double x0 = x;
                x = x0-eq.getEquation(x0)/eq.firstDerivative(x0);
            }
            return x;
        }
        return null;
    }

    private static Double checkBorder(double l, double r, Equation eq) throws BorderExeption {
        try{
            if (eq.getEquation(l)*eq.getEquation(r)>0)
                throw new BorderExeption();
            if (eq.getEquation(l)*eq.secondDerivative(l)>0)
                return l;
            else if (eq.getEquation(r)*eq.secondDerivative(r)>0)
                return r;
            else
                throw new TanBorderExeption();
        }
        catch (BorderExeption | TanBorderExeption e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
