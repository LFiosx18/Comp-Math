package exeptions;

public class BorderExeption extends Exception {
    public BorderExeption() {
        super("На границах введённого интервала функция имеет одинаковые знаки\n" +
                "Нет единственного решения");
    }
}
