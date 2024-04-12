import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[] mass = new long[N];
        boolean[] isVisited = new boolean[N];
        ArrayList<Node>[] edges = new ArrayList[N];
        for(int i =0; i<N; i++){
            edges[i] = new ArrayList<>();
        }
        long lcm =1;
        for(int i =0; i<N-1; i++){
            int thisIdx = scanner.nextInt();
            int theOtherIdx = scanner.nextInt();
            int thisWeight = scanner.nextInt();
            int otherWeight = scanner.nextInt();
            lcm *= LCM(thisWeight, otherWeight);
            edges[thisIdx].add(new Node(theOtherIdx, thisWeight, otherWeight));
            edges[theOtherIdx].add(new Node(thisIdx, otherWeight, thisWeight));
        }
        mass[0] = lcm;
        DFS(mass,isVisited, edges, 0, lcm);
        long gcdAll = mass[0];
        for(int i = 1; i<N; i++){
            gcdAll = GCD(gcdAll, mass[i]);
        }
        for(int  i =0; i<N; i++){
            mass[i] = mass[i]/gcdAll;
            System.out.print(mass[i]+" ");
        }



    }
    private static long LCM(long a, long b){
        //System.out.println(a + " with " + b + " LCM: " +  (a*b)/GCD(a, b));
        return (a*b)/GCD(a, b);
    }
    public static long GCD(long a, long b){
        long bigger = (a>b)?a:b;
        long smaller = (a<=b?a:b);
        while(smaller!=0){
            long temp = smaller;
            smaller = bigger%smaller;
            bigger = temp;

        }
        //System.out.println(a + " with " + b + " GCD: " +  bigger);
        return bigger;
    }
    private static void DFS(long[] mass, boolean[] isVisited, ArrayList<Node>[] edges, int thisIdx, long lcm){
        if(!isVisited[thisIdx]){
            isVisited[thisIdx] = true;
            for(Node node : edges[thisIdx]){
                if (!isVisited[node.theOther]) {
                    mass[node.theOther] = mass[thisIdx]*node.otherWeight/ node.myWeight;
                    DFS(mass, isVisited, edges, node.theOther, lcm);
                }
            }
        }
    }


}
class Node{
    int theOther;
    int myWeight;
    int otherWeight;
    Node(int theOther, int myWeight, int otherWeight){
        this.theOther=theOther;
        this.myWeight=myWeight;
        this.otherWeight = otherWeight;
    }
}