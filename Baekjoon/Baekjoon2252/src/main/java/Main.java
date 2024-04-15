import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] degree = new int[N+1];
        ArrayList<Integer>[] edges = new ArrayList[N+1];
        for(int i =1; i<=N; i++){
            edges[i] =new ArrayList<>();
        }
        for(int i =0; i<M; i++){
            st =new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            edges[A].add(B);
            degree[B]++;
        }
        Queue<Integer> queue = new LinkedList();
        for(int i =1; i<=N; i++){
            if(degree[i]==0)queue.add(i);
        }
        while(!queue.isEmpty()){
            int thisIdx = queue.poll();
            System.out.print(thisIdx + " ");
            for(int child : edges[thisIdx]){
                degree[child]--;
                if(degree[child]==0)queue.add(child);
            }
        }
    }
}
