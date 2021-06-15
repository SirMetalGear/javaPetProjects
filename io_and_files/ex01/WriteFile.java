import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFile {
    private FileOutputStream file;
    WriteFile(String resultPath) throws IOException {
        file = new FileOutputStream(resultPath);
    }
    public void WriteToFile(String content) throws IOException {
        byte[] buffer = content.getBytes();
        file.write(buffer, 0, buffer.length);
        file.write('\n');
    }
    public void close() throws IOException { file.close(); }
}
