package Task02.ex3.test;

import Task02.ex1.src.Item;
import Task02.ex2.src.ViewResult;
import Task02.ex3.src.ViewTable;
import Task02.ex3.src.ViewableTable;
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

    private ViewTable vt = (ViewTable) new ViewableTable().getView();




    /** Проверка основной функциональности класса {@linkplain ViewTable}
     * Проверка сериализации.
     */
    @Test
    public void testGenerate() throws IOException {

      vt.viewInit();

      Assert.assertEquals(5, vt.getItems().size());

        try {
            vt.viewSave();
        }catch (IOException e) {
            Assert.fail(e.getMessage());
        }

    }



    /** Проверка корректности восстановления данных. */
    @Test
    public void testRestore() throws Exception {

        try {
            vt.viewRestore();
        } catch (IOException e) {
                Assert.fail(e.getMessage());
        }

        Assert.assertEquals(5, vt.getItems().size());

    }
}