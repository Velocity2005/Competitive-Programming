import java.util.*;
import java.io.*;

public class RoundTrip {

    static Node empty = new Node(-1);

    public static class Node{
        int id;
        Node prevNode;
        ArrayList<Node> adj;
        boolean visited;
        public Node(int idd){
            id = idd;
            adj = new ArrayList<>();
            visited = false;
            prevNode = empty;
        }
        public String toString(){
            return ""+id;
        }
    }

    static boolean found = false;


    public static void dfs(Node n){
        n.visited = true;
        for(Node x : n.adj){
            if(n.prevNode.id != x.id && !found){
                if(!x.visited) {
                    x.prevNode = n;
                    dfs(x);
                    x.prevNode = empty;
                }else {
                    found = true;
                    start = x;
                    cycle.add(start);
                    backtrack(n);
                }
            }

        }


    }

    static Node start;
    static ArrayList<Node> cycle;
    public static void backtrack(Node n){

        cycle.add(n);
        if(n.id == start.id)
            return;
        backtrack(n.prevNode);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter pw = new PrintWriter(System.out);

        st = new StringTokenizer(br.readLine());
        int cities = Integer.parseInt(st.nextToken());
        int roads = Integer.parseInt(st.nextToken());
        ArrayList<Node> graph = new ArrayList<>();
        for(int i = 0; i < cities+1;i++)
            graph.add(new Node(i));

        for(int i = 0; i < roads;i++){
            st = new StringTokenizer(br.readLine());
            Node beg = graph.get(Integer.parseInt(st.nextToken()));
            Node end = graph.get(Integer.parseInt(st.nextToken()));
            beg.adj.add(end);
            end.adj.add(beg);
        }


        for(int i = 1; i < graph.size();i++){

            if(!graph.get(i).visited){
                cycle = new ArrayList<>();
                dfs(graph.get(i));
                if(found)
                    break;
            }


        }

        if(cycle.size() == 0){
            pw.print("IMPOSSIBLE");
        }else{
            pw.println(cycle.size());
            for(Node n : cycle){
                pw.print(n.id+" ");
            }
        }








        pw.close();
    }
}
