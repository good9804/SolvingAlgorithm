

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());//Test 횟수
        StringBuilder sb = new StringBuilder();//정답
        for(int i=0;i<testCount;i++){
            PriorityQueue<Integer> maxpriorityQueue = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minpriorityQueue=new PriorityQueue<>();
            HashMap<Integer,Integer> HashMap=new HashMap<>();//수의 개수를 저장할 hashmap
            int operationCount = Integer.parseInt(br.readLine());//연산 횟수

            for(int j=0;j<operationCount;j++){
                StringTokenizer st=new StringTokenizer(br.readLine());
                String operation = st.nextToken();//연산 종류 (넣거나 빼거나)
                if(operation.equals("D")){
                    int minOrMax = Integer.parseInt(st.nextToken());
                    if(minOrMax==1){//최대값 제거라면
                        if(maxpriorityQueue.isEmpty()){
                            continue;
                        }
                        else{
                            while(!maxpriorityQueue.isEmpty()){
                                int number=maxpriorityQueue.peek();
                                if(HashMap.containsKey(number)){
                                    maxpriorityQueue.poll();
                                    HashMap.put(number,HashMap.get(number)-1);
                                    if(HashMap.get(number)==0){
                                        HashMap.remove(number);
                                    }
                                    break;
                                }else{
                                    maxpriorityQueue.poll();
                                }
                            }
                        }
                    }
                    else{
                        if(minpriorityQueue.isEmpty()){
                            continue;
                        }
                        else{
                            while(!minpriorityQueue.isEmpty()){
                                int number=minpriorityQueue.peek();
                                if(HashMap.containsKey(number)){
                                    minpriorityQueue.poll();
                                    HashMap.put(number,HashMap.get(number)-1);
                                    if(HashMap.get(number)==0){
                                        HashMap.remove(number);
                                    }
                                    break;
                                }else{
                                    minpriorityQueue.poll();
                                }
                        }
                        }

                    }
                }
                else{
                    int number = Integer.parseInt(st.nextToken());
                    maxpriorityQueue.add(number);
                    minpriorityQueue.add(number);
                    HashMap.put(number, HashMap.getOrDefault(number,0)+1);
                }

                }
                if(HashMap.isEmpty()|| minpriorityQueue.isEmpty()|| maxpriorityQueue.isEmpty()){
                    sb.append("EMPTY\n");
                }else{
                    while(!maxpriorityQueue.isEmpty()){
                        if(HashMap.containsKey(maxpriorityQueue.peek())){
                        break;}else maxpriorityQueue.poll();
                    }
                    while(!minpriorityQueue.isEmpty()){
                        if(HashMap.containsKey(minpriorityQueue.peek())){
                            break;}else minpriorityQueue.poll();
                    }

                    sb.append(maxpriorityQueue.poll()+" "+minpriorityQueue.poll()+"\n");
                    }
                }

        System.out.print(sb);
            }
        }








