import java.util.Arrays;

/**
 * LeetCode1710
 * @author yanliu
 * @create 2022-05-16-5:19 PM
 */
public class MaximumUnitsOnATruck {
    class Solution1 {
        public int maximumUnits(int[][] boxTypes, int truckSize) {
            if (boxTypes == null || boxTypes.length == 0
                    || boxTypes[0] == null || boxTypes[0].length == 0) {
                return 0;
            }

            if (truckSize <= 0) {
                return 0;
            }

            // sort the boxTypes array based on the unit
            Arrays.sort(boxTypes, (o1, o2) -> {
                return o2[1] - o1[1];
            });

            int numOfUnits = 0;
            int numOfBoxes = 0;

            for (int[] boxType : boxTypes) {
                if (numOfBoxes + boxType[0] <= truckSize) {
                    numOfUnits += boxType[0] * boxType[1];
                    numOfBoxes += boxType[0];

                } else {
                    int rest = truckSize - numOfBoxes;
                    numOfUnits += rest * boxType[1];
                    break;
                }
            }

            return numOfUnits;
        }
    }

    class Solution2 {
        public int maximumUnits(int[][] boxTypes, int truckSize) {
            if (boxTypes == null || boxTypes.length == 0
                    || boxTypes[0] == null || boxTypes[0].length == 0) {
                return 0;
            }

            if (truckSize <= 0) {
                return 0;
            }

            // sort the boxTypes array based on the unit
            Arrays.sort(boxTypes, (o1, o2) -> {
                return o2[1] - o1[1];
            });

            int numOfUnits = 0;
            int remainingTruckSize = truckSize;

            for (int[] boxType : boxTypes) {
                int boxCount = Math.min(boxType[0], remainingTruckSize);
                remainingTruckSize -= boxCount;
                numOfUnits += boxCount * boxType[1];

                if (remainingTruckSize == 0) {
                    break;
                }
            }

            return numOfUnits;
        }
    }
}
