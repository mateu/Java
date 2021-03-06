import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AddGame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int m = (int) (Math.random() * 100) - 50;
	int n = (int) (Math.random() * 100) - 50;

	private JButton b, check_sum;
	private JLabel guess_sum_phrase;
	private JLabel score_phrase;

	AddGame() {
		createUserInterface();
	}

	private void createUserInterface() {

		Container c = getContentPane();
		c.setLayout(null);

		// b = new JButton();
		// b.setBounds(20, 20, 120, 20);
		// b.setText("Check Guess");
		// c.add(b);

		check_sum = new JButton();
		check_sum.setBounds(50, 100, 120, 20);
		check_sum.setText("Check Sum");
		c.add(check_sum);

		guess_sum_phrase = new JLabel();
		guess_sum_phrase.setBounds(50, 70, 260, 20);
		guess_sum_phrase.setText("Guess the sum of " + m + " and " + n);
		c.add(guess_sum_phrase);

		score_phrase = new JLabel();
		score_phrase.setBounds(50, 20, 260, 20);
		score_phrase.setText("Your score is: 0");
		c.add(score_phrase);

		JTextField t = new JTextField();
		t.setHorizontalAlignment(JTextField.CENTER);
		// t.setEditable(false);
		t.setBounds(180, 100, 40, 20);
		t.setText("");
		c.add(t);

		Escolta referee = new Escolta(check_sum, guess_sum_phrase, score_phrase, t, m,
				n);

		check_sum.addActionListener(referee);
		// down.addActionListener(referee);

		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		AddGame play = new AddGame();
		play.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class Escolta implements ActionListener {
	int my_score = 0;
	JButton check_sum;
	JLabel guess_sum_phrase, score_phrase;
	JTextField t;
	int m, n;

	Escolta(JButton check_sum, JLabel guess_sum_phrase, JLabel score_phrase,
			JTextField t, int m, int n) {
		this.check_sum = check_sum;
		this.guess_sum_phrase = guess_sum_phrase;
		this.score_phrase = score_phrase;
		this.t = t;
		this.m = m;
		this.n = n;
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == check_sum) {
			if (Integer.parseInt(t.getText()) == this.m + this.n) {
				System.out.println("you guessed correct!");
				this.my_score += 1;
			} else {
				System.out.println("you guessed INCorrect!");
				this.my_score -= 1;
			}
			this.score_phrase.setText("Your score is: " + this.my_score);
		} else {
			System.out.println("getSource did no return the check_sum JButton!");
		}
		m = (int) (Math.random() * 100) - 50;
		n = (int) (Math.random() * 100) - 50;
		this.guess_sum_phrase.setText("Guess the sum of " + m + " and " + n);
		System.out.println("my score: " + this.my_score);
	}
}
