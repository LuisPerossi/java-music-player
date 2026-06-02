import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PlaylistPanel extends JPanel {
    public PlaylistPanel() {
        setBorder(BorderFactory.createTitledBorder("My Songs"));
        setLayout(new BorderLayout());

        String[] columns = { "Title", "Author", "Genre", "Duration" };
        DefaultTableModel model = new DefaultTableModel(columns, 0);

        JTable table = new JTable(model);
        table.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }
}
