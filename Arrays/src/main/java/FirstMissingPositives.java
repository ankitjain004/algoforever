class FirstMissingPositives {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        if ((n == 1) && nums[0] == 1) return 2;
        boolean isOnePresent = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                isOnePresent = true;
                continue;
            }
            //convert all negatives and 0 to positive and say 1 for consistency as we already checked for 1 so the effect by these numbers at 1 will not matter
            nums[i] = nums[i] <= 0 ? 1 : nums[i];
        }

        if (!isOnePresent) return 1;


        for (int i = 0; i < n; i++) {
            int abs = Math.abs(nums[i]);
            if (abs > 0 && abs <= n) {
                //store information about number n at index n-1
                if (nums[abs - 1] > 0)
                    nums[abs - 1] = (-1) * nums[abs - 1];
            }
        }

        for (int i = 0; i < n; i++) {
            //i==0 stores information about 1 which is pretty useless
            // and manipulated by us many times maybe and we already checked for 1 too
            if (i == 0) continue;
            if (nums[i] > 0)
                return i + 1; //as i stored information about i+1
        }

        return n + 1;
    }
}