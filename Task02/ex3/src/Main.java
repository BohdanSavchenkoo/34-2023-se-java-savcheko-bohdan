package Task02.ex3.src;

import Task02.ex2.src.View;

public class Main extends Task02.ex2.src.Main {
    /**
     * Инициализирует поле {@linkplain Main#view view}.
     *
     * @param view
     */
    public Main(View view) {
        super(view);
    }

    public static void main(String arsg[]){
        Main main = new Main(new ViewableTable().getView());
        main.menu();
    }

}
