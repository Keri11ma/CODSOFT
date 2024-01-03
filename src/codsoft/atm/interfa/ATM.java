package codsoft.atm.interfa;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class ATM extends JFrame {
    private BankAccount bankAccount;
    private JTextField inputField;

    private List<String> transactionHistory;

    public ATM(BankAccount account) {
        this.bankAccount = account;
        setTitle("SaveMoney ATM");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel label = new JLabel("Welcome to the SaveMoney ATM");
        label.setBounds(50, 10, 300, 20);
        add(label);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(50, 40, 120, 30);
        add(withdrawButton);

        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(200, 40, 120, 30);
        add(depositButton);

        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.setBounds(50, 90, 120, 30);
        add(checkBalanceButton);

        transactionHistory = new ArrayList<>();

        JButton checkStatementButton = new JButton("Check Statement");
        checkStatementButton.setBounds(200, 90, 150, 30);
        add(checkStatementButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(130, 140, 120, 30);
        add(exitButton);

        inputField = new JTextField();
        inputField.setBounds(50, 190, 270, 30);
        add(inputField);

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                if (!input.isEmpty()) {
                    try {
                        double withdrawAmount = Double.parseDouble(input);
                        boolean withdrawn = bankAccount.withdraw(withdrawAmount);
                        if (withdrawn) {
                            transactionHistory.add("Withdrawal: R" + withdrawAmount);
                            JOptionPane.showMessageDialog(null, "Successfully withdrawn.\n Remaining balance is: " + bankAccount.getBalance());
                        } else {
                            JOptionPane.showMessageDialog(null, "Insufficient balance for withdrawal.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter an amount to withdraw.");
                }
            }
        });

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                if (!input.isEmpty()) {
                    try {
                        double depositAmount = Double.parseDouble(input);
                        bankAccount.deposit(depositAmount);
                        transactionHistory.add("Deposit: R" + depositAmount);
                        JOptionPane.showMessageDialog(null, "Successfully deposited.\n New balance is: " + bankAccount.getBalance());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter an amount to deposit.");
                }
            }
        });

        checkBalanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Your current balance is: " + bankAccount.getBalance());
            }
        });

        checkStatementButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!transactionHistory.isEmpty()) {
                    StringBuilder statement = new StringBuilder("Transaction History:\n");
                    for (String transaction : transactionHistory) {
                        statement.append(transaction).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, statement.toString());
                } else {
                    JOptionPane.showMessageDialog(null, "No transactions made yet.");
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Thank you for using the Save Money ATM.\n GoodBye!!");
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(4000.0);
        ATM atmGUI = new ATM(userAccount);
        atmGUI.setVisible(true);
    }
}

