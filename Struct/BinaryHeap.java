import java.util.Scanner;
import java.util.ArrayList;

class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BinaryHeap heap = new BinaryHeap();
		
		int n = s.nextInt();
		if ( n<0 )
			System.exit(1);
		
		
		for (int i=0; i<n; i++)
		{
			String cmd = s.next().toUpperCase();
			if ( cmd.equals("EXTRACT") )
			{
				System.out.println(heap.extract());
				//System.out.println(heap.toString());
			}
			else if ( cmd.equals("INSERT") )
			{
				int num = s.nextInt();
				heap.insert(num);
//				System.out.println(heap.toString());
			}
		}
	}
}

class BinaryHeap {
	private ArrayList<Long> heap = new ArrayList<>();

	private void siftDown(int leaf)
	{
		int lchild = leaf*2+1;
		int rchild = leaf*2+2;
		if ( rchild < size() )
		{
			if (heap.get(rchild) > heap.get(lchild) && 
				heap.get(rchild) > heap.get(leaf)  )
			{
				swap( rchild, leaf );
				siftDown( rchild );
			}
			else if (heap.get(lchild) >= heap.get(rchild) &&
					heap.get(lchild) > heap.get(leaf))
			{
				swap( lchild, leaf );
				siftDown( lchild );
			}
		}
		else{
			if ( lchild < size() &&
					heap.get(lchild) > heap.get(leaf) )
			{
				swap( lchild, leaf );
				siftDown( lchild );
			}
		}
	}

	
	private void siftUp(int leaf)
	{
		int parent = getParent(leaf);
		if ( parent > -1 )
		{
			if ( heap.get(parent) < heap.get(leaf) )
			{
				swap(parent, leaf);
				siftUp(parent);
			}
		}
	}
	
	public int size()
	{
		return heap.size();
	}
  
	public int getParent(int leaf)
	{
		if ( leaf == 0 )
			return 0;
		if (leaf >= size() )
			return -1;
		return (int)Math.ceil((double)leaf/2)-1;
	}
	
	public void insert(long leaf)
	{
		heap.add(leaf);
		this.siftUp(size()-1);
	}
	
	public long extract()
	{
		if (size() == 0 )
			return -1;
		long res = heap.get( 0 );
		heap.set(0, heap.get(size()-1) );
		heap.remove( size()-1 );
		siftDown( 0 );
	//	swap( 0, size()-1 );
		return res;
	}
	
	public void swap(int x, int y)
	{
		long temp = heap.get( x );
		heap.set( x, heap.get(y) );
		heap.set( y, temp );
	}
	
	public String toString()
	{
		String res = "";
		for (int i=0; i<size(); i++)
		{
			res += heap.get(i)+" ";
		}
		return res;
	}
	
	public static void main(String[] arg) {}
}