package model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import java.io.InputStream;

/**
 *
 * @author Charlie
 */
public class FileProcessor {

    private String path;
    private FileHandle file;

    public FileProcessor(String fileName) {
        path = fileName;

        file = Gdx.files.local(path);

    }

    public String readFile() {
        return file.readString();
    }

    //multiple forms of save function if they are needed
    public void saveFile(String data) {
        file.writeString(data, false);
    }

    public void saveFile(InputStream dataStream) {
        file.write(dataStream, false);
    }

    public void saveFile(byte[] data) {
        file.writeBytes(data, false);
    }

}
