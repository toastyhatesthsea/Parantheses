package Parantheses;

import java.util.Stack;

public class Parantheses
{


    public boolean isValid(String s)
    {
        if (s.length() == 1)
        {
            return false;
        } else if (s.isEmpty())
        {
            return true;
        }
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

        if(paranStack.isEmpty() && isValidParan)
        {
            return true;
        }
        else
        {
            return false;
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
                break;
            case "]":
                if (leftParan.equals("["))
                {
                    return true;
                }
                break;
            case ")":
                if (leftParan.equals("("))
                {
                    return true;
                }
                break;
            default:
                return false;

        }
        return false;
    }
}

class ParanTest
{
    public static void main(String[] aregsg)
    {
        Parantheses paran = new Parantheses();

        boolean rawrs = paran.isValid("((");
    }

}
