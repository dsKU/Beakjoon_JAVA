package implemented;
import java.io.*;
import java.util.*;

public class beajoon2116 {
    static int[][] dice;
    static int[][] maxNum;
    static int N,M;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());
        dice = new int[N][7];
        maxNum = new int[N][7];
        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());

            dice[i][a] = f; dice[i][b] = d;     //각 숫자마다 반대편을 저장함
            dice[i][c] = e; dice[i][d] = b;
            dice[i][e] = c; dice[i][f] = a;

            for(int j = 1 ; j <= 6; j++){   //옆면은 돌려도 상관없으니까 각 면마다 최대값을 구함
                if(dice[i][j] == 6 || dice[i][dice[i][j]] == 6)
                    if(dice[i][j] == 5 || dice[i][dice[i][j]] == 5)
                        maxNum[i][j] = maxNum[i][dice[i][j]] = 4;
                    else
                        maxNum[i][j] = maxNum[i][dice[i][j]] = 5;
                else
                    maxNum[i][j] = maxNum[i][dice[i][j]] = 6;

            }
            
        }

        int ans = 0;
        for(int i = 1 ; i <= 6; i++){   //1번 주사위의 윗면 기준
            int temp = maxNum[0][i];    //합
            int top = dice[0][i];       //윗면
            int idx = 1;          
            while(idx < N){
                temp += maxNum[idx][top];   //다음 주사위의 최대값
                top = dice[idx][top];       //다음 주사위의 윗면
                idx++;
            }
            //System.out.println(temp);
            ans = Math.max(ans, temp);
        }
        System.out.println(ans);
    }
}
