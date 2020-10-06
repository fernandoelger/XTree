import java.io.*;

public class xTree {

    private static String[] list;
    private static int position = 0;
    private static int sum = 0;
    private static int nodesCount = 1;
    private static int height = 1;
    private static int highestHeight = 0;

     private void analyseXTree() {

        int numberOfChildren = Integer.parseInt(list[position++]);
        int numberOfElements = Integer.parseInt(list[position++]);

        for(int i = 0; i < numberOfChildren; i++) {
            height++; nodesCount++;
            analyseXTree();
        }
        for(int i = 0; i < numberOfElements; i++) {
            sum += Integer.parseInt(list[position++]);
            if(height > highestHeight) highestHeight = height;
        }
        height--;
    }

    public void caseTest(String casePath) throws IOException{

        long start = System.currentTimeMillis();
        readCase(casePath);
        analyseXTree();
        long elapsed = System.currentTimeMillis() - start;

        // To convert to seconds = elapsed / 1000
        // To convert to minutes = elapsed / 60000
        
        System.out.println("\nNumber of nodesCount: " + nodesCount);
        System.out.println("Tree height: " + highestHeight);
        System.out.println("Sum of all values contained in the nodesCount" + sum);
        System.out.println("Execution time: " + elapsed + " milliseconds\n\n");
    }

    private void readCase(String casePath) throws IOException {
        
        try {
            
            FileReader fr = new FileReader(new File(casePath));
            BufferedReader br = new BufferedReader(fr);

            list = br.readLine().split(" ");
            br.close();
            fr.close();

        }catch (IOException e){
            throw new IOException("input.txt not found in the program directory.");
        }
    }
}