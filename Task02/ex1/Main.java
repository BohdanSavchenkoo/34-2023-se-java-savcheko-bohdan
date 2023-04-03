package Task02.ex1;

import java.io.*;
import java.util.Random;

public class Main {
    private static DecimalCalculator decimalCalculator = new DecimalCalculator(111);

    public static void main(String[] args) {
        Main main = new Main();
        Main.decimalCalculator.setTransientExample("Hehehehe");
        main.menu();
    }

    /** Метод який сериалізує об'єкт
     * @param decimalCalculator - об'єкт який передається на сериалізацію
     */
    public boolean serialize(DecimalCalculator decimalCalculator){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        boolean flag = false;
        try {
            fos = new FileOutputStream("object.bin");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(decimalCalculator);
            System.out.println("\u001B[32m" + "Сериалізація виконана успішно!" + "\u001B[0m");
            flag = true;
        } catch (IOException i) {
            i.printStackTrace();
        } finally {
            if (oos != null){
                try {
                    oos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return flag;
    }

    /** Метод, який дисериалізує об'єкт
     * @return - об'єкт
     */
    public DecimalCalculator deserialize(){
        DecimalCalculator desearialDecimalCalculate = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("object.bin");
            ois = new ObjectInputStream(fis);
            desearialDecimalCalculate = (DecimalCalculator) ois.readObject();

            if(decimalCalculator.equals(desearialDecimalCalculate)){
                System.out.println("\u001B[32m" + "Дисериалізація виконана успішно!" + "\u001B[0m");
                System.out.println("n = " + desearialDecimalCalculate.getN());
                System.out.println("transientExample = " + desearialDecimalCalculate.getTransientExample());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            if (ois != null){
                try {
                    ois.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return desearialDecimalCalculate;
    }



    /** Відображає. */
    private void menu() {
        String s = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            do {
                System.out.println("Enter command...");
                System.out.print("'q'uit, 'v'iew, 'g'enerate, 's'ave, 'r'estore: ");
                try {
                    s = in.readLine();
                } catch(IOException e) {
                    System.out.println("Error: " + e);
                    System.exit(0);
                }
            } while (s.length() != 1);
            switch (s.charAt(0)) {
                case 'q':
                    System.out.println("Exit.");
                    break;
                case 'v':
                    System.out.println("View current.");
                    System.out.println(decimalCalculator.getN());
                    break;
                case 'g':
                    System.out.println("Random generation.");
                    decimalCalculator.setN((int) ((Math.random() * (999999999l - 1l)) +1l));
                    break;
                case 's':
                    System.out.println("Save current.");
                    serialize(decimalCalculator);
                    break;
                case 'r':
                    System.out.println("Restore last saved.");
                    DecimalCalculator decimalCalculator1 = deserialize();
                    decimalCalculator1.countDigits();
                    break;
                default:
                    System.out.print("Wrong command. ");
            }
        } while(s.charAt(0) != 'q');
    }

}
