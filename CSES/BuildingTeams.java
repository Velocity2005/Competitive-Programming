import java.util.*;
import java.io.*;

public class BuildingTeams {

    public static class Node{
        int id;
        ArrayList<Node> adj;
        int color;
        boolean visited;
        public Node(int idd){
            id = idd;
            adj = new ArrayList<>();
            visited = false;
        }
    }

    public static boolean dfs(Node n,int color,boolean pos){
        n.visited = true;
        n.color = color;

        for(Node x : n.adj){
            if(!x.visited){
                if(color == 1)
                    pos = dfs(x,2,true);
                else
                    pos = dfs(x,1,true);
            }else if(x != n && x.color == n.color){
                return false;
            }
        }

        return pos;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter pw = new PrintWriter(System.out);

        st = new StringTokenizer(br.readLine());
        int nodes = Integer.parseInt(st.nextToken());
        int edges = Integer.parseInt(st.nextToken());
        ArrayList<Node> graph = new ArrayList<Node>();
        for(int i = 0; i < nodes+1;i++)
            graph.add(new Node(i));

        for(int i = 0;i < edges;i++){
            st = new StringTokenizer(br.readLine());
            Node beg = graph.get(Integer.parseInt(st.nextToken()));
            Node end = graph.get(Integer.parseInt(st.nextToken()));

            beg.adj.add(end);
            end.adj.add(beg);

        }
        boolean pos = true;
        for(int i = 1; i < graph.size();i++)
            if(!graph.get(i).visited)
                pos = dfs(graph.get(i),1,true);


        if(pos){
            for(int i = 1; i < graph.size();i++)
                pw.print(graph.get(i).color+" ");
        }else{
            pw.print("IMPOSSIBLE");
        }



        pw.close();
    }
}
