package implemented;
import java.io.*;
import java.util.*;
public class beakjoon13335 {
    static int N,M, K;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());//다리길이
        K = Integer.parseInt(st.nextToken());//최대하중
        int arr[] = new int [N+1];


        int time = 0;
        int qSum = 0;
        Queue<Node13335> q = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());

            time++;
            if(!q.isEmpty()){
                if(q.peek().time + M == time){
                    qSum -= arr[q.poll().idx];
                }
                if(qSum + arr[i] > K){
                    while(qSum + arr[i] > K){
                        Node13335 n = q.poll();
                        time = n.time + M;
                        qSum-= arr[n.idx];
                        
                   }
                   
                }
               
            }
            q.add(new Node13335(i,time));
            qSum += arr[i];            
            
        }

        while(! q.isEmpty()){
            time = q.poll().time + M;
        }
        
        System.out.println(time);
    }
}
class Node13335{
    int idx;
    int time;
    public Node13335(int a, int b){
        idx = a;
        time = b;
    }
}