package methods;

import equations.Equation;
import equations.Equations;
import exeptions.BorderExeption;
import utils.UserIO;

import static java.lang.Math.abs;

public class HalfDivision {
    public static double divisionRes;

    public static void divisionStart(double[] params) throws BorderExeption {
        double e = params[1];
        double[] borders = {params[2], params[3]};
        Double x = halfDivision(e, borders[0], borders[1], (int)params[0]);
        if (x!=null) {
            UserIO.printName(1);
            UserIO.printRes(x);
            divisionRes = x;
        }
    }

    private static Double halfDivision(double e, double left, double right, int num) throws BorderExeption {
        Equation eq = Equations.getEquation(num);
        if (checkBorder(left, right, eq)) {

            if (eq.getEquation(left)==0 || eq.getEquation(right)==0) {
                if (eq.getEquation(left)==0)
                    return left;
                else
                    return  right;
            }

            double x = (left+right)/2;
            while (right-left>=2*e) {
                if (eq.getEquation(x)*eq.getEquation(left)<0)
                    right=x;
                else
                    left=x;
                x=(left+right)/2;
            }
            return (left+right)/2;
        }
        return null;
    }

    private static boolean checkBorder(double l, double r, Equation eq) throws BorderExeption {
        try {
            if (eq.getEquation(l)*eq.getEquation(r)>0) {
                throw new BorderExeption();
            }
            return true;
        }
        catch (BorderExeption e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
