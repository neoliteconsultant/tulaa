package io.tulaa;

/**
 * Utility class for int primitive type
 * <p>
 * Copyright (c) <a href="http://www.ekenya.co.ke/">Eclectic International</a>.,
 * Jul 4, 2018,
 *
 * @author <a href="maganga.tony@ekenya.co.ke">Anthony Wafula</a>
 */
public class IntegerUtil {

    /**
     * Returns a string representation of an {@link Integer} array.
     * 
     * @param arr array input.
     * @return string representation of an {@link Integer} array.
     */
    public static String toString(int[] arr) {

        String delimeter=",";
        int length = arr.length;
        int lastElementIndex = length - 1;
        StringBuilder stringBuilder=new StringBuilder("[");
        for (int i = 0; i < lastElementIndex; ++i) {
            stringBuilder.append(arr[i]).append(delimeter).append(" ");
        }
       
        stringBuilder.append(arr[lastElementIndex]).append("]");
        return stringBuilder.toString();
    }
}
