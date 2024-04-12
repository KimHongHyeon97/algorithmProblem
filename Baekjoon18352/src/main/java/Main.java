import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int numNode = scanner.nextInt();
        int numEdge = scanner.nextInt();
        int targetDistance = scanner.nextInt();
        int startNode = scanner.nextInt();
        int[] distanceArr = new int[numNode];
        Arrays.fill(distanceArr, -1);
        ArrayList<Integer>[] edges = new ArrayList[numNode];
        for(int i =0; i<numNode; i++){
            edges[i] = new ArrayList<>();
        }
        for(int i =0; i<numEdge; i++){
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            edges[from-1].add(to-1);
        }
        distanceArr[startNode-1] =0;
        BFS(edges, distanceArr, startNode-1);
        boolean exist = false;
        for(int i =0; i<numNode; i++){
            if(distanceArr[i]==targetDistance){
                exist = true;
                System.out.println(i+1);
            }
        }
        if(!exist) System.out.println(-1);

    }
    public static void BFS(ArrayList<Integer>[] edges, int[] distanceArr, int startIdx){
        distanceArr[startIdx] =0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startIdx);
        while(!queue.isEmpty()){
            int nowIdx = queue.poll();
            for(int i: edges[nowIdx]){
                if(distanceArr[i]==-1){
                    distanceArr[i] = distanceArr[nowIdx]+1;
                    queue.add(i);
                }
            }
        }
    }
}
