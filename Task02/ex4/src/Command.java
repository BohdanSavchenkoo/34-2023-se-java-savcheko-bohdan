package Task02.ex4.src;
/** Интерфейс команды
 * или задачи;
 * шаблоны: Command,
 * Worker Thread
 * @author xone
 * @version 1.0
 */


public interface Command {
    /** Выполнение команды; шаблоны: Command, Worker Thread */
    public void execute();
}