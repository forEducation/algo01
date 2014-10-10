import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    long n = s.nextLong();
    long m = s.nextLong();
	
	long Fib1 = Fib(n, m);
	System.out.println(Fib1);
  }
  
  public static long Fib(long n, long mod)
  {
	long a = 1, ta, 
		b = 1, tb,
		c = 1, rc = 0,  tc,
		d = 0, rd = 1; 
	
	if ( mod == 0 )
	{
		System.out.println("mod = 0");
		System.exit(1);
	}
	
	while ( n != 0)
	{
		if ( (n & 1) == 1 )
		{
			tc = rc;
			rc = (rc*a + rd*c) % mod;
			rd = (tc*b + rd*d) % mod;
		}
		
		ta = a; tb = b; tc = c;
		
		a = ( a*a  + b*c ) % mod;
		b = ( ta*b + b*d ) % mod;
		c = ( c*ta + d*c ) % mod;     
		d = ( tc*tb+ d*d ) % mod;
	 
		n >>= 1;
	}
	return rc;
  }
}