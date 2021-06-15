import java.io.IOException;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReadFile {
    private Map<String,  String> signature;
    ReadFile(String path) throws IOException {
        signature = new HashMap<String, String>();
        Scanner read = new Scanner(new File(path));
        String parsed;
        while (read.hasNextLine())
        {
            parsed = read.nextLine();
            String[] splitted = parsed.split(", ");
            signature.put(splitted[1], splitted[0]);
        }
        read.close();
    }
    public Map<String, String> getSignature() { return signature; }
}
