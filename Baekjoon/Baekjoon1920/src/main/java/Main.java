import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for(int i =0; i<N; i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int numTarget = scanner.nextInt();
        
        int[] targets = new int[numTarget];
        for(int i =0; i<numTarget; i++){
            targets[i] = scanner.nextInt();
        }
        for(int target:targets){
            boolean[] ans = {false};
            binarySearch(arr,0, N-1, target, ans);
            if(ans[0]) System.out.println(1);
            else System.out.println(0);
        }
    }

    public static void binarySearch(int[] arr,int start, int end, int target, boolean[] ans){
        if(start>end)return;
        else{
            int middle = (start+end)/2;
            if(arr[middle]==target){
                ans[0]= true;
                return;
            }
            else if(arr[middle]>target){
                binarySearch(arr, start,middle-1, target, ans);
            }
            else {
                binarySearch(arr, middle+1, end, target, ans);
            }
        }
    }
}
