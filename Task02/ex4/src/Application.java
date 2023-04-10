package Task02.ex4.src;

import Task02.ex2.src.View;
import Task02.ex3.src.ViewableTable;

import Task02.ex4.src.Menu;

/** Формирует и отображает
 * меню; реализует шаблон
 * Singleton
 * @author xone
 * @version 1.0
 */
public class Application {
    /** Ссылка на экземпляр класса Application; шаблон Singleton
     * @see Application
     */
    private static final Application instance = new Application();
    /** Закрытый конструктор; шаблон Singleton
     * @see Application
     */
    private Application() {}
    /** Возвращает ссылку на экземпляр класса Application;
     * шаблон Singleton
     * @see Application
     */
    public static Application getInstance() {
        return instance;
    }
    /** Объект, реализующий интерфейс {@linkplain View};
     * обслуживает коллекцию объектов {@linkplain Task02.ex1.src.Item};
     * инициализируется с помощью Factory Method
     */
    private final View view = new ViewableTable().getView();
    /** Объект класса {@linkplain Menu};
     * макрокоманда (шаблон Command)
     */
    Menu menu = new Menu();
    /** Обработка команд пользователя
     * @see Application
     */
    public void run() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new SaveConsoleCommand(view));
        menu.add(new RestoreConsoleCommand(view));
        menu.execute();
    }
}