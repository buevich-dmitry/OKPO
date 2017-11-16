package by.bsuir.buevich.messenger;

import javax.swing.*;

public class Messenger {
    public static void showInfoMessage(String message) {
        showMessage(message, "INFO", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showErrorMessage(String message) {
        showMessage(message, "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    public static void showMessage(String message, String messageTitle, int messageType) {
        JOptionPane.showMessageDialog(null, message, messageTitle, messageType);
    }
}
