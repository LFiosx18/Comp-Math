package utils;

import equations.FirstEquation;
import equations.SecondEquation;
import equations.ThirdEquation;
import system.*;

import java.util.Scanner;

import static java.lang.Math.abs;
import static methods.HalfDivision.divisionRes;
import static methods.Tangents.tanRes;

public class UserIO {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";
    static FirstEquation firstEquation = new FirstEquation();
    static SecondEquation secondEquation = new SecondEquation();
    static ThirdEquation thirdEquation = new ThirdEquation();
    static FirstEqSystem firstEqSystem = new FirstEqSystem();
    static SecondEqSystem secondEqSystem = new SecondEqSystem();
    private static Scanner scanner = new Scanner(System.in);



    public static void showAll() {
        System.out.println("Доступные уравнения:");
        System.out.println("1)  "+firstEquation.showEquation());
        System.out.println("2)  "+secondEquation.showEquation());
        System.out.println("3)  "+thirdEquation.showEquation());
    }

    public static void showSystem() {
        System.out.println("Система для решения:");
        System.out.println("1)  "+firstEqSystem.showEquation());
        System.out.println("2)  "+secondEqSystem.showEquation());
    }

    public static double[] getParams() {
        double[] params = new double[4];
        params[0] = getNum();
        params[1] = getE();
        double[] borders = getBorders();
        params[2] = borders[0];
        params[3] = borders[1];
        return params;
    }

    public static int getNum() {
        String n="";
        while (n.equals("")) {
            System.out.println("Введите номер уравнения:");
            n=scanner.nextLine();
            if (!n.equals("1") && !n.equals("2")&& !n.equals("3")) {
                System.out.println("Введите одно число - номер уравнения");
                n="";
            }
        }
        return Integer.parseInt(n);
    }

    public static double getE() {
        String n="";
        while (n.equals("")) {
            System.out.println("Введите e:");
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

    public static double getX() {
        System.out.println("Введите начальное приближение Х: ");
        String n="";
        while (n.equals("")) {
            n=scanner.nextLine();
            try {
                return Double.parseDouble(n);
            }
            catch (Exception e) {
                System.out.println("Некорректное значение, попробуйте ещё раз");
            }
            n="";
        }
        return 0;
    }

    public static double getY() {
        System.out.println("Введите начальное приближение Y: ");
        String n="";
        while (n.equals("")) {
            n=scanner.nextLine();
            try {
                return Double.parseDouble(n);
            }
            catch (Exception e) {
                System.out.println("Некорректное значение, попробуйте ещё раз");
            }
            n="";
        }
        return 0;
    }

    public static void printRes(Double x) {
        System.out.println(BLUE+"x = "+x+"\n"+RESET);
    }
    public static void printName(int x) {
        if (x==1)
            System.out.println(BLUE+"\nРезультат метода половинного деления:"+RESET);
        else
            System.out.println(BLUE+"\nРезультат метода касательных:"+RESET);
    }

    public static void printDiff() {
        System.out.println(RED+"Разница методов: "+abs(abs(divisionRes)-abs(tanRes))+RESET);
    }

    public static void printResSys(Double[] res) {
        System.out.println("Решение системы найдено за " + res[2] + " итераций:\n"+
                "x = " + res[0] + "\ny = " + res[1]);
    }

    public static void printErrSys() {
        System.out.println("Решение не найдено");
    }

}
