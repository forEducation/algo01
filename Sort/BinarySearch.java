import java.util.Scanner;

class BinarySearch {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
	int arr[];
    int n = s.nextInt();
	if ( n<0 )
		System.exit(1);
		
	arr = new int[n];
	for (int i=0; i< n; i++)
		arr[i] = s.nextInt();
	
	int k = s.nextInt();
	if ( k<0 )
		System.exit(1);
	int B[] = new int[k];
	for (int i=0; i<k; i++)
		B[i] = s.nextInt();
		
	for (int i = 0; i < k; i++)
	{
		System.out.print(bSearch(arr, B[i]));
		if ( i != k-1 )
			System.out.print(" ");
	}
	
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