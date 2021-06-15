import java.util.Scanner;
public class Program
{
	public static void main(String[] args) {
		Scanner sk = new Scanner(System.in);
		String cipher = sk.nextLine();
		sk.close();
		decode(cipher.toCharArray(), cipher.length());
	}
	public static void decode (char[] code, int length){
		int key=0;
		final int arraySize = 65535;
		int[] freqs = new int[arraySize];
		for (int l = 0; l < arraySize; l++){
			freqs[l] = 0;
		}
		for (int k = 0; k < length; k++){
			freqs[code[k]]++;
		}
		getSorted(freqs, arraySize);
	}
	public static void getSorted(int[] freqs, int arraySize)
	{
		int[][] sorted = new int[10][2];
		int j = 0;
		int i = 0;
		while (i < arraySize) {
			if (freqs[i] != 0) {
				sorted[j][0] = i;
				sorted[j][1] = freqs[i];
				j++;
			}
			if (j == 10)
				break ;
			i++;
		}
		sort(sorted, j);
		if (i != arraySize) {
			continueSorting(freqs, sorted, i, arraySize);
			j = 10;
		}
		printResult(sorted, j);
	}
	public static void continueSorting(int[] freqs, int[][] sorted, int i, int arraySize)
	{
		while (i < arraySize)
		{
			if (freqs[i] > sorted[9][1])
			{
				sorted[9][0] = i;
				sorted[9][1] = freqs[i];
				if (sorted[9][1] > sorted[8][1] ||
						sorted[9][1] == sorted[8][1] && sorted[9][0] < sorted[8][0]) {
					sort(sorted, 10);
				}
			}
			else if (freqs[i] == sorted[9][1] && i < sorted[9][0])
				sorted[9][0] = i;
			i++;
		}
	}
	public static void sort(int[][] sorted, int length)
	{
		int i = 0;
		int tmpVal;
		int tmpIndex;
		while (i < length - 1)
		{
			if (sorted[i][1] < sorted[i + 1][1] ||
					sorted[i][1] == sorted[i + 1][1] && sorted[i][0] > sorted[i + 1][0])
			{
				tmpIndex = sorted[i][0];
				sorted[i][0] = sorted[i + 1][0];
				sorted[i + 1][0] = tmpIndex;
				tmpVal = sorted[i][1];
				sorted[i][1] = sorted[i + 1][1];
				sorted[i + 1][1] = tmpVal;
				i = -1;
			}
			i++;
		}
	}
	public static int countNum(int num)
	{
		int i = 0;
		while (num > 0)
		{
			i++;
			num = num / 10;
		}
		return i;
	}
	public static void printResult(int[][] sorted, int count)
	{
		if (count <= 0)
			return ;
		int max = sorted[0][1];
		int elementCount = 0;
		int line = 11;
		while (line > 0)
		{
			for (int z = 0; z < count; z++)
			{
				elementCount = sorted[z][1] * 10 / max;
				if (elementCount + 1 == line)
				{
					for (int k = countNum(sorted[z][1]); k <= 3; k++)
						System.out.print(" ");
					System.out.print(sorted[z][1]);
				}
				if (line <= elementCount)
					System.out.print("   #");
			}
			line--;
			System.out.println();
		}
		for (int z = 0; z < count; z++)
			System.out.print("   " + (char)sorted[z][0]);
		System.out.println();
	}
}