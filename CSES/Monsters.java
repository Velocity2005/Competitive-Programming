import java.util.*;
import java.io.*;

public class Monsters {
    public static class Node{
        int r;
        int c;
        public Node(int rr,int cc){
            r = rr;
            c = cc;
        }
    }

    static char[][] grid;
    static char[][] dynamicGrid;
    static boolean[][] visited;
    static char[][] dir;
    static ArrayList<Node> monsters = new ArrayList<>();
    static int[] r = {1,-1,0,0};
    static int[] c = {0,0,1,-1};
    static char[] direct = {'D','U','R','L'};
    public static void dfs(Node n){
        visited[n.r][n.c] = true;
        dynamicGrid[n.r][n.c] = 'A';
        for(int i = 0; i < 4;i++){
            Node x = new Node(n.r+r[i],n.c+c[i]);
            if(x.r >= 0 && x.r < grid.length && x.c >= 0 && x.c < grid[0].length && !visited[x.r][x.c] && grid[x.r][x.c] != '#' && dynamicGrid[x.r][x.c] != 'M'){
                for(int j = 0; j < grid.length;j++)
                    System.out.println(Arrays.toString(dynamicGrid[j]));
                dynamicGrid[n.r][n.c] = '.';
                dir[x.r][x.c] = direct[i];

                dfs(x);

            }


        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter pw = new PrintWriter(System.out);

        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        grid = new char[h][w];
        dynamicGrid = new char[h][w];
        visited = new boolean[h][w];
        dir = new char[h][w];
        for(int i = 0; i < h;i++)
            grid[i] = br.readLine().toCharArray();

        Node A = new Node(0,0);

        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length;j++){
                if(grid[i][j] == 'A')
                    A = new Node(i,j);
                if(grid[i][j] == 'M')
                    monsters.add(new Node(i,j));
                if(grid[i][j] == '.' && ((i == 0 || i == h-1) || (j == 0 || j == w-1))){
                    grid[i][j] = 'E';
                }

                dynamicGrid[i][j] = grid[i][j];
            }
        }



        dfs(A);







        pw.close();
    }
}
