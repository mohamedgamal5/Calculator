package calculator;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class calculator {
	
	
	JFrame frame = new JFrame("Calculator");
	JTextArea screen = new JTextArea("gfjhgjhgc");
	
	private JButton btnEqual = new JButton("=");
	double num1 = 0;
	double num2 = 0;
	double result;
	String operation;
	boolean first = true;
    //Number Buttons:
    private JButton btn0 = new JButton("0");
    private JButton btn1 = new JButton("1");
    private JButton btn2 = new JButton("2");
    private JButton btn3 = new JButton("3");
    private JButton btn4 = new JButton("4");
    private JButton btn5 = new JButton("5");
    private JButton btn6 = new JButton("6");
    private JButton btn7 = new JButton("7");
    private JButton btn8 = new JButton("8");
    private JButton btn9 = new JButton("9");
   
    //Operator Buttons:
    private JButton btnDiv = new JButton("/");
    private JButton btnMul = new JButton("*");
    private JButton btnSub = new JButton("-");
    private JButton btnAdd = new JButton("+");
    private JButton btnDec = new JButton(".");
    private JButton btnClear = new JButton("c");
    private JButton btnSign = new JButton("+/-");
    private JButton btnMode = new JButton("%");
    /**\uF0E7*/
    private JButton btnDelete = new JButton("<");
    public calculator()
    {
    	frame.setSize(245,385);
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setResizable(false);
    	frame.setLayout(null);
    	frame.setLocation(565,115);
    	screen.setSize(210, 35);
    	screen.setFont(new Font("Tahoma",Font.BOLD,15));
        screen.setLocation(10, 50);
        screen.setEditable(false);
        // 1 ROW
        btn0.setSize(45,35);
        btn0.setLocation(10, 300);
        btn0.setFont(new Font("Tahoma",Font.BOLD,15));
        btn0.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                String S=screen.getText()+btn0.getText();
                screen.setText(S);
            }
        });
        btnDec.setSize(45,35);
        btnDec.setLocation(65,300);
        btnDec.setFont(new Font("Tahoma",Font.BOLD,15));
        btnDec.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
            	if(! screen.getText().contains("."))
                {
            		screen.setText(screen.getText() + btnDec.getText());
                }
            }
        });
        btnSign.setSize(45,35);
        btnSign.setLocation(120, 300);
        //btnSign.setFont(new Font("Tahoma",Font.BOLD,15));
        btnSign.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
            	if (first != true)
            	{
            		num1 = result;
            		num1 = num1*(-1);
            		result = result*(-1);
                	screen.setText(String.valueOf(num1));
            	}
            	else {
            		double ops =Double.parseDouble(String.valueOf(screen.getText()));
                	ops=ops*(-1);
                	screen.setText(String.valueOf(ops));
            	}
            }
        });
        btnEqual.setSize(45,35);
        btnEqual.setLocation(175, 300);
        btnEqual.setFont(new Font("Tahoma",Font.BOLD,12));
        btnEqual.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                String answer;
                num2 = Double.parseDouble(screen.getText());
                if(operation=="+")
                {
                	result=num1+num2;
                	answer=String.format("%.2f", result);
                	screen.setText(answer);
                }
                else if(operation=="-")
                {
                	result = num1 - num2;
                	answer=String.format("%.2f", result);
                	screen.setText(answer);
                }
                else if(operation=="*")
                {
                	result = num1 * num2;
                	answer=String.format("%.2f", result);
                	screen.setText(answer);
                }
                else if(operation=="/")
                {
                	result = num1 / num2;
                	answer=String.format("%.2f", result);
                	screen.setText(answer);
                }
                else if(operation=="%")
                {
                	result = num1 % num2;
                	answer=String.format("%.2f", result);
                	screen.setText(answer);
                }
                first = false;
            }
        });
        //2row
        btn1.setSize(45,35);
        btn1.setLocation(10, 250);
        btn1.setFont(new Font("Tahoma",Font.BOLD,15));
        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                String S=screen.getText()+btn1.getText();
                screen.setText(S);
            }
        });
        btn2.setSize(45,35);
        btn2.setLocation(65, 250);
        btn2.setFont(new Font("Tahoma",Font.BOLD,15));
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                String S=screen.getText()+btn2.getText();
                screen.setText(S);
            }
        });
        btn3.setSize(45,35);
        btn3.setLocation(120, 250);
        btn3.setFont(new Font("Tahoma",Font.BOLD,15));
        btn3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                String S=screen.getText()+btn3.getText();
                screen.setText(S);
            }
        });
        btnAdd.setSize(45,35);
        btnAdd.setLocation(175, 250);
        btnAdd.setFont(new Font("Tahoma",Font.BOLD,12));
        btnAdd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
            	if (first != true)
            	{
            		num1=result;
            		screen.setText("");
                    operation="+";
            	}
            	else {
                num1=Double.parseDouble(screen.getText());
                screen.setText("");
                operation="+";
            	}
            }
        });
        //3row
        btn4.setSize(45,35);
        btn4.setLocation(10, 200);
        btn4.setFont(new Font("Tahoma",Font.BOLD,15));
        btn4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                String S=screen.getText()+btn4.getText();
                screen.setText(S);
            }
        });
        btn5.setSize(45,35);
        btn5.setLocation(65, 200);
        btn5.setFont(new Font("Tahoma",Font.BOLD,15));
        btn5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                String S=screen.getText()+btn5.getText();
                screen.setText(S);
            }
        });
        btn6.setSize(45,35);
        btn6.setLocation(120, 200);
        btn6.setFont(new Font("Tahoma",Font.BOLD,15));
        btn6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                String S=screen.getText()+btn6.getText();
                screen.setText(S);
            }
        });
        btnSub.setSize(45,35);
        btnSub.setLocation(175, 200);
        btnSub.setFont(new Font("Tahoma",Font.BOLD,20));
        btnSub.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
            	if (first != true)
            	{
            		num1=result;
            		screen.setText("");
                    operation="-";
            	}
            	else {
                num1=Double.parseDouble(screen.getText());
                screen.setText("");
                operation="-";
            	}
            }
        });
        //4Row
        btn7.setSize(45,35);
        btn7.setLocation(10, 150);
        btn7.setFont(new Font("Tahoma",Font.BOLD,15));
        btn7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                String S=screen.getText()+btn7.getText();
                screen.setText(S);
            }
        });
        btn8.setSize(45,35);
        btn8.setLocation(65, 150);
        btn8.setFont(new Font("Tahoma",Font.BOLD,15));
        btn8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                String S=screen.getText()+btn8.getText();
                screen.setText(S);
            }
        });
        btn9.setSize(45,35);
        btn9.setLocation(120, 150);
        btn9.setFont(new Font("Tahoma",Font.BOLD,15));
        btn9.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                String S=screen.getText()+btn9.getText();
                screen.setText(S);
            }
        });
        btnMul.setSize(45,35);
        btnMul.setLocation(175, 150);
        btnMul.setFont(new Font("Tahoma",Font.BOLD,15));
        btnMul.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
            	if (first != true)
            	{
            		num1=result;
            		screen.setText("");
                    operation="*";
            	}
            	else {
                num1=Double.parseDouble(screen.getText());
                screen.setText("");
                operation="*";
            	}
            }
        });
        //5 Row
        btnDelete.setSize(45,35);
        btnDelete.setLocation(10, 100);
        //btnDelete.setFont(new Font("Tahoma",Font.BOLD,20));
        btnDelete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                String d=null;
                if(screen.getText().length()>0)
                {
                	StringBuilder strB = new StringBuilder(screen.getText()); 
                	strB.deleteCharAt(screen.getText().length() - 1); 
                	d = strB.toString();
                	screen.setText(d);
                }
            }
        });
        btnClear.setSize(45,35);
        btnClear.setLocation(65, 100);
        btnClear.setFont(new Font("Tahoma",Font.BOLD,15));
        btnClear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                screen.setText(null);
            }
        });
        btnMode.setSize(45,35);
        btnMode.setLocation(120, 100);
       //btnMode.setFont(new Font("Tahoma",Font.BOLD,10));
        btnMode.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
            	if (first != true)
            	{
            		num1=result;
            		screen.setText("");
                    operation="%";
            	}
            	else {
                num1=Double.parseDouble(screen.getText());
                screen.setText("");
                operation="%";
            	}
            }
        });
        
        btnDiv.setSize(45,35);
        btnDiv.setLocation(175, 100);
        btnDiv.setFont(new Font("Tahoma",Font.BOLD,15));
        btnDiv.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
            	if (first != true)
            	{
            		num1=result;
            		screen.setText("");
                    operation="/";
            	}
            	else {
                num1=Double.parseDouble(screen.getText());
                screen.setText("");
                operation="/";
            	}
            }
        });
        //Adding
        frame.add(screen);        
        frame.add(btn0);        frame.add(btnDec);      frame.add(btnSign);       	frame.add(btnEqual);
        frame.add(btn1);        frame.add(btn2);        frame.add(btn3);         	frame.add(btnAdd);
        frame.add(btn4);        frame.add(btn5);        frame.add(btn6);        	frame.add(btnSub);
        frame.add(btn7);        frame.add(btn8);        frame.add(btn9);			frame.add(btnMul);
        frame.add(btnDelete);   frame.add(btnClear);    frame.add(btnMode);			frame.add(btnDiv);
        SwingUtilities.updateComponentTreeUI(frame);
    }
	public static void main(String[] args) {
        new calculator();
	}

}
