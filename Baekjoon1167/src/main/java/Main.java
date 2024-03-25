import java.util.*;

class Node{
    int dest;
    int weight;

    Node(int dest, int weight){
        this.dest = dest;
        this.weight = weight;
    }
}
/**
 *
 * main idea: 트리 구조에서 리프 노드간의 거리 중에 최대 길이가 존재하므로 임의의 노드로부터 DFS 또는 BFS를 통해 최대값을
 *             가지는 노드를 구한 후, 이 노드는 반드시 리프 노드이므로 이 노드로부터 다시 BFS 수행 후 최대값이 트리의 최대 너비가 된다.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numVortex = scanner.nextInt();
        scanner.nextLine();

        //edge 정보 리스트 할당 및 입력
        ArrayList<Node>[] edges = new ArrayList[numVortex];
        for (int i = 0; i < numVortex; i++) {
            edges[i] = new ArrayList<>();
        }
        for(int  i =0; i<numVortex; i++){
            int nodeA = scanner.nextInt();
            while(true){
                int nodeB = scanner.nextInt();
                if(nodeB==-1){
                    break;
                }
                int weight = scanner.nextInt();
                edges[nodeA-1].add(new Node(nodeB-1, weight));
            }
        }
        int[] arr = BFS(edges, 0);
        int nextStartVortex = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>arr[nextStartVortex])nextStartVortex = i;
        }
        int[] resultArr = BFS(edges, nextStartVortex);
        int max = 0;
        for(int i : resultArr){
            if(max<i)max=i;
        }
        System.out.println(max);


    }

    public static int[] BFS(ArrayList<Node>[] edges, int startVortex){
        boolean[] isVisited = new boolean[edges.length];
        Queue<Node> queue = new LinkedList<>();
        int[] distance = new int[edges.length];
        queue.add(new Node(startVortex, 0));
        distance[startVortex] =0;
        while (!queue.isEmpty()){
            Node nowNode = queue.poll();
            isVisited[nowNode.dest] = true;
            for(Node nextNode:edges[nowNode.dest]){
                if(!isVisited[nextNode.dest]){
                    distance[nextNode.dest] = distance[nowNode.dest] + nextNode.weight;
                    queue.add(nextNode);
                }

            }
        }
        return distance;


    }

}
