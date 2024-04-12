import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long min = scanner.nextLong();
        long max = scanner.nextLong();
        long[] numbers = new long[(int)(max-min)+1];

        for(int i = 0; i<numbers.length; i++){
            numbers[i] = min+i;
        }
        for(long i =2; i*i<=max; i++) {
            long pow = i * i;
            long startIdx = min % pow == 0 ? min / pow : min / pow + 1;
            for(long j = startIdx; j * pow <= max; j++) {
                numbers[(int)(j*pow -min)] = 0;
            }
        }
        int count =0;
        for(int i =0;i<numbers.length; i++){
            if(numbers[i]!=0)count++;
        }
        System.out.println(count);



    }
}
