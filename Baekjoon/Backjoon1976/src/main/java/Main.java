import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int[][] roads = new int[N+1][N+1];
        int[] city_parent = new int[N+1];
        for(int i = 1; i<=N; i++){
            city_parent[i] =i;
        }
        for(int i =1; i<=N; i++){
            st= new StringTokenizer(br.readLine());
            for(int j =1; j<=N; j++){
                if(Integer.parseInt(st.nextToken())==1){
                    union(i,j,city_parent);
                }
            }
        }
        ArrayList<Integer> plan =new ArrayList();
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            int nextCity = Integer.parseInt(st.nextToken());
            plan.add(nextCity);

        }
        int commonParent = find(plan.get(0), city_parent);
        for(int i =1; i<plan.size(); i++){
            if(find(plan.get(i), city_parent)!=commonParent){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");


    }

    public static void union(int a, int b, int[] city_parent){
        int parent_a = find(a, city_parent);
        int parent_b = find(b, city_parent);
        if(a<b){
            city_parent[parent_b] = parent_a;
        }
        else{
            city_parent[parent_a] = parent_b;
        }
    }
    public static int find(int a, int[] city_parent){
        if(a==city_parent[a]) return a;
        else{
            city_parent[a] = find(city_parent[a], city_parent);
            return city_parent[a];
        }
    }
}
