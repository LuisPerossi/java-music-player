import javax.swing.*;
import java.io.File;

public class AddFileDialog extends FileDialogBase {
    protected File file;

    public AddFileDialog(JFrame parent, File file) {
        super(parent, file);
        this.file = file;
    }

    @Override
    public void onConfirm() {
        String title = getTitle();
        String artist = getArtist();
        int duration = 0;
        String path = file.getPath();

        //Song s = new Song(path, title, artist, duration);
    }
}
