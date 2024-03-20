import java.util.*;


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
        ArrayList<Node>[] edges = new ArrayList[numVortex+1];
        for(int i = 1; i<=numVortex; i++){
            edges[i] = new ArrayList<>();
            String[] edgeStr = scanner.nextLine().split(" ");
            int vortex = Integer.parseInt(edgeStr[0]);
            for(int j =1; j<edgeStr.length-1; j+=2){
                edges[vortex].add(new Node(Integer.parseInt(edgeStr[j]), Integer.parseInt(edgeStr[j+1])));
            }
        }
        //nodeA -> nodeB의 최대 거리 배열
        int[][] maxDistances = new int[numVortex+1][numVortex+1];

        for(int i =1; i<=numVortex; i++){
            BFS(edges, i, maxDistances);
        }
        int max = max(maxDistances);
        System.out.println(max);

    }

    public static int BFS(ArrayList<Node>[] edges, int startVortex){
        Queue<Node> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[edges.length];
        int[] maxDistances = new int[edges.length+1];
        queue.add(new Node(startVortex, 0));
        int prevIdx = startVortex;
        while(!queue.isEmpty()){
            Node nowNode = queue.poll();
            isVisited[nowNode.dest] = true;
            maxDistances[nowNode.dest] = maxDistances[prevIdx] + nowNode.weight;
            for(Node node : edges[nowNode.dest]){
                if(!isVisited[node.dest]){
                    queue.add(node);
                }
            }
            prevIdx = nowNode.dest;
        }
        int maxIdx = startVortex;
        for(int i=1; i<= maxDistances.length; i++){


        }
    }



}
class Node{
    int dest;
    int weight;

    Node(int dest, int weight){
        this.dest = dest;
        this.weight = weight;
    }
}
