/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Flow
 */
public class TestClass 
{
  public static int main(String[] args) {
    // put your code here
	int firstArg = 0, secondArg = 0;
        if (args.length > 0) 
        {
            try {
				firstArg = Integer.parseInt(args[0]);
				secondArg = Integer.parseInt(args[1]);
			} catch (NumberFormatException e) {
				System.err.println("Argument must be an integer.");
				System.exit(1);
			}
                        return firstArg + secondArg;
		}
     System.exit(1);		
      return 1;
  }
}
