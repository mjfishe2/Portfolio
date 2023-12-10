import javax.swing.*;

public class AppLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //display weather app gui
                new WeatherAppGUI().setVisible(true);
               //System.out.println(WeatherApp.getLocationData("Berlin"));

              // System.out.println(WeatherApp.getCurrentTime());
            }
        });
    }
}
