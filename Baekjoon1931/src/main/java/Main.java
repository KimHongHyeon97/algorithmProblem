import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        PriorityQueue<Node> pq = new PriorityQueue<>((node1, node2)->{return node1.end<node2.end?-1:1;});
        for(int i =0; i< N; i++){
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            pq.add(new Node(start, end));
        }
        int now = pq.poll().end;
        int count =1;
        while(!pq.isEmpty()){
            Node newMeeting = pq.poll();
            if(newMeeting.start>=now){
                count++;
                now = newMeeting.end;
            }
        }
        System.out.println(count);
    }
}

class Node{
    int start;
    int end;
    public Node(int start, int end){
        this.start = start;
        this.end = end;
    }
}
