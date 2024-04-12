import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] edges = new ArrayList[N];
        for(int i =0; i<N; i++){
            edges[i] = new ArrayList<>();
        }
        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edges[from-1].add(to-1);
        }
        int[] trust = new int[N];
        for(int i =0; i<N; i++){
            boolean[] isVisited = new boolean[N];
            BFS(edges, isVisited, trust, i);
        }
        int max =0;
        for(int i =0; i<N; i++){
            if(max<trust[i])max=trust[i];
        }
        for(int i =0; i<N; i++){
            if(trust[i]==max) System.out.print((i+1)+" ");
        }


    }
    public static void BFS(ArrayList<Integer>[] edges, boolean[] isVisited, int[] trust, int startIdx){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(startIdx);
        isVisited[startIdx] = true;
        while(!queue.isEmpty()){
            int nextIdx = queue.poll();
            for(int i : edges[nextIdx]){
                if(!isVisited[i]){
                    queue.add(i);
                    trust[i]++;
                    isVisited[i]=true;
                }
            }

        }
    }
}
