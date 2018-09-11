package Parantheses;

import java.util.Stack;

public class Parantheses
{


    public boolean isValid(String s)
    {
        Stack<String> paranStack = new Stack<>();
        boolean isValidParan = true;
        for (int i = 0; i < s.length() && isValidParan; i++)
        {
            String aParan = s.substring(i, i + 1);

            if (aParan.equals("[") || aParan.equals("{") || aParan.equals("("))
            {
                paranStack.push(aParan);
            } else if (aParan.equals("]") || aParan.equals("}") || aParan.equals(")"))
            {
                if (!paranStack.empty())
                {
                    String leftParan = paranStack.pop();
                    isValidParan = validParanHelper(aParan, leftParan);
                } else
                {
                    isValidParan = false;
                }
            } else
            {
                isValidParan = false;
            }
        }
        return isValidParan;
    }

    public boolean validParanHelper(String rightParan, String leftParan)
    {

        switch (rightParan)
        {
            case "}":
                if (leftParan.equals("{"))
                {
                    return true;
                }
            case "]":
                if (leftParan.equals("["))
                {
                    return true;
                }
            case ")":
                if (leftParan.equals("("))
                {
                    return true;
                }
            default:
                return false;
        }
    }

}
