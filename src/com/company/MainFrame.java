package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private static final int WIDTH = 1000;
    private static final int HEIGHT = 600;

    private JLabel jLabel = new JLabel();

    private JLabel formulaImage = new JLabel();

    private JTextField textFieldX = new JTextField("0",15);
    private JTextField textFieldY = new JTextField("0",15);
    private JTextField textFieldZ = new JTextField("0",15);

    private JTextField textFieldResult = new JTextField("0",30);

    private Double activeVariable;
    private int activeVariableID;

    private int formulaID = 1;

    public MainFrame() {
        super("Вычисление по формулам");
        setSize(WIDTH, HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
        setLocation((kit.getScreenSize().width - WIDTH) / 2, (kit.getScreenSize().height - HEIGHT) / 2);

        add(jLabel);


        formulaImage.setIcon(new ImageIcon("Formula1.bmp"));
        formulaImage.setBounds(300, 20, 400, 70);
        jLabel.add(formulaImage);


        JRadioButton radioButtonFormula1 = new JRadioButton("Формула 1");
        radioButtonFormula1.setSelected(true);
        radioButtonFormula1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formulaID = 1;
                formulaImage.setIcon(new ImageIcon("Formula1.bmp"));
            }
        });
        radioButtonFormula1.setBounds(150, 100, 100, 20);
        JRadioButton radioButtonFormula2 = new JRadioButton("Формула 2");
        radioButtonFormula2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formulaID = 2;
                formulaImage.setIcon(new ImageIcon("Formula2.bmp"));
            }
        });
        radioButtonFormula2.setBounds(700, 100, 100, 20);
        ButtonGroup formulas = new ButtonGroup();
        formulas.add(radioButtonFormula1);
        formulas.add(radioButtonFormula2);
        jLabel.add(radioButtonFormula1);
        jLabel.add(radioButtonFormula2);
    }

    public static void main(String args[])
    {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
