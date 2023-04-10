package Task02.ex4.src;
import Task02.ex1.src.Item;

/** Команда
 * Change item;
 * шаблон Command
 * @author xone
 * @version 1.0
 */
public class ChangeItemCommand implements Task02.ex4.src.Command {
    /** Обрабатываемый объект; шаблон Command */
    private Item item;
    /** Параметр команды; шаблон Command */
    private double offset;
    /** Устанавливаент поле {@linkplain ChangeItemCommand#item}
     * @param item значение для {@linkplain ChangeItemCommand#item}
     * @return новое значение {@linkplain ChangeItemCommand#item}
     */
    public Item setItem(Item item) {
        return this.item = item;
    }
    /** Возвращает поле {@linkplain ChangeItemCommand#item}
     * @return значение {@linkplain ChangeItemCommand#item}
     */
    public Item getItem() {
        return item;
    }
    /** Устанавливаент поле {@linkplain ChangeItemCommand#offset}
     * @param offset значение для {@linkplain ChangeItemCommand#offset}
     * @return новое значение {@linkplain ChangeItemCommand#offset}
     */
    public double setOffset(double offset) {
        return this.offset = offset;
    }
    /** Возвращает поле {@linkplain ChangeItemCommand#offset}
     * @return значение {@linkplain ChangeItemCommand#offset}
     */
    public double getOffset() {
        return offset;
    }
    @Override
    public void execute() {
        item.setN((long) (item.getN() * offset));
    }
}