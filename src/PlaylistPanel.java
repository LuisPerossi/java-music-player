import javax.swing.*;
import java.awt.*;

public class PlaylistPanel extends JPanel {
    private DefaultListModel<Audio> listModel = new DefaultListModel<>();
    private JList<Audio> audioList = new JList<>(listModel);

    private InformationPanel informationPanel;

    public PlaylistPanel(InformationPanel informationPanel) {
        this.informationPanel = informationPanel;

        setBorder(BorderFactory.createTitledBorder("Audio List"));
        setLayout(new BorderLayout());

        audioList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                AudioPlayer.getInstance().setCurrentAudio(audioList.getSelectedValue());
                informationPanel.refresh();
            }
        });

        add(new JScrollPane(audioList));
    }

    public void refresh() {
        listModel.clear();

        for (Audio a : AudioPlayer.getInstance().getPlaylist()) {
            listModel.addElement(a);
        }
    }

    public void refresh(String search) {
        listModel.clear();
        search = search.toLowerCase();

        for (Audio a : AudioPlayer.getInstance().getPlaylist()) {
            String title = a.getTitle().toLowerCase();
            String author = a.getAuthor().toLowerCase();

            if (title.contains(search) || author.contains(search)) {
                listModel.addElement(a);
            }
        }
    }

    public void selectAudio(Audio audio) {
        audioList.setSelectedValue(audio, true);
    }
}
