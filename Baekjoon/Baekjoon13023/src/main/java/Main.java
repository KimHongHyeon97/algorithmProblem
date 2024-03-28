import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        */
        Scanner scanner = new Scanner(System.in);
        int numPeople = scanner.nextInt();
        int numEdge = scanner.nextInt();

        //edge 리스트, 방문여부 배열 제작
        ArrayList<Integer>[] edges = new ArrayList[numPeople];
        for(int i =0; i<numPeople; i++){
            edges[i] = new ArrayList<>();
        }
        for(int i =0; i<numEdge; i++){
            int personA = scanner.nextInt();
            int personB = scanner.nextInt();
            edges[personA].add(personB);
            edges[personB].add(personA);
        }
        boolean[] isVisited = new boolean[numPeople];
        boolean[] exist = new boolean[1];
        for(int i =0; i<numPeople; i++){
            DFS(edges, isVisited, i, 0, exist);
            if(exist[0])break;
        }
        if(exist[0]) System.out.println(1);
        else System.out.println(0);

    }

    public static void DFS(ArrayList<Integer>[] edges, boolean[] isVisited, int thisIdx,int count, boolean[] exist){
        isVisited[thisIdx] = true;
        count++;
        if(count>=5 || exist[0]==true){
            exist[0] = true;
            return;
        }
        for(int i =0; i< edges[thisIdx].size(); i++){
            int nextIdx = edges[thisIdx].get(i);
            if(!isVisited[nextIdx]) {
                DFS(edges, isVisited, nextIdx, count, exist);
            }
        }
        isVisited[thisIdx] = false;
    }
}
