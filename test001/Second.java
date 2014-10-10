public class Second
{
	public static void main(String[] args)
	{
		int firstArg=10;
		if (args.length > 0) {
			try {
				firstArg = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				System.err.println("Argument " + args[0] + " must be an integer.");
				System.exit(1);
			}
			if (firstArg <=0)
			{
				System.err.println("Argument " + args[0] + " must be >0");
			}
		}
		
		int count=firstArg;
		
		switch(count)
		{
			case 1:
				System.out.println("One");
				break;
			case 2:
				System.out.println("Two");
				break;
			case 3:
				System.out.println("Three");
				break;
			default:
				System.out.println("Unknown");
		}
	}
}