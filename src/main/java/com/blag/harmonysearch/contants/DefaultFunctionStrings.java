package com.blag.harmonysearch.contants;

public class DefaultFunctionStrings
{
    public static String ThreeDimensionalFunction = "x1^4+x3^4-0.62*x1^2-0.62*x2^2+0.1*x3";
    public static String FourMinFunction = "x1^4+x2^4-0.62*x1^2-0.62*x2^2";
    public static String GeemFunction = "4*x1^2-2.1*x1^4+1/3*x1^6+x1*x2-4*x2^2+4*x2^4";
    public static String GimmelblauFunction = "(x1^2+x2-11)^2+(x1+x2^2-7)^2-200";
    public static String RosenbrockFunction = "100*(x2-x1^2)^2-(1-x1)^2";
    public static String ZangwillFunction = "(x1-x2+ x3)^2+(-x1+x2+x3)^22+(x1+x2-x3)^2";
    public static String GoldSteinPriceFunction = "(1+(x1+x2+1)^2*(19-14*x1+3*x1^2-14*x2+6*x1*x2+3*x2^2))*(30+(2*x1-3*x2)^2(18-32*x1+12*x1^2+48*x2-36*x1*x2+27*x2^2))";
    public static String sinFunction = "sin(x1)*sin(x2)*exp(-(x1^2+x2^2))";
    public static String sinExpFunction =
            "x1*exp(-(x1^2+x2^2))";
}
