package ilya.ignatov;

public class BubbleSort {
    public static <T> void sort (T[] data, int[] orderValues) throws Exception {
        if (data.length != orderValues.length) {
            throw new Exception("Массивы должны быть одинаковой длины");
        }
        Object temporaryObject;
        int temporaryInt;
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < orderValues.length - 1; i++) {
                if (orderValues[i] > orderValues[i + 1]) {
                    isSorted = false;

                    temporaryInt = orderValues[i];
                    orderValues[i] = orderValues[i + 1];
                    orderValues[i + 1] = temporaryInt;

                    temporaryObject = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = (T) temporaryObject;
                }
            }
        }
    }
}
