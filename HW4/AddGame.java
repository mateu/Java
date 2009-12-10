import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

class Clicker {
  public static void main(String[] args) {
    JFrame f = new JFrame(); 
    
    Container c = f.getContentPane(); 
    c.setLayout(null); 

    JButton b = new JButton(); 
    b.setBounds(20, 20, 120, 20); 
    b.setText("Push me!"); 
    c.add(b); 

    JLabel output = new JLabel(); 
    output.setBounds(50, 70, 220, 20); 
    output.setText("0 clicks so far. Push the button."); 
    c.add(output); 

    Counter referee = new Counter(output); 
    b.addActionListener(referee); 

    f.setSize(400, 400); 
    f.setVisible(true); 
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  } 
}

class Counter implements ActionListener {
  int count = 0; 
  JLabel label; 
  Counter(JLabel label) {
    this.label = label;
  } 
  public void actionPerformed(ActionEvent e) {
    this.count += 1; 
    System.out.println("Ouch: " + this.count); 
    this.label.setText(this.count + " click(s) so far and counting."); 
  } 
}