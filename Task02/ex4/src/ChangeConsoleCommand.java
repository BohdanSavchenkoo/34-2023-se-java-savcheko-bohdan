package Task02.ex4.src;
import Task02.ex1.src.Item;
import Task02.ex2.src.View;
import Task02.ex2.src.ViewResult;
/** Консольная команда
 * Change item;
 * шаблон Command
 * @author xone
 * @version 1.0
 */
public class ChangeConsoleCommand extends Task02.ex4.src.ChangeItemCommand implements Task02.ex4.src.ConsoleCommand {
    /** Объект, реализующий интерфейс {@linkplain View};
     * обслуживает коллекцию объектов {@linkplain Task02.ex1.src.Item}
     */
    private View view;
    /** Возвращает поле {@linkplain ChangeConsoleCommand#view}
     * @return значение {@linkplain ChangeConsoleCommand#view}
     */
    public View getView() {
        return view;
    }
    /** Устанавливает поле {@linkplain ChangeConsoleCommand#view}
     * @param view значение для {@linkplain ChangeConsoleCommand#view}
     * @return новое значение {@linkplain ChangeConsoleCommand#view}
     */
    public View setView(View view) {
        return this.view = view;
    }
    /** Инициализирует поле {@linkplain ChangeConsoleCommand#view}
     * @param view объект, реализующий интерфейс {@linkplain View}
     */
    public ChangeConsoleCommand(View view) {
        this.view = view;
    }
    @Override
    public char getKey() {
        return 'c';
    }
    @Override
    public String toString() {
        return "'c'hange";
    }
    @Override
    public void execute() {
        System.out.println("Change item: scale factor " + setOffset(Math.random() * 100.0));
        for (Item item : ((ViewResult)view).getItems()) {
            super.setItem(item);
            super.execute();
        }
        view.viewShow();
    }
}