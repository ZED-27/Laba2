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

    public Double Calculate1(Double x, Double y, Double z) {
        if (y == 0){
            JOptionPane.showMessageDialog(getParent(),"y == 0", "Error", JOptionPane.ERROR_MESSAGE);
            return 0.0;
        }
        if (z == 0){
            JOptionPane.showMessageDialog(getParent(),"z == 0", "Error", JOptionPane.ERROR_MESSAGE);
            return 0.0;
        }

        return (Math.sin(Math.PI * y * y) + Math.log(y*y))/(Math.sin(Math.PI*z*z)+Math.sin(x)+Math.log(z*z)+x*x+Math.exp(Math.cos(z*x)));
    }

    public Double Calculate2(Double x, Double y, Double z) {
        if (z == -1){
            JOptionPane.showMessageDialog(getParent(),"z == -1", "Error", JOptionPane.ERROR_MESSAGE);
            return 0.0;
        }
        if (x == 0){
            JOptionPane.showMessageDialog(getParent(),"x == 0", "Error", JOptionPane.ERROR_MESSAGE);
            return 0.0;
        }

        return Math.pow((Math.cos(Math.exp(y)) + Math.exp(y*y)) + Math.pow(1/x,1/2),1/4)/Math.pow((Math.cos(Math.PI*z*z*z)+Math.log((1+z)*(1+z))),Math.sin(y));
    }

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



        JButton calculate = new JButton("Посчитать");
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double temp;
                if (formulaID == 1) {
                    temp = Calculate1(Double.parseDouble(textFieldX.getText()),Double.parseDouble(textFieldY.getText()),Double.parseDouble(textFieldZ.getText()) );
                }
                else{
                    temp = Calculate2(Double.parseDouble(textFieldX.getText()),Double.parseDouble(textFieldY.getText()),Double.parseDouble(textFieldZ.getText()) );
                }
                textFieldResult.setText(temp.toString());
            }
        });
        calculate.setBounds(300,200,100,30);
        jLabel.add(calculate);

        JButton clear = new JButton("Очистить");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldResult.setText("0");
                textFieldX.setText("0");
                textFieldY.setText("0");
                textFieldZ.setText("0");
            }
        });
        clear.setBounds(550,200,100,30);
        jLabel.add(clear);



        JButton MPlus = new JButton("M+");
        MPlus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double temp = Double.parseDouble(textFieldResult.getText())+activeVariable;
                textFieldResult.setText(temp.toString());
            }
        });
        MPlus.setBounds(400,250,70,70);
        jLabel.add(MPlus);

        JButton MC = new JButton("MC");
        MC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (activeVariableID == 1)
                {
                    textFieldX.setText("0");
                }
                else if (activeVariableID == 2)
                {
                    textFieldY.setText("0");
                }
                else
                {
                    textFieldZ.setText("0");
                }
            }
        });
        MC.setBounds(520,250,70,70);
        jLabel.add(MC);
    }

    public static void main(String args[])
    {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
