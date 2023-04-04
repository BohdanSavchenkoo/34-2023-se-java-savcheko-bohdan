package Task02.ex2.src;

/** ConcreteCreator
 * (шаблон проектирования
 * Factory Method)<br>
 * Объявляет метод,
 * "фабрикующий" объекты
 * @author BogdanSavchenko
 * @version 1.0
 * @see Viewable
 * @see ViewableResult#getView()
 */
public class ViewableResult implements Viewable{

    /** Создаёт отображаемый объект {@linkplain ViewResult} */
    public View getView() {
        return (View) new ViewResult(ViewResult.DEFAULT_NUM);
    }
}
