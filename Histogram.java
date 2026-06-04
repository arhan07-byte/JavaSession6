import java.util.Stack;

public class Histogram {
    public static int maxArea(int[] chart){
        int mArea = Integer.MIN_VALUE, temp=0;
        Stack<Integer> stk = new Stack<>();
        for(int index=0;index<=chart.length;index++){
            int cValue = (index==chart.length)?0:chart[index];
            while(!stk.isEmpty()&&cValue<chart[stk.peek()]){
                int len = chart[stk.pop()];
                int brd = stk.isEmpty()?
                        index:index-stk.peek()-1;
                temp=len*brd;
                mArea = Math.max(temp, mArea);
            }
            stk.push(index);
        }
        return mArea;
    }
public static void main(String[] args) {
        // int[] chart = {2,1,5,6,2,3};
        int[] chart = {2,4};
        System.out.println(maxArea(chart));
    }
}