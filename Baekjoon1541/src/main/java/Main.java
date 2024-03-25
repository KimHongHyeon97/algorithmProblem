import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        int left=0;
        int right =0;
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Character> operators = new ArrayList<>();
        while(left<inputStr.length()){
            if(inputStr.charAt(right)=='+' || inputStr.charAt(right)=='-'){
                numbers.add(Integer.parseInt(inputStr.substring(left, right)));
                operators.add(inputStr.charAt(right));
                right++;
                left = right;
            }
            else if(right==inputStr.length()-1){
                numbers.add(Integer.parseInt(inputStr.substring(left,right+1)));
                right++;
                left = right;
            }
            else{
                right++;
            }

        }

        int numCursor = 0;
        int opCursor =0;
        int minValue=0;
        if(numbers.size()!=operators.size()){
            operators.add(0,'+');
        }
        while(numCursor<numbers.size()){
            if(operators.get(opCursor)=='+'){
                minValue += numbers.get(numCursor++);
                opCursor++;
            }
            else{
                while(numCursor<numbers.size()){
                    minValue -= numbers.get(numCursor++);
                }
            }
        }
        System.out.println(minValue);

    }
}
