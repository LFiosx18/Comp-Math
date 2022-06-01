package utils;

import functions.FirstF;
import functions.SecondF;
import functions.ThirdF;

import java.util.Scanner;

public class UserIO {
    private static Scanner scanner = new Scanner(System.in);
    static FirstF firstF = new FirstF();
    static SecondF secondF = new SecondF();
    static ThirdF thirdF = new ThirdF();

    public static void showFunctions() {
        System.out.println("\nВыберите функцию, которая будет основой интерполяции:");
        System.out.println("1)  "+firstF.showFunction());
        System.out.println("2)  "+secondF.showFunction());
        System.out.println("3)  "+thirdF.showFunction());
    }

    public static int getNum() {
        String n="";
        while (n.equals("")) {
            System.out.println("\nВведите номер функции:");
            n=scanner.nextLine();
            if (!n.equals("0") && !n.equals("1") && !n.equals("2") && !n.equals("3")) {
                System.out.println("Введите одно число - номер функции");
                n="";
            }
        }
        return Integer.parseInt(n);
    }

    public static double[] getPoints() {
        System.out.println("Введите значения Х, '/' - конец ввода");
        int n=100;
        double[] x = new double[n];
        String s="";
        int i=0;
        while(!s.equals("/")) {
            s=scanner.nextLine();
            try {
                x[i] = Double.parseDouble(s);
                i++;
            }
            catch (Exception e) {
                break;
            }
        }
        double[] points = new double[i];
        if (i >= 0) System.arraycopy(x, 0, points, 0, i);

        return points;
    }

    public static boolean noise() {
        System.out.println("Добавить шум? (y/n)");
        String s = "";
        while (s.equals("")) {
            s=scanner.nextLine();
            if (s.equals("y"))
                return true;
            if (s.equals("n"))
                return false;
            s="";
            System.out.println("Ведите один символ: y или n");
        }
        return false;
    }
}
