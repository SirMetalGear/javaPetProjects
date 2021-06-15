import java.io.*;
import java.util.TreeMap;
import java.util.Map;

public class CountWords {
    private Map<String, Integer> freq;
    CountWords(FileReader file, Map<String, Integer> dictionary) throws IOException
    {
        freq = new TreeMap<String, Integer>(dictionary);
        count(file);
    }
    private void count(FileReader file) throws IOException {
        BufferedReader reader = new BufferedReader(file);
        String line;
        String[] words;
        while ((line = reader.readLine()) != null)
        {
            words = line.split(" ");
            for (int i = 0; i < words.length; i++)
                if (freq.containsKey(words[i]))
                    freq.merge(words[i], 1, Integer::sum);
        }
        reader.close();
    }
    public Map<String, Integer> getFreq() { return freq; }
}
