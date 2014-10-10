import java.util.Scanner;
public class run {
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int lapDistance = 400;
		System.out.print("1km runtime. Minutes: ");
		int mins = s.nextInt();
		System.out.print("Seconds: ");
		int secs = s.nextInt();
		secs += mins*60;
		double speed, lapTime;
		lapTime = secs / 2.5;
		speed = (3600.0 / secs);
		System.out.print("Lap time: "+(int)lapTime/60+"min "+lapTime%60+"sec. Average speed: "+speed);
	}
}