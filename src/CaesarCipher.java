public class CaesarCipher {
    private static final char[] ALPHABET = {
            'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м',
            'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш',
            'щ', 'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'',
            ':', '!', '?', ' '
    };

    private static final int ALPHABET_SIZE = ALPHABET.length;

    public String encrypt(String text, int shift) {
        StringBuilder encrypted = new StringBuilder();
        for (char ch : text.toCharArray()) {
            encrypted.append(shiftCharacter(ch, shift));
        }
        return encrypted.toString();
    }

    public String decrypt(String text, int shift) {
        return encrypt(text, ALPHABET_SIZE - (shift % ALPHABET_SIZE));
    }

    private char shiftCharacter(char ch, int shift) {
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (ALPHABET[i] == ch) {
                return ALPHABET[(i + shift) % ALPHABET_SIZE];
            }
        }
        return ch; // Возвращаем символ без изменений, если он не в алфавите
    }
}



/* import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

    public class CaesarCipher {

        private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
        private static final int ALPHABET_SIZE = ALPHABET.length();

        public static void main(String[] args) {
            // Пример использования
            try {
                encrypt("input.txt", "encrypted.txt", 3);
                decrypt("encrypted.txt", "decrypted.txt", 3);
                bruteForceDecrypt("encrypted.txt", "bruteforce_decrypted.txt");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void encrypt(String inputFilePath, String outputFilePath, int shift) throws IOException {
            validateFile(inputFilePath);
            shift = validateShift(shift);

            String text = Files.readString(Path.of(inputFilePath));
            StringBuilder encryptedText = new StringBuilder();

            for (char c : text.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    int newCharIndex = (c - base + shift) % ALPHABET_SIZE + base;
                    encryptedText.append((char) newCharIndex);
                } else {
                    encryptedText.append(c);
                }
            }

            Files.writeString(Path.of(outputFilePath), encryptedText.toString());
        }

        public static void decrypt(String inputFilePath, String outputFilePath, int shift) throws IOException {
            validateFile(inputFilePath);
            shift = validateShift(shift);

            String text = Files.readString(Path.of(inputFilePath));
            StringBuilder decryptedText = new StringBuilder();

            for (char c : text.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ? 'a' : 'A';
                    int newCharIndex = (c - base - shift + ALPHABET_SIZE) % ALPHABET_SIZE + base;
                    decryptedText.append((char) newCharIndex);
                } else {
                    decryptedText.append(c);
                }
            }

            Files.writeString(Path.of(outputFilePath), decryptedText.toString());
        }

        public static void bruteForceDecrypt(String inputFilePath, String outputFilePath) throws IOException {
            validateFile(inputFilePath);
            String text = Files.readString(Path.of(inputFilePath));

            StringBuilder results = new StringBuilder();

            for (int shift = 0; shift < ALPHABET_SIZE; shift++) {
                StringBuilder decryptedText = new StringBuilder();
                for (char c : text.toCharArray()) {
                    if (Character.isLetter(c)) {
                        char base = Character.isLowerCase(c) ? 'a' : 'A';
                        int newCharIndex = (c - base - shift + ALPHABET_SIZE) % ALPHABET_SIZE + base;
                        decryptedText.append((char) newCharIndex);
                    } else {
                        decryptedText.append(c);
                    }
                }
                results.append("Shift ").append(shift).append(": ").append(decryptedText.toString()).append("\n\n");
            }

            Files.writeString(Path.of(outputFilePath), results.toString());
        }



        private static void validateFile(String filePath) throws IOException {
            File file = new File(filePath);
            if (!file.exists() || !file.isFile()) {
                throw new IOException("File does not exist: " + filePath);
            }
        }

        private static int validateShift(int shift) {
            if (shift < 0) {
                throw new IllegalArgumentException("Shift must be non-negative.");
            }
            return shift % ALPHABET_SIZE;
        }
    }*/


