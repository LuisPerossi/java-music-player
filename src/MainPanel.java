import javax.swing.*;
import java.awt.BorderLayout;

public class MainPanel extends JPanel {
    public MainPanel() {
        setLayout(new BorderLayout());
        //setBorder(BorderFactory.createTitledBorder("Main Panel"));

        add(new ToolbarPanel(), BorderLayout.NORTH);
        add(new PlaylistPanel(), BorderLayout.CENTER);
        add(new InformationPanel(), BorderLayout.EAST);
        add(new ControlsPanel(), BorderLayout.SOUTH);
    }
}
