package Task02.ex1.test;

import Task02.ex1.src.Item;
import Task02.ex1.src.Main;
import org.junit.Assert;

public class MainTest {

    Main main = new Main();
    Item item2d;

    @org.junit.Before
    public void init(){
        item2d = new Item(7836472674l);
    }

    @org.junit.Test
    public void serialize() {
        Assert.assertFalse(!main.serialize(item2d));
    }

    @org.junit.Test
    public void deserialize() {
       Item desItem2d = main.deserialize();
       Assert.assertEquals(item2d, desItem2d);

       Assert.assertNotEquals(item2d.getTransientExample(), desItem2d.getTransientExample());
    }
}