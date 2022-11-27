import java.util.*;
import java.lang.*;
import java.io.*;
class Main{ 
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int testCount=Integer.parseInt(br.readLine());
        for(int i=0;i<testCount;i++){
            StringBuilder sb=new StringBuilder();
            boolean error=false;
            boolean reverse=false;
            String[] order=br.readLine().split("");
            String size=br.readLine();
            Deque<String> arr=new ArrayDeque<>();
            String[] str=br.readLine().split(",|\\[|\\]");

            for(int j=0;j<str.length;j++){
                if(!str[j].equals("")){
                    arr.add(str[j]);
                }
            }
            for(int k=0;k<order.length;k++){
                if(order[k].equals("R")){
                    reverse=!reverse;
                }
                else{
                    if(arr.isEmpty()){
                        error=true;
                        System.out.println("error");
                        break;
                    }
                   else {
                       if(reverse){
                       arr.pollLast();}
                       else{
                           arr.pollFirst();
                       }
                    }
                }
            }
            if(error){
                continue;
            }
            else {
                if(arr.isEmpty()){
                    System.out.println("[]");
                    continue;
                }
                if(reverse){
                    Iterator<String> itr=arr.descendingIterator();
                sb.append("[").append(itr.next());
                while(itr.hasNext()){
                    sb.append(",").append(itr.next());}

                sb.append("]");}
                else{
                    Iterator<String> itr=arr.iterator();
                    sb.append("[").append(itr.next());
                    while (itr.hasNext()){
                        sb.append(",").append(itr.next());
                    }
                    sb.append("]");

                }
                System.out.println(sb);
            }

        }
    }}