package Task02.ex5.src;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import Task02.ex4.src.Command;
import Task02.ex1.src.Item;
import Task02.ex2.src.ViewResult;
/** Задача, используемая
 * обработчиком потока;
 * шаблон Worker Thread
 * @author xone
 * @version 1.0
 * @see Command
 * @see CommandQueue
 */
public class AvgCommand implements Command /*, Runnable */ {
    /** Хранит результат обработки коллекции */
    private double result = 0.0;
    /** Флаг готовности результата */
    private int progress = 0;
    /** Обслуживает коллекцию объектов {@linkplain Item} */
    private ViewResult viewResult;
    /** Возвращает поле
     * @return значение {@linkplain }
     */
    public ViewResult getViewResult() {
        return viewResult;
    }
    /** Устанавливает поле {@linkplain}
     * @param viewResult значение для {@linkplain}
     * @return новое значение {@linkplain}
     */
    public ViewResult setViewResult(ViewResult viewResult) {
        return this.viewResult = viewResult;
    }
    /** Инициализирует поле {@linkplain}
     * @param viewResult объект класса {@linkplain ViewResult}
     */
    public AvgCommand(ViewResult viewResult) {
        this.viewResult = viewResult;
    }
    /** Возвращает результат
     * @return поле {@linkplain}
     */
    public double getResult() {
        return result;
    }
    /** Проверяет готовность результата
     * @return false - если результат найден, иначе - true
     * @see MaxCommand
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
            HashMap<Integer, Integer>  hashMap = item.getResult();
            double sum = 0;
            int count = 0;

            for (Map.Entry<Integer,Integer> entry : hashMap.entrySet()) {
                sum += entry.getValue();
                count++;
            }
            System.out.println(sum + " " + count + " " + (sum / count));
            if (count > 0) {
                this.result = sum / count;
            } else {
                this.result = 0.0;
            }
            System.out.println("AVG = " + this.result);


        });
    }
}
/**
 @Override
 public void run() {
 execute();
 }
 /**/
