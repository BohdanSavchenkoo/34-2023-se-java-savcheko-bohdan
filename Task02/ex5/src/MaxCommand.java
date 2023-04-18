package Task02.ex5.src;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import Task02.ex1.src.Item;
import Task02.ex2.src.ViewResult;
import Task02.ex4.src.Command;

/** Задача, используемая
 * обработчиком потока;
 * шаблон Worker Thread
 * @author xone
 * @version 1.0
 * @see Command
 * @see CommandQueue
 */
public class MaxCommand implements Command /*, Runnable */ {
    /** Хранит результат обработки коллекции */
    private int result = -1;
    /** Флаг готовности результата */
    private int progress = 0;
    /** Обслуживает коллекцию объектов {@linkplain Item} */
    private ViewResult viewResult;
    /** Возвращает поле {@linkplain MaxCommand#viewResult}
     * @return значение {@linkplain MaxCommand#viewResult}
     */
    public ViewResult getViewResult() {
        return viewResult;
    }
    /** Устанавливает поле {@linkplain MaxCommand#viewResult}
     * @param viewResult значение для {@linkplain MaxCommand#viewResult}
     * @return новое значение {@linkplain MaxCommand#viewResult}
     */
    public ViewResult setViewResult(ViewResult viewResult) {
        return this.viewResult = viewResult;
    }
    /** Инициализирует поле {@linkplain MaxCommand#viewResult}
     * @param viewResult объект класса {@linkplain ViewResult}
     */
    public MaxCommand(ViewResult viewResult) {
        this.viewResult = viewResult;
    }
/** Возвращает результат
 * @return поле {@linkplain MaxCommand#result}
 */

    public int getResult() {
        return result;
    }
    /** Проверяет готовность результата
     * @return false - если результат найден, иначе - true
     * @see MaxCommand#result
     */
    public boolean running() {
        return progress < 100;
    }
    /** Используется обработчиком потока {@linkplain CommandQueue};
     * шаблон Worker Thread
     */
    @Override
    public void execute() {
        this.viewResult.getItems().forEach(item -> {
            HashMap<Integer, Integer> hashMap = item.getResult();
            int maxValue = Integer.MIN_VALUE;
            for (Integer key : hashMap.values()) {
                if (key > maxValue) {
                    maxValue = key;
                }
            }
            System.out.println("MAX = " + maxValue);
        });
    }
/**
 System.out.println("Max done. Item #" + result +

 " found: " + viewResult.getItems().get(result));

 progress = 100;

 @Override
 public void run() {
 execute();
 }
 /**/
}