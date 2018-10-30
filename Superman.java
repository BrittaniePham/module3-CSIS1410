/* Author: Brittanie Pham
 * CSIS 1410
 * Module 3 Exam
 * 
 * font used: Verdana
 */

package superman;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

/**
 * creates the superman app that allows you to change what image you want shown by clicking radio buttons.
 * @author Brittanie Pham
 *
 */
public class Superman extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Superman frame = new Superman();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Superman() {
		makeWindow();
		supermanLabel();
		JPanel panel = radioButtonPanel();
		JRadioButton colorRadio = makeColorRadioButton(panel);
		JRadioButton bwRadio = makeBlackWhiteRadioButton(panel);
		JRadioButton negRadio = makeNegativeRadioButton(panel);
		JLabel imageLabel = makeImageLabel();
		bwListener(bwRadio, imageLabel);
		colorListener(colorRadio, imageLabel);
		negativeListener(negRadio, imageLabel);
	}

	/**
	 * action listener that runs when the negative radio button is selected
	 * @param negRadio
	 * @param imageLabel
	 */
	private void negativeListener(JRadioButton negRadio, JLabel imageLabel) {
		negRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imageLabel.setIcon(new ImageIcon(Superman.class.getResource("/superman/images/neg-superman.jpg")));
			}
	    });
	}

	/**
	 * action listener that runs when the color radio button is selected
	 * @param colorRadio
	 * @param imageLabel
	 */
	private void colorListener(JRadioButton colorRadio, JLabel imageLabel) {
		colorRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imageLabel.setIcon(new ImageIcon(Superman.class.getResource("/superman/images/color-superman.jpg")));
	        }
	    });
	}

	/**
	 * action listener that runs when the black and white radio button is selected
	 * @param bwRadio
	 * @param imageLabel
	 */
	private void bwListener(JRadioButton bwRadio, JLabel imageLabel) {
		bwRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imageLabel.setIcon(new ImageIcon(Superman.class.getResource("/superman/images/bw-superman.jpg")));
	        }
	    });
	}

	/**
	 * makes the main center label that holds the image as an icon
	 * @return
	 */
	private JLabel makeImageLabel() {
		JLabel imageLabel = new JLabel("");
		imageLabel.setIcon(new ImageIcon(Superman.class.getResource("/superman/images/color-superman.jpg")));
		contentPane.add(imageLabel, BorderLayout.CENTER);
		return imageLabel;
	}

	/**
	 * creates a radio button called negative
	 * @param panel
	 * @return
	 */
	private JRadioButton makeNegativeRadioButton(JPanel panel) {
		JRadioButton negRadio = new JRadioButton("Negative");
		buttonGroup.add(negRadio);
		negRadio.setFocusable(false);
		panel.add(negRadio);
		return negRadio;
	}

	/**
	 * creates a radio button called B&W
	 * @param panel
	 * @return
	 */
	private JRadioButton makeBlackWhiteRadioButton(JPanel panel) {
		JRadioButton bwRadio = new JRadioButton("B&W");
		buttonGroup.add(bwRadio);
		bwRadio.setFocusable(false);
		panel.add(bwRadio);
		return bwRadio;
	}

	/**
	 * creates a radio button called color
	 * @param panel
	 * @return
	 */
	private JRadioButton makeColorRadioButton(JPanel panel) {
		JRadioButton colorRadio = new JRadioButton("Color");
		colorRadio.setSelected(true);
		buttonGroup.add(colorRadio);
		colorRadio.setFocusable(false);
		panel.add(colorRadio);
		return colorRadio;
	}

	/**
	 * makes the panel for all the radio buttons
	 * @return
	 */
	private JPanel radioButtonPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		contentPane.add(panel, BorderLayout.SOUTH);
		return panel;
	}

	/**
	 * creates a label for the main title
	 */
	private void supermanLabel() {
		JLabel lblNewLabel = new JLabel("Superman");
		lblNewLabel.setBorder(new EmptyBorder(10, 0, 10, 0));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(Color.BLUE);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
	}

	/**
	 * create the window
	 */
	private void makeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
