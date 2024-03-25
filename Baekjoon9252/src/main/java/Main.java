import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        int[][] DP = new int[str1.length()+1][str2.length()+1];
        for(int i =1; i<=str1.length(); i++){
            for(int j = 1; j<=str2.length(); j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    DP[i][j] = DP[i-1][j-1] +1;
                }
                else{
                    DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]);
                }
            }
        }

        StringBuffer reverseLCS = new StringBuffer();
        int i = str1.length();
        int j = str2.length();
        while (i >= 1 && j >= 1) {
            if (str1.charAt(i-1)==str2.charAt(j-1)){
                reverseLCS.append(str2.charAt(j-1));
                i--;
                j--;

            }
            else{
                if(DP[i-1][j]>DP[i][j-1]) i--;
                else{
                    j--;
                }
            }
        }


        System.out.println(DP[str1.length()][str2.length()]);
        System.out.println(reverseLCS.reverse());


    }
}
