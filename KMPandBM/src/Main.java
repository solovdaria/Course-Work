import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("1) Knuth Morris Pratt\n2) Boyer Moore");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        long m = System.currentTimeMillis();

        switch (choice)
        {
            case 1:
                try {
                    File file1 = new File("pattern.txt");
                    FileReader fr1 = new FileReader(file1);
                    BufferedReader reader1 = new BufferedReader(fr1);

                    File file2 = new File("text.txt");
                    FileReader fr2 = new FileReader(file2);
                    BufferedReader reader2 = new BufferedReader(fr2);

                    String pat = reader1.readLine();
                    String txt = reader2.readLine();
                    new KMP_String_Matching().KMPSearch(pat, txt);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    File file1 = new File("pattern.txt");
                    FileReader fr1 = new FileReader(file1);
                    BufferedReader reader1 = new BufferedReader(fr1);

                    File file2 = new File("text.txt");
                    FileReader fr2 = new FileReader(file2);
                    BufferedReader reader2 = new BufferedReader(fr2);

                    String pat = reader1.readLine();
                    String txt = reader2.readLine();
                    char txtArr[] = txt.toCharArray();
                    char patArr[] = pat.toCharArray();
                    new BM_String_Matching().search(txtArr, patArr);;
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            default:
                break;
        }
        System.out.println("Time in seconds: " + ((double) (System.currentTimeMillis() - m)) / 1000);
    }
}
