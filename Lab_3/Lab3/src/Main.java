import methods.Trapezoidal;
import utils.UserIO;

public class Main {

    public static void main(String[] args) {
        while (true) {
            UserIO.showAll();
            double[] params = UserIO.getParams();
            if (params[0]==0)
                System.exit(0);
            try {
                Trapezoidal.start(params);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}