import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int offset = M;
        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);
        for(int i = M; i<=N; i++){
            if(i==1)continue;
            else{
                if(isPrime[i]){
                    for(int j = i*2; j<=N; j += i){
                        isPrime[j]=false;
                    }
                }
            }
        }
        for(int i =M; i<=N; i++){
            if(isPrime[i]){
                System.out.println(i);
            }
        }
    }

}
