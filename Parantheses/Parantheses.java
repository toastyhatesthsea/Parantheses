package Parantheses;

import java.util.Stack;

public class Parantheses
{


    public boolean isValid(String s)
    {
        Stack<String> paranStack = new Stack<>();
        for (int i = 0; i < s.length(); i++)
        {
            String aParan = s.substring(i, i + 1);

            if (aParan.equals("[") || aParan.equals("{") || aParan.equals("("))
            {
                paranStack.push(aParan);
            }
        }
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
