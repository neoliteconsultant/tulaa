package io.tulaa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * <p>
 * Copyright (c) <a href="http://www.ekenya.co.ke/">Eclectic International</a>.,
 * Jul 4, 2018,
 *
 * @author <a href="maganga.tony@ekenya.co.ke">Anthony Wafula</a>
 */
public class IntegerUtilTest {

    public IntegerUtilTest() {
    }

  

    @Test
    public void testToString() {
        int[] arr = {5, 1, 3, 4, 7};
        String expResult = "[5, 1, 3, 4, 7]";
        String result = IntegerUtil.toString(arr);
        assertEquals(expResult, result);
    }

}