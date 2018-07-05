package io.tulaa;

import java.util.Arrays;

/**
 * Tulaa Software Engineering Interview Quiz Solutions.
 * <p>
 * Copyright (c) <a href="http://www.ekenya.co.ke/">Eclectic International</a>.,
 * Jul 3, 2018,
 *
 * @author <a href="tonyafula@gmail.com">Tony Afula</a>
 */
public class Quiz {

    /**
     * Reverse string while preserving the position of special characters.
     *
     * @param word string to reverse.
     * @return reversed string.
     */
    public String reverseWord(String word) {

        char[] wordCharArray = word.toCharArray();
        int leftIndex = 0;
        int rightIndex = word.length() - 1;//index of the last element in the array

        char rightCharacter;
        char leftCharacter;
        while (leftIndex < rightIndex) {

            leftCharacter = wordCharArray[leftIndex];
            rightCharacter = wordCharArray[rightIndex];

            if (!Character.isAlphabetic(leftCharacter)) {//check if left character is a special character
                ++leftIndex;//non-alphabetic skip to the next element

            } else if (!Character.isAlphabetic(rightCharacter)) {//check if right character is a special character
                --rightIndex;//non-alphabetic skip to the next element

            } else {
                //Alphabetic characters swap
                wordCharArray[leftIndex] = rightCharacter;
                wordCharArray[rightIndex] = leftCharacter;

                ++leftIndex;
                --rightIndex;
            }

        }

        String reversedWord = new String(wordCharArray);

        return reversedWord;
    }

    /**
     * Find count of triplets with sum smaller than given sum value.
     *
     * @param inputArray array of distinct integers.
     * @param sum sum value.
     * @return count of triplets with sum smaller than given sum value.
     */
    public int getTripletCount(int[] inputArray, int sum) {
        int tripletCount = 0;

        Arrays.sort(inputArray);//Sort the input array in increasing order.

        int length = inputArray.length;
        int secondLastArrayIndex = length - 2;
        for (int i = 0; i < secondLastArrayIndex; i++) {
            // Declare and initialize the other two elements
            int j = i + 1, k = length - 1;

            while (j < k) {
                // If the sum of of the triplet is greater than or equal to the given sum,
                // move right corner to look for smaller values
                if (inputArray[i] + inputArray[j] + inputArray[k] >= sum) {
                    k--;
                } else {// move to the left side
                    tripletCount += (k - j);
                    j++;
                }
            }
        }

        return tripletCount;

    }

    /**
     * Check if array contains a triplet satisfying Pythagorean theorem.
     *
     * @param arrayInput array of distinct integers.
     * @return <code>true</code> if there is a triplet satisfying Pythagorean
     * theorem, <code>false</code> otherwise.
     */
    public boolean existPythagoreanTriplet(int[] arrayInput) {
        int length = arrayInput.length;

        // Square each array element
        for (int i = 0; i < length; i++) {
            arrayInput[i] = arrayInput[i] * arrayInput[i];
        }

        // Sort array in increasing order
        Arrays.sort(arrayInput);

        
        for (int i = length - 1; i >= 2; i--) {
            int leftIndex = 0; // index of the first element in array
            int rightIndex = i - 1; // index of the last element in array
            while (leftIndex < rightIndex) {
                // Elements satisfying pythagorem theorem found
                if (arrayInput[leftIndex] + arrayInput[rightIndex] == arrayInput[i]) {
                    return true;
                }

                if (arrayInput[leftIndex] + arrayInput[rightIndex] < arrayInput[i]) {//Move to the 'leftIndex'.
                    leftIndex++;
                } else {//Move to the right index.
                    rightIndex--;
                }
            }
        }

        return false;

    }

    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        String text = "Ab,c,de!$";
        String reversedText = quiz.reverseWord(text);
        System.out.println("1.Reverse the string in a way that special characters are not affected");
        System.out.println("Input\t" + text);
        System.out.println("Output\t" + reversedText);

        System.out.println();

        int[] arr = {5, 1, 3, 4, 7};
        int sum = 12;
        int tripletCount = quiz.getTripletCount(arr, sum);
        System.out.println("2. Given an array of distinct integers and a sum value."
                + " Find count of triplets with sum smaller than given sum value");

        System.out.println("Input\t" + IntegerUtil.toString(arr) + " sum value " + sum);
        System.out.println("Output\t" + tripletCount);

        System.out.println();

        int[] inputArray = {3, 1, 4, 6, 5};
        boolean result = quiz.existPythagoreanTriplet(inputArray);
        System.out.println("3. Check if array contains a triplet satisfying Pythagorean theorem");

        System.out.println("Input\t" + IntegerUtil.toString(inputArray));
        System.out.println("Output\t" + result);

    }

}
