import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int answer = 1;
            int count = 0;
            int maxcount = 0;
            Queue<Print> queue = new LinkedList<>();
            int case1[] = new int[2];
            int max = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int k = 0; k < 2; k++) {
                case1[k] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < case1[0]; j++) {
                Print print = new Print(j, Integer.parseInt(st.nextToken()));
                queue.offer(print);
            }
            int maxbag[] = new int[case1[0]];
            while (!queue.isEmpty()) {
                Print print = queue.poll();
                int value = print.getValue();
                int index = print.getIndex();
                boolean flag = true;
                Iterator it= queue.iterator();
                while(it.hasNext()){
                    Print nextvalue = (Print) it.next();
                    if(value<nextvalue.getValue()){
                        flag=false;
                        break;
                    }
                }
                if(flag==false){
                    queue.add(print);
                }else{
                    if(index==case1[1]){
                        System.out.println(answer);
                    }else answer++;
                }
                }

            }
        }

    }
class Print{
    int index;
    int value;
    public Print(int index, int value){
        this.index=index;
        this.value=value;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getIndex() {
        return index;
    }
    public int getValue() {
        return value;
    }
    }