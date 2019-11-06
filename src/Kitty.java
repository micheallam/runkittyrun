import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class Kitty extends JFrame implements ActionListener{
	//Variable Settings
	final private int ROWS = 8;
	final private int COLS = 8;
	final private int GAP = 2;
	final private int SIZE = 300;
	
	//Buttons
	JButton up = new JButton("Up");
	JButton down = new JButton("Down");
	JButton right = new JButton("Right");
	JButton left = new JButton("Left");
	
	//Cardinal Border Placements
	JPanel topPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	JPanel rightPanel = new JPanel();
	JPanel leftPanel = new JPanel();
	
	//2D array of JPanels
	private JPanel pane = new JPanel(new GridLayout(ROWS, COLS, GAP, GAP));
	private JPanel[][] panel = new JPanel[8][8]; //makes a 2d array of 8x8
	
	//The cat face
	JLabel kittykat = new JLabel("=^.^=");
	
	//Colors
	private Color color1 = Color.WHITE;
	private Color color2 = Color.BLUE;
	private Color tempColor; //placeholder for the color swapping
	
	//Constructor
	public Kitty() {
		super("Run Kitty Run");
		setSize(SIZE, SIZE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//Creates the checkerboard and sets the colors
		for(int x = 0; x < ROWS; x++) {
			for(int y = 0; y < COLS; y++) {
				panel[x][y] = new JPanel(); //Inits the panel
				pane.add(panel[x][y]);
				
				//Shades in the colors for the background of the tile
				if(x%2 == 0) {
					tempColor = color1;
					color1 = color2;
					color2 = tempColor;
				}else {
					tempColor = color1;
					color1 = color2;
					color2 = tempColor;
				}
				
				
				if(x%2 == 0) {
					panel[x][y].setBackground(color1);
				}else {
					panel[x][y].setBackground(color2);
				}
				
			}
		}
		
		//Set the layout for the panels
		topPanel.setLayout(new GridLayout(1,1,1,1));
		bottomPanel.setLayout(new GridLayout(1,1,1,1));
		rightPanel.setLayout(new GridLayout(1,1,1,1));
		leftPanel.setLayout(new GridLayout(1,1,1,1));
		
		//Set the buttons to the cardinal panels
		topPanel.add(up);
		bottomPanel.add(down);
		rightPanel.add(right);
		leftPanel.add(left);
		
		//Add the actionlisteners to the buttons
		up.addActionListener(this);
		down.addActionListener(this);
		right.addActionListener(this);
		left.addActionListener(this);
		
		//add the pane to the content pane
		add(pane, BorderLayout.CENTER);
		add(topPanel, BorderLayout.NORTH);
		add(bottomPanel, BorderLayout.SOUTH);
		add(rightPanel, BorderLayout.EAST);
		add(leftPanel, BorderLayout.WEST);
		
		panel[2][3].add(kittykat); // for testing pruposes
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
	}

}
