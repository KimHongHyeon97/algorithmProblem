import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int capaA = scanner.nextInt();
        int capaB = scanner.nextInt();
        int capaC = scanner.nextInt();
        Queue<State> queue = new ArrayDeque<>();
        Set<Integer> resultSet = new HashSet<>();
        boolean[][] isVisited = new boolean[capaA+1][capaB+1];
        queue.add(new State(0,0));
        isVisited[0][0] =true;
        while(!queue.isEmpty()){
            State nowState = queue.poll();
            if(nowState.A==0){
                resultSet.add(capaC-nowState.B);
            }
            //From A
            if(nowState.A!=0){
                //To B
                if(nowState.A+nowState.B <=capaB){
                    int newB = nowState.A+nowState.B;
                    int newA = 0;
                    if(!isVisited[newA][newB]){
                        isVisited[newA][newB]=true;
                        queue.add(new State(newA, newB));
                    }
                }
                else{
                    int newB = capaB;
                    int newA = nowState.A -(capaB-nowState.B);
                    if(!isVisited[newA][newB]){
                        isVisited[newA][newB]=true;
                        queue.add(new State(newA, newB));
                    }
                }

                //To C
                int newA =0;
                int newB = nowState.B;
                if(!isVisited[newA][newB]){
                    isVisited[newA][newB]=true;
                    queue.add(new State(newA, newB));
                }



            }
            //From B
            if(nowState.B!=0){
                //To A
                if(nowState.A+nowState.B <=capaA){
                    int newB = 0;
                    int newA = nowState.A+nowState.B;
                    if(!isVisited[newA][newB]){
                        isVisited[newA][newB]=true;
                        queue.add(new State(newA, newB));
                    }
                }
                else{
                    int newB = nowState.B-(capaA-nowState.A);
                    int newA = capaA;
                    if(!isVisited[newA][newB]){
                        isVisited[newA][newB]=true;
                        queue.add(new State(newA, newB));
                    }
                }

                //To C
                int newA =nowState.A;
                int newB = 0;
                if(!isVisited[newA][newB]){
                    isVisited[newA][newB]=true;
                    queue.add(new State(newA, newB));
                }



            }
            //From C
            if(capaC- nowState.A - nowState.B !=0){
                //To A
                if(capaC-nowState.B <=capaA){
                    int newB = nowState.B;
                    int newA = capaC-nowState.B;
                    if(!isVisited[newA][newB]){
                        isVisited[newA][newB]=true;
                        queue.add(new State(newA, newB));
                    }
                }
                else{
                    int newB = nowState.B;
                    int newA = capaA;
                    if(!isVisited[newA][newB]){
                        isVisited[newA][newB]=true;
                        queue.add(new State(newA, newB));
                    }
                }
                //To B
                if(capaC-nowState.A <=capaB){
                    int newB = capaC-nowState.A;
                    int newA = nowState.A;
                    if(!isVisited[newA][newB]){
                        isVisited[newA][newB]=true;
                        queue.add(new State(newA, newB));
                    }
                }
                else{
                    int newB = capaB;
                    int newA = nowState.A;
                    if(!isVisited[newA][newB]){
                        isVisited[newA][newB]=true;
                        queue.add(new State(newA, newB));
                    }
                }
            }

        }


        List<Integer> result = resultSet.stream().collect(Collectors.toList());
        result.sort((a,b)->a>b?1:-1);


        for(int i : result){
            System.out.print(i+" ");
        }

    }

}
class State{
    int A;
    int B;
    public State(int A, int B){
        this.A = A;
        this.B = B;
    }
}
