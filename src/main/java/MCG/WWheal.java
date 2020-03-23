package main.java.MCG;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class WWheal extends JFrame implements MouseMotionListener,ActionListener,ItemListener
{
	static JFrame f1,f2;
	static JLabel l1,l2,l3,l4,l5,l6;
	static JButton b1,b2,b3,b4,b5,b6,b7;
	static JRadioButton r1,r2,r3,r4,r5,r6;
	static ButtonGroup rbg1,rbg2;
	static JComboBox cb1,cb2,cr1,cr2;
	static GraphicsEnvironment ge;
	static GraphicsDevice screen;
	static Rectangle rect;
	static int pid,psession,sshot,xscore,yscore,sx,sy,p1id,p2id,jop,x,y;
	protected static String pteam=" ";
	static String[] JOPB = {"Yes","No"};
	protected static String playerlist[]=new String[11];
	
	public WWheal()
	{
		System.out.println("Started");
		System.out.println();
		playerlist[0]="A";
		playerlist[1]="B";
		playerlist[2]="C";
		playerlist[3]="D";
		playerlist[4]="E";
		playerlist[5]="F";
		playerlist[6]="G";
		playerlist[7]="H";
		playerlist[8]="I";
		playerlist[9]="J";
		playerlist[10]="k";
		ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
		screen=ge.getDefaultScreenDevice();
		rect=screen.getDefaultConfiguration().getBounds();
		sx=(int)(rect.getMaxX());
		sy=(int)(rect.getMaxY());
		f1=new JFrame();
		f2=new JFrame();
		b1=new JButton("1");
		b2=new JButton("2");
		b3=new JButton("3");
		b4=new JButton("4");
		b5=new JButton("6");
		b6=new JButton("X");
		b7=new JButton("_");
		r1=new JRadioButton("MCG 1st");
		r2=new JRadioButton("RCG 1st");
		r3=new JRadioButton("MCG 2nd");
		r4=new JRadioButton("RCG 2nd");
		r5=new JRadioButton();
		r6=new JRadioButton();
		rbg1=new ButtonGroup();
		rbg2=new ButtonGroup();
		cb1=new JComboBox();
		cb2=new JComboBox();
		rbg1.add(r1);
		rbg1.add(r2);
		rbg1.add(r3);
		rbg1.add(r4);
		rbg2.add(r5);
		rbg2.add(r6);
		l1=new JLabel();
		l2=new JLabel("Plaese Select a Type");
		l3=new JLabel("Select an Inning");
		l4=new JLabel("Select 1st Player");
		l5=new JLabel("Select 2nd Player");
		l6=new JLabel("Select Active Player");
		l6.setHorizontalAlignment(SwingConstants.CENTER);
		l6.setFont(new Font("Century Gothic", Font.BOLD, 18));
		l5.setHorizontalAlignment(SwingConstants.CENTER);
		l5.setFont(new Font("Century Gothic", Font.BOLD, 18));
		l4.setHorizontalAlignment(SwingConstants.CENTER);
		l4.setFont(new Font("Century Gothic", Font.BOLD, 18));
		l3.setHorizontalAlignment(SwingConstants.CENTER);
		l3.setFont(new Font("Century Gothic", Font.BOLD, 18));
		l1.setIcon(new ImageIcon(WWheal.class.getResource("/main/java/IMG/Ground.png")));
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		l2.setFont(new Font("Century Gothic", Font.BOLD, 18));
		l1.setAlignmentX(Component.CENTER_ALIGNMENT);
		l1.setBounds(0,0,1920,1080);
		l2.setBounds(69,255,266,25);
		l3.setBounds(59,15,266,25);
		l4.setBounds(21,95,160,25);
		l5.setBounds(202,95,160,25);
		l6.setBounds(92,175,200,25);
		b1.setBounds(22,295,50,50);
		b2.setBounds(94,295,50,50);
		b3.setBounds(166,295,50,50);
		b4.setBounds(238,295,50,50);
		b5.setBounds(310,295,50,50);
		b6.setBounds(1870,0,50,30);
		b7.setBounds(1821,0,50,30);
		r1.setBounds(12,55,80,25);
		r2.setBounds(104,55,80,25);
		r3.setBounds(196,55,80,25);
		r4.setBounds(288,55,80,25);
		r5.setBounds(48,215,150,25);
		r6.setBounds(226,215,150,25);
		cb1.setBounds(28,135,150,25);
		cb2.setBounds(206,135,150,25);
		b1.setEnabled(false);
		b2.setEnabled(false);
		b3.setEnabled(false);
		b4.setEnabled(false);
		b5.setEnabled(false);
		cb1.setEnabled(false);
		cb2.setEnabled(false);
		r5.setEnabled(false);
		r6.setEnabled(false);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		r1.addActionListener(this);
		r2.addActionListener(this);
		r3.addActionListener(this);
		r4.addActionListener(this);
		r5.addActionListener(this);
		r6.addActionListener(this);
		cb1.addActionListener(this);
		cb2.addActionListener(this);
		l1.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				{
					xscore=e.getX();
					yscore=e.getY();
					selectui(f2);
				}
			}
		}
		);
		//selectui(f2);
		mainui(f1);
	}
	public static void team()
	{
		if(psession==1)
		{
			pteam="MCG";
		}
		else if(psession==2)
		{
			pteam="RCG";
		}
		else if(psession==3)
		{
			pteam="MCG";
		}
		else if(psession==4)
		{
			pteam="RCG";
		}
	}
	public static void adder()
	{
		System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
		System.out.println();
		System.out.println("Player ID : "+pid);
		System.out.println("Player Team : "+pteam);
		System.out.println("Session : "+psession);
		System.out.println("Shot : "+sshot);
		System.out.println("X : "+xscore);
		System.out.println("y : "+yscore);
		jop=JOptionPane.showOptionDialog(null,"Are You Sure To Insert This Data ?","Choose Your Option",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,JOPB,JOPB[0]);
		if(jop==0)
		{
			try
			{
				main.java.httpRequestHandler.ReqHandler.addShot(pid,pteam,psession,sshot,xscore,yscore);
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
			f2.dispose();
        }	
	}
	public static void arrayadder()
	{
		playerlist[0]="";
		playerlist[1]="";
		playerlist[2]="";
		playerlist[3]="";
		playerlist[4]="";
		playerlist[5]="";
		playerlist[6]="";
		playerlist[7]="";
		playerlist[8]="";
		playerlist[9]="";
		playerlist[9]="";
		team();
		cb1.setEnabled(true);
		cb2.setEnabled(true);
		try
		{
			main.java.httpRequestHandler.ReqHandler.players();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		for(int i=0;i<=10;i++)
		{
			cb1.addItem(playerlist[i]);
			cb2.addItem(playerlist[i]);
		}
		//cb1.setSelectedIndex(10);
		//cb2.setSelectedIndex(10);
		cb1.revalidate();
		cb2.revalidate();
	}
	public void actionPerformed(ActionEvent a)
	{
		if(a.getSource()==b1)
		{
			sshot=1;
			adder();
		}
		else if(a.getSource()==b2)
		{
			sshot=2;
			adder();
		}
		else if(a.getSource()==b3)
		{
			sshot=3;
			adder();
		}
		else if(a.getSource()==b4)
		{
			sshot=4;
			adder();
		}
		else if(a.getSource()==b5)
		{
			sshot=6;
			adder();
		}
		else if(a.getSource()==b6)
		{
			System.exit(0);
		}
		else if(a.getSource()==b7)
		{
			f1.setState(ICONIFIED);
		}
		if(a.getSource()==r1)
		{
			psession=1;
			arrayadder();
		}
		else if(a.getSource()==r2)
		{
			psession=2;
			arrayadder();
		}
		else if(a.getSource()==r3)
		{
			psession=3;
			arrayadder();
		}
		else if(a.getSource()==r4)
		{
			psession=4;
			arrayadder();
		}
		if(a.getSource()==r5)
		{
			pid=p1id;
			b1.setEnabled(true);
			b2.setEnabled(true);
			b3.setEnabled(true);
			b4.setEnabled(true);
			b5.setEnabled(true);
		}
		else if(a.getSource()==r6)
		{
			pid=p2id;
			b1.setEnabled(true);
			b2.setEnabled(true);
			b3.setEnabled(true);
			b4.setEnabled(true);
			b5.setEnabled(true);
		}
		if(a.getSource()==cb1)
		{
			cr1=(JComboBox)a.getSource();
			p1id=cr1.getSelectedIndex();
			r5.setText(playerlist[p1id]);
			r5.setEnabled(true);
		}
		if(a.getSource()==cb2)
		{
			cr2=(JComboBox)a.getSource();
			p2id=cr2.getSelectedIndex();
			r6.setText(playerlist[p2id]);
			r6.setEnabled(true);
		}
	}
	public static void mainui(JFrame f1)
	{
		f1.setUndecorated(true);
		f1.setVisible(true);
		f1.setSize(1920,1080);
		f1.getContentPane().setLayout(null);
		f1.getContentPane().add(b6);
		f1.getContentPane().add(b7);
		f1.getContentPane().add(l1);
	}
	public static void selectui(JFrame f2)
	{
		f2.setVisible(true);
		f2.setSize(400,400);
		f2.setLocation(xscore,yscore);
		f2.getContentPane().setLayout(null);
		f2.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		f2.setTitle("Ball Type");
		f2.getContentPane().add(b1);
		f2.getContentPane().add(b2);
		f2.getContentPane().add(b3);
		f2.getContentPane().add(b4);
		f2.getContentPane().add(b5);
		f2.getContentPane().add(r1);
		f2.getContentPane().add(r2);
		f2.getContentPane().add(r3);
		f2.getContentPane().add(r4);
		f2.getContentPane().add(r5);
		f2.getContentPane().add(r6);
		f2.getContentPane().add(cb1);
		f2.getContentPane().add(cb2);
		f2.getContentPane().add(l2);
		f2.getContentPane().add(l3);
		f2.getContentPane().add(l4);
		f2.getContentPane().add(l5);
		f2.getContentPane().add(l6);
	}
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		new WWheal();
	}
	public void itemStateChanged(ItemEvent f) 
	{
	}
	public void mouseDragged(MouseEvent e) 
	{
		x=e.getXOnScreen();
		y=e.getYOnScreen();
		this.setLocation(x-xscore,y-yscore);
	}
	public void mouseMoved(MouseEvent e) 
	{
	}
}