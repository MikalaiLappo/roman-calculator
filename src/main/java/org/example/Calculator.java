package org.example;
import java.lang.FunctionalInterface;
import java.util.HashMap;
import java.util.Map;

@FunctionalInterface
interface Operation {
    int calc(int a, int b);
}

public class Calculator {
    private final Map<String, Operation> ops = new HashMap<>() {{
        put("*", (int a, int b) -> a * b);
        put("+", Integer::sum);
        put("-", (int a, int b) -> a - b);
        put("/", (int a, int b) -> a / b);
    }};

    public int calculate(String opId, int a, int b) throws IllegalArgumentException {
        Operation op = this.ops.get(opId);
        if (op == null) {
            throw new IllegalArgumentException("Invalid operation: " + opId);
        }

        return op.calc(a, b);
    }
}
