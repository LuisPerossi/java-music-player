import javax.swing.*;
import java.awt.*;

public class ToolbarPanel extends JPanel {
    protected JButton addFileButton = new JButton("Add File");
    protected JButton editFileButton = new JButton("Edit File");
    protected JButton removeFileButton = new JButton("Remove File");

    public ToolbarPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        //setBorder(BorderFactory.createTitledBorder("Toolbar Panel"));

        add(addFileButton);
        add(editFileButton);
        add(removeFileButton);
    }
}
