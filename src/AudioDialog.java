import javax.swing.*;

public class AudioDialog extends JDialog{
    protected JTextField fileField = new JTextField(20);
    protected JTextField authorField = new JTextField(20);
    protected JTextField typeField = new JTextField(20);
    protected JTextField extraField = new JTextField(20);

    protected JButton okButton = new JButton("Ok");
    protected JButton cancelButton = new JButton("Cancel");
}
