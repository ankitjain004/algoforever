//Idea is to think of how much water will be stored over a bar

// It will be between two highest bars on either side and the exact value will be minimum of the two
public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;

        int[] left = new int[n];
        int[] right = new int[n];

        int max = height[0];
        left[0] = max;

        for (int i = 1; i < n; i++) {
            if (height[i] > max) {
                max = height[i];
            }

            left[i] = max;
        }

        max = height[n - 1];
        right[n - 1] = max;

        for (int i = n - 2; i >= 0; i--) {
            if (height[i] > max)
                max = height[i];

            right[i] = max;  // at this point we can directly calculate the answer and remove another right array space
        }
        int answer = 0;
        for (int i = 1; i <= n - 2; i++) {
            int curr = Integer.min(left[i - 1], right[i + 1]) - height[i];
            if (curr > 0) answer = answer + curr;
        }

        return answer;


    }
}