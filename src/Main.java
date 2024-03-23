import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter input filename: ");
            FileController inFile = new FileController(new File(scanner.next()));
            //File inFile = new File(scanner.next());

            System.out.println("Enter output filename: ");
            FileController outFile = new FileController(new File(scanner.next()));
            //File outFile = new File(scanner.next());

            DictionaryController dictionaryController = new DictionaryController();
            dictionaryController.CountLetterFrequencies(inFile.getFile());
            dictionaryController.WriteToFile(outFile.getFile());
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}