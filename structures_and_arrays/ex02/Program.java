import java.util.Scanner;
public class Program
{
	public static boolean isPrime(int userInput)
	{
		int SumOfDigits = 0;
		while (userInput > 0)
		{
			SumOfDigits += userInput % 10;
			userInput = userInput / 10;
		}
		int square = 2;
		while (square * square <= SumOfDigits)
			square++;
		for (int i = 2; i <= square; i++) {
			if (SumOfDigits % i == 0) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sk = new Scanner(System.in);
		int UserInput = 0;
		int requests = 0;
		while ((UserInput = sk.nextInt()) != 42)
		{
			if (isPrime(UserInput))
				requests++;
		}
		sk.close();
		System.out.println("Count of coffee-request – " + requests);
	}
}