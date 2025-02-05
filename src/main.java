import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Приветствую тебя! ");
        System.out.println("Перед тобой шифр Цезаря");
        System.out.println("И если ты тут, то знаешь что делать! Смело выбирай один из пунктов.");
        System.out.println("Зашифровать текст введите цифру 1 ");
        System.out.println("Расшифровать текст введите цифру 2 ");

        Scanner console = new Scanner(System.in);
        int entry = console.nextInt();

        if (entry==1) {
            System.out.println("************************************");
            System.out.println("Вы ввели цифру 1 - Зашифровка текста");
            System.out.println("Вы можете вставить текст который нужно зашифровать в консоль или напечатать его");
            System.out.println("Введите текст и нажмите ENTER");




        FileHandler fileHandler = new FileHandler();
        CaesarCipher cipher = new CaesarCipher();

        try {
            fileHandler.createSampleFiles();
            String originalText = fileHandler.readFile("src/original.txt");

            System.out.println();
            System.out.println("Теперь укажите KEY - ключ для расшифровки текскта. Это число в деапозоне от 2 до 30 и нажмите Enter");
            int shift = console.nextInt();  //3; // Пример сдвига
            System.out.println("Вы ввели KEY: " + shift);

            String encryptedText = cipher.encrypt(originalText, shift);
            fileHandler.writeFile("src/encrypted.txt", encryptedText);
            System.out.println("Шифрование  завершено."); //и расшифрование
            System.out.println("******************************");
            System.out.println("Создан файл с зашифрованным текстом. Теперь вы можете передать его получателю, " +
                    "не переживая что сообщение попадет не в те руки=)");
            System.out.println("Не забудьте передать получателю  *KEY* - ключь для расшифровки сообщения." +
                    " Введенный ключ: "+ shift);
            System.out.println();
            System.out.println("************************");
            System.out.println("Отобразить зашифрованный текст? Если ДА введите цифру 1 ");
            int numSoutencryptedText = console.nextInt();
            if(numSoutencryptedText==1){
                System.out.println("*************************");
                System.out.println("Зашифрованный тест: " + encryptedText);
                System.out.println("Для расшифровки сообщения, перезапустите программу и выберите пункт 2");
            }else {
                System.out.println("Путь к файлу с шифром: \"src/encryptedText.txt\"");
                System.out.println("Для расшифровки сообщения, перезапустите программу и выберите пункт 2");
            }



                //String decryptedText = cipher.decrypt(encryptedText, shift);
                //fileHandler.writeFile("src/decrypted.txt", decryptedText);




        } catch (IOException e) {
            System.err.println("Ошибка работы с файлами: " + e.getMessage());
        }

        } else if (entry==2) {
            System.out.println("************************************");
            System.out.println("Вы ввели цифру 2 - Расшифровка сообщения");
            System.out.println("Вы можете вставить текст который нужно Расшифровать в консоль ");
            System.out.println("Введите текст и нажмите ENTER");

            FileHandlerDecrypted fileHandlerDecrypted = new FileHandlerDecrypted();
            CaesarCipher cipher = new CaesarCipher();

            try {
                fileHandlerDecrypted.createSampleFilesDecrypt();
                String encryptedText = fileHandlerDecrypted.readFile("src/encrypted.txt");

                System.out.println();
                System.out.println("Отлично!!!");
                System.out.println("Теперь укажите KEY - ключ для расшифровки, который вам передали вместе с шифровкой. " +
                        "Это число в деапозоне от 2 до 30 и нажмите Enter");
                int shift = console.nextInt();  //3; // Пример сдвига
                System.out.println("Вы ввели KEY: " + shift);

                //String encryptedText=console.nextLine();
                fileHandlerDecrypted.writeFile("src/encrypted.txt", encryptedText);
                System.out.println("Расшифровка  завершена."); //и расшифрование
                System.out.println("******************************");
                System.out.println("Создан файл с Расшифрованным текстом.");
                System.out.println("Ура!!");
                System.out.println("******************************");
                System.out.println("Путь к файлу: src/decrypted.txt");
                System.out.println();

                String decryptedText = cipher.decrypt(encryptedText, shift);
                fileHandlerDecrypted.writeFile("src/decrypted.txt", decryptedText);
                System.out.println("Отобразить Рашифрованный текст? Если ДА введите цифру 1 ");
                int numSoutencryptedText = console.nextInt();
                if(numSoutencryptedText==1){
                    System.out.println("**************************");
                    System.out.println("Расшифрованный тест: " + decryptedText);
                }else {
                    System.out.println("Упс... что то пошло не так. " +
                            "Программа завершилась и у нас есть время сделать себе чашечку кофе! До встречи!!");
                    System.out.println("Путь к файлу: src/decrypted.txt");
                }



            } catch (IOException e) {
                System.err.println("Ошибка работы с файлами: " + e.getMessage());
            }
        }
    }
}

/* import java.util.Scanner;

public class MainApp {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
        'и','к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
        'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public static void main(String[] args) {


        System.out.println("Перед вами шифр Цезаря");
        System.out.println("*******************************************");
        System.out.println("Если вы хотите Зашифровать текст, введите цифру 1");
        System.out.println("Если вы хотите Расшифровать текст, введите цифру 2");
        Scanner console = new Scanner(System.in);
        int entry = console.nextInt();
        if (entry == 1) {
            System.out.println("************************************");
            System.out.println("Вы ввели цифру 1 - Зашифровка текста");
            System.out.println();
            System.out.println("Давайте присвоим порядковый номер вашему текстовому сообщению! Введите цифру или число:  ");
            int number = console.nextInt();
            System.out.println("Порядковый номер зашифрованного сообщения: " + number);
            // Вводим Key
            System.out.println("Теперь укажите KEY - ключ для расшифровки текскта. Это число в деапозоне от 2 до 30");
            int key = console.nextInt();
            System.out.println("Вы ввели KEY" + key);
            System.out.println("Отлично! продолжаем");
            System.out.println("Теперь напечатайте или скопируйте текстовое сообщение которое хотите зашифровать и нажмите ввод/Enter");
            Scanner scanner = new Scanner(System.in);
            String textNumber = scanner.nextLine();


            // * Реализовать  хранение: Ключ/number - Значение/textNumber *

            System.out.println("*********************************");
            System.out.println("Вы ввели текст для зашифровки.");

            // * Реализовать хранение Значения со смещением KEY. Запись в файл  - Зашифровка *

        } else if (entry == 2) {
            System.out.println("Введите \"Ключ\" для расшифровки текста. Число в диапазоне от 2 до 30");
            //вводим key
            //Scanner console  = new Scanner(System.in);
            int keyEnter = console.nextInt();
        }
    }
}

*/







