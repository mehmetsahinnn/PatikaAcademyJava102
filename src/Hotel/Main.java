package Hotel;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TurizmAcenteSistemiGUI turizmGUI = new TurizmAcenteSistemiGUI();
            turizmGUI.setVisible(true);
        });
    }
}
