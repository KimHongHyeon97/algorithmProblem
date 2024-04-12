import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int testNum = scanner.nextInt();
        for(int test = 0; test<testNum; test++){
            int numV = scanner.nextInt();
            int numE = scanner.nextInt();
            ArrayList<Integer>[] edges = new ArrayList[numV];
            for(int i =0; i<numV; i++){
                edges[i] = new ArrayList<>();
            }
            for(int i =0; i<numE; i++){
                int A = scanner.nextInt();
                int B = scanner.nextInt();
                edges[A-1].add(B-1);
                edges[B-1].add(A-1);
            }
            int[] whatSet = new int[numV]; // 0:notVisited, 1:type1, 2:type2
            boolean[] isImpossible = new boolean[1];
            for(int i =0; i<numV; i++){
                if(whatSet[i]==0){
                    DFS(edges, whatSet, i, 2, isImpossible);
                }
            }
            if(isImpossible[0])System.out.println("NO");
            else System.out.println("YES");


        }
    }

    public static void DFS(ArrayList<Integer>[] edges, int[] whatSet, int thisIdx, int previous, boolean[] isImpossible){
        //방문한 노드이면 리턴
        if(whatSet[thisIdx]!=0){return;}
        else{
            int thisSet = previous==1?2:1;
            whatSet[thisIdx] = thisSet;
            for(int i : edges[thisIdx]){
                if(whatSet[i]==thisSet){
                    isImpossible[0]=true;
                    return;
                }
                else if(whatSet[i]==0){
                    DFS(edges,whatSet,i,thisSet,isImpossible);
                }

            }
        }
    }
}
