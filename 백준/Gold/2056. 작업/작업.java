
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

class Main {




    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] workCount=new int[N+1];//선행되어야하는 작업의 개수
        int[] costList=new int[N+1];//각 작업의 소요시간
         ArrayList<Integer>[] worklist=new ArrayList[N+1];//i를 선행으로 여기는  작업 리스트
        for(int i=1;i<=N;i++){
            worklist[i]=new ArrayList();
        }
        Queue<Integer> workingQ=new LinkedList<>();
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            int costTime = Integer.parseInt(st.nextToken());
            costList[i]=costTime;
            int list = Integer.parseInt(st.nextToken());
            workCount[i]=list;
            if(list>0){
                while(list-->0){
                    int workid = Integer.parseInt(st.nextToken());
                    worklist[workid].add(i);//workid를 선행으로하기에 worklist의 workid에 i추가
                }
            }
            else{
                workingQ.add(i);
            }





        }
        int time=0;
        while(!workingQ.isEmpty()){
            time++;
            int qsize=workingQ.size();
            for(int i=0;i<qsize;i++){
                int work=workingQ.poll();
                costList[work]--;//소요시간 --
                if(costList[work]==0){//일이끝나면
                    for(int next:worklist[work]){//work를 선행으로 했던 작업 순회
                        workCount[next]--;//next의 선행작업개수 -1 (선행작업 하나가 끝났으므로)
                        if(workCount[next]==0){//next의 선행작업개수가 아무것도없다면
                            workingQ.add(next);//일 Q추가 
                        }

                    }
                }else workingQ.add(work);//소요시간이 남았다면 즉 일이 안끝났으면 다시 일 Q에 추가
            }

        }
        System.out.println(time);















    }









}






