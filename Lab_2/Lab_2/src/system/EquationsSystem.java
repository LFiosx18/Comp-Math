package system;

import java.util.HashMap;
import java.util.Map;

public class EquationsSystem {
    private static Map<Integer, EquationSystem> equations;

    static {
        equations = new HashMap<>();
        equations.put(1, new FirstEqSystem());
        equations.put(2, new SecondEqSystem());
    }

    public static Map<Integer, EquationSystem> getEquations() {
        return equations;
    }

    public static EquationSystem getEquation(int number) {
        if (number <= 1 || number > equations.size()) {
            number = 1;
        }
        EquationSystem eq = equations.get(number);
        return eq;
    }
}
