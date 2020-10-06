import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String args[]) throws IOException{

        Scanner s = new Scanner(System.in);
        xTree tbMachine = new xTree();

        int option;

        do {
            System.out.println("--- Choose a case to be tested ---\n");
            System.out.println("1  - case 1\n"      +
                               "2  - case 2\n"      +
                               "3  - case 3\n"      +
                               "4  - case 4\n"      +
                               "5  - case 5\n"      +
                               "6  - case 6\n"      +
                               "7  - case 7\n"      +
                               "8  - case 8\n"      +
                               "0  - End\n"         +
                               "-----------------------------------");
            option = s.nextInt();

            switch(option){
                case 1: tbMachine.caseTest("test-cases/case-1.txt");
                        break;

                case 2: tbMachine.caseTest("test-cases/case-2.txt");
                        break;

                case 3: tbMachine.caseTest("test-cases/case-3.txt");
                        break;

                case 4: tbMachine.caseTest("./test-cases/case-4.txt");
                        break;

                case 5: tbMachine.caseTest("test-cases/case-5.txt");
                        break;

                case 6: tbMachine.caseTest("test-cases/case-6.txt");
                        break;

                case 7: tbMachine.caseTest("test-cases/case-7.txt");
                        break;

                case 8: tbMachine.caseTest("test-cases/case-8.txt");
                        break;

                case 9: tbMachine.caseTest("test-cases/caso-teste.txt");
                        break;
            }
        } while(option != 0);
        s.close();
    }
}