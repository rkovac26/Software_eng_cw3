/**
 * 
 */
package roms;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * @author pbj
 *
 */
public class MoneyTest {
    
    @Test
    public void testZero() {
        Money zero = new Money();
        assertEquals("0.00", zero.toString());
    }
    
    /*
     ***********************************************************************
     * BEGIN MODIFICATION AREA
     ***********************************************************************
     * Add all your JUnit tests for the Money class below.
     */
    @Test
    public void testConstructorString(){
        Money newmoney = new Money("1.12");
        assertEquals("1.12", newmoney.toString());
    }
    //problem: can't use BigDecimal unless it's imported
    
    //tests adding method. Adding 3.14 to nothing should produce 3.14
    @Test
    public void testAdd(){
        Money x = new Money();
        Money y = new Money("3.14");
        assertEquals("3.14", x.add(y).toString());
    }
    
    //tests multiplying method. 1.00*3 = 3.00
    @Test
    public void testMultiply(){
        Money x = new Money("1.00");
        int multiplier = 3;
        assertEquals("3.00", x.multiply(multiplier).toString());
    }
    
    //tests adding percent. 1.00*(an extra 20%) = 1.20 
    @Test
    public void testAddPercent(){
        Money x = new Money("1.00");
        int percent = 20;
        assertEquals("1.20", x.addPercent(percent).toString());
    }
    
    //tests that toString formats correctly
    @Test
    public void testToString(){
        Money x = new Money("3.14");
        assertEquals("3.14", x.toString());
    }
    
    //tests that money is rounded up if rounding decimal is > 0.005
    @Test
    public void testRoundingUp(){
        Money x = new Money("1.246");
        assertEquals("1.25", x.toString());
    }
    
    //tests that money is rounded down if rounding decimal point is <= 0.005
    @Test
    public void testRoundingDown(){
        Money x = new Money("1.245");
        assertEquals("1.24", x.toString());
    }
    
    //tests that if a whole number is put in, the trailing zeroes are added
    @Test
    public void testFormatZeroesOne(){
        Money x = new Money("1");
        assertEquals("1.00", x.toString());
    }
    
    //tests that if a number to 1 d.p is put in, a trailing zero is added
    @Test
    public void testFormatZeroesTwo(){
        Money x = new Money("1.1");
        assertEquals("1.10", x.toString());
    }
   /*
    * Put all class modifications above.
    ***********************************************************************
    * END MODIFICATION AREA
    ***********************************************************************
    */


}
