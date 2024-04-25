import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E =Integer.parseInt(st.nextToken());
        st =new StringTokenizer(br.readLine());
        int startV = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] edges = new ArrayList[V+1];
        int[] cost = new int[V+1];
        for(int i =1; i<=V; i++){
            edges[i] = new ArrayList<Edge>();
            cost[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to =Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[from].add(new Edge(to, weight));
        }
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(startV,0));
        cost[startV] = 0;
        while(!queue.isEmpty()){
            Edge thisEdge = queue.poll();
            // if (isVisited[thisEdge.to]) continue;
            // else isVisited[thisEdge.to] =true;
            for(Edge nextEdge : edges[thisEdge.to]){
                if(cost[nextEdge.to]>cost[thisEdge.to]+ nextEdge.weight){
                    cost[nextEdge.to] = cost[thisEdge.to]+ nextEdge.weight;
                    queue.add(new Edge(nextEdge.to, cost[nextEdge.to]));
                }
                /*
                if(!isVisited[nextEdge.to]){
                    queue.add(new Edge(nextEdge.to, nextEdge.weight));
                }
                */
            }
        }

        for(int i =1 ; i<=V; i++){
            if(i==startV){
                System.out.println(0);
            }
            else if (cost[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }
            else{
                System.out.println(cost[i]);
            }
        }
    }
}

class Edge implements Comparable<Edge>{
    int to;
    int weight;
    public Edge(int to, int weight){
        this.to = to;
        this.weight = weight;
    }
    @Override
    public int compareTo(Edge n){
        return (this.weight<n.weight)?-1:1;
    }
}
