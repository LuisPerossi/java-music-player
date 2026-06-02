import javax.swing.*;
import java.awt.*;
import java.io.File;

public abstract class FileDialogBase extends JDialog {
    protected JTextField titleField = new JTextField(20);
    protected JTextField authorField = new JTextField(20);

    protected JButton okButton = new JButton("OK");
    protected JButton cancelButton = new JButton("Cancel");

    protected Boolean confirmed = false;

    public FileDialogBase(JFrame parent, File file) {
        super(parent, "Audio Information", true);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2, 0, 2));

        inputPanel.add(new JLabel("Title:"));
        inputPanel.add(titleField);

        inputPanel.add(new JLabel("Author:"));
        inputPanel.add(authorField);


        okButton.addActionListener(e -> {
            confirmed = true;
            onConfirm();
            dispose();
        });

        cancelButton.addActionListener(e -> {
            confirmed = false;
            dispose();
        });

        JPanel buttonPanel = new JPanel();


        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        JPanel wrapperPanel = new JPanel();
        wrapperPanel.setLayout(new BoxLayout(wrapperPanel, BoxLayout.Y_AXIS));
        wrapperPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        wrapperPanel.add(inputPanel);
        wrapperPanel.add(buttonPanel);

        setResizable(false);
        setContentPane(wrapperPanel);
        pack();
        setLocationRelativeTo(parent);
    }

    abstract void onConfirm();

    public Boolean isConfirmed() {
        return confirmed;
    }

    public void open() {
        setVisible(true);
    }

    public String getTitle() {
        return titleField.getText();
    }

    public String getAuthor() {
        return authorField.getText();
    }

}
