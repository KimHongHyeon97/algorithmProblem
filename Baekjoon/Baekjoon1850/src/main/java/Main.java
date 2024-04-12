import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long num1 = scanner.nextLong();
        long num2 = scanner.nextLong();
        long bigger = num1>num2?num1:num2;
        long smaller = num1<=num2?num1:num2;
        while(smaller!=0){
            long temp = smaller;
            smaller = bigger%smaller;
            bigger = temp;
        }
        while (bigger>0){
            bw.write("1");
            bigger--;
        }
        bw.flush();
        bw.close();
    }
}
