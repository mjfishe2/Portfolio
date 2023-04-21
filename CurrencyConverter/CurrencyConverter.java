/**
 * Converts between currency.
 * <p>
 * Converts currency between the 10 most traded currency in the world.
 * Uses switch cases to select current currency and another switch case
 * to select currency being converted to.
 *</p>
 * @author Dylan Tran, Mathew Fisher, Thanh Du,
 * @version 1.0
 * @since 3/28/2023
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class CurrencyConverter {
    private static final String[] codes = {null, "USD", "EUR", "JPY", "GBP", "CNY", "AUD", "CAD", "CHF", "HKD", "NZD"};

    public static void main(String[] args) {
        class GUI extends JFrame implements ActionListener, Serializable {
            private JLabel amountLabel, fromLabel, toLabel, resultLabel, conversionLogLabel;
            private JTextField amountField;
            private JComboBox < String > fromComboBox, toComboBox;
            private JButton convertButton;
            private JTextArea conversionLog;
            private double[] exchangeRates = {
                    1.0,
                    0.83,
                    0.72,
                    1.30,
                    1.25,
                    109.40,
                    6.57
            };

            public GUI() {
                setTitle("Caucasians Currency Converter");
                setSize(500, 500);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLocationRelativeTo(null);
                amountLabel = new JLabel("Amount:");
                fromLabel = new JLabel("From:");
                toLabel = new JLabel("To:");
                amountField = new JTextField(10);
                fromComboBox = new JComboBox < String > (codes);
                toComboBox = new JComboBox < String > (codes);
                convertButton = new JButton("Convert");
                convertButton.addActionListener(this);
                resultLabel = new JLabel("Result:");
                conversionLogLabel = new JLabel("Conversion Log:");
                conversionLog = new JTextArea(10, 30);
                conversionLog.setEditable(false);

                JPanel UIPanel = new JPanel(new GridLayout(5, 2));
                UIPanel.add(amountLabel);
                UIPanel.add(amountField);
                UIPanel.add(fromLabel);
                UIPanel.add(fromComboBox);
                UIPanel.add(toLabel);
                UIPanel.add(toComboBox);
                UIPanel.add(convertButton);
                UIPanel.add(resultLabel);
                UIPanel.add(conversionLogLabel);

                JScrollPane scrollPane = new JScrollPane(conversionLog);
                UIPanel.add(scrollPane);

                add(UIPanel);
                setVisible(true);
            }
            public void DisplaySavedData() {
                try {
                    FileInputStream fileIn = new FileInputStream("Currency.ser");
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    GUI savedGUI = (GUI) in.readObject();
                    in.close();
                    fileIn.close();
                    amountField.setText(savedGUI.amountField.getText());
                    fromComboBox.setSelectedIndex(savedGUI.fromComboBox.getSelectedIndex());
                    toComboBox.setSelectedIndex(savedGUI.toComboBox.getSelectedIndex());
                    conversionLog.setText(savedGUI.conversionLog.getText());
                } catch (IOException | ClassNotFoundException i) {
                    i.printStackTrace();
                    return;
                }
            }

            public void saveToFile() {
                try {
                    // create output stream to write objects to file
                    FileOutputStream fos = new FileOutputStream("Currency.ser");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);

                    // write the GUI object to file
                    oos.writeObject(this);

                    // close the output streams
                    oos.close();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == convertButton) {
                    try {
                        double amount = Double.parseDouble(amountField.getText());
                        int fromIndex = fromComboBox.getSelectedIndex();
                        int toIndex = toComboBox.getSelectedIndex();

                        double result = amount * exchangeRates[toIndex];
                        resultLabel.setText(String.format("Result: %.2f %s", result, toComboBox.getSelectedItem()));
                        String conversion = String.format("%.2f %s converted to %s is %.2f %s\n", amount, fromComboBox.getSelectedItem(), toComboBox.getSelectedItem(), result, toComboBox.getSelectedItem());
                        conversionLog.append(conversion);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
                        saveToFile();
                    }

                }

            }
        }
        GUI gui = new GUI();
        gui.DisplaySavedData();
        gui.isDisplayable();

    }
            public static String getUSDCurrency(double amount) {
                int code = initialSetUp();
                switch (code) {
                    case 1:
                        break;
                    case 2:
                        amount *= .92202;
                        break;
                    case 3:
                        amount *= 132.775;
                        break;
                    case 4:
                        amount *= .81;
                        break;
                    case 5:
                        amount *= 6.8744;
                        break;
                    case 6:
                        amount *= 1.49589;
                        break;
                    case 7:
                        amount *= 1.35188;
                        break;
                    case 8:
                        amount *= .914;
                        break;
                    case 9:
                        amount *= 7.849;
                        break;
                    case 10:
                        amount *= 1.597;
                        break;
                }
                return String.format("%,.2f %s", amount, codes[code]);
            }

            public static String getEURCurrency(double amount) {
                int code = initialSetUp();
                switch (code) {
                    case 1:
                        amount *= 1 / .92202;
                    case 2:
                        break;
                    case 3:
                        amount *= 144.229;
                        break;
                    case 4:
                        amount *= .88;
                        break;
                    case 5:
                        amount *= 7.467157;
                        break;
                    case 6:
                        amount *= 1.625467;
                        break;
                    case 7:
                        amount *= 1.46968;
                        break;
                    case 8:
                        amount *= .994561;
                        break;
                    case 9:
                        amount *= 8.52813;
                        break;
                    case 10:
                        amount *= 1.737157;
                        break;
                }
                return String.format("%,.2f %s", amount, codes[code]);
            }

            public static String getJPYCurrency(double amount) {
                int code = initialSetUp();
                switch (code) {
                    case 1:
                        amount *= 1 / 132.775;
                        break;
                    case 2:
                        amount *= 1 / 144.229;
                        break;
                    case 3:
                        break;
                    case 4:
                        amount *= 0.00609;
                        break;
                    case 5:
                        amount *= 0.051939;
                        break;
                    case 6:
                        amount *= 0.011184;
                        break;
                    case 7:
                        amount *= 0.010156;
                        break;
                    case 8:
                        amount *= 0.006874;
                        break;
                    case 9:
                        amount *= 0.058907;
                        break;
                    case 10:
                        amount *= 0.012;
                        break;
                }
                return String.format("%,.2f %s", amount, codes[code]);
            }

            public static String getGBPCurrency(double amount) {
                int code = initialSetUp();
                switch (code) {
                    case 1:
                        amount *= 1 / .81;
                        break;
                    case 2:
                        amount *= 1 / .88;
                        break;
                    case 3:
                        amount *= 1 / 0.00609;
                        break;
                    case 4:
                        break;
                    case 5:
                        amount *= 8.46604;
                        break;
                    case 6:
                        amount *= 1.826637;
                        break;
                    case 7:
                        amount *= 1.6669;
                        break;
                    case 8:
                        amount *= 1.129995;
                        break;
                    case 9:
                        amount *= 9.725392;
                        break;
                    case 10:
                        amount *= 1.97386;
                        break;
                }
                return String.format("%,.2f %s", amount, codes[code]);
            }

            public static String getCNYCurrency(double amount) {
                int code = initialSetUp();
                switch (code) {
                    case 1:
                        amount *= 1 / 6.8744;
                        break;
                    case 2:
                        amount *= 1 / 7.467157;
                        break;
                    case 3:
                        amount *= 1 / .051939;
                        break;
                    case 4:
                        amount *= 1 / 8.46604;
                        break;
                    case 5:
                        break;
                    case 6:
                        amount *= 0.214283;
                        break;
                    case 7:
                        amount *= 0.195257;
                        break;
                    case 8:
                        amount *= 0.132686;
                        break;
                    case 9:
                        amount *= 7.849;
                        break;
                    case 10:
                        amount *= 1.597;
                        break;
                }
                return String.format("%,.2f %s", amount, codes[code]);
            }

            public static String getAUDCurrency(double amount) {
                int code = initialSetUp();
                switch (code) {
                    case 1:
                        amount *= 1 / 1.49589;
                        break;
                    case 2:
                        amount *= 1 / 1.625467;
                        break;
                    case 3:
                        amount *= 1 / .011184;
                        break;
                    case 4:
                        amount *= 1 / 1.826637;
                        break;
                    case 5:
                        amount *= 1 / .214283;
                        break;
                    case 6:
                        break;
                    case 7:
                        amount *= 0.911778;
                        break;
                    case 8:
                        amount *= 0.619454;
                        break;
                    case 9:
                        amount *= 5.32717;
                        break;
                    case 10:
                        amount *= 1.0772;
                        break;
                }
                return String.format("%,.2f %s", amount, codes[code]);
            }

            public static String getCADCurrency(double amount) {
                int code = initialSetUp();
                switch (code) {
                    case 1:
                        amount *= 1 / 1.35188;
                        break;
                    case 2:
                        amount *= 1 / 1.46968;
                        break;
                    case 3:
                        amount *= 1 / .010156;
                        break;
                    case 4:
                        amount *= 1 / 1.6669;
                        break;
                    case 5:
                        amount *= 1 / .195257;
                        break;
                    case 6:
                        amount *= 1 / .911778;
                        break;
                    case 7:
                        break;
                    case 8:
                        amount *= .679329;
                        break;
                    case 9:
                        amount *= 5.84308;
                        break;
                    case 10:
                        amount *= 1.18137;
                        break;
                }
                return String.format("%,.2f %s", amount, codes[code]);
            }

            public static String getCHFCurrency(double amount) {
                int code = initialSetUp();
                switch (code) {
                    case 1:
                        amount *= 1 / 0.914;
                        break;
                    case 2:
                        amount *= 1 / 0.994561;
                        break;
                    case 3:
                        amount *= 1 / 0.006874;
                        break;
                    case 4:
                        amount *= 1 / 1.129995;
                        break;
                    case 5:
                        amount *= 1 / 0.132686;
                        break;
                    case 6:
                        amount *= 1 / 0.619454;
                        break;
                    case 7:
                        amount *= 1 / .679329;
                        break;
                    case 8:
                        break;
                    case 9:
                        amount *= 8.60108;
                        break;
                    case 10:
                        amount *= 1.73906;
                        break;
                }
                return String.format("%,.2f %s", amount, codes[code]);
            }

            public static String getHKDCurrency(double amount) {
                int code = initialSetUp();
                switch (code) {
                    case 1:
                        amount *= 1 / 7.849;
                        break;
                    case 2:
                        amount *= 1 / 8.52813;
                        break;
                    case 3:
                        amount *= 1 / 0.058907;
                        break;
                    case 4:
                        amount *= 1 / 9.725392;
                        break;
                    case 5:
                        amount *= 1 / 7.849;
                        break;
                    case 6:
                        amount *= 1 / 5.32717;
                        break;
                    case 7:
                        amount *= 1 / 5.84308;
                        break;
                    case 8:
                        amount *= 8.60108;
                        break;
                    case 9:
                        break;
                    case 10:
                        amount *= 0.202206;
                        break;
                }
                return String.format("%,.2f %s", amount, codes[code]);
            }

            public static String getNZDCurrency(double amount) {
                int code = initialSetUp();
                switch (code) {
                    case 1:
                        amount *= 1 / 1.597;
                        break;
                    case 2:
                        amount *= 1 / 1.737157;
                        break;
                    case 3:
                        amount *= 1 / .012;
                        break;
                    case 4:
                        amount *= 1 / 1.97386;
                        break;
                    case 5:
                        amount *= 1 / 1.597;
                        break;
                    case 6:
                        amount *= 1 / 1.0772;
                        break;
                    case 7:
                        amount *= 1 / 1.18137;
                        break;
                    case 8:
                        amount *= 1 / 1.73906;
                        break;
                    case 9:
                        amount *= 1 / 0.202206;
                        break;
                    case 10:
                        break;
                }
                return String.format("%,.2f %s", amount, codes[code]);
            }

            public static int initialSetUp() {
                String question = JOptionPane.showInputDialog("""
                        Enter currency being converted to(three letter code):
                         USD - US Dollar
                         EUR - Euro
                         JPY - Yen
                         GBP - British Pound Sterling
                         CNY - Yuan
                         AUD - Australian Dollar
                         CAD - Canadian Dollar
                         CHF - Swiss Franc
                         HKD - Hong Kong Dollar
                         NZD - New Zealand Dollar""").toUpperCase();
                int usedCode = 0;
                for (int i = 1; i < codes.length; i++) {
                    if (codes[i].equals(question))
                        usedCode = i;
                }
                return usedCode;

            }
        }



