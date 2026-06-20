import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public class ToolbarPanel extends JPanel {
    protected JButton addFileButton = new JButton("Add File");
    protected JButton editFileButton = new JButton("Edit File");
    protected JButton removeFileButton = new JButton("Remove File");

    protected AudioDialog dialog;

    private PlaylistPanel playlistPanel;

    public ToolbarPanel(PlaylistPanel playlistPanel) {
        this.playlistPanel = playlistPanel;

        setLayout(new FlowLayout(FlowLayout.LEFT));
        //setBorder(BorderFactory.createTitledBorder("Toolbar Panel"));

        addFileButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileFilter(
                new FileNameExtensionFilter(
                        "Audio Files (*.mp3, *.wav)",
                        "mp3", "wav"
                )
            );

            chooser.showOpenDialog(null);
            File file = chooser.getSelectedFile();

            if (file == null) { return; }

            JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
            dialog = new AudioDialog(parent, file);
            dialog.open();

            if (dialog.isConfirmed()) {
                AudioPlayer.getInstance().addAudio(dialog.getAudio());
                playlistPanel.refresh();
            }
        });

        add(addFileButton);
        add(editFileButton);
        add(removeFileButton);
    }
}
