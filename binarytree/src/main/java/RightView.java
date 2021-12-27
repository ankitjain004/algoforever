import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//@link{https://leetcode.com/problems/binary-tree-right-side-view/}
public class RightView {
    Map<Integer, Integer> rightView = new HashMap();
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList();

        getRightView(root,0);

        for(Map.Entry<Integer, Integer> map : rightView.entrySet())
        {
            int val = map.getValue();
            ans.add(val);
        }



        return ans;

    }

    public void getRightView(TreeNode root,int hd)
    {
        if(root==null) return ;
        rightView.put(hd, root.val);
        getRightView(root.left,hd+1);
        getRightView(root.right,hd+1);

    }
}