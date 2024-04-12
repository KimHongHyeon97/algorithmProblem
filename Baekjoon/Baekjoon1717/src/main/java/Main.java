import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] nodeSet = new int[N+1];
        for(int i =0; i<=N; i++){
            nodeSet[i] =i;
        }

        for(int i = 0; i<M; i++){
            int op = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            //union
            if(op==0){
                if(nodeSet[a]<nodeSet[b]){
                    int setA = find(nodeSet, a);
                    int setB = find(nodeSet, b);
                    nodeSet[setB] = setA;
                }
                else{
                    int setA = find(nodeSet, a);
                    int setB = find(nodeSet, b);
                    nodeSet[setA] = setB;
                }
            }
            //
            else{
                if(find(nodeSet,a)==find(nodeSet,b)) System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }

    public static int find(int[] nodeSet, int node){
        if(node==nodeSet[node]){return node;}
        else{
            nodeSet[node] = find(nodeSet,nodeSet[node]);
            return nodeSet[node];
        }
    }
}
