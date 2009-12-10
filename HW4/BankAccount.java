import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

class One extends JFrame {

  private JButton b, down; 
  private JLabel output; 

  One() {
    createUserInterface(); 
  } 

  private void createUserInterface() {

    Container c = getContentPane(); 
    c.setLayout(null); 

    b = new JButton(); 
    b.setBounds(20, 20, 120, 20); 
    b.setText("Push me!"); 
    c.add(b); 

    down = new JButton(); 
    down.setBounds(20, 120, 180, 20); 
    down.setText("Push to withdraw"); 
    c.add(down); 

    output = new JLabel(); 
    output.setBounds(50, 70, 220, 20); 
    output.setText("0 clicks so far. Push the button."); 
    c.add(output); 

    Two referee = new Two(b, down, output); 

    b.addActionListener(referee); 
    down.addActionListener(referee); 

    setSize(400, 400); 
    setVisible(true);     
  } 

  public static void main(String[] args) {
    One one = new One();   
    one.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  } 
}

class Two implements ActionListener {
  int count; 
  JButton b, down; 
  JLabel output; 
  Two(JButton b, JButton down, JLabel output) {
    this.b = b; 
    this.down = down; 
    this.output = output; 
  } 
  public void actionPerformed(ActionEvent e) {
    Object source = e.getSource(); 
    if (source == b) { 
      count += 1; 
    } else if (source == down) { 
      count -= 1; 
    } else {
      System.out.println("What?!"); 
    } 
    System.out.println(this.count + " clicks recorded so far."); 
  } 
}