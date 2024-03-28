import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCoin = scanner.nextInt();
        int price = scanner.nextInt();
        int[] coins = new int[numCoin];
        for(int i=0; i<numCoin; i++){
            coins[i] = scanner.nextInt();
            scanner.nextLine();
            //System.out.println("coins[i] = " + coins[i]);
        }
        int answer = 0;
        for(int i =numCoin-1; i>=0; i--){
            answer+=price/coins[i];
            price = price%coins[i];
        }
        System.out.println(answer);
    }
}
