/* <applet code=Tuesday.class width=400 height=400>
</applet>
 */

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Tuesday extends Applet {
	int count;
	public void init() {
		this.addMouseMotionListener( new Referee() );
	}
	public void paint(Graphics g) {
		System.out.println("Painting..." + count);
		this.count += 1;
	}

}

class Referee implements MouseMotionListener {
	public void mouseMoved(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {
	}
}