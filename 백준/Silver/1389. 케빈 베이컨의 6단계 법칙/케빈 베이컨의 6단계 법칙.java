import java.lang.*;
import java.util.*;
import java.io.*;

class Main{
    static boolean[][] peopleArr;
    static int[] allPeople=new int[10000];

    public static void main(String[] args) throws IOException{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        int people=Integer.parseInt(st.nextToken());
        int connection=Integer.parseInt(st.nextToken());
        allPeople=new int[people+1];
        peopleArr=new boolean[people+1][people+1];
        for(int i=0;i<connection;i++){
            st=new StringTokenizer(br.readLine()," ");
            int temp=Integer.parseInt(st.nextToken());
            int temp2=Integer.parseInt(st.nextToken());
            peopleArr[temp][temp2]=true;
            peopleArr[temp2][temp]=true;
        }
        int sum=0;

        Queue<Integer> q=new LinkedList<>();
        for(int j=1;j<=people;j++){
            ArrayList<Integer> friend=new ArrayList<Integer>();
            int count=1;
            q.clear();
            q.add(j);
            friend.add(j);
            while(!q.isEmpty()){
                int qsize=q.size();
                
                if(friend.size()==people){
                    break;
                }
                for(int a=0;a<qsize;a++){
                int current=q.poll();
                for(int k=1;k<=people;k++){
                    if(peopleArr[current][k]&&!friend.contains(k)){
                        q.add(k);
                        friend.add(k);
                        sum+=count;
                    }
                }

            }
                count++;
            }
            allPeople[j]=sum;
            sum=0;
        }
        int min=allPeople[1];
        int answer=1;
        for(int index=1;index<=people;index++){
            if(allPeople[index]<min){
                min=allPeople[index];
                answer=index;
            };
        }

        System.out.println(answer);
    }
}