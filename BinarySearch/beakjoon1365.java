package BinarySearch;
import java.io.*;
import java.util.*;

public class beakjoon1365 {
    static ArrayList<Integer> l1 = new ArrayList<>();
    static ArrayList<Integer> l2 = new ArrayList<>();
    static void culc_l1(int n){
        if(n > l1.get(l1.size()-1)){
            l1.add(n);
            return;
        }
        int left = 0;
        int right = l1.size()-1;
        while(left < right){
            int mid = (left + right) >> 1;
            if(l1.get(mid) >= n){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        l1.set(right, n);
    }
    static void culc_l2(int n){
        if(n > l2.get(l2.size()-1)){
            l2.add(n);
            return;
        }
        int left = 0;
        int right = l2.size()-1;
        while(left < right){
            int mid = (left + right) >> 1;
            if(l2.get(mid) >= n){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        l2.set(right, n);
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        int[] val = new int[N+1];
        int[] val_reverse = new int[N+1];

        l1.add(Integer.MIN_VALUE);
        l2.add(Integer.MIN_VALUE);

        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= N; i++){
            int a = Integer.parseInt(st.nextToken());
            val[i] = a;
            val_reverse[a] = i;

            culc_l1(a);
            
        }
        for(int i = 1 ; i <= N; i++){
            culc_l2(val_reverse[i]);
        }
        int max_ = Math.max(l1.size(), l2.size());

        System.out.println(N - (max_-1));


        
    }
}
