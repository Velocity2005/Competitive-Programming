import java.util.*;
import java.io.*;

public class Round811Div3B {
    public static boolean check(int[] a){
        for(int i = 0; i < a.length;i++){
            if(a[i] > 1)
                return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter pw = new PrintWriter(System.out);

        int c = Integer.parseInt(br.readLine());
        while(c-->0){
            int num = Integer.parseInt(br.readLine());
            int[] freq = new int[num+1];
            int[] arr = new int[num];
            st = new StringTokenizer(br.readLine());
            int repeatC = 0;
            for(int i = 0; i < num;i++) {
                int x = Integer.parseInt(st.nextToken());
                arr[i] = x;
                freq[x]++;
                if(freq[x] > 1)
                    repeatC++;
            }
            //pw.println(Arrays.toString(freq)+" "+repeatC);

            int count = 0;
            if(repeatC == 0){
                pw.println(count);
            }else{
                for(int i = 0; i < arr.length;i++){
                    int rem = arr[i];
                    if(freq[rem] > 1)
                        repeatC--;
                    freq[rem]-=1;

                    count++;
                    if(repeatC == 0){
                        pw.println(count);
                        break;
                    }
                }
            }


        }


        pw.close();
    }
}
