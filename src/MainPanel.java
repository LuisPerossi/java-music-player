import javax.swing.*;
import java.awt.BorderLayout;

public class MainPanel extends JPanel {
    private PlaylistPanel playlistPanel;
    private InformationPanel informationPanel;

    public MainPanel() {
        setLayout(new BorderLayout());
        //setBorder(BorderFactory.createTitledBorder("Main Panel"));

        informationPanel = new InformationPanel();
        playlistPanel = new PlaylistPanel(informationPanel);

        add(playlistPanel, BorderLayout.CENTER);
        add(new ToolbarPanel(playlistPanel, informationPanel), BorderLayout.NORTH);

        add(informationPanel, BorderLayout.EAST);
        add(new ControlsPanel(playlistPanel), BorderLayout.SOUTH);

        playlistPanel.refresh();
    }
}
