import java.io.*;
import java.util.*;

public class swea5644 {
    
    static int N,M;
    static int[][] person;
    static int[][] position;
    static Battery[] batteries;
    static int dx[] = {0, -1 , 0, 1, 0};
    static int dy[] = {0, 0 , 1, 0, -1};
    static int aSum;
    static int bSum;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int t = 1; t <= T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            aSum = 0; bSum = 0;
            person = new int[2][N+1];
            batteries = new Battery[M];
            position = new int[2][2];

            for(int i = 0; i < 2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    person[i][j] = Integer.parseInt(st.nextToken());
                }
            }
                
            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());   //x
                int b = Integer.parseInt(st.nextToken());   //y
                int c = Integer.parseInt(st.nextToken());   //distance
                int d = Integer.parseInt(st.nextToken());   //power
                
                batteries[i] = new Battery(a, b, c, d);
            }

            position[0][0] = 1;
            position[0][1] = 1;
            position[1][0] = 10;
            position[1][1] = 10;
            turn();
            for(int i = 0 ; i < N; i++){
                
                position[0][0] += dy[person[0][i]]; //1x
                position[0][1] += dx[person[0][i]]; //1y
                position[1][0] += dy[person[1][i]]; //2x
                position[1][1] += dx[person[1][i]]; //2y
                turn();
            }
            int ans = aSum + bSum;
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
    static void turn(){
        ArrayList<Integer> list1 = new ArrayList<>();   //p1
        ArrayList<Integer> list2 = new ArrayList<>();   //p2

        for(int i = 0 ; i < M; i++){
            if(batteries[i].possible(position[0][0], position[0][1])){
                list1.add(i);
            }
            if(batteries[i].possible(position[1][0], position[1][1])){
                list2.add(i);
            }
        }
        //둘 다 영역에 없을떄
        if(list1.size() == 0 && list2.size() == 0) return;
        if(list1.size() == 0){  // b만 영역에 있을 떄
            int temp = 0;
            for(int i : list2){
                temp = Math.max(batteries[i].power, temp);
            }
            bSum += temp;
            return;
        }
        if(list2.size() == 0){  //a만 영역에 있을 떄
            int temp = 0;
            for(int i : list1){
                temp = Math.max(batteries[i].power, temp);
            }
            aSum += temp;
            return;
        }
        // 둘 다 영역에 있을 때 중복되는 곳을 찾아서 나눠줘야함
        int temp = 0;
        int a = 0;
        int b = 0;
        for(int i : list1){
            for(int j : list2){
                if(i == j){
                    if(batteries[i].power > temp){
                        temp = batteries[i].power;
                        a = temp / 2;
                        b = temp / 2;
                    }
                }
                else{//i,j가 다를 때
                    if(batteries[i].power + batteries[j].power > temp){
                        temp = batteries[i].power + batteries[j].power;
                        a = batteries[i].power;
                        b = batteries[j].power; 
                    }
                }
            }//end list1_for
        }//end list2_for
        
        aSum += a; bSum += b;
    }   
}
class Battery{
    int x, y, range, power;
    public Battery(int x, int y, int c, int power){
        this.x = x;
        this.y = y;
        this.range = c;
        this.power = power;
    }

    public boolean possible(int px, int py){
        if(Math.abs(x - px) + Math.abs(y - py) <= range) return true;
        return false;
    }

}