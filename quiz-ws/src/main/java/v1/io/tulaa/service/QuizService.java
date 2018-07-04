package v1.io.tulaa.service;

import org.springframework.stereotype.Service;

/**
 * Tulaa Software Engineering Interview Solutions.
 * <p>
 * Copyright (c) <a href="http://www.ekenya.co.ke/">Eclectic International</a>.,
 * Jul 3, 2018,
 * @author <a href="tonyafula@gmail.com">Tony Afula</a>
 */
@Service
public class QuizService {
    /**
     * Reverse a string while preserving the position of special characters.
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
}
