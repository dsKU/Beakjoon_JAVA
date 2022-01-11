package Graph;
import java.io.*;
import java.util.*;

public class beakjoon1753 {
    static int V;
    static int E;
    static int start;
    static int[] min_;
    static ArrayList<Node>[] arr;

    static void Dijkstra(){
        PriorityQueue<Node> pQ = new PriorityQueue<>();

        pQ.offer(new Node(start,0));

        while(!pQ.isEmpty()){
            Node node = pQ.poll();
            if(min_[node.a] < node.b) continue;

            for(Node n : arr[node.a]){
                if(min_[n.a] > min_[node.a]+n.b){
                    min_[n.a] = min_[node.a]+n.b;
                    pQ.offer(new Node(n.a, min_[n.a]));
                }
                
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        E = sc.nextInt();
        start = sc.nextInt();
        
        min_ = new int[V+1];
        arr = new ArrayList[V+1];

        for(int i = 1 ; i <= V; i++){
            min_[i] = 200001;
            arr[i] = new ArrayList<>();
        }
        min_[start] = 0;

        for(int i = 0; i < E; i++){
            int a = sc.nextInt();
            int b = sc.nextInt(); 
            int c = sc.nextInt();
            
            arr[a].add(new Node(b,c));
        }

        Dijkstra();

        for(int i = 1; i <=V;i++){
            if(min_[i] >= 200001)
                System.out.println("INF");
            else
                System.out.println(min_[i]);
        }
        sc.close();
    }
}

class Node implements Comparable<Node>{
    int a;
    int b;
    Node(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Node o) {
        return this.b - o.b;
    }
}