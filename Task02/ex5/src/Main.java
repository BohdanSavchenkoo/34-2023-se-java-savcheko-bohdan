package Task02.ex5.src;
import Task02.ex2.src.View;
import Task02.ex2.src.ViewableResult;
import Task02.ex4.src.ChangeConsoleCommand;
import Task02.ex4.src.GenerateConsoleCommand;
import Task02.ex4.src.Menu;
import Task02.ex4.src.ViewConsoleCommand;
/** Вычисление и отображение
 * результатов; содержит реализацию
 * статического метода main()
 * @author xone
 * @version 5.0
 * @see Main#main
 */
public class Main {
    /** Объект, реализующий интерфейс {@linkplain View};
     * обслуживает коллекцию объектов {@linkplain Task02.ex1.src.Item};

     15

     * инициализируется с помощью Factory Method
     */
    private View view = new ViewableResult().getView();
    /** Объект класса {@linkplain Menu};
     * макрокоманда (шаблон Command)
     */
    private Menu menu = new Menu();
    /** Обработка команд пользователя */
    public void run() {
        menu.add(new ViewConsoleCommand(view));
        menu.add(new GenerateConsoleCommand(view));
        menu.add(new ChangeConsoleCommand(view));
        menu.add(new ExecuteConsoleCommand(view));
        menu.execute();
    }
    /** Выполняется при запуске программы
     * @param args параметры запуска программы
     */
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}