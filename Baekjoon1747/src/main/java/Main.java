import java.util.*;
public class Main {
    public static void main(String[] args) {
        final int MAX_VAL = 2000000;
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        boolean[] isPrime = new boolean[MAX_VAL+1];
        Arrays.fill(isPrime, true);
        for(int i =1; i<=MAX_VAL; i++){
            if(i==1){
                isPrime[i] = false;
            }
            else if(isPrime[i]){
                for(int j = i*2; j<=MAX_VAL; j+=i){
                    isPrime[j] =false;
                }
            }
        }
        for(int i =N; i<MAX_VAL; i++){
            if(isPrime[i]){
                boolean isPelin = true;
                String numStr = String.valueOf(i);
                int left =0;
                int right = numStr.length()-1;
                while(left<right){
                    if(numStr.charAt(left++)!=numStr.charAt(right--))isPelin=false;
                }
                if(isPelin){
                    System.out.println(i);
                    return;
                }
            }
        }
    }
}
