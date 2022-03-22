import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        TextProcessor text = new TextProcessor(0, new HashMap<>(), 0, new ArrayList<>());

        File path = new File("C:\\Users\\Abdul\\Documents\\text.txt"); //PLEASE REPLACE WITH THE FILE PATH/DIRECTORY OF YOUR OWN TEXT FILE

        BufferedReader reader = new BufferedReader(new FileReader(path));

        String line;
        while((line = reader.readLine()) != null) {
            if (line.length() > 0) {
                String[] stringArr = line.split("[ .]+");

                Map<Integer, Integer> map = text.getWordLengths();
                for (String word : stringArr) {
                    int length = word.length();

                    text.setWordCount(text.getWordCount() + 1);

                    if(map.containsKey(length)) {
                        map.put(length, map.get(length) + 1);
                    } else {
                        map.put(length, 1);
                    }
                }
            }
        }

        text.fillCommonWordsAndCommonLength();

        String lengths = "";

        for (int i=0; i<text.getCommonWords().size(); i++) {
            if(lengths == "") {
                lengths += Integer.toString(text.getCommonWords().get(i));
            } else {
                lengths += " & " + text.getCommonWords().get(i);
            }
        }

        Map<Integer, Integer> sortedMap = new TreeMap<>(text.getWordLengths());

        DecimalFormat df = new DecimalFormat("0.000");

        System.out.println("Word count = " + text.getWordCount());
        System.out.println("Average word length = " + df.format(text.getAverageWordLength()));
        for (Map.Entry<Integer, Integer> length : sortedMap.entrySet()) {
            System.out.println("Number of words of length " + length.getKey() + " is " + length.getValue());
        }
        System.out.println("The most frequently occurring word length is " + text.getCommonLengths() + ", for word lengths of " + lengths);
    }
}
