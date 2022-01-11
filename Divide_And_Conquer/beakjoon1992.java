package Divide_And_Conquer;
import java.util.Scanner;

public class beakjoon1992 {
    static int N;
    static int[][] map;
    

    static public boolean check(int from_x, int to_x, int from_y, int to_y){
        int ch = map[from_y][from_x];
        for(int i = from_y; i < to_y; i++){
            for(int j = from_x; j < to_x; j++){
                if(ch != map[i][j]) return false;
            }
        }

        return true;
    }

    static public void DAC(int from_x, int to_x, int from_y, int to_y){
        if(check(from_x, to_x, from_y, to_y)){
            int val = map[from_y][from_x];
            System.out.print(val);
            return;
        }
        int size = to_x - from_x;
        int next_size = size / 2;

        System.out.print("(");

        DAC(from_x, to_x - next_size, from_y, to_y - next_size);

        DAC(from_x + next_size, to_x, from_y , to_y - next_size);

        DAC(from_x, to_x - next_size, from_y + next_size, to_y);

        DAC(from_x + next_size, to_x, from_y + next_size, to_y);
        System.out.print(")");
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        map = new int[N][N];
        sc.nextLine();
        for(int i = 0; i < N; i++){
            String str = sc.nextLine();
            for(int j = 0; j < str.length(); j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        DAC(0, N, 0, N);

        sc.close();
    }
}
