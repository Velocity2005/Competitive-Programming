import java.util.*;
import java.io.*;

public class Round811Div3A {
    public static class time implements Comparable<time>{
        int h;
        int m;
        public time(int hour, int min){
            h = hour;
            m = min;
        }

        public int compareTo(time o){
            if(h == o.h){
                return Integer.compare(m,o.m);
            }
            return Integer.compare(h,o.h);

        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter pw = new PrintWriter(System.out);


        int c = Integer.parseInt(br.readLine());
        while(c-- > 0){
            st = new StringTokenizer(br.readLine());
            int alarms = Integer.parseInt(st.nextToken());
            time bed = new time(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            ArrayList<time> a = new ArrayList<>();
            for(int i = 0; i < alarms;i++){
                st = new StringTokenizer(br.readLine());
                a.add(new time(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
            }

            Collections.sort(a);
            time wake = a.get(0);
            //pw.println(a.get(1).h+" "+a.get(1).m);
            for(int i = 0; i < a.size();i++){
                time temp = a.get(i);
                if(temp.h == bed.h && bed.m <= temp.m){
                    wake = temp;
                    break;
                }
                else if(temp.h > bed.h){
                    wake = temp;
                    break;
                }
            }


            int hour = wake.h-bed.h;
            int min = wake.m-bed.m;

            if(min < 0){
                hour--;
                min = 60+min;
            }

            if(hour < 0){
                hour = 24+hour;
            }



            //pw.println(bed.h+" "+bed.m+" "+wake.h+" "+wake.m);



            pw.println(hour+" "+min);


        }


        pw.close();
    }
}
