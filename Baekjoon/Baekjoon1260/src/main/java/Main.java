import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numVortex = scanner.nextInt();
        int numEdge = scanner.nextInt();
        int startVortex = scanner.nextInt();

        //edge list & 방문여부배열 할당
        boolean[] isVisitedDFS = new boolean[numVortex+1];
        boolean[] isVisitedBFS = new boolean[numVortex+1];
        ArrayList<Integer>[] edges = new ArrayList[numVortex+1];
        for(int i=0; i<numVortex+1; i++){
            edges[i] = new ArrayList<>();
        }

        //edge 정보 읽고 저장
        for(int i = 0; i<numEdge; i++){
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            edges[v1].add(v2);
            edges[v2].add(v1);
        }
        //노드별 edge정보 정렬
        for(int i =1; i<numVortex+1; i++){
            Collections.sort(edges[i]);
        }

        DFS(edges, startVortex, isVisitedDFS);
        System.out.println();
        BFS(edges, startVortex, isVisitedBFS);
        System.out.println();


    }

    public static void DFS(ArrayList<Integer>[] edges, int thisIdx, boolean[] isVisitedDFS){
        if(!isVisitedDFS[thisIdx]){
            isVisitedDFS[thisIdx]=true;
            System.out.print(thisIdx+" ");
            for(int i : edges[thisIdx]){
                if(!isVisitedDFS[i]){
                    DFS(edges,i,isVisitedDFS);
                }
            }
        }
    }

    public static void BFS(ArrayList<Integer>[] edges, int startVortex, boolean[] isVisitedBFS){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startVortex);

        while(!queue.isEmpty()){
            int polledIdx = queue.poll();
            if(!isVisitedBFS[polledIdx]){
                isVisitedBFS[polledIdx]=true;
                System.out.print(polledIdx + " ");
                for(int i : edges[polledIdx]){
                    if(!isVisitedBFS[i]){
                        queue.add(i);
                    }
                }
            }
        }
    }

}
