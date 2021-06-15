import java.io.FileReader;

public class Program {
    public static final String resultPath = "./dictionary.txt";
    public static void main(String[] args) {
        if (args.length != 2)
        {
            System.err.println("Wrong arguments");
            return;
        }
        try
        {
            WriteFile dictionaryContainer = new WriteFile(resultPath);
            Dictionary dict = new Dictionary(new FileReader(args[0]), new FileReader(args[1]));
            CountWords WordsFreqFile1 = new CountWords(new FileReader(args[0]), dict.getDictionary());
            CountWords WordsFreqFile2 = new CountWords(new FileReader(args[1]), dict.getDictionary());
            dictionaryContainer.WriteToFile(WordsFreqFile1.getFreq().keySet().toString());
            dictionaryContainer.close();
            if (WordsFreqFile1.getFreq().size() != 0 && WordsFreqFile2.getFreq().size() != 0)
                countSimilarity(WordsFreqFile1, WordsFreqFile2);
            else
                System.out.println("Similarity = 0");
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
    }
    public static void countSimilarity(CountWords f1, CountWords f2)
    {
        int numerator = 0;
        int denominator1 = 0;
        int denominator2 = 0;
        for (String key : f1.getFreq().keySet()) {
            numerator += f1.getFreq().get(key) * f2.getFreq().get(key);
            denominator1 += f1.getFreq().get(key) * f1.getFreq().get(key);
            denominator2 += f2.getFreq().get(key) * f2.getFreq().get(key);
        }
        double resultDenominator = Math.sqrt(denominator1) * Math.sqrt(denominator2);
        System.out.println("Similarity = " + Math.floor((numerator / resultDenominator) * 100) / 100);
    }
}
