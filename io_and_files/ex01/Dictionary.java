import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.Map;

public class Dictionary {
    private Map<String, Integer> dict;
    Dictionary(FileReader file1, FileReader file2) throws IOException {
        dict = new TreeMap<String, Integer>();
        readFile(file1);
        readFile(file2);
    }
    private void readFile(FileReader file) throws IOException {
        BufferedReader reader = new BufferedReader(file);
        String line;
        String[] words;
        while ((line = reader.readLine()) != null)
        {
            words = line.split(" ");
            for (int i = 0; i < words.length; i++)
                if (!dict.containsKey(words[i]))
                    dict.put(words[i], 0);
        }
        reader.close();
    }
    public Map<String, Integer> getDictionary() { return dict; }
}
