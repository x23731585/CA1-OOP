package mentalhealthhub;

/*
 * Simple main class to launch the Mental Health Hub menu
 */
public class TestMentalHealthHub {

    // static so all forms can share the same data
    public static MentalHealthHub hub = new MentalHealthHub();

    public static void main(String[] args) {
        MentalHealthMenu menu = new MentalHealthMenu();
        menu.setVisible(true);
    }
}
