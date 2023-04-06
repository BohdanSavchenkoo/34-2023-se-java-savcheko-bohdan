package Task02.ex3.src;

import Task02.ex1.src.Item;
import Task02.ex2.src.ViewResult;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Map;

public class ViewTable extends ViewResult {
    private static final int DEFAULT_WIDTH = 50;

    private int width;

    public ViewTable(){
        width = DEFAULT_WIDTH;
    }

    public ViewTable(int width) {
        this.width = width;
    }

    public int setWidth(int width) {
        return this.width = width;
    }

    public int getWidth() {
        return width;
    }

    private void outLine() {
        for(int i = width; i > 0; i--) {
            System.out.print('-');
        }
    }

    private void outLineLn() {
        outLine();
        System.out.println();
    }

      private void outHeader() {
          Formatter fmt = new Formatter();
          outLineLn();
          fmt.format("%s%d%s%2$d%s", "%", (width-3)/2, "s | %", "s\n");
          System.out.printf(fmt.toString(), "Number", "count");
      }

    private void outBody() {
        for(Item item : this.getItems()) {
            outLineLn();
            System.out.println("Item n= " + item.getN());
            Formatter fmt = new Formatter();
            item.getResult().forEach((k,v) ->{
                fmt.format("%22d%3s%24d\n", k, "|", v);
            });
            System.out.printf(fmt.toString());
        }


    }

    @Override
    public void viewHeader() {
        outHeader();
    }

    @Override
    public void viewBody() {
        outBody();
    }

    @Override
    public void viewFooter() {
        outLineLn();
    }

}
