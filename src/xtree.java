import java.io.*;
import java.util.Scanner;

public class Program {

    private static String[] vetStr;
    private static int posicao = 0;
    private static int soma = 0;
    private static int nodos = 1;
    private static int altura = 1;
    private static int maiorAltura = 0;

     private static void xtree() {
        int qtdFilhos = Integer.parseInt(vetStr[posicao++]);
        int qtdElementos = Integer.parseInt(vetStr[posicao++]);

        for(int i = 0; i < qtdFilhos; i++) {
            altura++; nodos++;
            xtree();
        }
        for(int i = 0; i < qtdElementos; i++) {
            soma += Integer.parseInt(vetStr[posicao++]);
            if(altura > maiorAltura) maiorAltura = altura;
        }
        altura--;
    }

    public static void main( String[] args ) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Informe o nome de arquivo texto: ");
        System.out.println("Dica: ( cohen/caso3.txt ou jb/caso5.txt )");
        String path = ler.nextLine();

        lerArquivo(path);
        long start = System.currentTimeMillis();
        xtree();
        long elapsed = System.currentTimeMillis() - start;

        // Para converter em segundos = end / 1000
        // Para converter em minutos = end / 60000

        System.out.println("Total nodos: " + nodos);
        System.out.println("Altura: " + maiorAltura);
        System.out.println("Soma: " + soma);
        System.out.println("Tempo: " + elapsed + " milissegundos");
    }

    public static void lerArquivo(String path) {
        File arquivo = new File("./casos/" + path);
        try {
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            vetStr = br.readLine().split(" ");
            br.close();
            fr.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

}