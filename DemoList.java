import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DemoList{
    public static void main(String[] args){
        LinkedList buffer=new LinkedList();
        buffer.add("Arhan");
        buffer.add(12);buffer.add(false);
        buffer.add(5.9);buffer.add('R');
        Queue<String> store=new PriorityQueue<>((a,b)->b.compareTo(a));
        store.offer("Spring boot");
        store.offer("Django");
        System.out.println(store);
        Iterator it=buffer.iterator();
        while(it.hasNext())
            System.out.println(it.next());
    }
}