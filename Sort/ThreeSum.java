import java.util.Scanner;

class ThreeSum {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
	int arr[];
    int n = s.nextInt();
	if ( n<0 )
		System.exit(1);
		
	arr = new int[n];
	for (int i=0; i< n; i++)
		arr[i] = s.nextInt();
	
	System.out.println(ThreeSum(arr));
	
  }
  
  public static boolean ThreeSum(int[] arr)
  {
	int j=0, r=arr.length;
	int i=0;
	do
	{
		int a = arr[i];
//		if (a == 0)
//			return true;
		j = i;
		int k = r-1;
		
		while (j<=k)
		{
			int b = arr[j];
			int c = arr[k];
			
			if ( a+b+c == 0)
			{
				System.out.println(i + " "+ j + " " + k);
				return true;
			}
			else if ( a+b+c >0 )
				k = k - 1;
			else
				j = j+1;
		}
		i++;
	} while (i != r);
	return false;
  }
  
  public static int bSearch(int[] arr, int number)
  {
	int l=0, r=arr.length-1;
	while ( l <= r )
	{
		int m = (l+r)/2;
	//	System.out.println(m+"<>"+number);
		if ( arr[m] == number ) return m+1;
		else if (arr[m] > number)
			r = m - 1;
		else if (arr[m] < number)
			l = m + 1;
		//System.out.println("from: "+l+" to"+r);
	}
	return -1;
  }
}