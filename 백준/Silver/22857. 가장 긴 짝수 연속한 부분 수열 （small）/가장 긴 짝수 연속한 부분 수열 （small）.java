
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;


class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr=new int[N];
        ArrayList<Integer> list=new ArrayList<>();
        int count=0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            if(arr[i]%2==0){
                count++;
            }
            else{
                if(count>0){
                list.add(count);}
                list.add(0);
                count=0;
            }

        }
        if(count>0){list.add(count);}
        int answer=0;
        for(int i=0;i<list.size();i++){
            int hap=0;
            int j=i;
            int kCount=0;
            while(true){

                if(j<list.size()){
                    if(kCount>K){break;}
                    if(list.get(j)==0){
                        kCount++;
                    }
                else{hap+=list.get(j);}
                }else{break;}
                j++;
            }
            answer=Math.max(hap,answer);
        }

        System.out.println(answer);

    }
    class Node{
        int oddCount;
        int evenCont;
        public Node(int oddCount,int evenCont){
            this.oddCount=oddCount;
            this.evenCont=evenCont;
        }
    }




}