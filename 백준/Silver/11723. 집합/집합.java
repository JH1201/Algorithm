import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws Exception {
        
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        //int N = sc.nextInt();
        //sc.nextLine();
        int N = Integer.parseInt(br.readLine());
        
        int result = 0;
        
        //ArrayList<String> list = new ArrayList<>();
        //HashMap<String, Boolean> map = new HashMap<>();
        boolean[] set = new boolean[21];
        
        for(int i=0; i<N; i++) {
            String tmp = br.readLine();
            
            String command = "";
            String[] str = new String[2];
            int num = 0;
            
            if(tmp.equals("all") || tmp.equals("empty")) {
                if(tmp.equals("all")) command = "all";
                else command = "empty";
            }
            else {
                str = tmp.split(" ");
                command = str[0];
                num = Integer.valueOf(str[1]);
            }
            
            boolean idx;
            switch (command) {
                case "add" : 
                    set[num] = true;
                    break;
                case "remove" :
                    set[num] = false;
                    break;
                case "check" :
                    sb.append(set[num] ? 1 : 0).append('\n');
                    break;
                case "toggle" :
                    set[num] = !set[num];
                    break;
                case "all" : 
                    for(int j=1; j<=20; j++) {
                        set[j] = true;
                    }
                    break;
                case "empty" :
                    for(int j=1; j<=20; j++) {
                        set[j] = false;
                    }
                    break;
            }
            
        }
        System.out.print(sb);
       
    }
}