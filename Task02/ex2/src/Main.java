package Task02.ex2.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/** Вычисление и отображение результатов<br>
 * Содержит реализацию статического метода main()
 * @author BogdanSavchenko
 * @version 1.0
 * @see Main#main
 */
public class Main {

    /** Объект, реализующий интерфейс {@linkplain View};
     * обслуживает коллекцию объектов {@linkplain Task02.ex1.src.Item}
     */
    public View view;

    /** Инициализирует поле {@linkplain Main#view view}. */
    public Main(View view){
        this.view = view;
    }

    public static void main(String args[]){
        Main main = new Main(new ViewableResult().getView());
        main.menu();
    }

    /** Отображает меню. */
    public void menu(){
        String s = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            do {
                System.out.println("\u001B[33m" + "Enter command..." + "\u001B[0m");
                System.out.print("'q'uit, 'v'iew, 'g'enerate, 's'ave, 'r'estore: ");
                try {
                    s = in.readLine();
                } catch(IOException e) {
                    System.out.println("\u001B[31m" + "Error: " + e + "\u001B[0m");
                    System.exit(0);
                }
            } while (s.length() != 1);
            switch (s.charAt(0)) {
                case 'q':
                    System.out.println("\u001B[32m" + "Exit." + "\u001B[0m");
                    break;
                case 'v':
                    System.out.println("\u001B[32m" + "View current." + "\u001B[0m");
                    view.viewShow();
                    break;
                case 'g':
                    System.out.println("\u001B[35m" + "Random generation." + "\u001B[0m");
                    view.viewInit();
                    view.viewShow();
                    break;
                case 's':
                    System.out.println("\u001B[32m" +"Save current." + "\u001B[0m");
                    try {
                        view.viewSave();
                    } catch (IOException e) {
                        System.out.println("\u001B[31m" + "Serialization error: " + e + "\u001B[0m");
                    }
                    view.viewShow();
                    break;
                case 'r':
                    System.out.println("\u001B[32m" + "Restore last saved." + "\u001B[0m");
                    try {
                        view.viewRestore();
                    } catch (Exception e) {
                        System.out.println("\u001B[31m" + "Serialization error: " + e + "\u001B[0m");
                    }
                    view.viewShow();
                    break;
                default:
                    System.out.println("\u001B[31m" + "Wrong command." + "\u001B[0m");
            }
        } while(s.charAt(0) != 'q');
    }
}
