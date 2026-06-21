import javax.swing.*;
import java.awt.*;

public class InformationPanel extends JPanel {
    private JLabel titleLabel = new JLabel("Title:");
    private JLabel authorLabel = new JLabel("Author:");
    private JLabel typeLabel = new JLabel("Type:");
    private JLabel durationLabel = new JLabel("Duration:");
    private JLabel extraLabel = new JLabel("Extra:");

    public InformationPanel() {
        setBorder(BorderFactory.createTitledBorder("Audio Info"));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(140, 0));

        add(titleLabel);
        add(authorLabel);
        add(typeLabel);
        add(durationLabel);
        add(extraLabel);

        refresh();
    }

    public void refresh() {
        Audio audio = AudioPlayer.getInstance().getCurrentAudio();

        if (audio == null) {
            titleLabel.setText("No audio selected.");
            authorLabel.setText("");
            typeLabel.setText("");
            durationLabel.setText("");
            extraLabel.setText("");
        } else {
            titleLabel.setText("Title: " + audio.getTitle());
            authorLabel.setText("Author: " + audio.getAuthor());
            typeLabel.setText("Type: " + audio.getType());
            durationLabel.setText("Duration: " + audio.getFormattedDuration());

            if (audio instanceof Song) {
                extraLabel.setText("Genre: " + ((Song) audio).getGenre());
            } else if (audio instanceof Podcast) {
                extraLabel.setText("Episode: " + (((Podcast) audio).getEpisodeNumber()));
            }

        }
    }
}
