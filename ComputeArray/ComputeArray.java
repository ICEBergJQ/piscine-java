public class ComputeArray {
    public static int[] computeArray(int[] array) {
        if (array == null) {
            return null;
        }
        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int x = array[i];

            if (x % 3 == 0) {
                result[i] = x * 5;
            } else if (x % 3 == 1) {
                result[i] = x + 7;
            } else {
                result[i] = x;
            }
        }

        return result;
    }
}
