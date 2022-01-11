package BackTracking;
import java.util.Scanner;

public class beakjoon14888 {
    static int N;
    static int[] val;
    static int[] oper;
    static int max_val;
    static int min_val;

    static int culc(int a, int op, int b){
        if(op == 0){
            return a + b;
        }
        else if(op == 1){
            return a - b;
        }
        else if(op == 2){
            return a * b;
        }
        else{
            return a / b;
        }
    }
    
    static public void DFS(int cnt, int result){
        if(cnt == N){

            max_val = Math.max(max_val, result);
            min_val = Math.min(min_val, result);
            
            return;
        }

        for(int i = 0; i < 4; i ++){
            if(oper[i] > 0){
                oper[i] --;
                int re = culc(result, i, val[cnt]);
                DFS(cnt + 1, re);
                oper[i] ++;
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        val = new int[N+1];
        oper = new int[4];
        max_val = Integer.MIN_VALUE;
        min_val = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++){
            val[i] = sc.nextInt();
        }
        for(int i = 0; i < 4; i++){
            oper[i] = sc.nextInt();
        }

        DFS(1,val[0]);

        System.out.println(max_val);
        System.out.println(min_val);

        sc.close();
    }
}
