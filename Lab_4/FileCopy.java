import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        String sourcePath = "source.txt";
        String destPath = "dest.txt";

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(sourcePath);
            fos = new FileOutputStream(destPath);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("Копирование успешно завершено.");

        } catch (FileNotFoundException e) {
            System.out.println("Критическая ошибка открытия: Файл не найден или отказано в доступе (" + e.getMessage() + ")");
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода в процессе копирования: " + e.getMessage());
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    System.out.println("Ошибка при закрытии исходного файла source.txt: " + e.getMessage());
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    System.out.println("Ошибка при закрытии целевого файла dest.txt: " + e.getMessage());
                }
            }
        }
    }
}