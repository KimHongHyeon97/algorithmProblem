import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Integer> pq_pos = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq_neg = new PriorityQueue<>();

        int N = scanner.nextInt();
        for(int i =0; i<N; i++){
            int num = scanner.nextInt();
            if(num>0){
                pq_pos.add(num);
            }
            else{
                pq_neg.add(num);
            }
        }
        int maxSum =0;
        while(pq_pos.size()>1){
            int num1 = pq_pos.poll();
            int num2 = pq_pos.poll();
            if(num1+num2 <= num1*num2){
                maxSum += num1*num2;
            }
            else{
                maxSum += num1;
                pq_pos.add(num2);
            }
        }
        if(pq_pos.size()==1){
            maxSum += pq_pos.poll();
        }
        while(pq_neg.size()>1){
            int num1 = pq_neg.poll();
            int num2 = pq_neg.poll();
            if(num1+num2 <= num1*num2){
                maxSum += num1*num2;
            }
            else{
                maxSum += num1;
                pq_neg.add(num2);
            }
        }
        if(pq_neg.size()==1){
            maxSum += pq_neg.poll();
        }
        System.out.println(maxSum);


    }
}
