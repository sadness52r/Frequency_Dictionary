import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DictionaryController {
    private final HashMap<Character, Integer> frequencies;

    DictionaryController(){
        frequencies = new HashMap<>();
    }

    public void CountLetterFrequencies(File file) throws FileNotFoundException {
         try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
                String line;
                while ((line = bufferedReader.readLine()) != null){
                    for (char i = 0; i < line.length(); i++){
                        if (line.charAt(i) >= 'A' && line.charAt(i) <= 'Z' || line.charAt(i) >= 'a' && line.charAt(i) <= 'z'){
                            if (!frequencies.containsKey(line.charAt(i))){
                                frequencies.put(line.charAt(i), 1);
                            }
                            else{
                                frequencies.put(line.charAt(i), frequencies.get(line.charAt(i)) + 1);
                            }
                        }
                    }
                }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public void WriteToFile(File file) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
            for (Map.Entry entry: frequencies.entrySet()) {
                bufferedWriter.write(entry.toString() + "\n");
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
