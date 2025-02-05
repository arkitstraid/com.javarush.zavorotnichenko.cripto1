import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileHandler {
    public String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public void writeFile(String filePath, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        }
    }

    public void createSampleFiles() throws IOException {

        Scanner scanner = new Scanner(System.in);

            String originalText = scanner.nextLine();
            String encryptedText = "Пример";

            writeFile("src/encrypted.txt", encryptedText);
            writeFile("src/original.txt", originalText);




    }
}
