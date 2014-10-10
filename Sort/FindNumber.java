import java.util.Scanner;

class FindNumber {
	public static void main (String[] args) 
	{
		Scanner s = new Scanner(System.in);
		int arr[];
		int n = s.nextInt();
		if ( n<0 )
			System.exit(1);
			
		arr = new int[n];
		for (int i=0; i< n; i++)
			arr[i] = s.nextInt();
			
		System.out.println(findRepeats(arr, (int)Math.floor(n/2)));
	}

	public static boolean findRepeats(int[] arr, int count)
	{
		int n = arr.length;
		for ( int i = 0; i < n-2; i++ )
		{
			int a = arr[i];
			int j = i+1;
			int k = n-1;
			int counter = 1;
			while ( j <= k )
			{
				if (j == k && arr[k] == a)
					counter++;
				else
				{
					if ( arr[j] == a)
						counter++;
					if ( arr[k] == a )
						counter++;
				}
				if ( counter > count )
					return true;
				j++;
				k--;
			}
		}
		return false;
	}
}