package com.blag.harmonysearch.helpers;


import org.mariuszgromada.math.mxparser.Function;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FunctionStringValidator
{
    static String genericArgumentRegex = "[a-z|A-Z]\\d|[a-z|A-Z]\\d|[a-z|A-Z]";
    static String xArgumentRegex = "[x|X]\\d|[x|X]";
    private Pattern pattern;
    private Matcher matcher;
    private ArgumentMatching argumentMatching;

    public FunctionStringValidator()
    {
        pattern = Pattern.compile(xArgumentRegex);
    }

    public FunctionStringValidator(ArgumentMatching argumentMatching)
    {
        if (argumentMatching == ArgumentMatching.AllLettersAllowed)
        {
            pattern = Pattern.compile(genericArgumentRegex);
        } else
        {
            pattern = Pattern.compile(xArgumentRegex);
        }
    }

    public Function validateFunctionString(String functionString)
    {
        matcher = pattern.matcher(functionString);

        Set<String> arguments = new HashSet<String>();
        while (matcher.find())
        {
            arguments.add(matcher.group());
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("f(");
        for (String argument: arguments) {
            stringBuilder.append(argument);
            stringBuilder.append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append(")=");

        stringBuilder.append(functionString);
        return new Function(stringBuilder.toString());
    }

    boolean matchFunctionArguments(String functionString)
    {
        matcher = pattern.matcher(functionString);
        return matcher.find();
    }
}
