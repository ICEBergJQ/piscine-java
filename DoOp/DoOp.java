public class DoOp {
    public static String operate(String[] args) {
        if (args.length < 3) {
            return "Error";
        }

        int left, right;
        try {
            left = Integer.parseInt(args[0]);
            right = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
            return "Error";
        }

        String op = args[1];
        int result;

        switch (op) {
            case "+":
                result = left + right;
                break;
            case "-":
                result = left - right;
                break;
            case "*":
                result = left * right;
                break;
            case "/":
                if (right == 0) return "Error";
                result = left / right;
                break;
            case "%":
                if (right == 0) return "Error";
                result = left % right;
                break;
            default:
                return "Error";
        }

        return String.valueOf(result);
    }
}