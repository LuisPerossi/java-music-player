import javax.swing.*;

public class ControlsPanel extends JPanel {
    protected JButton previousButton = new JButton("⏮\uFE0F");
    protected JButton playButton = new JButton("▶\uFE0F");
    protected JButton pauseButton = new JButton("⏸\uFE0F");
    protected JButton nextButton = new JButton("⏭\uFE0F");

    protected JSlider timeSlider = new JSlider();
    protected JLabel songTime = new JLabel("00:00/00:00");

    public ControlsPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //setBorder(BorderFactory.createTitledBorder("Controls Panel"));

        JPanel topPanel = new JPanel();
        topPanel.add(previousButton);
        topPanel.add(playButton);
        topPanel.add(pauseButton);
        topPanel.add(nextButton);

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(timeSlider);
        bottomPanel.add(songTime);
        timeSlider.setValue(0);

        add(topPanel);
        add(bottomPanel);
    }
}
