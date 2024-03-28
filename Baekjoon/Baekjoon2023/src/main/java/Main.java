import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        DFS(2, N);
        DFS(3, N);
        DFS(5, N);
        DFS(7, N);
    }

    public static boolean isPrimeNum(int val){
        //가능한 가장 작은 약수는 2, 가장 큰 약수는 val/2이므로
        for(int i =2; i<=val/2; i++){
            if(val%i==0)return false;
        }
        return true;
    }

    public static void DFS(int val, int N){
        if(isPrimeNum(val)){
            if(String.valueOf(val).length()==N){
                System.out.println(val);
                return;
            }
            else{
                for(int i = 1; i<10; i+=2){
                    DFS(val*10+i, N);
                }
            }
        }
        return;

    }
}
