import java.util.Random;
import java.math.*;
import java.util.*;

public class Main {
	static int gcd(int a, int b)
    {

        if (a == 0)
          return b;
        if (b == 0)
          return a;
      
       
        if (a == b)
            return a;
      
        if (a > b)
            return gcd(a-b, b);
        return gcd(a, b-a);
    }
	public static void main(String args[])
	{
		
		
		int msg = 3;
		Random rand = new Random();
		int p = 11 , q = 13;
		int n = p*q;
		int h = (p - 1) * (q - 1);
		int upperbound = h;
		int e=0;
		for(int i =2 ; i< upperbound ; i++)
		{
			e = i;
			if (gcd(e , upperbound)==1)
			{
				break;
			}
			
		}
		System.out.println("upper :" + upperbound);
		System.out.println("e : " + e);
		
		int d = 0;
		for (int i = 0; i <= 9; i++) {
            int x = 1 + (i * upperbound);
 
            if (x % e == 0) {
                d = x / e;
                break;
            }
        }
		System.out.println("d: " + ((d* e)%upperbound));
		BigInteger N = BigInteger.valueOf(n);
		
		double encrypted_message=  (int) ((Math.pow(msg, e)) % n);
		System.out.println("Encrypted message is : " + encrypted_message);
		BigInteger C = BigDecimal.valueOf(encrypted_message).toBigInteger();
		BigInteger decrypted = (C.pow(d)).mod(N);
		System.out.println("Decrypted message is : " + decrypted);
		
	}
}
