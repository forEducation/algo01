import java.util.Scanner;

class CountSort {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
	int arr[];
	int M = 11;
    int n = s.nextInt();
	if ( n<0 )
		System.exit(1);
	arr = new int[n];
	for (int i=0; i< n; i++)
		arr[i] = s.nextInt();
	
	int B[] = new int[M];
	for (int i=0; i<M; i++)
		B[i] = 0;
		
	for (int i=0; i< n; i++)
	{
		B[arr[i]] +=1;
	}
	
	int k = 0;
	for (int i =1; i<M; i++ )
		for (int j=0; j< B[i]; j++)
		{
			arr[k++] = i;
		}
	for (int i=0; i< n; i++)
		System.out.print(arr[i] + " ");
  }
}