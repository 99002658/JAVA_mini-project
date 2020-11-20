import java.awt.event.*;
import javax.swing.*;

class QuizSimulation extends JFrame implements ActionListener
{
	JLabel label;
	JRadioButton btn[] = new JRadioButton[5];                                            //btn is an array of radio buttonids for the options of the questions
	JButton b1;
	JButton b2;                                                                       //button ids for interacting directly with the dialog box
	ButtonGroup bg;
	int count = 0;                                                                       //counter for keeping a tab on the number of correct answers 
	int current = 0;                                                                     //counter for keeping track of current question
	int counter1 = 1;
	int counter2 = 1;
	int now = 0;
	int intArray[] = new int[10];	
	QuizSimulation(String s)
	{
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for(int i=0;i<5;i++)                                                             //for-loop  for creating buttonids and adding them to the button array 
		{                                                                                //which has been defined above
			btn[i] = new JRadioButton();	
			add(btn[i]);
			bg.add(btn[i]);
		}
		b1 = new JButton("Next");                                                        //button declaration for the Next Question button
		b2 = new JButton("Reconsider");                                                  //button declaration for the Reconsideration button
		b1.addActionListener(this);                                                      //adding action listener method for Next button
		b2.addActionListener(this);                                                      //adding action listener methos for Reconsider button
        add(b1);
        add(b2);
		set();
		label.setBounds(30,40,450,20);                                                   //setting up the boundary limits for the main dialog box
		btn[0].setBounds(50,80,200,20);                                                  //setting up boundaries for the buttons which are to be used as the options
		btn[1].setBounds(50,110,200,20);                                                 //--do--
		btn[2].setBounds(50,140,200,20);                                                 //--do--
		btn[3].setBounds(50,170,200,20);                                                 //--do--
		b1.setBounds(100,240,150,30);                                                    //setting boundary for the Next Question button
		b2.setBounds(270,240,150,30);                                                    //setting boundary for the Reconsider ths question button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                                  //declaring a default operation for the frame, i.e., close operation
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(600,350);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			if(check())                                                                  //keeps checking whether the current question counter has reached 10
				count = count+1;
			current++;
			set();	
			if(current==9)                                                               //in case the current question counter does reach the last question,
			{                                                                            //then diable the Next question button by setting the Enabled flag as 'false'
				b1.setEnabled(false);                                                    //as shown here
				b2.setText("Show result");                                               
			}
		}
		if(e.getActionCommand().equals("Reconsider"))
		{
			JButton lookAgain=new JButton("Reconsider"+counter1);
			lookAgain.setBounds(480,20+30*counter1,100,30);
			add(lookAgain);
			lookAgain.addActionListener(this);
			intArray[counter1]=current;
			counter1++;
			current++;
			set();	
			if(current==9)
				b2.setText("Show result");
			setVisible(false);
			setVisible(true);
		}
		for(int i=0,counter2=1;i<counter1;i++,counter2++)
		{
		if(e.getActionCommand().equals("Reconsider"+counter2))
		{
			if(check())
				count=count+1;
			now=current;
			current=intArray[counter2];
			set();
			((JButton)e.getSource()).setEnabled(false);
			current=now;
		}
		}
	
		if(e.getActionCommand().equals("Show result"))
		{
			if(check())
				count=count+1;
			current++;
			JOptionPane.showMessageDialog(this,"Correct answer count:: "+count);
			System.exit(0);
		}
	}
	void set()
	{
		btn[4].setSelected(true);
		if(current==0)
		{
			label.setText("Que1: The Indian, who holds the pride of beating the computers in mathematical wizard is:");
			btn[0].setText("Shakuntala Devi");
			btn[1].setText("Raja Ramanna");
			btn[2].setText("Ramanujam");
			btn[3].setText("Rina Panigrahi");	
		}
		if(current==1)
		{
			label.setText("Que2: What year did the Titanic sink in the Atlantic Ocean on its maiden voyage?");
			btn[0].setText("1910");
			btn[1].setText("1909");
			btn[2].setText("1912");
			btn[3].setText("1911");
		}
		if(current==2)
		{
			label.setText("Que3: What is the name of the biggest technology company in South Korea?");
			btn[0].setText("Samsung");
			btn[1].setText("Hyundai");
			btn[2].setText("SK Group");
			btn[3].setText("Hanjin");
		}
		if(current==3)
		{
			label.setText("Que4: What is the capital of Portugal?");
			btn[0].setText("Evora");
			btn[1].setText("Lisbon");
			btn[2].setText("Fero");
			btn[3].setText("Tavora");
		}
		if(current==4)
		{
			label.setText("Que5: What is the world’s smallest bird?");
			btn[0].setText("Kingfisher");
			btn[1].setText("Kiwi");
			btn[2].setText("Cocktail");
			btn[3].setText("Bee Hummingbird");
		}
		if(current==5)
		{
			label.setText("Que6: What is the chemical name for silver?");
			btn[0].setText("Argentum");
			btn[1].setText("Plumbsum");
			btn[2].setText("Aurum");
			btn[3].setText("Actinium");
		}
		if(current==6)
		{
			label.setText("Que7: In which year was 'The Godfather' first released?");
			btn[0].setText("1975");
			btn[1].setText("1969");
			btn[2].setText("1972");
			btn[3].setText("1967");
		}
		if(current==7)
		{
			label.setText("Que8: Who played Mary Poppins in the 1964 film Mary Poppins?");
			btn[0].setText("Eryl Streep");
			btn[1].setText("Julie Andrews");
			btn[2].setText("Elsa Lanchester");
			btn[3].setText("Angela Lansbury");		
		}
		if(current==8)
		{
			label.setText("Que9: Which famous actor famous for his portrayal of James Bond, passed away recently?");
			btn[0].setText("Roger Moore");
			btn[1].setText("Pierce Brosnan");
			btn[2].setText("Timothy Dalton");
			btn[3].setText("Sean Connery");
		}
		if(current==9)
		{
			label.setText("Que10: ‘Losing my religion‘ was a hit for which alternative Rock Band in 1991?");
			btn[0].setText("INXS");
			btn[1].setText("Nirvana");
			btn[2].setText("R.E.M.");
			btn[3].setText("Oasis");
		}
		label.setBounds(30,40,450,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			btn[j].setBounds(50,80+i,200,20);
	}
	boolean check()
	{
		if(current==0)
			return(btn[0].isSelected());
		if(current==1)
			return(btn[2].isSelected());
		if(current==2)
			return(btn[0].isSelected());
		if(current==3)
			return(btn[1].isSelected());
		if(current==4)
			return(btn[3].isSelected());
		if(current==5)
			return(btn[0].isSelected());
		if(current==6)
			return(btn[2].isSelected());
		if(current==7)
			return(btn[1].isSelected());
		if(current==8)
			return(btn[3].isSelected());
		if(current==9)
			return(btn[2].isSelected());
		return false;
	}
	public static void main(String s[])
	{
		new QuizSimulation("GK Quiz Simulation");
	}


}
