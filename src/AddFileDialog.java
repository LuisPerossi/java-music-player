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
        System.out.println(file + getAuthor() + getTitle());
    }
}
