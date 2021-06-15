import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static final String resultPath = "./result.txt";
    public static final String signaturePath = "./signatures.txt";
    public static void main(String[] args) {
        try {
            ReadFile signatures = new ReadFile(signaturePath);
            Scanner in = new Scanner(System.in);
            WriteFile result = new WriteFile();
            String userInput;
            int SignIsPresent;
            while ((userInput = in.nextLine()) != null && userInput.equals("42") != true) {
                SignIsPresent = 0;
                try {
                    String sign = ReadSignature.getSign(userInput);
                    for (String key : signatures.getSignature().keySet()) {
                        if (sign.contains(key))
                        {
                            String val = signatures.getSignature().get(key);
                            SignIsPresent = 1;
                            result.WriteToFile(val);
                            break ;
                        }
                    }
                    if (SignIsPresent == 0)
                        result.WriteToFile("UNDEFINED");
                    System.out.println("PROCESSED");
                } catch (Exception e) {
                    System.out.println("File not found");
                }
            }
            result.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }
}
