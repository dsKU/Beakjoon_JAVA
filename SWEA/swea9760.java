import java.io.*;
import java.util.*;
public class swea9760 {
    static int getColor(char ch){
        switch (ch) {
            case 'S': return 0;
            case 'D': return 1;
            case 'H': return 2;
            case 'C': return 3;
        }
        return -1;
    }
    static int getNum(char ch){
        if(ch >= '2' && ch <= '9') return ch - '0';
        else{
            switch (ch) {
                case 'A': return 1;
                case 'T': return 10;
                case 'J': return 11;
                case 'Q': return 12;
                case 'K': return 13;
            }
            return -1;
        }
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] color = new int[4];
        int[] number = new int[14];
        for(int t= 1; t <= T; t++){
            sb.append("#").append(t).append(" ");
            Arrays.fill(color, 0);
            Arrays.fill(number, 0);

            int max = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 5; i++) {
                String str = st.nextToken();
                int c = getColor(str.charAt(0));
                int n = getNum(str.charAt(1));
            
                color[c]++;
                number[n]++;
                max = Math.max(max, number[n]);
            }

            if(max == 4){   //포카드
                sb.append("Four of a Kind");   
            }
            else if(max == 3){   //풀하우스와 트리플
                boolean flag = false;
                for (int i = 1; i < 14; i++) {
                    if(number[i] == 2){
                        flag = true;
                        break;
                    } 
                }
                if(flag){
                    sb.append("Full House");
                }
                else{
                    sb.append("Three of a kind");
                }
            }
            else if(max == 2){   //투페어와 원페어
                int cnt = 0;
                for (int i = 1; i < 14; i++) {
                    if(number[i] == 2){
                        cnt++;
                    } 
                }
                if(cnt == 2){
                    sb.append("Two pair");
                    //two 
                }
                else{
                    sb.append("One pair");
                    //one
                }
            }
            else{
                boolean flag = false;
                int cnt = 0;
                for (int i = 1; i < 18; i++) {
                    int idx = i % 13 + 1;
                    if(cnt == 5) break;
                    if(number[idx] == 1){
                        cnt++;
                    } 
                    else{
                        cnt = 0;
                    }
                }
                for (int i = 0; i < 4; i++) {
                    if(color[i] == 5){
                        flag = true;
                        break;
                    } 
                }
                if(flag){   // 플러쉬, 스트레이트 플러쉬
                    if( cnt == 5 ) sb.append("Straight Flush");
                    else sb.append("Flush");
                }
                else{   //스트레이트와 탑
                    if( cnt == 5 ) sb.append("Straight");
                    else  sb.append("High card");
                }
            }


            
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
