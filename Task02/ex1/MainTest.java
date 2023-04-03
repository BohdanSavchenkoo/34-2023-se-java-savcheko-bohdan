package Task02.ex1;

import org.junit.Assert;

public class MainTest {

    Main main = new Main();
    DecimalCalculator decimalCalculator;

    @org.junit.Before
    public void init(){
        decimalCalculator = new DecimalCalculator(7836472674l);
    }

    @org.junit.Test
    public void serialize() {
        Assert.assertFalse(!main.serialize(decimalCalculator));
    }

    @org.junit.Test
    public void deserialize() {
       DecimalCalculator desDecimalCalculator = main.deserialize();
       Assert.assertEquals(decimalCalculator, desDecimalCalculator);

       Assert.assertNotEquals(decimalCalculator.getTransientExample(), desDecimalCalculator.getTransientExample());
    }
}