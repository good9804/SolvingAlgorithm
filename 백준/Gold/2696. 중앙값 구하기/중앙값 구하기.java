

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static ArrayList<Integer> arrayList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());
        StringBuilder answer=new StringBuilder();
        for(int i=0;i<testCount;i++){
            int orderCount = Integer.parseInt(br.readLine());
            StringBuilder sb=new StringBuilder();
            arrayList.clear();
            int centerCount=0;
            for(int index=0;index<(orderCount/10)+1;index++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                    int j=0;
                    while (st.hasMoreTokens()){
                        j++;
                        if(j%2==1){//홀수번째일때
                            binaryinsert(Integer.parseInt(st.nextToken()));
                            centerCount++;
                            if(centerCount%10==0){
                                sb.append(arrayList.get(arrayList.size()/2)+"\n");
                            }else{
                                sb.append(arrayList.get(arrayList.size()/2)+" ");
                            }
                        }else{
                            binaryinsert(Integer.parseInt(st.nextToken()));
                        }
                    }

            }
            if(sb.charAt(sb.length()-1)==' '){
                answer.append(centerCount+"\n"+sb+"\n");
            }
            else{answer.append(centerCount+"\n"+sb);}
            }

        System.out.print(answer);
        }
    static void binaryinsert(int number){
        int first=0;
        if(arrayList.isEmpty()){
            arrayList.add(number);
            return;
        }
        int last=arrayList.size()-1;
        while(first<=last){
            int mid=(first+last)/2;
            if(arrayList.get(mid)>number){
                last=mid-1;
            }
            else if(arrayList.get(mid)<number){
                first=mid+1;
            }
            else{
                arrayList.add(mid,number);
                return;
            }

        }
        arrayList.add(first,number);
    }
}









