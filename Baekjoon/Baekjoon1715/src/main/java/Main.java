import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int N = scanner.nextInt();
        for(int i =0; i<N; i++){
            int numCard = scanner.nextInt();
            priorityQueue.add(numCard);
        }
        int sum = 0;
        while(priorityQueue.size()>1){
            int num1 = priorityQueue.poll();
            int num2 = priorityQueue.poll();
            sum += (num1 + num2);
            priorityQueue.add(num1+num2);
        }
        System.out.println(sum);

    }
}
/**
 * 왜 배열로 받고 sort()한 후 더하는 로직으로는 틀리는지?...
 * -> 과정 중 하나로 합쳐진 카드덱의 카드 수가 아직 더하지 않은 카드 덱보다 많으면, 아직 더하지 않은 카드 덱부터 합친다.
 * -> 정렬한 배열로는 이 과정이 이루어지지 않음.
 */