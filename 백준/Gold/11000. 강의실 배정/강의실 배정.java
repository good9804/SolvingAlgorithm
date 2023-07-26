
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.List;


class Main{

    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        PriorityQueue<Booking> pq=new PriorityQueue<>();
        for(int i=0;i<size;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.add(new Booking(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        int answer=1;

        PriorityQueue<Integer> endPQ=new PriorityQueue<>();
        endPQ.add(pq.poll().end);
        while(!pq.isEmpty()){
            Booking currentBooking = pq.poll();
            if(endPQ.peek()<= currentBooking.start){
                endPQ.poll();
            }
            endPQ.add(currentBooking.end);
        }




        System.out.println(endPQ.size());

}}

class Booking implements Comparable<Booking>{
    int start;
    int end;
    public Booking(int start,int end){
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Booking b){
        if(this.start==b.start){
            return this.end-b.end;
        }else return this.start-b.start;
    }

}


