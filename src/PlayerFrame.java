import javax.swing.*;

public class PlayerFrame extends JFrame {
    public PlayerFrame() {
        setTitle("Audio Player");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        add(new MainPanel());
    }
}
