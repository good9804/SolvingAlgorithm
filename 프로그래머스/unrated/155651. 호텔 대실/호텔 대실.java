import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        ArrayList<ArrayList<Book>> hotel=new ArrayList<>();
        PriorityQueue<Book> books=new PriorityQueue<>();
        for(int i=0;i<book_time.length;i++){
            books.add(new Book(changeRealTime(changeTime(book_time[i][0])),changeRealTime(changeTime(book_time[i][1])+10)));    
        }
        hotel.add(new ArrayList<Book>() {{ add(books.poll()); }});
        while(!books.isEmpty()){
            Book currentB=books.poll();
            boolean find=false;
            for(int i=0;i<hotel.size();i++){
                ArrayList<Book> bookTime=hotel.get(i);
                int loopLength=bookTime.size();
                for(int j=0;j<loopLength;j++){
                    Book b=bookTime.get(j);
                    if(b.end<=currentB.start){
                        if(j<loopLength-1&&bookTime.get(j+1).start>=currentB.end){//중간에 낑겨 들어갈 자리 찾았을때
                        find=true;
                            bookTime.add(j+1,currentB);
                            break;
                        }else if(j==loopLength-1){
                            find=true;
                            bookTime.add(currentB);
                            break;
                        }else{
                            continue;
                        }
                    }else if(j==0&&currentB.end<=b.start){
                        find=true;
                        bookTime.add(0,currentB);
                        break;
                    }
                }
                if(find){break;}
            }
                if(!find){
                    
                    hotel.add(new ArrayList<Book>() {{ add(currentB); }});
                }
            
        }
        return hotel.size();
    }
    static int changeRealTime(int time){
        int temp=((time/100)*60+time%100);
        return temp/60*100+temp%60;
    }
    static int changeTime(String time){
        return Integer.parseInt(Arrays.stream(time.split(":")).reduce("",(part,str)->part+str));
    }
}
class Book implements Comparable<Book>{
    int start;
    int end;
    public Book(int start,int end){
        this.start=start;
        this.end=end;
    }
    @Override
    public int compareTo(Book b){
        if(this.start==b.start){
            return this.end-b.end;
        }
        else return this.start-b.start;
    }
    
}