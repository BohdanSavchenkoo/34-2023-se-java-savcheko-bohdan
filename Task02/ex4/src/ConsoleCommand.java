package Task02.ex4.src;

/** Интерфейс
 * консольной команды;
 * шаблон Command
 * @author xone
 * @version 1.0
 */
public interface ConsoleCommand extends Task02.ex4.src.Command {
    /** Горячая клавиша команды;
     * шаблон Command
     * @return символ горячей клавиши
     */
    public char getKey();
}