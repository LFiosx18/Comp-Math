package exeptions;

public class TanBorderExeption extends Exception{
    public TanBorderExeption() {
        super("Не существует хорошего начального приближения по границам введённого отрезка");
    }
}
