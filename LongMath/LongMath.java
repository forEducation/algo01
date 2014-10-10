import java.util.Scanner;
import java.math.BigInteger;
class LongMath {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    BigInteger x = new BigInteger(s.next());
    BigInteger y = new BigInteger(s.next());
	
	
//	System.out.println(x.toString(2) + " = "+ getNBits(x, y, true).toString(2) + "|"+ getNBits(x, y, false).toString(2));	
	System.out.println(Karatsuba(x, y, 0));
  }
  /*
	 
  */
  public static BigInteger Karatsuba(BigInteger x, BigInteger y, int level)
  {
	double n = Math.max(x.bitLength(), y.bitLength());
	if ( x == BigInteger.ZERO || y == BigInteger.ZERO )
		return BigInteger.ZERO;
	if ( n<=1 ) return x.multiply(y);
	int half = (int)Math.ceil(n/2);
	System.out.println(drawTab(level)+ x.toString()+" ("+x.toString(2)+")"+" * "+y.toString()+" ("+y.toString(2)+") n/2: "+half );
	
	BigInteger Xl = getNBits( x, half, true ); 
	BigInteger Xr = getNBits( x, half, false );
	
	BigInteger Yl = getNBits( y, half, true );
	BigInteger Yr = getNBits( y, half, false );
	System.out.println( drawTab(level)+ Xl.toString(2)+"|"+Xr.toString(2)+"; "+Yl.toString(2)+"|"+Yr.toString(2)+";" );
	
	System.out.println(drawTab(level)+"P1");
	BigInteger P1 = Karatsuba( Xl, Yl, level+1 );
	System.out.println(drawTab(level)+"P2");
	BigInteger P2 = Karatsuba( Xr, Yr, level+1 );
	System.out.println(drawTab(level)+"P3");
	BigInteger P3 = Karatsuba( Xl.add(Xr), Yl.add(Yr), level+1 );
	System.out.println(drawTab(level)+P1.toString(2) + " " + P2.toString(2) + " " + P3.toString(2) +"n/2:" +half);
	P3 = ((P3.subtract(P1)).subtract(P2)).shiftLeft(half);
	P1 = P1.shiftLeft(2*half);
	System.out.println(drawTab(level)+P1.add(P3.add(P2)));
	return P1.add(P3.add(P2));
  }
  // P3 - P1 - P2 = 2 - 0 - 1
  //				2 - (0 - 1)
  public static String drawTab(int level)
  {
	String res = "";
	for (int i=0; i<level; i++)
		res += "* ";
	return res;
  }
  
  // negative values?
  public static BigInteger getNBits(BigInteger i, int N, boolean isLeft)
  {
	BigInteger mask = new BigInteger("1");
	int n = i.bitLength();
//	System.out.println("n = "+N+"; number: "+i.toString()+"("+i.toString(2)+")");
	if ( isLeft )
	{
		if ( N<1 ) 
			return i;
		if ( N>n )
		{
			return BigInteger.ZERO;
		}
//		System.out.println("Shifted right ("+N+"): "+i.shiftRight(N));
		return i.shiftRight(N);
	}
	else
	{
		if ( N<1 ) 
			return BigInteger.ZERO;
		if ( N>n )
		{
			return i;
		}
		mask = mask.shiftLeft(N);
		mask = mask.subtract(BigInteger.ONE);
		BigInteger t = i.and(mask);
//		System.out.println("Masked (mask: "+mask.toString(2)+"); Result "+t+"("+t.toString(2)+")");
		return t;
	}
  }
}