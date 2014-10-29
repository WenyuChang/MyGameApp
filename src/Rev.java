import java.awt.event.*;
import java.lang.Object.*;
import java.awt.*;
import javax.swing.*;

public class Rev extends JFrame implements ActionListener
{
	JButton[] square;//���з�ת��Ĵ���
	int stepnum=0;//����
	boolean[] squareColor;//��ת���Ƿ�ת�ı�־
	JTextField text=new JTextField(10);//�û������Ѷȵ��ı���
	JButton regame;//���¿�ʼ��Ϸ����
	JPanel panel, panel1;//����
	JMenuBar bar;//�˵���
	JMenu FileMenu,EditMenu;//�˵���
	JMenuItem Restart;//���¿�ʼ��Ϸ
	boolean ifwin=false;//�Ƿ�Ӯ
	JLabel x;//����label
	public Rev(String str,int num)//���캯��
	{
		//ͼ�ν�������
		super(str);
		setVisible(true);
		setResizable(false);
		//�˵�������
		bar=new JMenuBar();
		FileMenu=new JMenu("�ļ�(F)");
		EditMenu=new JMenu("�༭(E)");
		Restart=new JMenuItem("���¿�ʼ");
		Restart.addActionListener(this);
		FileMenu.add(Restart);
		bar.add(FileMenu);
		bar.add(EditMenu);
		setJMenuBar(bar);
		//��������
		square=new JButton[num*num];//Ϊ��ת���ӳ�ʼ��
		squareColor=new boolean[num*num];//��ʼ��
		for(int k=0;k<num*num;k++)
			squareColor[k]=true;
		getContentPane().setLayout(new BorderLayout());//���ò���
		panel=new JPanel();
		panel.setLayout(new FlowLayout());
		panel1=new JPanel();
		getContentPane().add(panel,BorderLayout.NORTH);//����panel
		getContentPane().add(panel1,BorderLayout.CENTER);//panel1
		regame=new JButton("��ʼ");//������Ϸ���������ַ
		panel.add(new JLabel("�Ѷȣ�"));//panel������
		text.setText(Integer.toString(num));//�����ʼ���Ѷ�
		panel.add(text);//panel������
		panel.add(regame);//panel������
		x=new JLabel("      ������"+Integer.toString(stepnum));//��ʾ��ʱ�Ĳ���
		panel.add(x);
		panel1.setLayout(new GridLayout(num,num));//panel1������
		regame.addActionListener(this);//���Ӽ�����
		num=num*num;
		for(int i=0;i<num;i++)//��ת���ӳ�ʼ��
		{
			square[i]=new JButton("   ");
			square[i].setBackground(Color.blue);//���÷�ת������ɫ
			panel1.add(square[i]);//���뷭ת����
			square[i].addActionListener(this);//��ת�������Ӽ�����
		}
		pack();//������С
	}
	
	boolean check(boolean[] squareColor,int num)//�ж��Ƿ���Ϸʤ��
	{
		for(int k=0;k<num*num;k++)
		{
			if(squareColor[k]==false);//��һ��û��ת��ûʤ��
			else
				return false;
		}
		return true;
	}
	void turnColorBlock(int i,int num)//���ӷ�ת
	{
		i++;
		stepnum++;//������һ
		int x1=i%num,x2=i/num;//���������ʲôλ��
		//�����Ǹ���λ�õĲ�ͬ�����Ҫ���Ĳ�ͬ����
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
		ifwin=check(squareColor,num);//�ж���Ϸ�Ƿ�ʤ��
		x.setText("      ������"+Integer.toString(stepnum));//�ı䲽��
		if(ifwin==true)
		{
			JOptionPane.showMessageDialog(panel,"Win!!!!");
			return;
		}
	}
	void turnColor(int i)//���ӷ�ת
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
	public void actionPerformed(ActionEvent e)//�¼�����
	{
		if(e.getSource()==regame||e.getSource()==Restart)//����������Ϸ����
		{
			dispose();//�ر�ԭ�Ƚ���
			int num=Integer.parseInt(text.getText());
			new Rev("rev",num);//���½���
		}
		for(int i=0;i<square.length;i++)//���������ת����
			if(e.getSource()==square[i])
			{		
				turnColorBlock(i,(int)java.lang.Math.sqrt(square.length));//��ת����
			}
	}

	public static void main(String[] args) 
	{
		new Rev("Rev",8);//��Ϸ��ʼ
	}
}
