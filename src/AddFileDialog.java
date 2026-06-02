import javax.swing.*;
import java.awt.*;
import java.io.File;

public class AddFileDialog extends JDialog {
    private JTextField titleField = new JTextField(20);
    private JTextField authorField = new JTextField(20);
    private Boolean confirmed = false;

    public AddFileDialog(JFrame parent, File file) {
        super(parent, "Audio Information", true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(new JLabel("Title:"));
        panel.add(titleField);

        panel.add(new JLabel("Author:"));
        panel.add(authorField);

        JButton ok = new JButton("OK");
        JButton cancel = new JButton("Cancel");

        ok.addActionListener(e -> {
            confirmed = true;
            System.out.println(titleField.getText() + authorField.getText());
            dispose();
        });

        cancel.addActionListener(e -> {
            confirmed = false;
            dispose();
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        buttonPanel.add(ok);
        buttonPanel.add(Box.createHorizontalStrut(10));
        buttonPanel.add(cancel);

        panel.add(buttonPanel);

        setContentPane(panel);
        setLocationRelativeTo(parent);
        pack();
    }
}
