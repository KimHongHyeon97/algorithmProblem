import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        Queue<Integer> absHeap = new PriorityQueue<>((val1, val2)->{
            int val1_abs = Math.abs(val1);
            int val2_abs = Math.abs(val2);
            if(val1_abs==val2_abs){
                return val1 > val2 ? 1:-1;
            }
            else{
                return val1_abs>val2_abs ? 1:-1;
            }
        });
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int val;
        for(int i =0; i<N; i++){
            val = Integer.parseInt(br.readLine());
            if(val==0){
                if(absHeap.isEmpty()) System.out.println(0);
                else{
                    System.out.println(absHeap.poll());
                }
            }
            else{
                absHeap.add(val);
            }
        }
    }
}
