package Task02.ex5.src;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

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
public class MinMaxCommand implements Command /*, Runnable */ {
    /** Хранит результат обработки коллекции */
    private int resultMin = -1;
    /** Хранит результат обработки коллекции */
    private int resultMax = -1;
    /** Флаг готовности результата */
    private int progress = 0;
    /** Обслуживает коллекцию объектов {@linkplain ex01.Item2d} */
    private ViewResult viewResult;

    /** Возвращает поле {@linkplain MinMaxCommand#viewResult}
     * @return значение {@linkplain MinMaxCommand#viewResult}
     */
    public ViewResult getViewResult() {
        return viewResult;
    }
    /** Устанавливает поле {@linkplain MinMaxCommand#viewResult}
     * @param viewResult значение для {@linkplain MinMaxCommand#viewResult}
     * @return новое значение {@linkplain MinMaxCommand#viewResult}
     */
    public ViewResult setViewResult(ViewResult viewResult) {
        return this.viewResult = viewResult;
    }
    /** Инициализирует поле {@linkplain MinMaxCommand#viewResult}
     * @param viewResult объект класса {@linkplain ViewResult}
     */
    public MinMaxCommand(ViewResult viewResult) {
        this.viewResult = viewResult;
    }
    /** Возвращает результат
     * @return поле {@linkplain MinMaxCommand#resultMin}
     */
    public int getResultMin() {
        return resultMin;
    }
    /** Возвращает результат
     * @return поле {@linkplain MinMaxCommand#resultMax}
     */
    public int getResultMax() {
        return resultMax;
    }
    /** Проверяет готовность результата
     * @return false - если результат найден, иначе - true
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
            int minValue = Integer.MAX_VALUE;
            for (Integer value : hashMap.values()) {
                if (value < minValue) {
                    minValue = value;
                }
            }
            System.out.println("MIN = " + minValue);
        });
    }
/**
 @Override
 public void run() {
 execute();
 }
 /**/
}