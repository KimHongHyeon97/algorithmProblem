import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    //방향이동 상수, 동서남북 순
    static final int[] dx ={1,-1,0,0};
    static final int[] dy={0,0,1,-1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();
        //미로 맵 할당 및 입력
        int[][] map = new int[N][M];
        boolean[][] isVisited = new boolean[N][M];
        for(int i =0; i<N; i++){
            String rowStr = scanner.nextLine();
            for(int j = 0; j<rowStr.length(); j++){
                map[i][j] = rowStr.charAt(j) - '0';
            }
        }
        BFS(map, isVisited);
        System.out.println(map[N-1][M-1]);

    }

    public static void BFS(int[][] map, boolean[][] isVisited){
        int count =0;
        Queue<int[]> queue = new LinkedList<>();
        int[] start = {0,0};
        queue.add(start);
        while(!queue.isEmpty()){
            int[] nowCoordinate = queue.poll();
            int nowRow = nowCoordinate[0];
            int nowCol = nowCoordinate[1];
            isVisited[nowRow][nowCol] = true;

            //(N,M)에 도달하면 현재까지 count return

            for(int i =0; i<4;i++){
                int nextRow = nowRow + dy[i];
                int nextCol = nowCol + dx[i];
                if( nextRow>=0 && nextRow<map.length && nextCol >=0 && nextCol<map[0].length && map[nextRow][nextCol]==1 && !isVisited[nextRow][nextCol]){
                    int[] nextCoordinate = new int[]{nextRow, nextCol};
                    map[nextRow][nextCol] = map[nowRow][nowCol]+1;
                    if(nextRow==map.length-1 &&nextCol==map[0].length-1) return;
                    queue.add(nextCoordinate);
                }
            }
        }


    }


}
