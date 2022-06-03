/**
 * https://www.educative.io/module/lesson/data-structures-in-java/mEGjlJw2O4O
 * @author yanliu
 * @create 2022-06-03-12:03 AM
 */
public class RearrangeSortedArrayInMaxMinForm {
    public void maxMin(int[] arr) {
        int maxIdx = arr.length - 1;
        int minIdx = 0;
        int maxElem = arr[maxIdx] + 1; // store any element that is greater than the maximum element in the array
        for( int i = 0; i < arr.length; i++) {
            // at even indices we will store maximum elements
            if (i % 2 == 0){
                arr[i] = arr[i] + (arr[maxIdx] % maxElem ) * maxElem;
                maxIdx -= 1;
            }
            else { // at odd indices we will store minimum elements
                arr[i] = arr[i] + (arr[minIdx] % maxElem ) * maxElem;
                minIdx += 1;
            }
        }
        // dividing with maxElem to get original values.
        for( int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / maxElem;
        }
    }

}
