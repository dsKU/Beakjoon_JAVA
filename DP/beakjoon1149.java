package DP;
import java.util.Scanner;

public class beakjoon1149 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int x = sc.nextInt(), y =sc.nextInt(), z = sc.nextInt();
        int r,g,b;
        for(int i = 1; i < N; i++){
            r = sc.nextInt() + Math.min(y,z);
            g = sc.nextInt() + Math.min(x,z);
            b = sc.nextInt() + Math.min(y,x);
            
            x = r; y = g; z = b;

        }
        System.out.println(Math.min(x,Math.min(y,z)));
        sc.close();
    }
}
