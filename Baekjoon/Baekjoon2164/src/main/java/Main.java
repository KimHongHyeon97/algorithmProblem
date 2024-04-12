import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for(int i =0; i<N; i++){
            queue.add(i+1);
        }
        while(queue.size()>1){
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.println(queue.poll());
    }
}