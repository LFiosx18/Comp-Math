import interpolation.Interpolation;
import utils.UserIO;

public class Main {

    public static void main(String[] args) {
        UserIO.showFunctions();
        int num = UserIO.getNum();
        double[] points = UserIO.getPoints();
        Interpolation.run(num, points);
    }
}
