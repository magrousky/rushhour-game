package gui;

import javax.swing.*;

import java.util.Queue;

import java.util.Date;
import java.util.LinkedList;
import java.util.Vector;
import java.text.SimpleDateFormat;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;  
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.io.BufferedReader;  
import java.io.BufferedWriter;  
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;  
import java.*;
public class gui {


	public static void main(String[] args)
	{
//		new PassWord();
		
		ZhuFrame frame =new ZhuFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new PassWord(frame);
		
	}

}

class ZhuFrame extends JFrame implements MouseListener
{
	
	JButton m1,m2,m3;
	JLabel m,n;
	public ZhuFrame()
	{
		setVisible(false);
		init();
		validate();
		
	}
	public void init()
	{
		URL url;
		File file= new File("music//��������.wav");
		 try{
			 url=file.toURL();
			 AudioClip clip =Applet.newAudioClip(url);
			 clip.play();
		 }catch(MalformedURLException e){
			 e.printStackTrace();
		 }
		 
		ImageIcon imageIcon = new ImageIcon("Image//��������.png"); 
		ImageIcon imageIcon1 = new ImageIcon("Image//��ť11.png"); 
		ImageIcon imageIcon2 = new ImageIcon("Image//��ť22.png"); 
		String s="author:��Խ ��ӽ� ��̩";
	     n=new JLabel(s);
	     n.setFont(new Font("����",Font.BOLD, 16));
	     n.setForeground(Color.white);
	     n.setBounds(900,600,200,100);
	     add(n);
		m=new JLabel(imageIcon);
		m.setBounds(0,0,1200,800);
		setBounds(0,0,1200,800);
		 setLayout(null);
		 m1=new JButton(imageIcon1);
		 m2=new JButton(imageIcon2);
		 Color c = new Color(255,245,170);//��Ӱ��ɫ���������ֵ,ֻ��ռλ���á�  
         m1.setBackground(c);  
         m1.setOpaque(false); 
         m1.setBorderPainted(false);
         m2.setBackground(c);  
         m2.setOpaque(false); 
         m2.setBorderPainted(false);
		 m1.setBounds(475,350,200,54);
		 m2.setBounds(475,500,200,54);
		 m1.addMouseListener(this);
		 m2.addMouseListener(this);
		 add(m1);
		 add(m2);
		 add(m);
		 
		 


	}
	public void mouseClicked(MouseEvent e) 
	{
		JButton a=(JButton)e.getSource();
		int y=a.getY();
		if(y==350)
			{
			setVisible(false);
			RushhourFrame1 frame1 =new RushhourFrame1();
			frame1.init(1,1,0,0);
			frame1.setVisible(true);
			}
		else
			{
			setVisible(false);
			RushhourFrame frame2=new RushhourFrame();
			frame2.setVisible(true);
			}
			
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}
	
}

class RushhourFrame extends JFrame implements MouseListener,MouseMotionListener,ActionListener
{
	
	int[]A=new int[100];//��¼���úᳵ������˳��
	Car [] hengcar=new Car[20];
	Car [] shucar=new Car[20];
	Car [] hengtruck=new Car[20];
	Car [] shutruck=new Car[20];
	int[]X={100,200,300,400,500,600};
	int[]Y={100,200,300,400,500,600};
	int ox,oy;//�϶����õĳ�ʼ����
	int hk=0,sk=0,ak=0,hkt=0,skt=0;
	int flag;
	int owncarx=100;
	Point p;
	Car owncar;
	JButton left,right,above,below;
	JLabel beijing;
	Car start;
	Car heng,heng2,shu,shu2;
	
	public RushhourFrame()
	{
		init();
		setVisible(false);
	    validate();
	}
	public void init()
	 {
		 setBounds(0,0,1200,800);
		 setLayout(null);
		 
		 //������Ե
		 left=new JButton();
        right=new JButton();
        above=new JButton();
        below = new JButton();
        add(left);
        add(right);
        add(above);
        add(below);
        left.setBounds (90, 90, 8, 608);
        right.setBounds(700, 90, 8, 608);
        above.setBounds(90, 90, 608,8);
        below.setBounds(90, 700,608,8);
        
        //����ѡ��ť
        heng=new Car(0,-1,"h");
        heng2=new Car(0,-3,"h");
        shu=new Car(0,-2,"s");
        shu2=new Car(0,-4,"s");
        ImageIcon icon1=new ImageIcon("Image//hengcar.png");
		 heng.setIcon(icon1);
		 ImageIcon icon2=new ImageIcon("Image//shucar.png");
		 shu.setIcon(icon2);
		 ImageIcon icon3=new ImageIcon("Image//hengtruck.png");
		 heng2.setIcon(icon3);
		 ImageIcon icon4=new ImageIcon("Image//shutruck.png");
		 shu2.setIcon(icon4);
        add(heng);
        add(heng2);
        add(shu);
        add(shu2);
        heng.setBounds(800,200,200,100);
        shu.setBounds(800,400,100,200);
        heng2.setBounds(800,100,300,100);
        shu2.setBounds(900,400,100,300);
        heng.addMouseListener(this);
		heng.addMouseMotionListener(this);
		heng2.addMouseListener(this);
		heng2.addMouseMotionListener(this);
		shu.addMouseListener(this);
		shu.addMouseMotionListener(this);
		shu2.addMouseListener(this);
		shu2.addMouseMotionListener(this);
		ImageIcon imageIcon1 = new ImageIcon("Image//redcar.png"); 
		 owncar=new Car(-1,1,"ma");
		 owncar.addMouseListener(this);
		 owncar.addMouseMotionListener(this);
		 owncar.setBounds(100,300,198,98);
	     owncar.setIcon(imageIcon1);
		 add(owncar);
		 
		 
		 //��ʼ��Ϸ
		 start=new Car(100,100,"start");
		 start.setBounds(800,600,100,50);
		 start.addMouseListener(this);
		 start.setOpaque(true); 
         start.setBorderPainted(true);
		 add(start);
		 
		 //������ť
		 Car re;
		 re=new Car(200,200,"return");
		 re.setBounds(800,650,100,50);
		 re.addMouseListener(this);
		 re.setOpaque(true); 
         re.setBorderPainted(true);
		 add(re);
		 
		 //����
		 //ImageIcon imageIcon = new ImageIcon("Image//����.png"); 
		 //beijing=new JLabel(imageIcon);
		 //beijing.setBounds(90,90,620,620);
		 //add(beijing);
	 }
	
	public void mousePressed(MouseEvent e)
    {
         ox=e.getX();
         oy=e.getY();
         
    }
    
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    
    public void mouseDragged(MouseEvent e) {
		// TODO �Զ����ɵķ������
   	Car car=(Car)e.getSource();
   	if(car.number!=-1)
		{
   		int fx=e.getX()-ox;
		int fy=e.getY()-oy;
		p=car.getLocation();
		int x=p.x+fx;
		int y=p.y+fy;
		car.setLocation(x,y);
		}
   	if(car.number==-1)
   	{
   		int fx=e.getX()-ox;
 		int fy=e.getY()-oy;
 		p=car.getLocation();
 		int x=p.x+fx;
 		int y=p.y+fy;
 		if(car.biaoji==1||car.biaoji==3)
 			go(car,left,right,x);
   	}
       
	}
    public void go(Car car, JButton direction1,JButton direction2,int t) {
   	 flag=1;
   	 int i;
   	 Rectangle carnext=car.getBounds();
   	 int x=car.getBounds().x;
        int y=car.getBounds().y;
        if(direction1==left)x=t;
	         else if(direction1==below)y=t;
        carnext.setLocation(x,y);
        Rectangle directionRect1=direction1.getBounds();
        Rectangle directionRect2=direction2.getBounds();
        for(int k=0;k<sk;k++)
	        {
	            Rectangle carRect=shucar[k].getBounds();
	            if(carnext.intersects(carRect)&&(car.number!=k||car.biaoji!=2))
	                flag=0;
	        }
       for(int k=0;k<hk;k++)
	        {
	            Rectangle carRect=hengcar[k].getBounds();
	            if(carnext.intersects(carRect)&&(car.number!=k||car.biaoji!=1))
	                flag=0;
	        }
       for(int k=0;k<skt;k++)
       {
           Rectangle carRect=shutruck[k].getBounds();
           if(carnext.intersects(carRect)&&(car.number!=k||car.biaoji!=4))
               flag=0;
       }
       for(int k=0;k<hkt;k++)
	        {
	            Rectangle carRect=hengtruck[k].getBounds();
	            if(carnext.intersects(carRect)&&(car.number!=k||car.biaoji!=3))
	                flag=0;
	        }
        if(carnext.intersects(directionRect1)||carnext.intersects(directionRect2))
	            flag=0;
        
        if(flag==1)
       	 {car.setLocation(x,y);}
    }
	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		dispose();  //ע��
        new RushhourFrame();
	}
	@Override
	public void mouseClicked(MouseEvent e1) {
		int i;
		Car start=(Car)e1.getSource();
		int y=start.getY();
		if(y==600)
		{try {
            FileOutputStream out=new FileOutputStream("Level\\test.txt");
            PrintStream p=new PrintStream(out);
            p.print(hk+"\r\n");
            for(i=0;i<hk;i++)
            	p.print(hengcar[i].x+"\r\n"+hengcar[i].y+"\r\n");
            p.print(sk+"\r\n");
            for(i=0;i<sk;i++)
            	p.print(shucar[i].x+"\r\n"+shucar[i].y+"\r\n");
            p.print(hkt+"\r\n");
            for(i=0;i<hkt;i++)
            	p.print(hengtruck[i].x+"\r\n"+hengtruck[i].y+"\r\n");
            p.print(skt+"\r\n");
            for(i=0;i<skt;i++)
            	p.print(shutruck[i].x+"\r\n"+shutruck[i].y+"\r\n");
            p.print(owncarx+"\r\n");
            p.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();}
		dispose();
		int sf=0;
		if(owncarx==100&&shucar[0].x==300)
		{
			sf=4;
		}
		else if(owncarx==200&&shucar[0].x==600)
		{
			sf=5;
		}
		else if(owncarx==300&&shucar[0].x==600)
		{
			sf=6;
		}
		else if(owncarx==100&&shucar[0].y==100&shucar[1].y==300&&hengtruck[0].x==300)
		{
			sf=7;
		}
		else {sf=10;}
		RushhourFrame1 frame1 =new RushhourFrame1();
		frame1.setVisible(true);
		frame1.init(2,0,0,sf);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		if(y==650)
		{
			ak--;
			if(A[ak]==1)
			{
				hk--;
				hengcar[hk].setVisible(false);
			}
			else if(A[ak]==2)
			{
				sk--;
				shucar[sk].setVisible(false);
			}
			else if(A[ak]==3)
			{
				hkt--;
				hengtruck[hkt].setVisible(false);
			}
			else if(A[ak]==4)
			{
				skt--;
				shutruck[skt].setVisible(false);
			}
			
		}
			
	}
	@Override
	public void mouseReleased(MouseEvent e)
	{
		
		Car car=(Car)e.getSource();
		p=car.getLocation();
		int i;
		int x=p.x;
		int y=p.y;
		if((x!=800&&y!=600)||(x!=800&&y!=650))
		{for(i=0;i<5;i++)
   	    {
   		 if(x>X[i]&&x<=X[i+1])
   			 {if(x>(X[i]+X[i+1])/2)
   			     {x=X[i+1];}
   			 else
   				 {x=X[i];}
   			 }
   	    }
        for(i=0;i<5;i++)
   		 {if(y>Y[i]&&y<=Y[i+1])
   		     {if(y>(Y[i]+Y[i+1])/2)
			     {y=Y[i+1];}
			 else
				 {y=Y[i];}
   		     }
   		 }
        
        if(car.biaoji==-1)                          //�ص��ж�
        {
        	flag=1;
        	if(x>650||x<50||y<50||y>650)
        		flag=0;
        	Rectangle carnext=new Rectangle(x,y,198,98);
        	for(int k=0;k<hk;k++)
	        {
	            Rectangle carRect=hengcar[k].getBounds();
	            if(carnext.intersects(carRect))
	                flag=0;
	        }
            for(int k=0;k<sk;k++)
 	        {
 	            Rectangle carRect=shucar[k].getBounds();
 	            if(carnext.intersects(carRect))
 	                flag=0;
 	        }
            for(int k=0;k<hkt;k++)
	        {
	            Rectangle carRect=hengtruck[k].getBounds();
	            if(carnext.intersects(carRect))
	                flag=0;
	        }
            for(int k=0;k<skt;k++)
	        {
	            Rectangle carRect=shutruck[k].getBounds();
	            if(carnext.intersects(carRect))
	                flag=0;
	        }
        Rectangle left1=left.getBounds();
        Rectangle right1=right.getBounds();
        Rectangle above1=above.getBounds();
        Rectangle below1=below.getBounds();
        if(carnext.intersects(left1)||carnext.intersects(right1)||carnext.intersects(above1)||carnext.intersects(below1))
             flag=0;
        if(flag==1)
        {hengcar[hk]=new Car(hk,1,"h");
        ImageIcon icon2=new ImageIcon("Image//hengcar.png");
		 hengcar[hk].setIcon(icon2);
    	add(hengcar[hk]);
    	hengcar[hk].setBounds(x,y,198,98);
    	hengcar[hk].x=x;
    	hengcar[hk].y=y;
        hk++;
        A[ak]=1;
        ak++;
        }
        car.setLocation(800,200);
        }
        else if(car.biaoji==-2)
        {
        	flag=1;
        	if(x>650||x<50||y<50||y>500)
        		flag=0;
        	Rectangle carnext=new Rectangle(x,y,98,198);
        	for(int k=0;k<hk;k++)
	        {
	            Rectangle carRect=hengcar[k].getBounds();
	            if(carnext.intersects(carRect))
	                flag=0;
	        }
            for(int k=0;k<sk;k++)
 	        {
 	            Rectangle carRect=shucar[k].getBounds();
 	            if(carnext.intersects(carRect))
 	                flag=0;
 	        }
            for(int k=0;k<hkt;k++)
	        {
	            Rectangle carRect=hengtruck[k].getBounds();
	            if(carnext.intersects(carRect))
	                flag=0;
	        }
            for(int k=0;k<skt;k++)
	        {
	            Rectangle carRect=shutruck[k].getBounds();
	            if(carnext.intersects(carRect))
	                flag=0;
	        }
        Rectangle left1=left.getBounds();
        Rectangle right1=right.getBounds();
        Rectangle above1=above.getBounds();
        Rectangle below1=below.getBounds();
        if(carnext.intersects(left1)||carnext.intersects(right1)||carnext.intersects(above1)||carnext.intersects(below1))
             flag=0;
        if(flag==1)
        	{shucar[sk]=new Car(sk,2,"s");
        	ImageIcon icon2=new ImageIcon("Image//shucar.png");
   		    shucar[sk].setIcon(icon2);
        	add(shucar[sk]);
        	shucar[sk].setBounds(x,y,98,198);
        	shucar[sk].x=x;
        	shucar[sk].y=y;
        	sk++;
        	A[ak]=2;
        	ak++;
        	}
        car.setLocation(800,400);
        }
        else if(car.biaoji==-3)
        {
        	flag=1;
        	if(x>650||x<50||y<50||y>650)
        		flag=0;
        	Rectangle carnext=new Rectangle(x,y,298,98);
        	for(int k=0;k<hk;k++)
	        {
	            Rectangle carRect=hengcar[k].getBounds();
	            if(carnext.intersects(carRect))
	                flag=0;
	        }
            for(int k=0;k<sk;k++)
 	        {
 	            Rectangle carRect=shucar[k].getBounds();
 	            if(carnext.intersects(carRect))
 	                flag=0;
 	        }
            for(int k=0;k<hkt;k++)
	        {
	            Rectangle carRect=hengtruck[k].getBounds();
	            if(carnext.intersects(carRect))
	                flag=0;
	        }
            for(int k=0;k<skt;k++)
	        {
	            Rectangle carRect=shutruck[k].getBounds();
	            if(carnext.intersects(carRect))
	                flag=0;
	        }
        Rectangle left1=left.getBounds();
        Rectangle right1=right.getBounds();
        Rectangle above1=above.getBounds();
        Rectangle below1=below.getBounds();
        if(carnext.intersects(left1)||carnext.intersects(right1)||carnext.intersects(above1)||carnext.intersects(below1))
             flag=0;
        if(flag==1)
        	{hengtruck[hkt]=new Car(hkt,3,"s");
        	ImageIcon icon3=new ImageIcon("Image//hengtruck.png");
   		    hengtruck[hkt].setIcon(icon3);
        	add(hengtruck[hkt]);
        	hengtruck[hkt].setBounds(x,y,298,98);
        	hengtruck[hkt].x=x;
        	hengtruck[hkt].y=y;
        	hkt++;
        	A[ak]=3;
        	ak++;
        	}
        car.setLocation(800,100);
        }
        else if(car.biaoji==-4)
        {
        	flag=1;
        	if(x>650||x<50||y<50||y>650)
        		flag=0;
        	Rectangle carnext=new Rectangle(x,y,98,298);
        	for(int k=0;k<hk;k++)
	        {
	            Rectangle carRect=hengcar[k].getBounds();
	            if(carnext.intersects(carRect))
	                flag=0;
	        }
            for(int k=0;k<sk;k++)
 	        {
 	            Rectangle carRect=shucar[k].getBounds();
 	            if(carnext.intersects(carRect))
 	                flag=0;
 	        }
            for(int k=0;k<hkt;k++)
	        {
	            Rectangle carRect=hengtruck[k].getBounds();
	            if(carnext.intersects(carRect))
	                flag=0;
	        }
            for(int k=0;k<skt;k++)
	        {
	            Rectangle carRect=shutruck[k].getBounds();
	            if(carnext.intersects(carRect))
	                flag=0;
	        }
        Rectangle left1=left.getBounds();
        Rectangle right1=right.getBounds();
        Rectangle above1=above.getBounds();
        Rectangle below1=below.getBounds();
        if(carnext.intersects(left1)||carnext.intersects(right1)||carnext.intersects(above1)||carnext.intersects(below1))
             flag=0;
        if(flag==1)
        	{shutruck[skt]=new Car(skt,4,"s");
        	ImageIcon icon3=new ImageIcon("Image//shutruck.png");
   		    shutruck[skt].setIcon(icon3);
        	add(shutruck[skt]);
        	shutruck[skt].setBounds(x,y,98,298);
        	shutruck[skt].x=x;
        	shutruck[skt].y=y;
        	skt++;
        	A[ak]=4;
        	ak++;
        	}
        car.setLocation(900,400);
        }
        else if(car.biaoji==1)
        {
        	car.setLocation(x,y);
        	owncarx=x;
        }
        
		}
	}
	
		
		
		
}

class RushhourFrame1 extends JFrame implements MouseListener,MouseMotionListener,ActionListener
{
	int jj=0;
	int jcount;
	int[]X={100,200,300,400,500,600};
	int[]Y={100,200,300,400,500,600};
	int[]guocheng=new int[10000];
	int[]guochengxin=new int[10000];
	int bushu=0;
	int []paiming= new int[10];
	int ox,oy;//�϶����õĳ�ʼ����
	int oox,ooy;
	int hk,sk,hkt,skt;
	int flag;
	int level;
	int owncarx;
	int iii=0;
	Point p;
	Car [] hengcar=new Car[20];
	Car [] shucar=new Car[20];
	Car [] hengtruck=new Car[20];
	Car [] shutruck=new Car[20];
	Car owncar;
	JButton left,right,above,below;
	JLabel beijing;
	JLabel guanka;
	Car huiqi;
	int i;
	int levelflag;//�����ļ��Ķ�ȡ
	Vector<data1> temp=new Vector<data1>();
	Vector<Vector<data1>> ans=new Vector<Vector<data1> >();
	 Vector<Vector<data1>> vis=new Vector<Vector<data1> >();
	
	int carcount;
	 int dx[]={100,-100};
	 int dy[]={100,-100};
	
	int solveflag;
	//ʱ��
	JLabel lbl=new JLabel();
	Date now=new Date();
	int feng=0;
	Timer timer=new Timer(1000,new ActionListener(){

		 public void actionPerformed(ActionEvent e) {

		 Date now2=new Date(now.getTime()+1000);
		 now=now2;
		 feng=feng+10;
		 SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

		 lbl.setText(formatter.format(now));
		 }

		 });
		 
	
	public RushhourFrame1()
	{
		setVisible(false);
	    validate();
	}
	 public void init(int levelf,int l,int hui,int sf)
	 {
		 JMenuBar menuBar=new JMenuBar();
		 setJMenuBar(menuBar);
		 JMenu editMenu = new JMenu("Edit");
		 menuBar.add(editMenu);
		 JMenuItem newgame = new JMenuItem("������Ϸ");
		 editMenu.add(newgame);
		 JMenuItem return1 = new JMenuItem("�������˵�");
		 editMenu.add(return1);
	     newgame.addActionListener(this);
	     return1.addActionListener(this);
	     
	     
	     
		 now.setHours(0);
		 now.setMinutes(0);
		 now.setSeconds(0);
		 if(levelf==1)
		 {timer.start();
		 lbl.setBounds(800,100,100,100);
		 add(lbl);}
		 setBounds(0,0,1200,800);
		 setLayout(null);
		 solveflag=sf;
		 levelflag=levelf;
		 level=l;
		 int t=levelflag;
		 int level=l;  //�ؿ��޸Ŀɵò�ͬ��
		 
		 String s="��"+level+"��";
	     guanka=new JLabel(s);
	     guanka.setFont(new Font("����",Font.BOLD, 36));
	     guanka.setBounds(50,0,100,100);
	     add(guanka);
		 
		 
		 //������Ե
		 left=new JButton();
         right=new JButton();
         above=new JButton();
         below = new JButton();
         add(left);
         add(right);
         add(above);
         add(below);
         left.setBounds (90, 90, 8, 608);
         right.setBounds(700, 90, 8, 608);
         above.setBounds(90, 90, 608,8);
         below.setBounds(90, 700,608,8);
         
         
		 hk=0;sk=0;
		 int i,a,b;//�ᳵ������������������
		 try { // ��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ����throw  

             /* ����TXT�ļ� */  
			 String pathname;
			 if(t==1)
			 {pathname = "Level\\level"+level+".txt";}// ����·�������·�������ԣ������Ǿ���·����д���ļ�ʱ��ʾ���·��  
			 else 
			 {pathname = "Level\\test.txt";}
             File filename = new File(pathname); // Ҫ��ȡ����·����input��txt�ļ�  
             InputStreamReader reader = new InputStreamReader(  
                     new FileInputStream(filename)); // ����һ������������reader  
             BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������  
             String line = "";  
             line = br.readLine();  
             hk=Integer.parseInt(line);
             for(i=0;i<hk;i++)
                 {
            	 line = br.readLine();
            	 a=Integer.parseInt(line);   //�����������
            	 line = br.readLine();
            	 b=Integer.parseInt(line);
            	 hengcar[i]= new Car(i,1,"h");   //�ᳵ�ı�Ƕ�Ϊ1
        		 hengcar[i].addMouseListener(this);
        		 hengcar[i].addMouseMotionListener(this);
        		 hengcar[i].setBounds(a,b,198,98);
        		 hengcar[i].x=a;
        		 hengcar[i].y=b;
        		 hengcar[i].biaoji=1;
        		 hengcar[i].setContentAreaFilled(false);
        		 ImageIcon icon2=new ImageIcon("Image//hengcar.png");
        		 hengcar[i].setIcon(icon2);
        		 add(hengcar[i]);
        		 
        		 
                 }
             line = br.readLine();  
             sk=Integer.parseInt(line);
             for(i=0;i<sk;i++)
             {
        	 line = br.readLine();
        	 a=Integer.parseInt(line);   //�����������
        	 line = br.readLine();
        	 b=Integer.parseInt(line);
        	 shucar[i]= new Car(i,2,"s");   //�ᳵ�ı�Ƕ�Ϊ1
    		 shucar[i].addMouseListener(this);
    		 shucar[i].addMouseMotionListener(this);
    		 shucar[i].setBounds(a,b,98,198);
    		 shucar[i].x=a;
    		 shucar[i].y=b;
    		 shucar[i].biaoji=2;
    		 shucar[i].setContentAreaFilled(false);
    		 ImageIcon icon2=new ImageIcon("Image//shucar.png");
    		 shucar[i].setIcon(icon2);
    		 add(shucar[i]);
    		 
             }
             line = br.readLine();  
             hkt=Integer.parseInt(line);
             for(i=0;i<hkt;i++)
             {
            	 line = br.readLine();
            	 a=Integer.parseInt(line);   //�����������
            	 line = br.readLine();
            	 b=Integer.parseInt(line);
            	 hengtruck[i]= new Car(i,3,"h");   //�ᳵ�ı�Ƕ�Ϊ1
        		 hengtruck[i].addMouseListener(this);
        		 hengtruck[i].addMouseMotionListener(this);
        		 hengtruck[i].setBounds(a,b,298,98);
        		 hengtruck[i].x=a;
        		 hengtruck[i].y=b;
        		 hengtruck[i].biaoji=3;
        		 
        		 hengtruck[i].setContentAreaFilled(false);
        		 ImageIcon icon3=new ImageIcon("Image//hengtruck.png");
        		 hengtruck[i].setIcon(icon3);
        		 add(hengtruck[i]);
             }
             line = br.readLine();  
             skt=Integer.parseInt(line);
             for(i=0;i<skt;i++)
             {
            	 line = br.readLine();
            	 a=Integer.parseInt(line);   //�����������
            	 line = br.readLine();
            	 b=Integer.parseInt(line);
            	 shutruck[i]= new Car(i,4,"s");   //�ᳵ�ı�Ƕ�Ϊ1
        		 shutruck[i].addMouseListener(this);
        		 shutruck[i].addMouseMotionListener(this);
        		 shutruck[i].setBounds(a,b,100,300);
        		 shutruck[i].x=a;
        		 shutruck[i].y=b;
        		 shutruck[i].biaoji=4;
        		 
        		 shutruck[i].setContentAreaFilled(false);
        		 ImageIcon icon4=new ImageIcon("Image//shutruck.png");
        		 shutruck[i].setIcon(icon4);
        		 add(shutruck[i]);
             }
             line = br.readLine();  
             owncarx=Integer.parseInt(line);
             ImageIcon icon1=new ImageIcon("Image//redcar.png");
    		 owncar=new Car(-1,1,"ma");
    		 owncar.addMouseListener(this);
    		 owncar.addMouseMotionListener(this);
    		 owncar.setBounds(owncarx,300,198,98);
    		 owncar.setContentAreaFilled(false);
    	     owncar.setIcon(icon1);
    	     owncar.x=owncarx;
    		 owncar.y=300;
    		 owncar.biaoji=1;
    	     
    		 add(owncar);
                 
    		 
    		 
    		 
               
         } catch (Exception e) {  
             e.printStackTrace();  
         }  
		 
		 
		 
		 temp.clear();
		 data1 temp_data= new data1(owncar.x,owncar.y,200,100);
		 temp.add(temp_data);
		 for(i=0;i<hk;i++)
		 {
			 data1 temp_data1= new data1(hengcar[i].x,hengcar[i].y,200,100);
    		 temp.add(temp_data1);
		 }
		 for(i=0;i<sk;i++)
		 {
			 data1 temp_data2= new data1(shucar[i].x,shucar[i].y,100,200);
    		 temp.add(temp_data2);
		 }
		 for(i=0;i<hkt;i++)
		 {
			 data1 temp_data3= new data1(hengtruck[i].x,hengtruck[i].y,300,100);
    		 temp.add(temp_data3);
		 }
		 for(i=0;i<skt;i++)
		 {
			 data1 temp_data4= new data1(shutruck[i].x,shutruck[i].y,100,300);
    		 temp.add(temp_data4);
		 }
		 
		 //ans=solve1(temp);
		 
		 
		 
		 
		 
		 Car huiqi=new Car(-10,0,"����");
		 huiqi.setBounds(800,500,100,50);
		 huiqi.addMouseListener(this);
		 huiqi.setOpaque(true); 
         huiqi.setBorderPainted(true);
		 add(huiqi);
		 
		 Car solve=new Car(-11,0,"�Զ����");
		 solve.setBounds(800,600,100,50);
		 solve.addMouseListener(this);
		 solve.setOpaque(true); 
         solve.setBorderPainted(true);
		 add(solve);
		 
		 ImageIcon imageIcon = new ImageIcon("Image//����.png"); 
		 beijing=new JLabel(imageIcon);
		 beijing.setBounds(90,90,620,620);
		 add(beijing);
		 
		 data1 p=new data1();
		 for(int ii=0;ii<temp.size();ii++){
			 p=(data1) temp.get(ii);
			 System.out.printf("%d %d %d %d\n", p.x,p.y,p.w,p.h);
		 }
		 
		 
		 if(hui==1)
		 {
			 
			 Car xia=new Car(-9,0,"��һ��");
			 xia.setBounds(800,600,100,50);
			 xia.addMouseListener(this);
			 xia.setOpaque(true); 
             xia.setBorderPainted(true);
			 add(xia);
			 huiqi.setVisible(false);
			 solve.setVisible(false);
			 try { // ��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ����throw  

                 /* ����TXT�ļ� */  
    			 String pathname2;
    			 if(solveflag==0)
                 {pathname2 = "Level\\guocheng.txt";}// ����·�������·�������ԣ������Ǿ���·����д���ļ�ʱ��ʾ���·��  
    			 else
    			 {
    				 pathname2 = "Level\\guocheng"+level+".txt";
    			 }
                 File filename = new File(pathname2); // Ҫ��ȡ����·����input��txt�ļ�  
                 InputStreamReader reader = new InputStreamReader(  
                         new FileInputStream(filename)); // ����һ������������reader  
                 BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������  
                 String line = "";
                 jcount=0;
                 line = br.readLine(); 
                 while(line!=null)
                 {
                 int guo=Integer.parseInt(line);
                 guochengxin[jcount]=guo;
                 jcount++;
                 line = br.readLine(); 
                 }
                 guochengxin[jcount]=0;//�����Ž���
                 }
                 catch (Exception e3) {
                     e3.printStackTrace();
                     }
			 
		 }
		
	 }
	
	 

	 
	 public boolean is_end(Vector<data1> a){
		 return a.get(1).x == 500;
	 }
	 public boolean has_vis(Vector<data1> cur){
			for (int i = 0; i < vis.size(); i++)
			{
				Vector<data1> a =  vis.get(i);
				int cntt = 0;
				for (int j = 0; j < a.size(); j++)
				{
					data1 b = a.get(j);
					data1 c = cur.get(j);
					if (b.x==c.x&&b.y==c.y&&b.w==c.w&&b.h==c.h) cntt++;
				}
				if (cntt == carcount) return true;
			}
			return false;
	 }
	 public Vector<Vector<data1>> solve1(Vector<data1> src){
			Rectangle left = new Rectangle(90, 90, 10, 620);
			Rectangle right = new Rectangle(710, 90, 10, 620);
			Rectangle above = new Rectangle(100, 90, 600,10);
			Rectangle below = new Rectangle(100, 700,600,10);
//		 Queue Q<State1> = new LinkedList<Sta>();
			Queue<State1> Q = new LinkedList<State1>();
			State1 s = new State1();
			s.stat = src;//��ǰ״̬
			vis.add(src);
			Q.add(s);
			int cnt = 1;
			carcount = src.size();
			while(cnt>0){
				State1 cur=Q.poll();
				Vector<data1> cur_stat=cur.stat;
				cnt--;
				if(is_end(cur_stat)){
					for (int j = 0; j < cur.steps.size(); j++) ans.add(cur.steps.get(j));
					break;
				}
				for(int ii=0;ii<cur_stat.size();ii++){
					data1 p=(data1) cur_stat.get(ii);
					Rectangle NextRectangle = new Rectangle(p.x, p.y, p.w, p.h);
					if(p.w>=p.h){//���ŵ�
						for(int k=0;k<2;k++){
							int nextx=p.x+dx[k];
							int nexty=p.y;
							NextRectangle.setLocation(nextx, nexty);
							boolean CanMove = true;
							for (int j = 0; j < cur_stat.size(); j++)
							{
								data1 car1 = cur_stat.get(j);
								if (!(car1.x==p.x&&car1.y==p.y&&car1.w==p.w&&car1.h==p.h))
								{
									Rectangle car1Rectangle = new Rectangle(car1.x, car1.y, car1.w, car1.h);
									if (NextRectangle.intersects(car1Rectangle)) CanMove = false;
								}
							}
							//�᲻����Աߵĳ���ײ
							if (NextRectangle.intersects(left))  CanMove = false;
							if (NextRectangle.intersects(right)) CanMove = false;
							if (NextRectangle.intersects(above)) CanMove = false;
							if (NextRectangle.intersects(below)) CanMove = false;
							if (!CanMove) continue;
							Vector<data1> next_stat = new Vector<data1>(carcount);
							//����ǰi����
							for (int j = 0; j < ii; j++) next_stat.add( cur_stat.get(j));
							next_stat.add(new data1(nextx, nexty, p.w, p.h));
							//����ʣ�µĳ�
							for (int j = ii + 1; j < cur_stat.size(); j++) next_stat.add( cur_stat.get(j));

							//next_stat��ʾ�µ�״̬

							State1 next = new State1();
							next.stat = next_stat;
							Vector<Vector<data1>> temp = new Vector<Vector<data1>>(100000);
							for (int j = 0; j < cur.steps.size(); j++) temp.add(cur.steps.get(j));
							temp.add(next_stat);
							next.steps = temp;
							//�ж�����µ�״̬�Ƿ��Ѿ�����,�������˳�
							if (has_vis(next_stat)) continue;
							//���������ڣ���ô��ӵȴ��Ժ������
							vis.add(next_stat);
							Q.add(next);
							cnt++;
						}
					}
					else{//���ŵ�
						for(int k=0;k<2;k++){
							int nextx=p.x;
							int nexty=p.y+dy[k];
							NextRectangle.setLocation(nextx, nexty);
							boolean CanMove=true;
							for (int j = 0; j < cur_stat.size(); j++)
							{
								data1 car1 = cur_stat.get(j);
								if (!(car1.x==p.x&&car1.y==p.y&&car1.w==p.w&&car1.h==p.h))
								{
									Rectangle car1Rectangle = new Rectangle(car1.x, car1.y, car1.w, car1.h);
									if (NextRectangle.intersects(car1Rectangle)) CanMove = false;
								}
							}
							//�᲻����Աߵĳ���ײ
							if (NextRectangle.intersects(left))  CanMove = false;
							if (NextRectangle.intersects(right)) CanMove = false;
							if (NextRectangle.intersects(above)) CanMove = false;
							if (NextRectangle.intersects(below)) CanMove = false;
							if (!CanMove) continue;
							Vector<data1> next_stat = new Vector<data1>(carcount);
							//����ǰi����
							for (int j = 0; j < ii; j++) next_stat.add(cur_stat.get(j));
							next_stat.add(new data1(nextx, nexty, p.w, p.h));
							//����ʣ�µĳ�
							for (int j = ii + 1; j < cur_stat.size(); j++) next_stat.add((data1) cur_stat.get(j));

							//next_stat��ʾ�µ�״̬

							State1 next = new State1();
							next.stat = next_stat;
							Vector<Vector<data1>> temp = new Vector<Vector<data1>>(100000);
							for (int j = 0; j < cur.steps.size(); j++) temp.add(cur.steps.get(j));
							temp.add(next_stat);
							next.steps = temp;
							//�ж�����µ�״̬�Ƿ��Ѿ�����,�������˳�
							if (has_vis(next_stat)) continue;
							//���������ڣ���ô��ӵȴ��Ժ������
							vis.add(next_stat);
							Q.add(next);
							cnt++;
						}
					}
				}
			}
			return ans;
	 }
	 
	 
	 
	 public void actionPerformed(ActionEvent e){
	     if(e.getSource() instanceof JMenuItem){
	         String arg = e.getActionCommand();
	         if(arg.equals("������Ϸ"))
	         {
	        	 dispose();
	        	 RushhourFrame1 frame1 =new RushhourFrame1();
           		 frame1.setVisible(true);
	        	 frame1.init(levelflag,level,0,0);
	         }
	        	 
	         else if (arg.equals("�������˵�"))
	         {
	        	 dispose();
	        	 ZhuFrame frame =new ZhuFrame();
	        	 frame.setVisible(true);
	         }
	        		 
	      }
	 } 

	 
	 
     public void mousePressed(MouseEvent e)
     {
    	 Car car=(Car)e.getSource();
    	 File file= new File("music//��������.wav");
		 URL url;
		 
    	 if(car.number!=-9&&car.number!=-10&&car.number!=-11)
          {
    		 try{
    			 url=file.toURL();
    			 AudioClip clip =Applet.newAudioClip(url);
    			 clip.play();
    		 }catch(MalformedURLException e2){
    			 e2.printStackTrace();}
    		 ox=e.getX();
          oy=e.getY();
          oox=car.getX();
          ooy=car.getY();
          }
    	 if(car.number==-1)
    		 {
    		 ImageIcon icon1=new ImageIcon("Image//redcar2.png");
    		 car.setIcon(icon1);
    		 }
    	 else if(car.biaoji==1)
    	 {
    		 ImageIcon icon1=new ImageIcon("Image//hengcar2.png");
    		 car.setIcon(icon1);
    	 }
    	 else if(car.biaoji==2)
    	 {
    		 ImageIcon icon1=new ImageIcon("Image//shucar2.png");
    		 car.setIcon(icon1);
    	 }
    	 else if(car.biaoji==3)
    	 {
    		 ImageIcon icon1=new ImageIcon("Image//hengtruck2.png");
    		 car.setIcon(icon1);
    	 }
    	 else if(car.biaoji==4)
    	 {
    		 ImageIcon icon1=new ImageIcon("Image//shutruck2.png");
    		 car.setIcon(icon1);
    	 }
     }
     
     public void mouseEntered(MouseEvent e){}
     public void mouseExited(MouseEvent e){}
     
     public void mouseDragged(MouseEvent e) {
 		// TODO �Զ����ɵķ������
    	Car car=(Car)e.getSource();
 		int fx=e.getX()-ox;
 		int fy=e.getY()-oy;
 		p=car.getLocation();
 		int x=p.x+fx;
 		int y=p.y+fy;
 		if(car.biaoji==1||car.biaoji==3)
 			go(car,left,right,x);
 		else
 			go(car,below,above,y);
        
 	}
 	@Override
 	public void mouseMoved(MouseEvent arg0) {
 		// TODO �Զ����ɵķ������
 		
 	}
     public void go(Car car, JButton direction1,JButton direction2,int t) {
    	 flag=1;
    	 int i;
    	 Rectangle carnext=car.getBounds();
    	 int x=car.getBounds().x;
         int y=car.getBounds().y;
         if(direction1==left)x=t;
	         else if(direction1==below)y=t;
         carnext.setLocation(x,y);
         Rectangle directionRect1=direction1.getBounds();
         Rectangle directionRect2=direction2.getBounds();
         if(x>650||x<50||y<50||y>650)
     		flag=0;
         for(int k=0;k<sk;k++)
	        {
	            Rectangle carRect=shucar[k].getBounds();
	            if(carnext.intersects(carRect)&&(car.number!=k||car.biaoji!=2))
	                flag=0;
	        }
        for(int k=0;k<hk;k++)
 	        {
 	            Rectangle carRect=hengcar[k].getBounds();
 	            if(carnext.intersects(carRect)&&(car.number!=k||car.biaoji!=1))
 	                flag=0;
 	        }
        for(int k=0;k<skt;k++)
        {
            Rectangle carRect=shutruck[k].getBounds();
            if(carnext.intersects(carRect)&&(car.number!=k||car.biaoji!=4))
                flag=0;
        }
        for(int k=0;k<hkt;k++)
	        {
	            Rectangle carRect=hengtruck[k].getBounds();
	            if(carnext.intersects(carRect)&&(car.number!=k||car.biaoji!=3))
	                flag=0;
	        }
        if(car.number!=-1)
         {
        	Rectangle carRect=owncar.getBounds();
         if(carnext.intersects(carRect))
             flag=0;
         }
         
         if(carnext.intersects(directionRect1)||carnext.intersects(directionRect2))
	            flag=0;
         
         if(flag==1)
        	 {
        	 
        	 car.setLocation(x,y);}
         
         
         

     }
     public void mouseClicked(MouseEvent e) {
    	 Car car=(Car)e.getSource();
         if(car.number==-9)
         {  
			 int x,y;
    		 int biao=guochengxin[jj];
    		 if(biao==1000)
    		 {
    			jj++;
    			int tt=guochengxin[jj];
    			x=hengcar[tt].getX();
    		    y=hengcar[tt].getY();
    			jj++;
    			x=x+guochengxin[jj];
    			jj++;
    			y=y+guochengxin[jj];
    			jj++;
    			hengcar[tt].setLocation(x,y);
    		}
    		else if(biao==2000)
    		{
    			jj++;
    			int tt=guochengxin[jj];
    			x=shucar[tt].getX();
    			y=shucar[tt].getY();
    			jj++;
    			x=x+guochengxin[jj];
    			jj++;
    			y=y+guochengxin[jj];
    			jj++;
    			shucar[tt].setLocation(x,y);
    		}
    		else if(biao==3000)
    		{
    			jj++;
    			int tt=guochengxin[jj];
    			x=hengtruck[tt].getX();
    			y=hengtruck[tt].getY();
    			jj++;
    			x=x+guochengxin[jj];
    			jj++;
    			y=y+guochengxin[jj];
    			jj++;
    			hengtruck[tt].setLocation(x,y);
    		}
    		else if(biao==4000)
    		{
    			jj++;
    			int tt=guochengxin[jj];
    			x=shutruck[tt].getX();
    			y=shutruck[tt].getY();
    			jj++;
    			x=x+guochengxin[jj];
    			jj++;
    			y=y+guochengxin[jj];
    			jj++;
    			shutruck[tt].setLocation(x,y);
    		}
    		else if(biao==-1000)
    		{
    			jj++;
    			x=owncar.getX();
    			y=owncar.getY();
    		    jj++;
    			x=x+guochengxin[jj];
    			jj++;
    			y=y+guochengxin[jj];
    			jj++;
    			owncar.setLocation(x,y);
    		}
    		else if(biao==0)
    		{
    			owncar.setLocation(600,300);
    			Object[] options ={ "�ص����˵�", "�ط�" ,"��һ��"};  
           	 int op=JOptionPane.showOptionDialog( null , "Congradulations\r\n", "����",
           			 JOptionPane.YES_NO_CANCEL_OPTION,
           			 JOptionPane.QUESTION_MESSAGE, 
           			 null,
           			 options, 
                        options[2]) ;
           	 if(op==JOptionPane.YES_OPTION)
           	 {
           		dispose();
           		 ZhuFrame frame;
				 frame = new ZhuFrame();
           		 frame.setVisible(true);
           	 }
           	 else if(op==JOptionPane.NO_OPTION)
           	 {
           		dispose();
           		 RushhourFrame1 frame1 =new RushhourFrame1();
           		 frame1.setVisible(true);
           		 frame1.init(levelflag,level,1,0);
           		 
           		 
           	 }
           	 else if(op==JOptionPane.CANCEL_OPTION)
           	 {
           		dispose();
           		 RushhourFrame1 frame1 =new RushhourFrame1();
           		 frame1.setVisible(true);
           		 level++;
           		 frame1.init(1,level,0,0);
           	 }
    		}
         }
         else if(car.number==-10)
         {
        	 int x,y;
        	 bushu=bushu-4;
        	 int biao=guocheng[bushu];
        	 if(biao==1000)
        	 {
        		 bushu++;
        		 int tt=guocheng[bushu];
        		 x=hengcar[tt].getX();
        		 y=hengcar[tt].getY();
        		 bushu++;
        		 x=x-guocheng[bushu];
        		 bushu++;
        		 y=y-guocheng[bushu];
        		 bushu++;
        		 hengcar[tt].setLocation(x,y);
        		 bushu=bushu-4;
        	 }
        	 else if(biao==2000)
        	 {
        		 bushu++;
        		 int tt=guocheng[bushu];
        		 x=shucar[tt].getX();
        		 y=shucar[tt].getY();
        		 bushu++;
        		 x=x-guocheng[bushu];
        		 bushu++;
        		 y=y-guocheng[bushu];
        		 bushu++;
        		 shucar[tt].setLocation(x,y);
        		 bushu=bushu-4;
        	 }
        	 else if(biao==3000)
        	 {
        		 bushu++;
        		 int tt=guocheng[bushu];
        		 x=hengtruck[tt].getX();
        		 y=hengtruck[tt].getY();
        		 bushu++;
        		 x=x-guocheng[bushu];
        		 bushu++;
        		 y=y-guocheng[bushu];
        		 bushu++;
        		 hengtruck[tt].setLocation(x,y);
        		 bushu=bushu-4;
        	 }
        	 else if(biao==4000)
        	 {
        		 bushu++;
        		 int tt=guocheng[bushu];
        		 x=shutruck[tt].getX();
        		 y=shutruck[tt].getY();
        		 bushu++;
        		 x=x-guocheng[bushu];
        		 bushu++;
        		 y=y-guocheng[bushu];
        		 bushu++;
        		 shutruck[tt].setLocation(x,y);
        		 bushu=bushu-4;
        	 }
        	 else if(biao==-1000)
        	 {
        		 bushu++;
     			x=owncar.getX();
     			y=owncar.getY();
     		    bushu++;
     			x=x-guocheng[bushu];
     			bushu++;
     			y=y-guocheng[bushu];
     			bushu++;
     			owncar.setLocation(x,y);
     			bushu=bushu-4;
        	 }
         }
         else if (car.number==-11)
         {
        	 solve(car);
             /*Vector<data1> tempt = ans.get(iii);
             int j=0,t=0;
             data1 car2=tempt.get(t);
             t++;
             int x=car2.x;
             int y=car2.y;
             owncar.setLocation(x,y);
             for(j=0;j<hk;j++,t++)
             {
            	 data1 car1=tempt.get(t);
            	 x=car1.x;
            	 y=car1.y;
            	 hengcar[j].setLocation(x,y);
             }
             for(j=0;j<sk;j++,t++)
             {
            	 data1 car1=tempt.get(t);
            	 x=car1.x;
            	 y=car1.y;
            	 shucar[j].setLocation(x,y);
             }
             for(j=0;j<hkt;j++,t++)
             {
            	 data1 car1=tempt.get(t);
            	 x=car1.x;
            	 y=car1.y;
            	 hengtruck[j].setLocation(x,y);
             }
             for(j=0;j<skt;j++,t++)
             {
            	 data1 car1=tempt.get(t);
            	 x=car1.x;
            	 y=car1.y;
            	 shutruck[j].setLocation(x,y);
             }
             iii++;*/
         }
    	 
     }    
     public void mouseReleased(MouseEvent e)
     {
    	 Car car=(Car)e.getSource();
    	 
    	 if(car.number==-1)
		 {
		 ImageIcon icon1=new ImageIcon("Image//redcar.png");
		 car.setIcon(icon1);
		 }
	     else if(car.biaoji==1)
	     {
		 ImageIcon icon1=new ImageIcon("Image//hengcar.png");
		 car.setIcon(icon1);
	     }
	     else if(car.biaoji==2)
	     {
		 ImageIcon icon1=new ImageIcon("Image//shucar.png");
		 car.setIcon(icon1);
	     }
	     else if(car.biaoji==3)
	     {
		 ImageIcon icon1=new ImageIcon("Image//hengtruck.png");
		 car.setIcon(icon1);
	     }
	     else if(car.biaoji==4)
	     {
		 ImageIcon icon1=new ImageIcon("Image//shutruck.png");
		 car.setIcon(icon1);
	     }
    	 
    	 int x=car.getX();
    	 int y=car.getY();
    	 if(flag==1&&car.number!=-9&&car.number!=-10&&car.number!=-11)
    	 {
    	 
    	 if(car.biaoji==1||car.biaoji==3)
    	 {
    		 for(i=0;i<6;i++)
    	 {
    		 if(x>X[i]&&x<=X[i+1])
    			 {if(x>p.x)
    			     {x=X[i+1];}
    			 else
    				 {x=X[i];}
    			 }
    	 }}
    	 else
    	 {for(i=0;i<6;i++)
    		 {if(y>Y[i]&&y<=Y[i+1])
    		     {if(y>p.y)
			         {y=Y[i+1];}
			     else
				     {y=Y[i];}
			     }
    		 }
    	 }
    	 car.setLocation(x,y);
    	 }
    	 if(car.number!=-9&&car.number!=-10&&car.number!=-11)
    		 //��¼ÿ������
    	 {if(car.biaoji==1&&car.number!=-1)
    		 guocheng[bushu]=1000;
    	 else if(car.biaoji==2&&car.number!=-1)
    		 guocheng[bushu]=2000;
    	 else if(car.biaoji==3&&car.number!=-1)
    		 guocheng[bushu]=3000;
    	 else if(car.biaoji==4&&car.number!=-1)
    		 guocheng[bushu]=4000;
    	 else
    		 guocheng[bushu]=-1000;
    	 bushu++;
    	 guocheng[bushu]=car.number;
    	 bushu++;
    	 guocheng[bushu]=x-oox;
    	 bushu++;
    	 guocheng[bushu]=y-ooy;
    	 bushu++;
    	 }
    	 if(car.number==-1&&x>=450&&levelflag==1)
         {
        	 timer.stop();
        	 String time=lbl.getText();
        	 try {
                 FileOutputStream out=new FileOutputStream("Level\\guocheng.txt");
                 PrintStream p=new PrintStream(out);
                 for(int j=0;j<bushu;j++)
                 {p.print(guocheng[j]+"\r\n");
                 j++;
                 p.print(guocheng[j]+"\r\n");
                 j++;
                 p.print(guocheng[j]+"\r\n");
                 }
                 p.close();
             } catch (FileNotFoundException e2) {
                 e2.printStackTrace();}
        	 try { // ��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ����throw  

                 /* ����TXT�ļ� */  
    			 String pathname3;
    			 pathname3 = "Level\\���а�"+level+".txt";
                 File filename3 = new File(pathname3); // Ҫ��ȡ����·����input��txt�ļ�  
                 InputStreamReader reader = new InputStreamReader(  
                         new FileInputStream(filename3)); // ����һ������������reader  
                 BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������  
                 String line = "";  
                 for(i=0;i<5;i++)
                 {
                	 line = br.readLine();  
                	 int aaa=Integer.parseInt(line);
                	 paiming[i]=aaa;
                 }
                 
                 
        	     } catch (Exception e5) {  
                 e5.printStackTrace();  
             }
        	 feng=1000-feng;
        	 int ff=-1;
        	 int tttt;
        	 if(feng>paiming[4])
        		 {
        		 paiming[4]=feng;
        	     for(i=4;i>0;i--)
                 {
            	 if(paiming[i]>paiming[i-1])
            	 {tttt=paiming[i];paiming[i]=paiming[i-1];paiming[i-1]=tttt;}
                 }
        		 }
        	 for(i=4;i>=0;i--)
        		 {
        		 if(feng==paiming[i])
        			 {
        			 ff=i+1;
        			 }
        		 }
        	 
        	 try {
                 FileOutputStream out=new FileOutputStream("Level\\���а�"+level+".txt");
                 PrintStream p=new PrintStream(out);
                 for(int j=0;j<5;j++)
                 {p.print(paiming[j]+"\r\n");}
             
                 p.close();
             } catch (FileNotFoundException e2) {
                 e2.printStackTrace();}
        	 
        	 
        	 String sss;
        	 if(ff==-1)
        		 sss="���ź�����δ���\r\n";
        	else
        		sss="��"+ff+"��\r\n";
        	 
        	 String ss="Congradulations\r\n"+"�����ʱ:"+ time+"\r\n"+
        		       "��"+level+"�����а�\r\n"+
        		       "1."+paiming[0]+"\r\n"+
        		       "2."+paiming[1]+"\r\n"+
        		       "3."+paiming[2]+"\r\n"+
        		       "4."+paiming[3]+"\r\n"+
        		       "5."+paiming[4]+"\r\n"+
        		       "��ķ���"+feng+"\r\n"+
        		       "�������:"+sss;
        	 Object[] options ={ "�ص����˵�", "�ط�" ,"��һ��"};  
        	 int op=JOptionPane.showOptionDialog( null , ss, "����",
        			 JOptionPane.YES_NO_CANCEL_OPTION,
        			 JOptionPane.QUESTION_MESSAGE, 
        			 null,
        			 options, 
                     options[2]) ;
        	 if(op==JOptionPane.YES_OPTION)
        	 {
        		 dispose();
        		 ZhuFrame frame =new ZhuFrame();
        		 frame.setVisible(true);
        	 }
        	 else if(op==JOptionPane.NO_OPTION)
        	 {
        		 dispose();
        		 RushhourFrame1 frame1 =new RushhourFrame1();
        		 frame1.setVisible(true);
        		 frame1.init(levelflag,level,1,0);
        		 
        		 
        	 }
        	 else if(op==JOptionPane.CANCEL_OPTION)
        	 {
        		 dispose();
        		 RushhourFrame1 frame1 =new RushhourFrame1();
        		 frame1.setVisible(true);
        		 level++;
        		 frame1.init(1,level,0,0);
        	 }
         }
    	 else if(car.number==-1&&x>=450&&levelflag==2)
    	 {
    		 try {
                 FileOutputStream out=new FileOutputStream("Level\\guocheng.txt");
                 PrintStream p=new PrintStream(out);
                 for(int j=0;j<bushu;j++)
                 {p.print(guocheng[j]+"\r\n");
                 j++;
                 p.print(guocheng[j]+"\r\n");
                 j++;
                 p.print(guocheng[j]+"\r\n");
                 }
                 p.close();
             } catch (FileNotFoundException e2) {
                 e2.printStackTrace();}
    		 
    		 Object[] options ={ "�ص����˵�", "�ط�" };  
        	 int op=JOptionPane.showOptionDialog( null , "Congradulations Cheate", "����",
        			 JOptionPane.YES_NO_CANCEL_OPTION,
        			 JOptionPane.QUESTION_MESSAGE, 
        			 null,
        			 options, null) ;
        	 if(op==JOptionPane.YES_OPTION)
        	 {
        		 dispose();
        		 ZhuFrame frame =new ZhuFrame();
        		 frame.setVisible(true);
        	 }
        	 else if(op==JOptionPane.NO_OPTION)
        	 {
        		 dispose();
        		 RushhourFrame1 frame1 =new RushhourFrame1();
        		 frame1.setVisible(true);
        		 frame1.init(levelflag,level,1,0);
        		 
        	 }
    	 }

     }
     public void solve(Car car)
     {
    	 if(solveflag!=10)
    	 {if(levelflag==1)
    	 {dispose();
   		 RushhourFrame1 frame1 =new RushhourFrame1();
   		 frame1.setVisible(true);
   		 frame1.init(levelflag,level,1,1);}
    	 else if(levelflag==2)
    	 {
    		 dispose();
       		 RushhourFrame1 frame1 =new RushhourFrame1();
       		 frame1.setVisible(true);
       		 frame1.init(levelflag,solveflag,1,solveflag);
    	 }}
    	 else
    	 {
    		 for(int ss=0;ss<100000;ss++)
    		 {}
    		 JOptionPane.showMessageDialog(null, "�޽�", "����",JOptionPane.PLAIN_MESSAGE);  
    		 
    	 }
     }
     
     
}
	class data1{
		int x,y,w,h;
		data1(int x1,int y1,int w1,int h1){
			x=x1;
			y=y1;
			w=w1;
			h=h1;
			
		}
		data1(){
			x=0;y=0;w=0;h=0;
		}
	}
     class State1 
     {
    	 Vector<data1> stat;
    	 Vector<Vector<data1> >steps;
     }

     class Car extends JButton implements FocusListener
     {
    	 int number;
    	 int biaoji;
    	 int x,y;  //����
    	 Color c= new Color(255,245,170);
    	 Car(int number,int biaoji,String s)
         {
             super(s);
             setBackground(c);
             this.number=number;
             this.biaoji=biaoji;
             c=getBackground();
             Color c = new Color(255,245,170);//��Ӱ��ɫ���������ֵ,ֻ��ռλ���á�  
             setBackground(c);  
             setOpaque(false); 
             setBorderPainted(false);

             
         }
    	 public void focusGained(FocusEvent e)
         {
             setBackground(Color.red);
         }
         public void focusLost(FocusEvent e)
         {
            setBackground(c);
         }
         public void paintButtonPressed(Graphics g, AbstractButton b) {  
        	 if ( b.isContentAreaFilled() ) {  
//               Dimension size = b.getSize();  
                 g.setColor(Color.red);  
//               g.fillRect(0, 0, size.width, size.height);  
         }}
     
     }

     //Password  ��½����
     class PassWord implements ActionListener // ��������Ի�����
     {
         JTextField user;
         JPasswordField passWd;
         JButton b1, b2;
         Container dialogPane;
         JDialog d;
         JFrame f;


         public PassWord(JFrame f)
         {
             d = new JDialog(); // �½�һ�Ի���
             d.setTitle("�������û���������"); // ���ñ���
             dialogPane = d.getContentPane();
             dialogPane.setLayout(new GridLayout(3, 2));
             dialogPane.add(new JLabel("�û���", SwingConstants.CENTER));
             user = new JTextField();
             dialogPane.add(user);
             dialogPane.add(new JLabel("�� ��", SwingConstants.CENTER));
             passWd = new JPasswordField();
             dialogPane.add(passWd);
             b1 = new JButton("ȷ��");
             b2 = new JButton("ע��");
             dialogPane.add(b1);
             dialogPane.add(b2);
             b1.addActionListener(this);
             b2.addActionListener(this);
             d.setBounds(200, 150, 400, 130);
             d.getRootPane().setDefaultButton(b1);
             d.setVisible(true);
             this.f = f;
         }


         public void actionPerformed(ActionEvent e)
         {
             String cmd = e.getActionCommand();
             if (cmd.equals("ȷ��"))
             {
                 String name = user.getText();
                 char[] c = passWd.getPassword();
                 String passWord = new String(c);
                 if ((name.equals("123")) && (passWord.equals("123")))
                 {
                     new RushhourFrame();
                     d.dispose();
                     f.setVisible(true);

                     return;
                 }
                 else
                 {
                     JOptionPane.showMessageDialog(d, "�û������������", "����������",
                                                   JOptionPane.WARNING_MESSAGE);
                     user.setText("");
                     passWd.setText("");
                 }
             }
             if (cmd.equals("�˳�"))
                 System.exit(0);
         }
     }