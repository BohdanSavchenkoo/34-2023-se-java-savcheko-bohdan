package Task02.ex2.src;

import java.io.IOException;

/** Product
 * (шаблон проектирования
 * Factory Method)<br>
 * Интерфейс "фабрикуемых"
 * объектов<br>
 * Объявляет методы
 * отображения объектов
 * @author BogdanSavchenko
 * @version 1.0
 */
public interface View {

    /** Отображает заголовок */
    public void viewHeader();

    /** Отображает основную часть */
    public void viewBody();

    /** Отображает окончание */
    public void viewFooter();

    /** Отображает объект целиком */
    public void viewShow();

    /** Выполняет инициализацию */
    public void viewInit();

    /** Сохраняет данные для последующего восстановления
     * @throws java.io.IOException ошибка ввода-вывода
     * */
    public void viewSave() throws IOException;

    /** Восстанавливает ранее сохранённые данные
     * @throws Exception файл не найден
     * */
    public void viewRestore() throws Exception;
}
