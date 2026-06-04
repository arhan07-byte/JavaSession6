public class Lcs {
    public static int findSeq(String src,String dest){
        int rSize = src.length();
        int cSize = dest.length();
        int[][] grid = new int[rSize+1][cSize+1];
        for(int row=1;row<=rSize;row++){
            for(int col=1;col<=cSize;col++){
                if(src.charAt(row-1)==dest.charAt(col-1))
                    grid[row][col] = grid[row-1][col-1]+1;
                else
                    grid[row][col]=Math.max(
                grid[row-1][col],grid[row][col-1]);
            }
        }
        return grid[rSize][cSize];
    }
    public static void main(String[] args) {
        String text1="abcde", text2="ace";
        System.out.println(findSeq(text1, text2));
    }
}