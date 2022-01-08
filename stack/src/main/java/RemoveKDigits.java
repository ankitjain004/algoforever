//402. Remove K Digits
//Given string num representing a non-negative integer num, and an integer k,
// return the smallest possible integer after removing k digits from num.

import java.util.Stack;

class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int digitsToRemove = k;

        Stack<Character> stack = new Stack<>();

        stack.push(num.charAt(0));
        int i=1;
        while(i<num.length() && digitsToRemove>0)
        {
            if(stack.isEmpty())
            {
                stack.push(num.charAt(i));
                i++;
                continue;
            }
            int top = stack.peek();
            int curr = num.charAt(i);
            if(top>curr)
            {
                stack.pop();
                digitsToRemove--;

            }
            else
            {
                stack.push(num.charAt(i));
                i++;
            }
        }

        while(i<num.length())
        {
            stack.push(num.charAt(i));
            i++;
        }
        while(digitsToRemove>0)  //monotonically increasing sequence
        {
            stack.pop();
            digitsToRemove--;
        }


        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
        {
            sb = sb.append(stack.pop());
        }

        sb = sb.reverse();

        sb = removeTrailingZero(sb);

        return sb.length()==0?"0":sb.toString();

    }

    private StringBuilder removeTrailingZero(StringBuilder sb)
    {
        while(sb.length()>0&&sb.charAt(0)=='0')
        {
            sb=sb.deleteCharAt(0);
        }
        return sb;
    }
}