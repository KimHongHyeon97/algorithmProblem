import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Edge>[] edges = new ArrayList[V+1];
        PriorityQueue<Integer>[] pathCosts = new PriorityQueue[V+1];
        for(int i =1; i<=V; i++){
            edges[i] = new ArrayList<>();
            pathCosts[i] = new PriorityQueue<>((Integer x1, Integer x2) -> {return x1>x2?-1:1;});
        }
        for(int i =0; i<M;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[from].add(new Edge(to, weight));
        }
        PriorityQueue<Edge> queue = new PriorityQueue();
        queue.add(new Edge(1, 0));
        pathCosts[1].add(0);
        while(!queue.isEmpty()){
            Edge thisEdge = queue.poll();
            for(Edge nextEdge : edges[thisEdge.to]){
                if(pathCosts[nextEdge.to].size()<K){
                    pathCosts[nextEdge.to].add(thisEdge.weight+ nextEdge.weight);
                    queue.add(new Edge(nextEdge.to, thisEdge.weight+ nextEdge.weight));
                }
                else if(pathCosts[nextEdge.to].peek()>thisEdge.weight+ nextEdge.weight){
                    pathCosts[nextEdge.to].poll();
                    pathCosts[nextEdge.to].add(thisEdge.weight+ nextEdge.weight);
                    queue.add(new Edge(nextEdge.to, thisEdge.weight+ nextEdge.weight));
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i =1; i<=V; i++){
            if(pathCosts[i].size()==K){
                bw.write(pathCosts[i].peek()+"\n");
            }
            else{
                bw.write(-1 + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }


}
class Edge implements Comparable<Edge>{
    int to, weight;
    public Edge(int to, int weight){
        this.to =to;
        this.weight =weight;
    }

    public int compareTo(Edge e){
        return this.weight-e.weight;
    }
}