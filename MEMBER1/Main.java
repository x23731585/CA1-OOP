/**
 *
 * @author kingd
 */

package MEMBER1;

import APP.HealthFitnessUI;
import APP.Screen;

public class Main {

    public static void main(String[] args) {

        // Start Swing GUI on the Event Dispatch Thread
        javax.swing.SwingUtilities.invokeLater(() -> {

            // Launch your main Home UI (HealthFitnessUI)
            HealthFitnessUI home = new HealthFitnessUI();

            // Show it using your existing Screen.show() system
            Screen.show(home, "Fitness & Nutrition");
        });
    }
}


