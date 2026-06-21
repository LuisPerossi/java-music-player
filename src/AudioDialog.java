import javax.swing.*;
import java.awt.*;
import java.io.File;

public class AudioDialog extends JDialog{
    private JTextField titleField = new JTextField(20);
    private JTextField authorField = new JTextField(20);

    private String[] options = { "Song", "Podcast" };
    private JComboBox<String> typeField = new JComboBox<>(options);

    private JLabel extraLabel = new JLabel("Genre:");
    private JTextField extraField = new JTextField();

    private JButton okButton = new JButton("Ok");
    private JButton cancelButton = new JButton("Cancel");

    private boolean confirmed = false;
    private File file;

    private Audio audio;
    private Audio editingAudio;

    public AudioDialog(JFrame parent, File file) {
        super(parent, "Audio Information", true);
        this.file = file;

        JPanel form = new JPanel();
        form.setLayout(new GridLayout(0, 2, 5, 5));

        form.add(new JLabel("Title:"));
        form.add(titleField);

        form.add(new JLabel("Author:"));
        form.add(authorField);

        form.add(new JLabel("Type:"));
        form.add(typeField);

        form.add(extraLabel);
        form.add(extraField);

        typeField.addActionListener(e -> {
            if (typeField.getSelectedItem().equals("Song")) {
                extraLabel.setText("Genre:");
            } else {
                extraLabel.setText("Episode:");
            }
        });

        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout());

        buttons.add(okButton);
        buttons.add(cancelButton);

        okButton.addActionListener(e -> {
            String title = titleField.getText();
            String author = authorField.getText();
            String path = file.getAbsolutePath();
            String extra = extraField.getText();

            if (title.trim().isEmpty() || author.trim().isEmpty() || extra.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields!");
                return;
            }

            if (typeField.getSelectedItem().equals("Song")) {
                String genre = extraField.getText();

                audio = new Song(title, author, path, genre);
            } else {
                try {
                    int episodeNumber = Integer.parseInt(extraField.getText());
                    audio = new Podcast(title, author, path, episodeNumber);
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(this, "Episode must be a number!");
                    return;
                }
            }

            confirmed = true;
            dispose();
        });

        cancelButton.addActionListener(e -> {
            confirmed = false;
            dispose();
        });

        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS));

        wrapper.add(form);
        wrapper.add(buttons);

        setResizable(false);
        setContentPane(wrapper);
        pack();
        setLocationRelativeTo(parent);
    }

    //construtor para edições
    public AudioDialog(JFrame parent, Audio audio) {
        super(parent, "Audio Information", true);
        this.audio = audio;

        JPanel form = new JPanel();
        form.setLayout(new GridLayout(0, 2, 5, 5));

        form.add(new JLabel("Title:"));
        form.add(titleField);
        titleField.setText(audio.getTitle());

        form.add(new JLabel("Author:"));
        form.add(authorField);
        authorField.setText(audio.getAuthor());

        form.add(new JLabel("Type:"));
        form.add(typeField);
        typeField.setSelectedItem(audio.getType());

        form.add(extraLabel);
        form.add(extraField);

        if (audio instanceof Song) {
            extraLabel.setText("Genre:");
            extraField.setText(((Song) audio).getGenre());
        } else if (audio instanceof Podcast) {
            extraLabel.setText("Episode:");
            extraField.setText(String.valueOf(((Podcast) audio).getEpisodeNumber()));
        }

        typeField.setEnabled(false);

        JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout());

        buttons.add(okButton);
        buttons.add(cancelButton);

        okButton.addActionListener(e -> {
            String title = titleField.getText();
            String author = authorField.getText();
            String extra = extraField.getText();

            if (title.trim().isEmpty() || author.trim().isEmpty() || extra.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields!");
                return;
            }

            audio.setTitle(title);
            audio.setAuthor(author);

            if (audio instanceof Song) {
                String genre = extraField.getText();
                ((Song) audio).setGenre(genre);
            } else if (audio instanceof Podcast) {
                try {
                    int episodeNumber = Integer.parseInt(extraField.getText());
                    ((Podcast) audio).setEpisodeNumber(episodeNumber);
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(this, "Episode must be a number!");
                    return;
                }
            }

            AudioPlayer.getInstance().savePlaylist();
            confirmed = true;
            dispose();
        });

        cancelButton.addActionListener(e -> {
            confirmed = false;
            dispose();
        });

        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS));

        wrapper.add(form);
        wrapper.add(buttons);

        setResizable(false);
        setContentPane(wrapper);
        pack();
        setLocationRelativeTo(parent);
    }


    public boolean isConfirmed() {
        return confirmed;
    }

    public Audio getAudio() {
        return audio;
    }

    public void open() {
        setVisible(true);
    }
}
