/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ex4;

/**
 *
 * @author i090674
 */
public class CalCombinatorio
{

    public static long factorial(long num)
    {
        long fact=1;
        for (long i=num; i>1;i=i-1)
        {
            fact=fact*i;
        }
        return fact;
    }
     public static long combinacoes(long n, long p )
    {
        if(n<p)
        return -1;
        return factorial(n)/(factorial(p)*factorial(n-p));
    }

    public static long arranjos(long n, long p )
    {
        if(n<p)
        return -1;
        return factorial(n)/(factorial(n-p));
    }
    public static long permutacoes(long num)
    {
        long fact=1;
        for (long i=num; i>1;i=i-1)
        {
            fact=fact*i;
        }
        return fact;
    }
}
