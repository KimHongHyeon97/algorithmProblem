import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long A = scanner.nextLong();
        long B = scanner.nextLong();
        int sqrtA = (int)Math.sqrt(A);
        int sqrtB = (int)Math.sqrt(B);
        boolean[] isPrime = new boolean[10000001];
        long count =0;
        Arrays.fill(isPrime, true);
        for(int i = 2; i<=10000000; i++){
            if(isPrime[i] && i!=1){
                for(int j = i*2; j<=sqrtB; j +=i){
                    isPrime[j] = false;
                }
            }
        }
        for(int i =2; i<=10000000; i++){
            if(isPrime[i]){
                long powNum = i;
                while((double)powNum<=(double)B/i){  //**
                    if((double)powNum>=(double)A/i)count++;  //**
                    powNum = powNum * i;
                }
            }
        }
        System.out.println(count);

    }

    /**
     * powNum = i * i 로 잡고 B와 비교하다보면 powNum에 오버플로우(10^21) 생기고 이상한 값이 생길 수 있음.
     * -> powNum = B / i 로 비교하면 해결
     * 위 코드에서 별표친 부분의 double 타입으로 캐스팅을 제외하면 오답 나옴.
     * why? int 형 나눗셈하며 소숫점 자리가 버려지면, 실제 조건이 맞지 않는데 맞다고 카운트 되거나 반대 경우 발생 가능
     * 
     */
}