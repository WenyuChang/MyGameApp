import java.awt.event.*;
import java.lang.Object.*;
import java.awt.*;
import javax.swing.*;

public class Rev extends JFrame implements ActionListener
{
	JButton[] square;//所有翻转格的创建
	int stepnum=0;//步数
	boolean[] squareColor;//翻转格是否翻转的标志
	JTextField text=new JTextField(10);//用户输入难度的文本栏
	JButton regame;//重新开始游戏按键
	JPanel panel, panel1;//容器
	JMenuBar bar;//菜单栏
	JMenu FileMenu,EditMenu;//菜单条
	JMenuItem Restart;//重新开始游戏
	boolean ifwin=false;//是否赢
	JLabel x;//步数label
	public Rev(String str,int num)//构造函数
	{
		//图形界面设置
		super(str);
		setVisible(true);
		setResizable(false);
		//菜单栏设置
		bar=new JMenuBar();
		FileMenu=new JMenu("文件(F)");
		EditMenu=new JMenu("编辑(E)");
		Restart=new JMenuItem("重新开始");
		Restart.addActionListener(this);
		FileMenu.add(Restart);
		bar.add(FileMenu);
		bar.add(EditMenu);
		setJMenuBar(bar);
		//界面设置
		square=new JButton[num*num];//为翻转格子初始化
		squareColor=new boolean[num*num];//初始化
		for(int k=0;k<num*num;k++)
			squareColor[k]=true;
		getContentPane().setLayout(new BorderLayout());//设置布局
		panel=new JPanel();
		panel.setLayout(new FlowLayout());
		panel1=new JPanel();
		getContentPane().add(panel,BorderLayout.NORTH);//加入panel
		getContentPane().add(panel1,BorderLayout.CENTER);//panel1
		regame=new JButton("开始");//重新游戏按键分配地址
		panel.add(new JLabel("难度："));//panel的设置
		text.setText(Integer.toString(num));//设置最开始的难度
		panel.add(text);//panel的设置
		panel.add(regame);//panel的设置
		x=new JLabel("      步数："+Integer.toString(stepnum));//显示当时的步数
		panel.add(x);
		panel1.setLayout(new GridLayout(num,num));//panel1的设置
		regame.addActionListener(this);//连接监视器
		num=num*num;
		for(int i=0;i<num;i++)//翻转格子初始化
		{
			square[i]=new JButton("   ");
			square[i].setBackground(Color.blue);//设置翻转格子颜色
			panel1.add(square[i]);//加入翻转格子
			square[i].addActionListener(this);//翻转格子连接监视器
		}
		pack();//调整大小
	}
	
	boolean check(boolean[] squareColor,int num)//判断是否游戏胜利
	{
		for(int k=0;k<num*num;k++)
		{
			if(squareColor[k]==false);//有一个没翻转就没胜利
			else
				return false;
		}
		return true;
	}
	void turnColorBlock(int i,int num)//格子翻转
	{
		i++;
		stepnum++;//步数加一
		int x1=i%num,x2=i/num;//计算格子在什么位置
		//以下是格子位置的不同情况所要做的不同操作
		if(x1>1&&x2>0&&x2<num-1)
		{
			turnColor(i);
			turnColor(i+1);
			turnColor(i-1);
			turnColor(i-num);
			turnColor(i+num);
		}
		if(x1==1&&x2>0&&x2<num-1)
		{
			turnColor(i);
			turnColor(i+1);
			turnColor(i-num);
			turnColor(i+num);
		}
		if(x1==0&&x2>1&&x2<num)
		{
			turnColor(i);
			turnColor(i-1);
			turnColor(i-num);
			turnColor(i+num);
		}
		if(x2==0&&x1>1)
		{
			turnColor(i);
			turnColor(i-1);
			turnColor(i+1);
			turnColor(i+num);
		}
		if(x2==num-1&&x1>1)
		{
			turnColor(i);
			turnColor(i-1);
			turnColor(i+1);
			turnColor(i-num);
		}
		if(x1==1&&x2==0)
		{
			turnColor(i);
			turnColor(i+1);
			turnColor(i+num);
		}
		if(x1==0&&x2==1)
		{
			turnColor(i);
			turnColor(i-1);
			turnColor(i+num);
		}
		if(x1==1&&x2==num-1)
		{
			turnColor(i);
			turnColor(i+1);
			turnColor(i-num);
		}
		if(x1==0&&x2==num)
		{
			turnColor(i);
			turnColor(i-1);
			turnColor(i-num);
		}
		ifwin=check(squareColor,num);//判断游戏是否胜利
		x.setText("      步数："+Integer.toString(stepnum));//改变步数
		if(ifwin==true)
		{
			JOptionPane.showMessageDialog(panel,"Win!!!!");
			return;
		}
	}
	void turnColor(int i)//格子翻转
	{
		i--;
		if(squareColor[i]==true)
		{
			square[i].setBackground(Color.gray);
			squareColor[i]=false;
		}
		else
		{
			square[i].setBackground(Color.blue);
			squareColor[i]=true;
		}
	}
	public void actionPerformed(ActionEvent e)//事件处理
	{
		if(e.getSource()==regame||e.getSource()==Restart)//按动重新游戏按键
		{
			dispose();//关闭原先界面
			int num=Integer.parseInt(text.getText());
			new Rev("rev",num);//打开新界面
		}
		for(int i=0;i<square.length;i++)//如果按动翻转格子
			if(e.getSource()==square[i])
			{		
				turnColorBlock(i,(int)java.lang.Math.sqrt(square.length));//翻转格子
			}
	}

	public static void main(String[] args) 
	{
		new Rev("Rev",8);//游戏开始
	}
}
