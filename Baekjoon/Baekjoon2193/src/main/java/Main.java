import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[][] numPrinary = new long[N][2];
        numPrinary[0][0]=0;
        numPrinary[0][1]=1;
        for(int i = 1; i<N;i++){
            numPrinary[i][0] = numPrinary[i-1][0] + numPrinary[i-1][1];
            numPrinary[i][1] = numPrinary[i-1][0];
        }
        System.out.println(numPrinary[N-1][0]+numPrinary[N-1][1]);

    }
}
