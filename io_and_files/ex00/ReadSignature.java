import java.io.FileInputStream;
import java.io.IOException;

public class ReadSignature {
    ReadSignature() {}
    static public String getSign(String path) throws IOException {
        FileInputStream fin= new FileInputStream(path);
        String sign = new String();
        int symb = -1;
        for (int j = 0; j < 3; j++) {
            symb = fin.read();
            sign = sign + Integer.toHexString(symb).toUpperCase() + " ";
        }
        symb = fin.read();
        sign = sign + Integer.toHexString(symb).toUpperCase();
        fin.close();
        return sign;
    }
}
