/**
 * Converts between currency.
 * <p>
 * Converts currency between the 10 most traded currency in the world.
 * Uses switch cases to select current currency and another switch case
 * to select currency being converted to.
 * </p>
 *
 * @author Dylan Tran, Mathew Fisher, Thanh Du,
 * @version 1.0
 * @since 3/28/2023
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverter {
    private static final String[] codes = {null, "USD", "EUR", "JPY", "GBP", "CNY", "AUD", "CAD", "CHF", "HKD", "NZD"};

    public static void main(String[] args) {
        class GUI extends JFrame implements ActionListener {
            private JLabel amountLabel, fromLabel, toLabel, resultLabel, conversionLogLabel;
            private JTextField amountField;
            private JComboBox<String> fromComboBox, toComboBox;
            private JButton convertButton;
            private JTextArea conversionLog;

            public GUI() {
                setTitle("Caucasians Currency Converter");
                setSize(500, 300);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLocationRelativeTo(null);

                amountLabel = new JLabel("Amount:");
                fromLabel = new JLabel("From:");
                toLabel = new JLabel("To:");
                amountField = new JTextField(10);
                fromComboBox = new JComboBox<String>(codes);
                toComboBox = new JComboBox<String>(codes);
                convertButton = new JButton("Convert");
                convertButton.addActionListener(this);
                resultLabel = new JLabel("Result:");
                conversionLogLabel = new JLabel("Conversion Log:");
                conversionLog = new JTextArea(10,30);
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


            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == convertButton) {
                    try {
                        double amount = Double.parseDouble(amountField.getText());
                        int fromIndex = fromComboBox.getSelectedIndex();
                        int toIndex = toComboBox.getSelectedIndex();
                        double result = 0;

                        // uses fromComboBox index to determine which currency is being converted from.
                        switch (fromIndex) {
                            case 1:
                                result = getUSDCurrency(amount, toIndex);
                                break;
                            case 2:
                                result = getEURCurrency(amount, toIndex);
                                break;
                            case 3:
                                result = getJPYCurrency(amount, toIndex);
                                break;
                            case 4:
                                result = getGBPCurrency(amount, toIndex);
                                break;
                            case 5:
                                result = getCNYCurrency(amount, toIndex);
                                break;
                            case 6:
                                result = getAUDCurrency(amount, toIndex);
                                break;
                            case 7:
                                result = getCADCurrency(amount, toIndex);
                                break;
                            case 8:
                                result = getCHFCurrency(amount, toIndex);
                                break;
                            case 9:
                                result = getHKDCurrency(amount, toIndex);
                                break;
                            case 10:
                                result = getNZDCurrency(amount, toIndex);
                                break;
                        }

                        resultLabel.setText(String.format("Result: %.2f %s", result, toComboBox.getSelectedItem()));
                        String conversion = String.format("%.2f %s converted to %s is %.2f %s\n", amount, fromComboBox.getSelectedItem(), toComboBox.getSelectedItem(), result, toComboBox.getSelectedItem());
                        conversionLog.append(conversion);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }
        }

        GUI currencyGUI = new GUI();
        currencyGUI.isDisplayable();
    }

    /**
     * Converts USD currency to the selected currency
     *
     * @param amount double value that is being converted
     * @param conversionIndex int value that gets the selected currency
     * @return double value of the converted amount
     */
    public static double getUSDCurrency(double amount, int conversionIndex) {
        switch (conversionIndex) {
            case 1:
                break; // to self
            case 2:
                amount *= .92202; // to EUR
                break;
            case 3:
                amount *= 132.775; // tp JPY
                break;
            case 4:
                amount *= .81; // to GBP
                break;
            case 5:
                amount *= 6.8744; // to CNY
                break;
            case 6:
                amount *= 1.49589; // to AUD
                break;
            case 7:
                amount *= 1.35188; // to CAD
                break;
            case 8:
                amount *= .914; // to CHF
                break;
            case 9:
                amount *= 7.849; // to HKD
                break;
            case 10:
                amount *= 1.597; //to NZD
                break;
        }
        return amount;
    }

    /**
     * Converts EUR currency to the selected currency
     *
     * @param amount double value that is being converted
     * @param conversionIndex int value that gets the selected currency
     * @return double value of the converted amount
     */
    public static double getEURCurrency(double amount, int conversionIndex) {
        switch (conversionIndex) {
            case 1:
                amount *= 1 / .92202; // To USD
            case 2:
                break; //To self
            case 3:
                amount *= 144.229; // To JPY
                break;
            case 4:
                amount *= .88; // To GBP
                break;
            case 5:
                amount *= 7.467157; // To CNY
                break;
            case 6:
                amount *= 1.625467; // To AUD
                break;
            case 7:
                amount *= 1.46968; // To CAD
                break;
            case 8:
                amount *= .994561; // To CHF
                break;
            case 9:
                amount *= 8.52813; // To HKD
                break;
            case 10:
                amount *= 1.737157; // To NZD
                break;
        }
        return amount;
    }

    /**
     * Converts JPY currency to the selected currency
     *
     * @param amount double value that is being converted
     * @param conversionIndex int value that gets the selected currency
     * @return double value of the converted amount
     */
    public static double getJPYCurrency(double amount, int conversionIndex) {
        switch (conversionIndex) {
            case 1:
                amount *= 1 / 132.775; // To USD
                break;
            case 2:
                amount *= 1 / 144.229; // To EUR
                break;
            case 3:
                break; // To self
            case 4:
                amount *= 0.00609; // To GBP
                break;
            case 5:
                amount *= 0.051939; // To CNY
                break;
            case 6:
                amount *= 0.011184; // To AUD
                break;
            case 7:
                amount *= 0.010156; // To CAD
                break;
            case 8:
                amount *= 0.006874; // To CHF
                break;
            case 9:
                amount *= 0.058907; // To HKD
                break;
            case 10:
                amount *= 0.012; // To NZD
                break;
        }
        return amount;
    }

    /**
     * Converts GBP currency to the selected currency
     *
     * @param amount double value that is being converted
     * @param conversionIndex int value that gets the selected currency
     * @return double value of the converted amount
     */
    public static double getGBPCurrency(double amount, int conversionIndex) {
        switch (conversionIndex) {
            case 1:
                amount *= 1 / .81; // To USD
                break;
            case 2:
                amount *= 1 / .88; // To EUR
                break;
            case 3:
                amount *= 1 / 0.00609; // To JPY
                break;
            case 4:
                break; // To self
            case 5:
                amount *= 8.46604; // To CNY
                break;
            case 6:
                amount *= 1.826637; // To AUD
                break;
            case 7:
                amount *= 1.6669; // To CAD
                break;
            case 8:
                amount *= 1.129995; // Tp CHF
                break;
            case 9:
                amount *= 9.725392; // To HKD
                break;
            case 10:
                amount *= 1.97386; // To NZD
                break;
        }
        return amount;
    }

    /**
     * Converts CNY currency to the selected currency
     *
     * @param amount double value that is being converted
     * @param conversionIndex int value that gets the selected currency
     * @return double value of the converted amount
     */
    public static double getCNYCurrency(double amount, int conversionIndex) {
        switch (conversionIndex) {
            case 1:
                amount *= 1 / 6.8744; // To USD
                break;
            case 2:
                amount *= 1 / 7.467157; // To EUR
                break;
            case 3:
                amount *= 1 / .051939; // To JPY
                break;
            case 4:
                amount *= 1 / 8.46604; // To GBP
                break;
            case 5:
                break; // To Self
            case 6:
                amount *= 0.214283; // To AUD
                break;
            case 7:
                amount *= 0.195257; // To CAD
                break;
            case 8:
                amount *= 0.132686; // To CHF
                break;
            case 9:
                amount *= 7.849; // To HKD
                break;
            case 10:
                amount *= 1.597; // To NZD
                break;
        }
        return amount;
    }

    /**
     * Converts AUD currency to the selected currency
     *
     * @param amount double value that is being converted
     * @param conversionIndex int value that gets the selected currency
     * @return double value of the converted amount
     */
    public static double getAUDCurrency(double amount, int conversionIndex) {
        switch (conversionIndex) {
            case 1:
                amount *= 1 / 1.49589; // To USD
                break;
            case 2:
                amount *= 1 / 1.625467; // To EUR
                break;
            case 3:
                amount *= 1 / .011184; // To JPY
                break;
            case 4:
                amount *= 1 / 1.826637; // To GBP
                break;
            case 5:
                amount *= 1 / .214283; // Tp CNH
                break;
            case 6:
                break; // To self
            case 7:
                amount *= 0.911778; // to CAD
                break;
            case 8:
                amount *= 0.619454; // To CHF
                break;
            case 9:
                amount *= 5.32717; // To HKD
                break;
            case 10:
                amount *= 1.0772; // To NZD
                break;
        }
        return amount;
    }

    /**
     * Converts CAD currency to the selected currency
     *
     * @param amount double value that is being converted
     * @param conversionIndex int value that retrieves the selected currency
     * @return double value of the converted amount
     */
    public static double getCADCurrency(double amount, int conversionIndex) {
        switch (conversionIndex) {
            case 1:
                amount *= 1 / 1.35188; // To USD
                break;
            case 2:
                amount *= 1 / 1.46968; // To EUR
                break;
            case 3:
                amount *= 1 / .010156; // To JPY
                break;
            case 4:
                amount *= 1 / 1.6669; // To GBP
                break;
            case 5:
                amount *= 1 / .195257; // To CNY
                break;
            case 6:
                amount *= 1 / .911778; // To AUD
                break;
            case 7:
                break; // To self
            case 8:
                amount *= .679329; // To CHF
                break;
            case 9:
                amount *= 5.84308; // To HKD
                break;
            case 10:
                amount *= 1.18137; // To NZD
                break;
        }
        return amount;
    }

    /**
     * Converts CHF currency to the selected currency
     *
     * @param amount double value that is being converted
     * @param conversionIndex int value that gets the selected currency
     * @return double value of the converted amount
     */
    public static double getCHFCurrency(double amount, int conversionIndex) {
        switch (conversionIndex) {
            case 1:
                amount *= 1 / 0.914; // To USD
                break;
            case 2:
                amount *= 1 / 0.994561; // To EUR
                break;
            case 3:
                amount *= 1 / 0.006874; // To JPY
                break;
            case 4:
                amount *= 1 / 1.129995; // To GBP
                break;
            case 5:
                amount *= 1 / 0.132686; // To CNY
                break;
            case 6:
                amount *= 1 / 0.619454; // To AUD
                break;
            case 7:
                amount *= 1 / .679329; // To CAD
                break;
            case 8:
                break; // To self
            case 9:
                amount *= 8.60108; // To HKD
                break;
            case 10:
                amount *= 1.73906; // To NZD
                break;
        }
        return amount;
    }

    /**
     * Converts HKD currency to the selected currency
     *
     * @param amount double value that is being converted
     * @param conversionIndex int value that gets the selected currency
     * @return double value of the converted amount
     */
    public static double getHKDCurrency(double amount, int conversionIndex) {
        switch (conversionIndex) {
            case 1:
                amount *= 1 / 7.849; // To USD
                break;
            case 2:
                amount *= 1 / 8.52813; // To EUR
                break;
            case 3:
                amount *= 1 / 0.058907; // To JPY
                break;
            case 4:
                amount *= 1 / 9.725392; // To GBP
                break;
            case 5:
                amount *= 1 / 7.849; // To CNY
                break;
            case 6:
                amount *= 1 / 5.32717; // To AUD
                break;
            case 7:
                amount *= 1 / 5.84308; // To CAD
                break;
            case 8:
                amount *= 8.60108; // To CHF
                break;
            case 9:
                break; // To self
            case 10:
                amount *= 0.202206; // To NZD
                break;
        }
        return amount;
    }

    /**
     * Converts NZD currency to the selected currency
     *
     * @param amount double value that is being converted
     * @param conversionIndex int value that gets the selected currency
     * @return double value of the converted amount
     */
    public static double getNZDCurrency(double amount, int conversionIndex) {
        switch (conversionIndex) {
            case 1:
                amount *= 1 / 1.597; // To USD
                break;
            case 2:
                amount *= 1 / 1.737157; // To EUR
                break;
            case 3:
                amount *= 1 / .012; // To JPY
                break;
            case 4:
                amount *= 1 / 1.97386; // To GBP
                break;
            case 5:
                amount *= 1 / 1.597; // To CNY
                break;
            case 6:
                amount *= 1 / 1.0772; // To AUD
                break;
            case 7:
                amount *= 1 / 1.18137; // To CAD
                break;
            case 8:
                amount *= 1 / 1.73906; // To CHF
                break;
            case 9:
                amount *= 1 / 0.202206; // To HKD
                break;
            case 10:
                break; // To self
        }
        return amount;
    }
}

