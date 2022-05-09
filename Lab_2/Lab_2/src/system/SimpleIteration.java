package system;

import utils.UserIO;
import static java.lang.Math.abs;

public class SimpleIteration {
    private static final int LIMIT = 100;

    public static void iterationStart() {
        UserIO.showSystem();
        EquationSystem eq1 = EquationsSystem.getEquation(1);
        EquationSystem eq2 = EquationsSystem.getEquation(2);

        Double[] res = simpleIteartion(eq1, eq2);
        if (res!=null)
            UserIO.printResSys(res);
        else
            UserIO.printErrSys();
    }

    private static Double[] simpleIteartion(EquationSystem eq1, EquationSystem eq2) {
        double e = UserIO.getE();
        double x0 = UserIO.getX();
        double y0 = UserIO.getY();

        int k=1;
        Double[] res1 = {eq1.getEquation(x0, y0), eq2.getEquation(x0, y0), (double) 0};

        while ((abs(abs(res1[0])-abs(x0))>=e || abs(abs(res1[1])-abs(y0))>=e) && k<LIMIT) {
            double x1 = eq1.getEquation(res1[0], res1[1]);
            double x2 = eq2.getEquation(res1[0], res1[1]);

            x0 = res1[0];
            y0 = res1[1];
            res1[0] = x1;
            res1[1] = x2;
            k++;
        }
        res1[2] = (double)k;
        if (k<LIMIT && !res1[0].isNaN())
            return res1;

        return null;
    }
}
