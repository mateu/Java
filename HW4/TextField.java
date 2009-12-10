import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class One {
  public static void main(String[] args) {
    JFrame f = new JFrame();
    Container c = f.getContentPane();
    c.setLayout(null);

    JTextField t = new JTextField();
    t.setHorizontalAlignment(JTextField.CENTER);
    //t.setEditable(false);
    t.setBounds(200, 40, 40, 20);
    t.setText("0");
    c.add(t);

    JButton b = new JButton();
    b.setBounds(70, 40, 120, 20);
    b.setText("Add One");
    c.add(b);

    Two referee = new Two(t);
    b.addActionListener(referee);

    f.setSize(400, 400);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}

class Two implements ActionListener {
    JTextField t;
    Two(JTextField t) {
        this.t = t;
    }
    public void actionPerformed(ActionEvent e) {
        String val = t.getText();
        int num = Integer.parseInt(val);
        num += 1;
        t.setText(num + "");
    }
}