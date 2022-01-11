package BackTracking;
import java.util.Scanner;

public class beakjoon9663 {
    static int N;
    static int[] col;
    static int count = 0;
    public static boolean check(int x){
        for(int j = 0 ; j < x; j++){
            if(col[x] == col[j] || Math.abs(col[x] - col[j]) == x - j)
                return false;
        }
        return true;
    }
    
    public static void backT(int depth){
        if(depth == N) count++;
        else{
            for(int i = 0; i < N ; i++ ){
                col[depth] = i;
                if(check(depth))
                    backT(depth+1);
            }
        }
        

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        col = new int[N+1];

        backT(0);
        System.out.println(count);
        sc.close();  
    }  
}
