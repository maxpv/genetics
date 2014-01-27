package group2.genetics.miscellaneous;

import java.util.Arrays;

public class ArrayUtils {

    //Thanks Joachim Sauer
    public static <T> T[] concat(T[] first, T[]... rest) {
        int totalLength = first.length;
        for (T[] array : rest) {
            totalLength += array.length;
        }
        T[] result = Arrays.copyOf(first, totalLength);
        int offset = first.length;
        for (T[] array : rest) {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }
        return result;
    }
    
    public static <T> T[] add(T[] first, T... rest) {
        int totalLength = first.length + rest.length;
        T[] result = Arrays.copyOf(first, totalLength);
        for (int i = first.length; i < totalLength; i++) {
            result[i] = rest[i-first.length];
        }
        return result;
    }
    
    public static <T> String[] toStringArray(T[] array) {
        int size = array.length;
        String[] result = new String[size];
        for (int i = 0; i < size; i++) {
            result[i] = array[i].toString();
        }
        return result;
    }
    
    public static String[] toStringArray(Class[] array) {
        int size = array.length;
        String[] result = new String[size];
        for (int i = 0; i < size; i++) {
            result[i] = array[i].getSimpleName();
        }
        return result;
    }
}
