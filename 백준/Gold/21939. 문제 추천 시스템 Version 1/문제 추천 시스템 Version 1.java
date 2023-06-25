

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Problem> treeSet = new TreeSet<>();//트리셋 선언
        HashMap<Integer, Integer> problemCountMap = new HashMap<>();
        HashMap<Integer, Integer> problemValueMap = new HashMap<>();
        size = Integer.parseInt(br.readLine());
        for(int i=0;i<size;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index=Integer.parseInt(st.nextToken());
            int value=Integer.parseInt(st.nextToken());
            treeSet.add(new Problem(index, value));//값 넣어주기
            problemCountMap.put(index, problemCountMap.getOrDefault(index,0)+1);//수가 존재하는 저장할 map
            problemValueMap.put(index,value);//번호에 맞는 난이도 데이터 삽입
        }
        StringBuilder sb = new StringBuilder();
        int orderCount = Integer.parseInt(br.readLine());//명렁어 개수
        for(int i=0;i<orderCount;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order=st.nextToken();
            if(order.equals("add")){//add라면 데이터추가
                int index=Integer.parseInt(st.nextToken());
                int value=Integer.parseInt(st.nextToken());
                treeSet.add(new Problem(index, value));//값 넣어주기
                problemCountMap.put(index, problemCountMap.getOrDefault(index,0)+1);//수가 존재하는 저장할 map
                problemValueMap.put(index,value);//번호에 맞는 난이도 데이터 삽입
            }
            else if(order.equals("recommend")){
                int minOrMax = Integer.parseInt(st.nextToken());
                if(minOrMax==1){
                    while(true){
                        if(problemCountMap.containsKey(treeSet.last().index)&&
                                treeSet.last().value==problemValueMap.get(treeSet.last().index)){//수가 존재한다면
                            sb.append(treeSet.last().index+"\n");
                            break;}
                        else{
                            treeSet.pollLast();//수가 존재하지않으면 poll
                        }
                    }
                }
                else{


                    while(true){
                        if(problemCountMap.containsKey(treeSet.first().index)&&
                                treeSet.first().value==problemValueMap.get(treeSet.first().index)){//수가 존재한다면
                            sb.append(treeSet.first().index+"\n");
                            break;}
                        else{
                            treeSet.pollFirst();//수가 존재하지않으면 poll
                        }
                    }
                }

            }
            else{
                int index = Integer.parseInt(st.nextToken());
                problemCountMap.remove(index);//수 삭제
                problemValueMap.remove(index);
            }
        }
        System.out.print(sb);
    }
}
class Problem implements Comparable<Problem>{
    int index;
    int value;
    public Problem(int index,int value){
        this.index=index;
        this.value=value;
    }
    @Override
    public int compareTo(Problem p){//작은값이 제일 먼저 나오게 정렬
        if(p.value==this.value){
            return Integer.compare(this.index,p.index);
        }else return Integer.compare(this.value,p.value);
    }

}








