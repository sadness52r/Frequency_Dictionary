import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileController {
    private File file;

    public File getFile(){
        return file;
    }
    public String getFileName(){
        return file.getName();
    }

    FileController(File file) throws IOException {
        if (!file.canRead()){
            throw new IOException("This file cannot be read!");
        }
        else if (!file.exists()) {
            throw new FileNotFoundException("This file is not exist!");
        }
        this.file = file;
    }
}
