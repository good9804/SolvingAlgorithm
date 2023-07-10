
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;


class Main {
    static ArrayList<Integer>[] childList;
    static int nodeSize;
    static int[] parentList;
    static int[] heightList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int testCount = 0; testCount < testCase; testCount++) {
            nodeSize = Integer.parseInt(br.readLine());
            childList = new ArrayList[nodeSize + 1];
            makeChildList();
            parentList = new int[nodeSize + 1];
            heightList=new int[nodeSize+1];
            for (int i = 1; i < nodeSize; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                childList[parent].add(child);
                parentList[child] = parent;
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            int findFirst = Integer.parseInt(st.nextToken());
            int findSecond = Integer.parseInt(st.nextToken());
            int rootNode = 0;
            for (int i = 1; i <= nodeSize; i++) {
                if (parentList[i] == 0) {
                    rootNode = i;
                    break;
                }
            }
            findHeight(rootNode);
            while (true) {
                if(heightList[findFirst]==heightList[findSecond]){
                    int firstParent=parentList[findFirst];
                    int secondParent=parentList[findSecond];
                    if(firstParent==secondParent){
                        sb.append(firstParent+"\n");
                        break;
                    }
                    findFirst=firstParent;
                    findSecond=secondParent;
                }
                else if(heightList[findFirst]>heightList[findSecond]){
                    int firstParent=parentList[findFirst];
                    if(firstParent==findSecond){
                        sb.append(firstParent+"\n");
                        break;
                    }
                    findFirst=firstParent;
                }
                else{
                    int secondParent=parentList[findSecond];
                    if(secondParent==findFirst){
                        sb.append(secondParent+"\n");
                        break;
                    }
                    findSecond=secondParent;
                }

            }


        }
        System.out.print(sb);

    }
    static void makeChildList(){
        for(int i=1;i<=nodeSize;i++){
            childList[i] = new ArrayList<>();
        }
    }
    static void findHeight(int rootNode){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(rootNode);
        boolean[] isVisited = new boolean[nodeSize+1];
        isVisited[rootNode]=true;
        heightList[rootNode]=0;
        int height=0;
        while(!queue.isEmpty()){
            height++;
            int qsize= queue.size();
            for(int i=0;i<qsize;i++){
            int current=queue.poll();
            for(int child:childList[current]){
                if(!isVisited[child]){
                    isVisited[child]=true;
                    heightList[child]=height;
                    queue.add(child);
                }
            }
        }
    }
    }



}












