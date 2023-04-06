package Task02.ex3.src;

import Task02.ex2.src.View;
import Task02.ex2.src.ViewableResult;

public class ViewableTable extends ViewableResult {
    @Override
    public View getView(){
        return (View) new ViewTable();
    }
}
