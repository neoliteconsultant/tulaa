package io.tulaa;

import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test class for {@link Quiz}
 * <p>
 * Copyright (c) <a href="http://www.ekenya.co.ke/">Eclectic International</a>.,
 * Jul 3, 2018,
 * @author <a href="tonyafula@gmail.com">Tony Afula</a>
 */
public class QuizTest {
    private Quiz quiz; 
    public QuizTest() {
    }

    @Before
    public void setUp() {
        quiz = new Quiz();
    }

    /**
     * Test method for {@link Quiz#reverseWord(java.lang.String)}.
     */
    @Test
    public void testReverseWord() {
//        String input = "a,b$c";     
//        String expResult = "c,b$a";
        
        String input = "a!!!b.c.d,e'f,ghi";
        String expResult = "i!!!h.g.f,e'd,cba";
        
//        String input = "Ab,c,de!$";     
//        String expResult = "ed,c,bA!$";
        String actualResult = quiz.reverseWord(input);
        assertEquals(expResult, actualResult);
      
    }

    /**
     * Test method for {@link Quiz#getTripletCount(int[], int) }.
     */
    @Test
    public void testGetTripletCount() {
        /*
        int[] arr = {-2, 0, 1, 3};
        int sum = 2;
        int expResult = 2;
*/
        
        int[] arr = {5, 1, 3, 4, 7};
        int sum = 12;
        int expResult = 4;
        int actualResult = quiz.getTripletCount(arr, sum);
        assertEquals(expResult, actualResult);
    }

     /**
     * Test method for {@link Quiz#existPythagoreanTriplet(int[])  }.
     */
    @Test
    public void testExistsPythogarenTriple() {
        int[] arr = {3, 1, 4, 6, 5};    
//        boolean expResult = true;
        
//        int[] arr = {10, 4, 6, 12, 5};       
//        boolean expResult = false;
         assertTrue(quiz.existPythagoreanTriplet(arr));
       
        
        
    }

}