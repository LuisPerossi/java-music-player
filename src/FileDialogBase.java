import javax.swing.*;
import java.awt.*;
import java.io.File;

public abstract class FileDialogBase extends JDialog {
    protected JTextField titleField = new JTextField(20);
    protected JTextField authorField = new JTextField(20);

    protected JButton okButton = new JButton("OK");
    protected JButton cancelButton = new JButton("Cancel");

    public FileDialogBase(JFrame parent, File file) {
        super(parent, "Audio Information", true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Title:"));
        panel.add(titleField);

        panel.add(new JLabel("Author:"));
        panel.add(authorField);

        panel.add(okButton);
        okButton.addActionListener(e -> {
            System.out.println("Clicked!");
        });

    }
}
