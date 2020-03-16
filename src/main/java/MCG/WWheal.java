package main.java.MCG;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class WWheal extends JFrame implements MouseMotionListener,ActionListener,ItemListener
{
	static JFrame f1,f2;
	static JLabel l1,l2;
	static JButton b1,b2,b3,b4,b5,b6,b7;
	static JRadioButton r1,r2,r3,r4;
	static ButtonGroup rbg;
	static GraphicsEnvironment ge;
	static GraphicsDevice screen;
	static Rectangle rect;
	static int pid,psession,sshot,xscore,yscore,sx,sy;
	static String pTeam=" ";
	
	public WWheal()
	{
		System.out.println("Started");
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
		rbg=new ButtonGroup();
		rbg.add(r1);
		rbg.add(r2);
		rbg.add(r3);
		rbg.add(r4);
		l1=new JLabel();
		l2=new JLabel("Plaese Select a Type");
		l1.setIcon(new ImageIcon(WWheal.class.getResource("/main/java/IMG/Ground.png")));
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		l2.setFont(new Font("Century Gothic", Font.BOLD, 20));
		l1.setAlignmentX(Component.CENTER_ALIGNMENT);
		l1.setBounds(0,0,1920,1080);
		l2.setBounds(59,24,266,50);
		b1.setBounds(23,85,50,50);
		b2.setBounds(95,85,50,50);
		b3.setBounds(167,85,50,50);
		b4.setBounds(239,85,50,50);
		b5.setBounds(311,85,50,50);
		b6.setBounds(1870,0,50,30);
		b7.setBounds(1821,0,50,30);
		r1.setBounds(19,205,72,50);
		r2.setBounds(110,205,72,50);
		r3.setBounds(201,205,72,50);
		r4.setBounds(292,205,72,50);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		r1.addItemListener(this);
		r2.addItemListener(this);
		r3.addItemListener(this);
		r4.addItemListener(this);
		l1.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				{
					xscore=e.getX();
					yscore=e.getY();
					System.out.println("x : "+xscore);
					System.out.println("Y : "+yscore);
					selectui(f2);
				}
			}
		}
		);
		//selectui(f2);
		mainui(f1);
	}
	public void itemStateChanged(ItemEvent f) 
	{
		if(f.getItemSelectable()==rbg)
		{
			if(f.getItemSelectable()==r1)
			{
				System.out.println("MCG 1");
			}
			//System.out.println("MCG 1");
		}
	}
	public void actionPerformed(ActionEvent a) 
	{
		if(a.getSource()==b1)
		{
			sshot=1;
			System.out.println(sshot);
		}
		else if(a.getSource()==b2)
		{
			sshot=2;
			System.out.println(sshot);
		}
		else if(a.getSource()==b3)
		{
			sshot=3;
			System.out.println(sshot);
		}
		else if(a.getSource()==b4)
		{
			sshot=4;
			System.out.println(sshot);
		}
		else if(a.getSource()==b5)
		{
			sshot=6;
			System.out.println(sshot);
		}
		else if(a.getSource()==b6)
		{
			System.exit(0);
		}
		else if(a.getSource()==b7)
		{
			f1.setState(ICONIFIED);
		}
	}
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		new WWheal();
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
		f2.setLocation((960-200),(540-400));
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
		f2.getContentPane().add(l2);
	}
	public void mouseDragged(MouseEvent e) 
	{
	}
	public void mouseMoved(MouseEvent e) 
	{
	}
}