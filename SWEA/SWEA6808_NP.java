package SWEA_JAVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class SWEA6808_NP {
 
    static int T, win, lose, N = 9;
    static int[] input = new int[19];
    static int[] guCard = new int[9];
    static int[] inCard = new int[9];
 
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
 
        for (int t = 1; t <= T; t++) {
            // 초기화
            win = 0;
            lose = 0;
            Arrays.fill(input, 0);
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            // 규영이의 카드
            int num = 0;
            for (int i = 0; i < 9; i++) {
                num = Integer.parseInt(st.nextToken());
                guCard[i] = num;
                input[num] = 1;
            }
            // 인영이의 카드
            int srcIdx = 0;
            for (int i = 1; i <= 18; i++) {
                if (input[i] != 0)
                    continue;
                inCard[srcIdx++] = i;
            }
            while(true) {
                // 순열의 각각의 경우
                check();
                if(!np()) break;
                 
            }
            System.out.println("#" + t + " " + win + " " + lose);
             
        }
 
    }
 
    static boolean np() {
         
        int[] src = inCard;
         
        int i = src.length - 1;
        while(i > 0 && src[i-1] >= src[i]) --i;
         
        if(i == 0) return false; // 완전 끝
         
        int j = src.length - 1;
        while(src[i-1] >= src[j]) --j;
         
        swap(src, i-1, j);
         
        int k = src.length - 1;
        while(i < k) {
            swap(src, i++, k--);
        }
        return true;
    }
 
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void check() {
        int guSum = 0;
        int inSum = 0;
        for (int i = 0; i < 9; i++) {
            if (guCard[i] > inCard[i]) {
                guSum = guSum + inCard[i] + guCard[i];
            } else {
                inSum = inSum + inCard[i] + guCard[i];
            }
        }
        if (guSum > inSum)
            win++;
        else if (guSum < inSum)
            lose++;
    }
 
}