package Task02.ex4.src;
import Task02.ex2.src.View;
import Task02.ex4.src.ConsoleCommand;
import Task02.ex2.src.View;
/** Консольная команда
 * Generate;
 * шаблон Command
 * @author xone
 * @version 1.0
 */
public class GenerateConsoleCommand implements ConsoleCommand {
    /** Объект, реализующий интерфейс {@linkplain View};
     * обслуживает коллекцию объектов {@linkplain Task02.ex1.src.Item}
     */
    private View view;
    /** Инициализирует поле {@linkplain GenerateConsoleCommand#view}
     * @param view объект, реализующий интерфейс {@linkplain View}
     */
    public GenerateConsoleCommand(View view) {
        this.view = view;
    }
    @Override
    public char getKey() {
        return 'g';
    }
    @Override
    public String toString() {
        return "'g'enerate";
    }
    @Override
    public void execute() {
        System.out.println("Random generation.");
        view.viewInit();
        view.viewShow();
    }
}