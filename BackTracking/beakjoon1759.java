package BackTracking;
import java.util.Arrays;
import java.util.Scanner;

public class beakjoon1759 {
    static Boolean[] alpha;
    static char[] arr;
    static char[] str;
    static int L;
    static int N;
    static StringBuilder sb;

    public static void DFS(int depth, int idx, int C, int V){
        if(depth == L){
            if(C >= 2 && V >= 1){
                for(int i = 0 ; i < L; i ++){
                    sb.append(str[i]);
                }
                sb.append("\n");
            }
            return;
        }
        
        for(int i = idx ; i < N ; i ++){
            str[depth] = arr[i];
            if(alpha[i]){   //모음일때
                DFS(depth+1, i + 1, C, V + 1);
            }
            else{
                DFS(depth+1, i + 1, C + 1, V);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        L = sc.nextInt();
        N = sc.nextInt();
        alpha = new Boolean[26];
        arr = new char[N+1];
        str = new char[L];
        sc.nextLine();
        
        String str = sc.nextLine();
        String[] sp = str.split(" ");

        Arrays.sort(sp);
        Arrays.fill(alpha,false);
        
        for(int i = 0 ; i < sp.length; i ++){
            arr[i] = sp[i].charAt(0);
            if(arr[i] == 'a' || arr[i] == 'e'|| arr[i] == 'i'|| arr[i] == 'o'|| arr[i] == 'u'){
                alpha[i] = true;
            }
        }

        DFS(0,0,0,0);

        System.out.print(sb);
        sc.close(); 
    }
}
