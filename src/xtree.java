import java.io.*;

public class xTree {

    private static String[] vetStr;
    private static int position = 0;
    private static int sum = 0;
    private static int nodes = 1;
    private static int height = 1;
    private static int highestHeight = 0;

     private void xTree() {

        int qtdFilhos = Integer.parseInt(vetStr[position++]);
        int qtdElementos = Integer.parseInt(vetStr[position++]);

        for(int i = 0; i < qtdFilhos; i++) {
            height++; nodes++;
            xTree();
        }
        for(int i = 0; i < qtdElementos; i++) {
            sum += Integer.parseInt(vetStr[position++]);
            if(height > highestHeight) highestHeight = height;
        }
        height--;
    }

    public void caseTest(String casePath) throws IOException{

        long start = System.currentTimeMillis();
        readCase(casePath);
        xTree();
        long elapsed = System.currentTimeMillis() - start;

        // To convert to seconds = elapsed / 1000
        // To convert to minutes = elapsed / 60000
        
        System.out.println("\nNumber of nodes: " + nodes);
        System.out.println("Tree height: " + highestHeight);
        System.out.println("Sum of all values contained in the nodes" + sum);
        System.out.println("Execution time: " + elapsed + " milliseconds\n\n");
    }

    private void readCase(String casePath) throws IOException {
        
        try {
            
            FileReader fr = new FileReader(new File(casePath));
            BufferedReader br = new BufferedReader(fr);

            vetStr = br.readLine().split(" ");
            br.close();
            fr.close();

        }catch (IOException e){
            throw new IOException("input.txt not found in the program directory.");
        }
    }
}