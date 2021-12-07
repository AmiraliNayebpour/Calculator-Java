package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

    public class calculator implements ActionListener {
        JFrame frame;
        JTextField text;
        JButton[] btnNumbers = new JButton[15];
        String[] Numbers = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        String[] Operators = new String[]{"+", "-", "÷", "×", "=" , "C"};
        int btnWidth = 90;
        int btnHeight = 90;
        String op;
        double lastNumber;

        public calculator() {
            frame = new JFrame("Calculator");
            frame.setSize(430, 500);
            text = new JTextField("");
            text.setBounds(10, 10, 410, 50);
            frame.add(text);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            initialNumbersbtn();
            initialOperatorbtn();
            frame.setLayout(null);
            frame.setVisible(true);
        }

        public void initialNumbersbtn() {
            int totalSize = 440;
            int x = 10;
            int y = 70;
            int btnWidth = 90;
            int btnHeight = 90;
            int col = 0;
            for (int i = 0; i < Numbers.length; i++) {
                JButton btn = new JButton(Numbers[i]);
                btn.setBounds(x, y, btnWidth, btnHeight);
                btn.addActionListener(this);
                frame.add(btn);
                btnNumbers[i] = btn;
                col++;
                if (col == 3 || col == 6 || col == 9) {
                    y += btnHeight + 10;
                    x = 10;
                } else {
                    x += 10 + btnWidth;
                }
            }
        }

        public void initialOperatorbtn() {
            int totalSize = 440;
            int defaultX = (3 * this.btnWidth) + 50;
            int x = defaultX;
            int y = 70;
            btnWidth = 100;
            btnHeight = 90;
            for (int i = 0; i < Operators.length; i++) {
                JButton btn = new JButton(Operators[i]);
                btn.setBounds(x, y, btnWidth, btnHeight);
                btn.addActionListener(this);
                if (Operators[i].equals("=")) {
                    btn.setBounds(5 + this.btnWidth, y - (btnHeight + 10),  this.btnWidth, btnHeight);
                }
                if (Operators[i].equals("C")) {
                    btn.setBounds(110 + this.btnWidth, btnHeight + 280,  this.btnWidth, btnHeight);
                }
                frame.add(btn);
                btnNumbers[i] = btn;

                y += btnHeight + 10;

            }

        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String btnLable = ((JButton) actionEvent.getSource()).getText();
            if (Arrays.asList(Numbers).contains(btnLable)) {
                text.setText(text.getText() + btnLable);
            } else {
                if (btnLable.equals("+") || btnLable.equals("-") || btnLable.equals("÷") || btnLable.equals("×") || btnLable.equals("C")) {
                    lastNumber = Double.parseDouble(text.getText());
                    text.setText("0");
                    op = btnLable;
                }
                if (btnLable.equals("=")) {
                    double res = 0;
                    switch (op) {
                        case "+":
                            res = lastNumber + Double.parseDouble(text.getText());
                            break;
                        case "-":
                            res = lastNumber - Double.parseDouble(text.getText());
                            break;
                        case "÷":
                            res = lastNumber / Double.parseDouble(text.getText());
                            break;
                        case "×":
                            res = lastNumber * Double.parseDouble(text.getText());
                            break;
                        case "C" :
                            res = 0;
                            break;
                    }
                    text.setText(String.valueOf(res));
                }
            }
        }
    }

