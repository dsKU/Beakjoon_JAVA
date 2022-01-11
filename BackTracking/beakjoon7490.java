package BackTracking;
import java.util.ArrayList;
import java.util.Scanner;

public class beakjoon7490 {
    static int T;
    static int N;
    static String[] arr;
    static ArrayList<Integer> oper;
    static ArrayList<Integer> number;
    
    static int culc(int a, int op, int b){
        if(op == 1){
            return a + b;
        }
        else {
            return a - b;
        }
    }

    static int culc(int depth, String str){
        int result = number.get(0);
        for(int i = 0; i < oper.size(); i++){
            result = culc(result, oper.get(i), number.get(i+1));
        }

        return result;
    }
    static void DFS(int depth, String str){
        if(depth > 10) return;
        if(depth > 3){
            if(culc(depth-1, str) == 0){
                arr[depth-1] += (str + "\n"); 
            }

            
        }

        for(int i = 0; i < 3; i++){
            int temp = depth;
            int pre = number.get(number.size()-1);
            if(i == 0){
                str += " ";
                temp = number.remove(number.size()-1) * 10  + depth;
                
            }
            else if(i == 1){
                str += "+";
                oper.add(1);
                
            }
            else{
                str += "-";
                oper.add(0);
                
            }
            number.add(temp);
            str+= depth;
            DFS(depth + 1, str);

            str = str.substring(0, str.length() - 2);
            if(i >= 1){
                oper.remove(oper.size()-1);
                number.remove(number.size()-1);
            }
            else{
                number.remove(number.size()-1);
                number.add(pre);
            }
            

        }


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        arr = new String[10];
        for(int i = 0; i < 10; i++){
            arr[i] = "";
        }
        oper = new ArrayList<>();
        number = new ArrayList<>();

        number.add(1);
        DFS(2, "1");
        

        while(T-- > 0){
            N = sc.nextInt();

            System.out.println(arr[N]);
        }


        sc.close();
    }
}
