import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        TextProcessor processor = new TextProcessor(0, new HashMap<>());
        File path = new File("C:\\Users\\Abdul\\Documents\\test.txt");
//        String path = "C:\\Users\\Abdul\\Documents\\test.txt";
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        while(reader.readLine() != null) {
            line = reader.readLine();
            String[] stringArr = line.split(" ");
            for (String word : stringArr) {
                int length = word.length();
                Map<Integer, Integer> map = processor.getLengthOccurrence();

                processor.setWordCount(processor.getWordCount()+1);

                if(map.get(length) == null) {
                    map.put(length, map.get(length) + 1);
                }
            }

        }
    }
}
