package functions;

import java.util.HashMap;
import java.util.Map;

public class Functions {
    private static Map<Integer, Function> functions;

    static {
        functions = new HashMap<>();
        functions.put(1, new FirstF());
        functions.put(2, new SecondF());
        functions.put(3, new ThirdF());
    }

    public static Function getFunction(int number) {
        if (number <= 1 || number > functions.size()) {
            number = 1;
        }
        Function f = functions.get(number);
        return f;
    }
}
