
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow {
    public static int[] traverse(int[] arr, int win){
        if(arr.length==0) return new int[0];
        int size = arr.length, index = 0;
        int[] res = new int[size-win+1];
        Deque<Integer> dq = new LinkedList<>();
        while(index<size){
            while(!dq.isEmpty()&&dq.peekFirst()<=index-win)
                dq.pollFirst();
            while(!dq.isEmpty()&&arr[dq.peekLast()]<arr[index])
                dq.pollLast();
            dq.offer(index);
            if(index>=win-1) res[index-win+1]=arr[dq.peekFirst()];
            index++;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int[] got = traverse(arr, 3);
        System.out.println(Arrays.toString(got));
    }
}