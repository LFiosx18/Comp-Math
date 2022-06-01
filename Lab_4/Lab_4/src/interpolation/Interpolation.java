package interpolation;

import functions.Function;
import functions.Functions;
import utils.Graph;
import utils.UserIO;

public class Interpolation {
    static double[][] matrix;
    public static boolean noise;

    public static void run(int num, double[] x) {
        Function f = Functions.getFunction(num);
        noise = UserIO.noise();
        double[] y = startPoints(f, x);
        double[] xf = xLinePoint(x);
        double[] yf = line(f, xf);
        double[] polyXf = polyXLinePoint(x);

        matrix = dif(x, y);

        double[] polyYf = new double[polyXf.length];
        for (int i=0; i<polyYf.length; i++) {
            polyYf[i] = polyNewton(polyXf[i]);
        }

        Graph.draw(f, x, y, xf, yf, polyXf, polyYf);
    }

    public static double[][] dif(double[] x, double[] y) {
        double[][] dif = new double[x.length][y.length+1];

        for (int j=0; j<x.length; j++) {
            dif[j][0] = x[j];
            dif[j][1] = y[j];
        }

        int k=1;
        for (int j=2; j<x.length+1; j++) {
            for (int i=0; i<x.length-k; i++) {
                dif[i][j] = (dif[i+1][j-1]-dif[i][j-1])/(dif[i+k][0]-dif[i][0]);
            }
            k++;
        }

        return dif;
    }

    public static double polyNewton(double x) {
        double res = matrix[0][1];
        double m = x-matrix[0][0];
        for (int i=0; i<matrix.length-1; i++) {
            res+=matrix[0][i+2]*m;
            m*=(x-matrix[i+1][0]);
        }
        return res;
    }

    private static double[] startPoints(Function f, double[] x) {
        double[] y = new double[x.length];
        for (int i=0; i<y.length; i++) {
            y[i] = f.getFNoise(x[i]);
        }
        return y;
    }

    private static double[] line(Function f, double[] x) {
        double[] y = new double[x.length];
        for (int i=0; i<y.length; i++) {
            y[i] = f.getFunction(x[i]);
        }
        return y;
    }

    private static double[] xLinePoint (double[] x) {
        double[] xf = new double[(int)(x[x.length-1]-x[0]+1)*10+2];
        int i=1;
        xf[0] = x[0]-1;
        while (i<xf.length) {
            xf[i] = xf[i-1]+0.1;
            i++;
        }
        return xf;
    }
    private static double[] polyXLinePoint (double[] x) {
        double[] xf = new double[(int)(x[x.length-1]-x[0]+1)*10+4];
        int i=1;
        xf[0] = x[0]-1;
        while (i<xf.length) {
            xf[i] = xf[i-1]+0.1;
            i++;
        }
        return xf;
    }
}
