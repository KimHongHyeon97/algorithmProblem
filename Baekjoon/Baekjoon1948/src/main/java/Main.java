import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        // cost 배열과 edge, degree 배열 초기화
        int[] totalCost = new int[n+1];
        ArrayList<Node>[] edges = new ArrayList[n+1];
        ArrayList<Node>[] reverseEdges = new ArrayList[n+1];
        int[] degree = new int[n+1];
        for(int i = 1; i<=n; i++){
            edges[i] = new ArrayList<>();
            reverseEdges[i] = new ArrayList<>();
        }
        for(int i =0; i<m; i++){
            st =new StringTokenizer(br.readLine());
            int from  = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges[from].add(new Node(to, cost));
            degree[to]++;
            reverseEdges[to].add(new Node(from, cost));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList();
        queue.add(start);
        while(!queue.isEmpty()){
            int thisIdx = queue.poll();
            for(Node child : edges[thisIdx]){
                totalCost[child.to] = Math.max(totalCost[child.to], totalCost[thisIdx]+ child.cost);
                degree[child.to]--;
                if(degree[child.to]==0){
                    queue.add(child.to);
                }

            }
        }
        System.out.println(totalCost[end]);
        queue.add(end);
        int count = 0;
        boolean[] reverseVisited = new boolean[n+1];
        reverseVisited[end] = true;
        while(!queue.isEmpty()){
            int thisIdx = queue.poll();
            for(Node parent : reverseEdges[thisIdx]){
                if(totalCost[thisIdx] == totalCost[parent.to] + parent.cost){
                    count++;
                    if(!reverseVisited[parent.to]){
                        reverseVisited[parent.to] = true;
                        queue.add(parent.to);
                    }
                }
            }
        }
        System.out.println(count);



    }
}

class Node{
    int to;
    int cost;
    public Node(int to, int cost){
        this.to =to;
        this.cost =cost;
    }
}