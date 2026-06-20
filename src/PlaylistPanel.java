import javax.swing.*;
import java.awt.*;

public class PlaylistPanel extends JPanel {
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> audioList = new JList<>(listModel);

    public PlaylistPanel() {
        setBorder(BorderFactory.createTitledBorder("Audio List"));
        setLayout(new BorderLayout());

        add(new JScrollPane(audioList));
    }

    public void refresh() {
        listModel.clear();

        for (Audio a : AudioPlayer.getInstance().getPlaylist()) {
            listModel.addElement(a.getDisplayName());
        }
    }


}
