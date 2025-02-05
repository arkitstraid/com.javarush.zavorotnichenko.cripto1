import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileHandlerDecrypted {


        public String readFile(String filePath) throws IOException {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        }

        public void writeFile(String filePath, String content) throws IOException {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write(content);
            }
        }

        public void createSampleFilesDecrypt() throws IOException {

            Scanner scanner = new Scanner(System.in);

            //String originalText = "Пример";
            String encryptedText = scanner.nextLine();
            writeFile("src/encrypted.txt", encryptedText);
           // writeFile("src/original.txt", originalText);



        }
    }


