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



        JLabel labelForX = new JLabel("X:");
        labelForX.setBounds(245,140,30,30);
        jLabel.add(labelForX);
        textFieldX.setBounds(275,140, 100,30);
        jLabel.add(textFieldX);

        JLabel labelForY = new JLabel("Y:");
        labelForY.setBounds(405,140,30,30);
        jLabel.add(labelForY);
        textFieldY.setBounds(435,140, 100,30);
        jLabel.add(textFieldY);

        JLabel labelForZ = new JLabel("Z:");
        labelForZ.setBounds(565,140,30,30);
        jLabel.add(labelForZ);
        textFieldZ.setBounds(595,140, 100,30);
        jLabel.add(textFieldZ);



        ButtonGroup activeVariableButtons = new ButtonGroup();
        JRadioButton activeVariable1  = new JRadioButton("Переменная 1");
        activeVariable1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activeVariable = Double.parseDouble(textFieldX.getText());
                activeVariableID = 1;
            }
        });
        activeVariableButtons.add(activeVariable1);
        activeVariable1.setBounds(245,170,150,20);
        jLabel.add(activeVariable1);

        JRadioButton activeVariable2  = new JRadioButton("Переменная 2");
        activeVariable2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activeVariable = Double.parseDouble(textFieldY.getText());
                activeVariableID = 2;
            }
        });
        activeVariableButtons.add(activeVariable2);
        activeVariable2.setBounds(405,170,150,20);
        jLabel.add(activeVariable2);

        JRadioButton activeVariable3  = new JRadioButton("Переменная 3");
        activeVariable3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activeVariable = Double.parseDouble(textFieldZ.getText());
                activeVariableID = 3;
            }
        });
        activeVariableButtons.add(activeVariable3);
        activeVariable3.setBounds(565,170,150,20);
        jLabel.add(activeVariable3);



        textFieldResult.setBounds(270,400,400,30);
        jLabel.add(textFieldResult);
    }

    public static void main(String args[])
    {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
