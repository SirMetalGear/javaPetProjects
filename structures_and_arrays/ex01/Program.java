import java.util.Scanner;
public class Program
{
	public static int getSquare(int num)
	{
		int square = 2;
		while (square * square <= num)
			square++;
		return square;

	}
	public static void isPrime(int userInput)
	{
		int steps = 0;
		int square = getSquare(userInput);
		for (int i = 2; i <= square; i++) {
			if (userInput % i == 0) {
				steps++;
				System.out.println("false " + steps);
				return ;
			}
			steps++;
		}
		System.out.println("true " + steps);
	}
	public static void main(String[] args) {
		Scanner sk = new Scanner(System.in);
		int userInput = 0;
		int errorFlag = 0;
		if (sk.hasNextInt()) {
			userInput = sk.nextInt();
			if (userInput <= 1) {
				errorFlag = 1;
			}
		}
		else
			errorFlag = 1;
		sk.close();
		if (errorFlag == 0)
			isPrime(userInput);
		else {
			System.err.println("Illegal Argument");
			System.exit(-1);
		}
	}
}