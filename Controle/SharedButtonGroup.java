package Controle;

import javax.swing.*;


public class SharedButtonGroup {
    static Boolean isRose = false;
    static Boolean isLys = false;
    static Boolean isTuplipe = false;
    private static String selectedButton = null;

    public static String getSelectedButton() {
        return selectedButton;
    }

    public static void setSelectedButton(String buttonName) {
        selectedButton = buttonName;
    }

    public static void isSelectedButton() {
        String selectedButton = getSelectedButton();
        if (selectedButton != null) {
            String buttonName = selectedButton;
            switch (buttonName) {
                case "ChoisirRose":
                    isRose = true;
                    isLys = false;
                    isTuplipe = false;
                    break;
                case "ChoisirLys":
                    isRose = false;
                    isLys = true;
                    isTuplipe = false;
                    break;
                case "ChoisirTulipe":
                    isRose = false;
                    isLys = false;
                    isTuplipe = true;
                    break;
                default:
                    isRose = false;
                    isLys = false;
                    isTuplipe = false;
                    break;
            }
        }
    }

}
