package Task02.ex2.src;

import Task02.ex1.src.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;


/** ConcreteProduct
 * (Шаблон проектирования
 * Factory Method)<br>
 * Вычисление функции,
 * сохранение и отображение
 * результатов
 * @author BogdanSavchenko
 * @version 1.0
 * @see View
 */
public class ViewResult implements View{

    /** Имя файла, используемое при сериализации */
    public static final String FIlENAME = "items.bin";

    /** Определяет количество элементов списка по умолчанию */
    static final int DEFAULT_NUM = 5;

    /** Коллекция элементов */
    private ArrayList<Item> items = new ArrayList<>();

    /** Вызывает {@linkplain ViewResult#ViewResult(int n) ViewResult(int n)}
     * с параметром {@linkplain ViewResult#DEFAULT_NUM DEFAULT_NUM}
     */
    public ViewResult() {
        this(DEFAULT_NUM);
    }

    /** Инициализирует коллекцию {@linkplain ViewResult#items}
     * @param n начальное количество элементов
     */
    public ViewResult(int n) {
        for(int ctr = 0; ctr < n; ctr++) {
            items.add(new Item());
        }
    }

    /** Получить коллекцию {@linkplain ViewResult#items}
     * @return текущее значение ссылки на объект {@linkplain ArrayList}
     */
    public ArrayList<Item> getItems() {
        return items;
    }
    /** Назначить коллекцию {@linkplain ViewResult#items}
    * @param items коллекция
    */
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    /** Генерация случайного числа элемента коллекции
     */
    private long generate() {
         return (long) ((Math.random() * (999999999l - 10000l)) +1l);
    }


    /** Сохраняет результат в коллекции {@linkplain ViewResult#items}
    */
    private void init() {
        for(Item item : items) {
            item.setN(generate());
        }
    }

    /** Инициализирует коллекцию {@linkplain ViewResult#items}
     * {@inheritDoc}
     */
    @Override
    public void viewInit() {
        init();
    }


    /** Реализация метода {@linkplain View#viewSave()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewSave() throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FIlENAME));
        os.writeObject(this.getItems());
        os.flush();
        os.close();
    }


    /** Реализация метода {@linkplain View#viewRestore()}<br>
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public void viewRestore() throws Exception {
        ObjectInputStream is = new ObjectInputStream(new FileInputStream(FIlENAME));
        this.setItems((ArrayList<Item>) is.readObject());
        is.close();
    }


    /** Реализация метода {@linkplain View#viewHeader()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewHeader() {
        System.out.println("Results:");
    }


    /** Реализация метода {@linkplain View#viewBody()}<br>
    * {@inheritDoc}
    */
    @Override
    public void viewBody() {
        for(Item item : items) {
//            item.countDigits();

            System.out.println("Item n= " + item.getN());

            for (Map.Entry<Integer, Integer> set :
                    item.getResult().entrySet()) {

                // Printing all elements of a Map
                System.out.println(set.getKey() + " : "
                        + set.getValue());
            }

        }

        System.out.println();
    }

    /** Реализация метода {@linkplain View#viewFooter()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewFooter() {
        System.out.println("End.");
    }

    /** Реализация метода {@linkplain View#viewShow()}<br>
     * {@inheritDoc}
     */
    @Override
    public void viewShow() {
        viewHeader();
        viewBody();
        viewFooter();
    }
}
