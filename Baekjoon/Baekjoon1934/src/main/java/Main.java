import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for(int i =0; i<N; i++){
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int bigger = A>B?A:B;
            int smaller = A<=B?A:B;
            while(bigger%smaller!=0){
                int temp = smaller;
                smaller = bigger % smaller;
                bigger = temp;
            }
            int GCD = A*B/smaller;
            System.out.println(GCD);
        }
    }

}
