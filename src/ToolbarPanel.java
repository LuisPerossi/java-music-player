import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public class ToolbarPanel extends JPanel {
    protected JButton addFileButton = new JButton("Add File");
    protected JButton editFileButton = new JButton("Edit File");
    protected JButton removeFileButton = new JButton("Remove File");

    protected JTextField searchField = new JTextField(10);
    protected JButton searchButton = new JButton("Search");

    protected AudioDialog dialog;

    private PlaylistPanel playlistPanel;
    private InformationPanel informationPanel;

    public ToolbarPanel(PlaylistPanel playlistPanel, InformationPanel informationPanel) {
        this.playlistPanel = playlistPanel;
        this.informationPanel = informationPanel;

        setLayout(new FlowLayout(FlowLayout.LEFT));
        //setBorder(BorderFactory.createTitledBorder("Toolbar Panel"));

        addFileButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileFilter(
                new FileNameExtensionFilter(
                        "Audio Files (*.wav)",
                        "wav"
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

        removeFileButton.addActionListener(e -> {
            Audio audio = AudioPlayer.getInstance().getCurrentAudio();

            if (audio == null) {
                JOptionPane.showMessageDialog(this,"No audio was selected!");
                return;
            } else {
                int response = JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to delete this audio?",
                        "Delete audio",
                        JOptionPane.YES_NO_OPTION
                );

                if (response == JOptionPane.YES_OPTION) {
                    AudioPlayer.getInstance().removeAudio(audio);
                    AudioPlayer.getInstance().setCurrentAudio(null);
                    playlistPanel.refresh();
                    informationPanel.refresh();
                }
            }
        });

        editFileButton.addActionListener(e -> {
            Audio audio = AudioPlayer.getInstance().getCurrentAudio();

            if (audio == null) {
                JOptionPane.showMessageDialog(this,"No audio was selected!");
                return;
            } else {
                JFrame parent = (JFrame) SwingUtilities.getWindowAncestor(this);
                dialog = new AudioDialog(parent, audio);
                dialog.open();

                if (dialog.isConfirmed()) {
                    AudioPlayer.getInstance().setCurrentAudio(null);
                    playlistPanel.refresh();
                    informationPanel.refresh();
                }
            }
        });

        searchButton.addActionListener(e -> {
            String search = searchField.getText().trim().toLowerCase();

            AudioPlayer.getInstance().setCurrentAudio(null);
            playlistPanel.refresh(search);
            informationPanel.refresh();
        });

        add(addFileButton);
        add(editFileButton);
        add(removeFileButton);

        add(searchField);
        add(searchButton);
    }
}
