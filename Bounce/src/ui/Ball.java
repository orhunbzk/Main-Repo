package ui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.time.LocalDateTime;

import javax.swing.*;

public class Ball extends JPanel implements Runnable {

	// Ball
	float r = 25, R = 50;

	// Initial position
	float x = 230, y = 130;

	// Axis
	float axisX = 5, axisY = 5;

	// Thread flags
	boolean paused = false, canRun = true;

	// Labels for position, axis and w/h
	private JLabel poslbl;
	private JLabel axislbl;

	// Initialize
	Thread bounce = new Thread(this);

	public Ball() {

		setLayout(null);

		axislbl = new JLabel("");
		poslbl = new JLabel("");

		axislbl.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		axislbl.setBounds(1, 1, 150, 10);

		poslbl.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		poslbl.setBounds(1, 1, 100, 30);

		add(axislbl);
		add(poslbl);

		this.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {

				if (bounce != null && bounce.isAlive()) {
					paused = true;
					System.out.println("[-] Thread Paused " + LocalDateTime.now());
				}

				x = e.getX();
				y = e.getY();

				repaint();

			}

			@Override
			public void mouseReleased(MouseEvent e) {

				if (!(bounce.isAlive())) {
					bounce.start();
					System.out.println("[*] Thread Started " + LocalDateTime.now());
				}

				else {

					paused = false;

					synchronized (bounce) {
						bounce.notify();
						System.out.println("[+] Thread Resuming " + LocalDateTime.now());
					}
				}
			}

		});

		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseDragged(MouseEvent e) {

				x = e.getX();
				y = e.getY();

				repaint();

			}
		});
	}

	@Override
	public void run() {
		while (true) {
			if (canRun) {
				if (!paused) {

					// Axis calculation results range are -> 45, -45, 135, -135
					// change the axis to opposite way by multiplying it -1

					if (getWidth() <= (x + r)) {
						axisX *= -1;
						x = getWidth() - r;
					} else if (getHeight() <= (y + r)) {
						axisY *= -1;
						y = getHeight() - r;
					} else if ((x - r) <= 0) {
						axisX *= -1;
						x = r;
					} else if ((y - r) <= 0) {
						axisY *= -1;
						y = r;
					} else {
					}

					x += axisX;
					y += axisY;

					repaint();

					poslbl.setText(String.valueOf(getWidth()) + "/" + getHeight());
					axislbl.setText(axisX + "/" + axisY);

					try {
						Thread.sleep(35);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					try {
						synchronized (bounce) {
							bounce.wait();
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				break;
			}
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.RED);
		g.fillArc((int) (x - r), (int) (y - r), 50, 50, 0, 360);
	}

}
