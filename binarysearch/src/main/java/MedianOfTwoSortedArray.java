public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);

        int numOfMedianKey = (n1 + n2) / 2;     // 5 6

        int lo = 0;
        int hi = n1; //talking in teerms of number of elements
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;

            int cut1 = mid; //mid no. of elements taken in first cut so last element will have index cut1-1
            int cut2 = numOfMedianKey - mid;
            int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];  // case to handle when taking 0 elements from first array

            int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int right1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1]; // case to handle when taking all elements from first array
            int right2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];

            if ((left1 <= right2) && (left2 <= right1)) {
                if ((n1 + n2) % 2 == 0) {
                    int left = Integer.max(left1, left2);
                    int right = Integer.min(right1, right2);
                    return (left + right) / 2.0;
                } else {
                    return Integer.min(right1, right2);
                }
            } else if (left1 > right2) {
                hi = cut1 - 1;
            } else {
                lo = cut1 + 1;
            }

        }
        //since answer is returned inside only
        return 0.0;


    }
}