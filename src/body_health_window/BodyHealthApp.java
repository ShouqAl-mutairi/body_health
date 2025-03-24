package body_health_window;

public class BodyHealthApp {

    public static void main(String[] args) {
        try {
            WelcomeWindow f1 = new WelcomeWindow();
        } catch (CustomException ex) {
            System.out.println("An error occurred : " + ex.getMessage());
        } 
    }
}
