package Task02.ex2.test;

import Task02.ex1.src.Item;
import Task02.ex2.src.ViewResult;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.*;


/** Выполняет тестирование
 * разработанных классов.
 * @author BogdanSavchenko
 * @version 1.0
 */
public class MainTest {

    private ViewResult vr = new ViewResult(6);


    /** Проверка основной функциональности класса {@linkplain ViewResult}
     * Проверка сериализации.
     */
    @Test
    public void testGenerate() throws IOException {

        vr.viewInit();

        Assert.assertEquals(6, vr.getItems().size());

        Item item1 = new Item(111111);
        Item item2 = new Item(222222);
        Item item3 = new Item(333333);

        ArrayList<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        items.add(item3);

        vr.setItems(items);

        int i = 1;
        for(Item item : vr.getItems()){
            Assert.assertEquals(111111 * i, item.getN() );
            i++;

        }

        vr.viewSave();

        vr.setItems(null);
    }


    /** Проверка корректности восстановления данных. */
    @Test
    public void testRestore() throws Exception {

        vr.viewRestore();

        int i = 1;
        for(Item item : vr.getItems()){
            Assert.assertEquals(111111 * i, item.getN() );
            i++;

        }

    }
}