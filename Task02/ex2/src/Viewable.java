package Task02.ex2.src;

/** Creator
 * (шаблон проектирования
 * Factory Method)<br>
 * Объявляет метод,
 * "фабрикующий" объекты
 * @author BogdanSavchenko
 * @version 1.0
 * @see Viewable#getView()
 */
public interface Viewable {

    /** Создаёт объект, реализующий {@linkplain View} */
    public View getView();
}
