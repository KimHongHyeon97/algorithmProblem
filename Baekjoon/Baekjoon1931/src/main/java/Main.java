import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Comparator<Node> compare = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.end == o2.end){
                    return o1.start- o2.start;
                }
                else{
                    return o1.end- o2.end;
                }
            }
        };
        PriorityQueue<Node> pq = new PriorityQueue<>(compare);
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
