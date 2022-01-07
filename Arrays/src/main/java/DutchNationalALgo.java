//We know that when nums[curr]==2, after swapping with p2, we should not increase curr since the number swapped back from p2 can be 0/1, which needs to be further processed.
//        But how about when nums[curr]==0? Why is the number swapped from p0 not required to be handled?
//        In fact, if curr > p0, the number swapped back from p0 can only be 1, as curr has passed p0, therefore processed nums[p0]. In this case, leaving curr where it is, or increasing curr, does not really make a difference.
//        However, it is also possible that curr == p0 as initialization; in this case, both of them need to move forward.
//        As a unified solution, we increase curr when nums[curr] == 0.

class DutchNationalALgo {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0;
        int p2 = n -1 ;
        int curr =0;
        int i=0;
        while(curr <= p2)
        {
            if(nums[curr]==0)
            {
                swap(nums, p0, curr);
                p0++;
                curr++; //tricky as number swapped can be only 1 and hence does not need further processing
            }
            else if(nums[curr]==1)
            {
                curr++;
            }

            else if(nums[curr]==2)
            {
                swap(nums, curr, p2);
                p2--;
            }
        }

    }


    public void swap(int[] a, int left, int right)
    {
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }
}