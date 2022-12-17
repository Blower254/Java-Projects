import java.awt.*;
import java.awt.event.*;


import javax.swing.*;


public class Calculator1 implements ActionListener{
    JFrame frame;
    JTextField textfield;
    JButton[] numBtns = new JButton[10];
    JButton[] fncBtns = new JButton[8];
    JButton addBtn, subBtn, mulBtn, divBtn;
    JButton decBtn, equaBtn, delBtn, ctrBtn;
    JPanel panel;

    Font myFont = new Font("times new roman", Font.BOLD, 30);

    double num1=0, num2=0, result=0;
    char operator;

    Calculator1(){
        frame = new JFrame("CALCULATOR SB30/PU/40258/21");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(370, 600);
        frame.setLayout(null);  
        frame.setLocationRelativeTo(null); 
        
        Color color = new Color(255, 239, 213);
        frame.getContentPane().setBackground(color);

        


        textfield = new JTextField();
        textfield.setBounds(20, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setBackground(Color.GRAY);
        textfield.setEditable(true);

       addBtn = new JButton("+");
       addBtn.setBackground(Color.GRAY);
       subBtn = new JButton("-");
       subBtn.setBackground(Color.GRAY);
       mulBtn = new JButton("*");
       mulBtn.setBackground(Color.GRAY);
       divBtn = new JButton("/");
       divBtn.setBackground(Color.GRAY);
       decBtn = new JButton(".");
       decBtn.setBackground(Color.GRAY);
       equaBtn = new JButton("=");
       equaBtn.setBackground(Color.GRAY);
       delBtn = new JButton("Del");
       delBtn.setBackground(Color.GRAY);
       ctrBtn = new JButton("AC");
       ctrBtn.setBackground(Color.GRAY);

        fncBtns[0] = addBtn;
        fncBtns[1] = subBtn;
        fncBtns[2] = mulBtn;
        fncBtns[3] = divBtn;
        fncBtns[4] = decBtn;
        fncBtns[5] = equaBtn;
        fncBtns[6] = delBtn;
        fncBtns[7] = ctrBtn;


        for(int i = 0; i < 8; i++){
            fncBtns[i].addActionListener(this);;
            fncBtns[i].setFont(myFont);
            fncBtns[i].setFocusable(false);
        }

        for(int i = 0; i < 10; i++){
            numBtns[i] = new JButton(String.valueOf(i));
            numBtns[i].addActionListener(this);
            numBtns[i].setFont(myFont);
            numBtns[i].setFocusable(false);
            numBtns[i].setBackground(Color.GRAY);
        }
          
            
            delBtn.setBounds(20, 430, 120, 50);
            ctrBtn.setBounds(205, 430, 120,50);
        
            panel = new JPanel();
            panel.setBounds(20,100,300,300);
            panel.setLayout(new GridLayout(4,4,10,10));
            panel.setBackground(Color.GRAY);  
            


            panel.add(numBtns[1]);
            panel.add(numBtns[2]);
            panel.add(numBtns[3]);
            panel.add(addBtn);
            panel.add(numBtns[4]);
            panel.add(numBtns[5]);
            panel.add(numBtns[6]);
            panel.add(subBtn);
            panel.add(numBtns[7]);
            panel.add(numBtns[8]);
            panel.add(numBtns[9]);
            panel.add(mulBtn);
            panel.add(decBtn);
            panel.add(numBtns[0]);
            panel.add(equaBtn);
            panel.add(divBtn); 



            frame.add(panel); 
            frame.add(delBtn);
            frame.add(ctrBtn);
            frame.add(textfield);
            //myFont.setColor(Color.BLUE)
            textfield.setFont(myFont);
            
        
            frame.setVisible(true);
    }

    public static void main(String[] args) {
      try{
        //Calculator1 calc = new Calculator1();
        System.out.println("No Exception");
        

        }
        catch(Exception e){
            System.out.println("Error"); 
        }
       
        
        
    }

    @Override
        public void actionPerformed(ActionEvent e) {
            for(int i = 0; i < 10; i++){
                if(e.getSource() == numBtns[i]){
                    textfield.setText(textfield.getText().concat(String.valueOf(i)));
                }
            }

                if(e.getSource() == decBtn){
                    textfield.setText(textfield.getText().concat("."));
                }
                    
                if(e.getSource() == addBtn){
                    num1 = Double.parseDouble(textfield.getText());
                    operator = '+';
                    textfield.setText("");
            
                }
                if(e.getSource() == subBtn){
                    num1 = Double.parseDouble(textfield.getText());
                    operator = '-';
                    textfield.setText("");
                }
                if(e.getSource() == mulBtn){
                    num1 = Double.parseDouble(textfield.getText());
                    operator = '*';
                    textfield.setText(""); 
                }
                if(e.getSource() == divBtn){
                    num1 = Double.parseDouble(textfield.getText());
                    operator = '/';
                    textfield.setText("");
                }
             
                if(e.getSource() == equaBtn){
                    num2 = Double.parseDouble(textfield.getText());

                    switch (operator) {

                        case '+':
                            result = num1+num2;
                        break;

                        case '-':
                            result = num1-num2;
                        break;

                        case '*':
                            result = num1*num2;
                        break;

                        case '/':
                        try{
                            result = num1/num2;
                            //System.out.println("No Exception");
                            
                    
                            }
                            catch(Exception ea){
                                System.out.println("Syntax Error"); 
                            }
                            
                        break;
                
                    }
                
                    textfield.setText(String.valueOf(result));
                    num1 = result;
                }
               

            if(e.getSource() == ctrBtn){
                textfield.setText(" ");
            }

            if(e.getSource() == delBtn){
                String string = textfield.getText();
                textfield.setText("");

                for(int i=0; i < string.length()-1; i++ ){
                    textfield.setText(textfield.getText() +  string.charAt(i));
                }
            }

        }
}


    

