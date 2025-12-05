// Author: Desmond Peter
package mentalhealthhub;

public class Main {

    public static void main(String[] args) {
        MentalHealthHub hub = new MentalHealthHub();

        // Start GUI on the Swing event thread
        javax.swing.SwingUtilities.invokeLater(() -> {
            MentalHealthHubGUI gui = new MentalHealthHubGUI(hub);
            gui.setVisible(true);
        });
    }
}
