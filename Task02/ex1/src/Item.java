package Task02.ex1.src;

import java.io.Serializable;
import java.util.Objects;


/**
 * Калькулятор для підрахунку кількості цифр у даному числі.
 * @author BohdanSavchenko
 * @version 1.0
 */
public class Item implements Serializable {
    static final long DEFAULT_NUM = 231314321231l;
    /**
     * Дане число для підрахунку
     */
    private long n;
    transient String transientExample = "Hehe";


    /** Конструктор
     * @param n - задане число
     */
    public Item(long n) {
        this.n = n;
    }

    public Item() {
        this(DEFAULT_NUM);
    }

    /** Метод для підрахунку цифр у числі, та виводу результату
     * @void
     */
    public void countDigits(){

        System.out.println("This n: " + this.n);
        int[] count = new int[10];

        String digitsOfString = Long.toString(n);

        for (int i = 0; i < digitsOfString.length(); i++) {
            int digit = Character.getNumericValue(digitsOfString.charAt(i));
            count[digit]++;
        }

        for (int i = 0; i < 10; i++) {
            if(count[i] != 0 ){
                System.out.println(i + ": " + count[i]);
            }
        }

        System.out.println("--------------------------------");
    }

    public long getN() {
        return n;
    }

    public void setN(long n) {
        this.n = n;
    }

    public String getTransientExample() {
        return transientExample;
    }

    public void setTransientExample(String transientExample) {
        this.transientExample = transientExample;
    }

    /** Метод порівняння об'єктів
     * @param o - об'єкт для порівняння
     * @return - boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item that = (Item) o;
        return n == that.n;
    }

    @Override
    public int hashCode() {
        return Objects.hash(n);
    }
}
