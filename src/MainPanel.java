import javax.swing.*;
import java.awt.BorderLayout;

public class MainPanel extends JPanel {
    private PlaylistPanel playlistPanel;

    public MainPanel() {
        setLayout(new BorderLayout());
        //setBorder(BorderFactory.createTitledBorder("Main Panel"));

        //criando o playlist separadamente para passar pro toolbar (por causa do refresh)
        playlistPanel = new PlaylistPanel();

        add(playlistPanel, BorderLayout.CENTER);
        add(new ToolbarPanel(playlistPanel), BorderLayout.NORTH);
        add(new InformationPanel(), BorderLayout.EAST);
        add(new ControlsPanel(), BorderLayout.SOUTH);
    }
}
