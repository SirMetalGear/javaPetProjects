import java.util.Scanner;
public class Program
{
	public static void main(String[] args) {
		Scanner sk = new Scanner(System.in);
		int count = 1;
		int minMark = 0;
		long Marks = 0;
		String UserInputWeek;
		while ((UserInputWeek = sk.nextLine()) != null &&
				UserInputWeek.equals("Week " + count) && count != 19)
		{
			minMark = ParseMinMark(sk);
			Marks = Marks * 10 + minMark;
			count++;
			sk.nextLine();
		}
		if (UserInputWeek.equals("42"))
			printStat(Marks);
		else
			errorExit(sk);
	}
	public static void printStat(long Marks)
	{
		int i = 1;
		long reversed = 0;
		long mark = 0;
		while (Marks > 0)
		{
			reversed = reversed * 10 + (Marks % 10);
			Marks = Marks / 10;
		}
		System.out.println(reversed);
		while (reversed > 0)
		{
			System.out.print("Week " + i++ + " ");
			mark = reversed % 10;
			reversed = reversed / 10;
			while (mark > 0)
			{
				System.out.print("=");
				mark--;
			}
			System.out.println(">");
		}
	}
	public static int ParseMinMark(Scanner sk)
	{
		int parsedMark = 0;
		int minMark = 9;
		for (int i = 0; i < 5; i++) {
			parsedMark = sk.nextInt();
			if (parsedMark < 1 || parsedMark > 9)
				errorExit(sk);
			if (parsedMark < minMark)
				minMark = parsedMark;
		}
		return minMark;
	}
	public static void errorExit(Scanner sk)
	{
		sk.close();
		System.err.println("IllegalArgument");
		System.exit(-1);
	}
}