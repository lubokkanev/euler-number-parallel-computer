import com.lubo.oiler.number.console.OilerNumberComputerConsole;
import com.lubo.oiler.number.core.OilerNumberComputer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        OilerNumberComputerConsole oilerNumberComputerConsole = new OilerNumberComputerConsole
                (args);

        oilerNumberComputerConsole.run();

        long endTime   = System.currentTimeMillis();
        double totalTimeInMills = (endTime - startTime) / 1000.0;
        System.out.println("The program finished in " + totalTimeInMills + " second(s) with " + 2 +
                " threads. ");
    }
}
