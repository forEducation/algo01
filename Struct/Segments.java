import java.util.Scanner;
import java.util.ArrayList;

class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		if ( n<0 )
			System.exit(1);
		
		Segments a = new Segments(n);
		
		for (int i=1; i<=n; i++)
		{
			a.set(i, s.nextLong());
			System.out.println(a);
		}
	}
}

class Segments {

	private ArrayList<Long> list = new ArrayList<>();
	private int startPos=0;
	public Segments(int n)
	{
		int newN = (int)Math.pow(2, Math.ceil(Math.log(n)/Math.log(2)));
		
		startPos = newN-1;
		for (int i=0 ; i< 2*newN-1; i++)
			list.add(-1L);
//			list.add(Long.MAX_VALUE-1);
		System.out.println(newN+"/2 = "+startPos);
	}
	
	public void set(int pos, long num)
	{
		int newPos = startPos + pos-1;
		
		list.set(newPos, num);
//		System.out.println(list);
		CalcMins(newPos, 0);
	}
	/*
		Алгоритм поиска мин() на отрезке от а до б
		1. 
	*/
	public long getMin()
	{
		
		return 0L;
	}
	
	private long getMin(int from, int to, int level)
	{
		System.out.println(br(level)+"getMin("+from+","+to+")");
		if (from == to)
		{
			return list.get(from);
		}
		else
		{
			long left = getMin(from, (int)Math.floor((from+to)/2), level+1);
			long right = getMin((int)Math.floor((from+to)/2)+1, to, level+1);
			
			int parent = (int)Math.floor(from/2);
			System.out.println(br(level)+"parent="+parent);
			if (left < right)
			{
				list.set(parent, right);
				return right;
			}
			list.set(parent, left);
			return left;
		}
	}
	
	public void swap(int x, int y)
	{
		long tmp = list.get(x);
		list.set(x, list.get(y));
		list.set(y, tmp);
	}
	
	public int getParent(int leaf)
	{
		if ( leaf == 0 )
			return 0;
		if (leaf >= list.size() )
			return -1;
		return (int)Math.ceil((double)leaf/2)-1;
	}
	
	public void CalcMins(int pos, int level)
	{
		int parent = getParent(pos);
		System.out.println(br(level)+"CalcMins("+pos+"); parent: "+parent);
		
		if (list.get(parent) < list.get(pos))
		{
			list.set(parent, list.get(pos));
			CalcMins(parent, level+1);
		}
		
/*		System.out.println(br(level)+"CalcMins("+from+","+to+")");
		if (from == to)
		{
			return list.get(from);
		}
		else
		{
			long left = CalcMins(from, (int)Math.floor((from+to)/2), level+1);
			long right = CalcMins((int)Math.floor((from+to)/2)+1, to, level+1);
			
			int parent = (int)Math.floor(from/2);
			System.out.println(br(level)+"parent="+parent);
			if (left < right)
			{
				list.set(parent, right);
				return right;
			}
			list.set(parent, left);
			return left;
		}
*/		
	}
	
	public String toString()
	{
		String res = "";
		for (int i=0; i< list.size(); i++)
		{
			res +=" "+list.get(i)+" ";
		}
		return res;
	}
	
	public String br(int level)
	{
		String res = "";
		for (int i=0; i< level; i++)
			res += " * ";
		return res;
	}
	
	public static void main(String[] args){}
}