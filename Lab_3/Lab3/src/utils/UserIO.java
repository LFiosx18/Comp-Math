package utils;

import integrals.FirstInt;
import integrals.SecondInt;
import integrals.ThirdInt;

import java.util.Scanner;

import static java.lang.Math.abs;

public class UserIO {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";
    public static final String YELLOW = "\u001B[33m";
    static FirstInt firstInt = new FirstInt();
    static SecondInt secondInt = new SecondInt();
    static ThirdInt thirdInt = new ThirdInt();
    private static Scanner scanner = new Scanner(System.in);

    public static void showAll() {
        System.out.println("\nДоступные интегралы:");
        System.out.println("1)  "+firstInt.showEquation());
        System.out.println("2)  "+secondInt.showEquation());
        System.out.println("3)  "+thirdInt.showEquation());
    }

    public static double[] getParams() {
        double[] params = new double[4];
        params[0] = getNum();
        if (params[0]==0)
            return params;
        params[1] = getE();
        double[] borders = getBorders();
        params[2] = borders[0];
        params[3] = borders[1];
        return params;
    }

    public static int getNum() {
        String n="";
        while (n.equals("")) {
            System.out.println("\nВведите номер интеграла (0 - завершить программу):");
            n=scanner.nextLine();
            if (!n.equals("0") && !n.equals("1") && !n.equals("2") && !n.equals("3")) {
                System.out.println("Введите одно число - номер интеграла");
                n="";
            }
        }
        return Integer.parseInt(n);
    }

    public static double getE() {
        String n="";
        while (n.equals("")) {
            System.out.println("Введите необходимую точность результата:");
            n=scanner.nextLine();
            if (n.equals(""))
                continue;
            try {
                return Double.parseDouble(n);
            }
            catch (Exception e) {
                System.out.println("Значение должно быть числом, попробуйте ещё раз");
            }
            n="";
        }
        return 1;
    }

    public static double[] getBorders() {
        double[] borders = {0, 0};
        String l, r;
        while (true) {
            System.out.println("Введите левую границу: ");
            l=scanner.nextLine();
            System.out.println("Введите правую границу: ");
            r=scanner.nextLine();
            if (l.equals("") || r.equals("")) {
                System.out.println("Некорректные значения, попробуйте ещё раз");
                continue;
            }
            try {
                borders[0]=Double.parseDouble(l);
                borders[1]=Double.parseDouble(r);
                if (borders[0]>=borders[1]) {
                    System.out.println("Левая граница должна быть меньше правой!");
                    continue;
                }
                return borders;
            }
            catch (Exception e) {
                System.out.println("Некоректные значение, введите числа!");
            }
        }
    }

    public static void printRes(double res, int n) {
        System.out.println(BLUE+"\nПолученное значение интеграла: "+ res);
        System.out.println("При n = " + n + RESET);
    }

    public static void printNewton(double res, double res1) {
        System.out.println(YELLOW+"Значение интеграла методом Ньютона-Лейбница: " + res);
        System.out.println("Разница методов: " + abs(abs(res)-abs(res1))+RESET);
    }

    public static void errAccurate() {
        System.out.println(RED+"Невозможно посчитать интеграл по формуле Ньютона-Лейбница (первообразная функции не элементарная)"+RESET);
    }

    public static void printErr() {
        System.out.println(RED+"\nНе удалось посчитать интеграл :("+RESET);
    }

    public static void okGap() {
        System.out.println(BLUE+"\nСуществует устранимый разрыв функции в точке 0\n" +
                "Разрыв устранён путём доопределения функции в данной точке"+RESET);
    }

    public static void errGap() {
        System.out.println(RED + "\nНа данном участке функции существует неустранимый разрыв\n" +
                "Вычислить интеграл невозможно" + RESET);
    }
}
