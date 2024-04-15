import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[] totalCost = new long[N+1];
        long[] cost = new long[N+1];
        int[] degree = new int[N+1];
        ArrayList<Integer>[] edges = new ArrayList[N+1];
        for(int i =1; i<=N; i++){
            edges[i] = new ArrayList<>();
        }
        for(int i=1; i<=N; i++){
            long thisCost = scanner.nextInt();
            cost[i] = thisCost;
            int next = scanner.nextInt();
            while(next!=-1){
                degree[i]++;
                edges[next].add(i);
                next=scanner.nextInt();
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(degree[i]==0){queue.add(i);}
        }
        while(!queue.isEmpty()){
            int thisIdx = queue.poll();
            for(int child : edges[thisIdx]){
                degree[child]--;
                totalCost[child] = Math.max(totalCost[child], totalCost[thisIdx]+cost[thisIdx]);
                if(degree[child]==0){
                    queue.add(child);
                }
            }
        }
        for(int i =1; i<=N; i++){
            System.out.println(totalCost[i]+cost[i]);
        }
    }
    public static int findMaxParent(long[] totalCost,ArrayList<Integer>[] edges, int thisIdx){
        int max=0;
        int maxParent = thisIdx;
        for(int i =1; i<= edges.length-1; i++){
            for(int child : edges[i]){
                if(child == thisIdx && totalCost[i]>max)maxParent=i;
            }
        }
        return maxParent;
    }
}
