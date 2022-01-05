public class ElementInRowAndColumnSortedMatrix {

    public static int[] findElement(int[][] arr, int x) {
        int row = arr.length;
        if (row == 0) {
            return new int[]{-1, -1};
            //add exception or return -1
        }
        int col = arr[0].length;

        int rowPtr = 0;
        int colPtr = col - 1;

        while (rowPtr < row && colPtr > 0) //maintain we are inside the range
        {
            int curr = arr[rowPtr][colPtr];
            if (curr == x) {
                return new int[]{rowPtr, colPtr};
            } else if (curr > x) {
                colPtr--;
            } else if (curr < x) {
                rowPtr++;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int arr[][] = new int[][]{
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};
        int[] element = ElementInRowAndColumnSortedMatrix.findElement(arr, 100);
        System.out.println(element[0]);
        System.out.println(element[1]);
    }
}
