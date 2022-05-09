import methods.HalfDivision;
import methods.Tangents;
import system.SimpleIteration;
import utils.UserIO;

public class Main {

    public static void main(String[] args) {
        UserIO.showAll();
        double[] params = UserIO.getParams();
        try {
            HalfDivision.divisionStart(params);
            Tangents.tangentsStart(params);
            UserIO.printDiff();
            SimpleIteration.iterationStart();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
