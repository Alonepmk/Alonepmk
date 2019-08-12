package com.alonepmk.Utils;


public class MathUtils
{

    public MathUtils()
    {
    }

    public static double getRandomDoubleBetweenRange(double min, double max)
    {
        double x = Math.random() * ((max - min) + 1.0D) + min;
        return x;
    }
}
