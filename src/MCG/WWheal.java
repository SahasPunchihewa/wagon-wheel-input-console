package MCG;
import javax.swing.*;


import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
public class WWheal extends JFrame implements MouseMotionListener,ActionListener
{
	static JFrame f1,f2;
	static JLabel l1,l2;
	static JButton b1,b2,b3,b4,b5;
	protected static int pid,psession,sshot,xscore,yscore;
	protected static String pTeam=" ";
	
	public WWheal()
	{
		f1=new JFrame();
		f2=new JFrame();
		b1=new JButton("1");
		b2=new JButton("2");
		b3=new JButton("3");
		b4=new JButton("4");
		b5=new JButton("6");
		l1=new JLabel();
		l2=new JLabel("Plaese Select a Type");
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
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		l1.setIcon(new ImageIcon(WWheal.class.getResource("/IMG/Ground.png")));
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
	public void actionPerformed(ActionEvent a) 
	{
		if(a.getSource()==b1)
		{
			sshot=1;
			System.out.println(sshot);
			System.exit(0);
		}
		if(a.getSource()==b2)
		{
			sshot=2;
			System.out.println(sshot);
		}
		if(a.getSource()==b3)
		{
			sshot=3;
			System.out.println(sshot);
		}
		if(a.getSource()==b4)
		{
			sshot=4;
			System.out.println(sshot);
		}
		if(a.getSource()==b5)
		{
			sshot=6;
			System.out.println(sshot);
		}
	}
	public static void main(String[] args) 
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
		f1.getContentPane().add(l1);
	}
	public static void selectui(JFrame f2)
	{
		f2.setVisible(true);
		f2.setSize(400,200);
		f2.getContentPane().setLayout(null);
		f2.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		f2.setTitle("Ball Type");
		f2.getContentPane().add(b1);
		f2.getContentPane().add(b2);
		f2.getContentPane().add(b3);
		f2.getContentPane().add(b4);
		f2.getContentPane().add(b5);
		f2.getContentPane().add(l2);
	}
	public void mouseDragged(MouseEvent e) 
	{
	}
	public void mouseMoved(MouseEvent e) 
	{
	}
}