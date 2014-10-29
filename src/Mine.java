import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;

class Min extends JPanel  //�׵���
{
 //��ע��������� = 1���Ҽ� = 3���м� = 2
 private int flag = 0,statu = 0; //�����׵����� 0:û�д� 1:�� 2:��ʾΪ�� 3:��ȷ��
         //flag = 0 ������  �� flag = 1����
 private int but,count = 0; //but:��һ������������ȥ��   count:���������Χ�ж��ٸ���
 private int mx = 0,my = 0,mw = 10; //�����׵�����Ϳ��
 
 public Min()  //���캯��
 {
  statu = 0;
 }
 public Min(int f,int x,int y,int w)
 //���캯��
 {
  flag = f;
  mx  = x;
  my  = y;
  mw  = w;
 }
 public int getFlag(){return flag;}
 public int getStatu(){return statu;}
 public int getMx(){return mx;}
 public int getMy(){return my;}
 public int getMw(){return mw;}
 public int getCount(){return count;}
 public void setFlag(int f){flag = f;}
 public void setCount(int c){count = c;}
 public void setData(int f,int x,int y,int w,int s)
 //����ֵ
 {
  flag = f;
  mx  = (x-1)*w;
  my  = (y-1)*w;
  mw  = w-1;
  statu = s;
 }
 //�����������Ĳ�ͬ���ı��׵�����
 public int sendKey(int key)
 {
 //����ֵ�������Ϸ�����򷵻�-1 
  int rtn = 1;
  if(key == 3)
  {
   switch(statu)
   {
    case 1:
     break;
    case 2:
     statu = 3;
     break;
    case 3:
     statu = 0;
     break;
    case 0:
     statu = 2;
     break;
   }
   rtn = 1;
  }
  if(key == 1 && statu == 0)
  {
   switch(flag)
   {
    case 0:
     statu = 1;
     rtn = 2;
     break;
    case 1:
     statu = 1;
     rtn = -1;
     break;
   }
  }
  return rtn;
 }
}

class DrawPanel extends JPanel
{
 private int i,j;
 private int f = 0;    //if f = 1 then game over ,if f =2 then win
 private int chx = 0,chy = 0; //ר�ż�¼����x,y��ֵ
 private int msum = 6,ksum = 0; //msum:�׵ĸ���,ksum:��ʾ�׵ĸ���
 private int bx = 10,by = 10,bw = 40; //bx,by:���̵Ĵ�С��bw:���ӵĴ�С
 public Min board[][] = {
   {new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min()},
   {new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min()},
   {new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min()},
   {new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min()},
   {new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min()},
   {new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min()},
   {new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min()},
   {new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min()},
   {new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min()},
   {new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min()},
   {new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min()},
   {new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min()},
   {new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min()},
   {new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min()},
   {new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min()},
   {new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min()},
   {new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min()},
   {new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min()},
   {new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min()},
   {new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min(),new Min()},
   };
 //������Ϊax,ay������׵�״̬
 public void draw(Graphics g,int ax,int ay)
 {
  int x,y,w; //����x,y;�Ϳ��:w
  int s,c,flag; //״̬���׵ĸ�����
  int cx = bw/2 - 4;
  int cy = bw/2 + 4;
  x = board[ax][ay].getMx();
  y = board[ax][ay].getMy();
  w = board[ax][ay].getMw();
  s = board[ax][ay].getStatu();
  c = board[ax][ay].getCount();
  flag= board[ax][ay].getFlag();
  
  switch(s)
  {
   case 0: //û�д�״̬
   {
    g.setColor(Color.black);
    g.fillRect(x,y,w,w);
    break;
   }
   case 1: //��״̬
   {
    g.setColor(Color.blue);
    g.fillRect(x,y,w,w);
    if(c != 0 && flag == 0) //�˴�û����
    {
     g.setColor(Color.red);
     g.drawString(String.valueOf(c),x + cx,y + cy);
    }
    if(flag == 1) //�˴�����
    {
     g.setColor(Color.red);
     g.fillRect(x,y,w,w);
     g.setColor(Color.blue);
     g.drawString("��",x + cx,y + cy);
    }
    break;
   }
   case 2: //����״̬
   {
    g.setColor(Color.green);
    g.fillRect(x,y,w,w);
    g.setColor(Color.blue);
    g.drawString("��",x + cx,y + cy);
    break;
   }
   case 3: //��ȷ��״̬
   {
    g.setColor(Color.black);
    g.fillRect(x,y,w,w);
    g.setColor(Color.red);
    g.drawString("?",x + cx,y + cy);
    break;
   }
   default:
    break;
  }
 }
 //û��ͼ�����Ļ�ͼ��������������ax,ay���׵�״̬��ͼ��
 public void draw(int ax,int ay)
 {
  Graphics g;
  g = this.getGraphics();
  draw(g,ax,ay);
 }

 //����Χû���׵ĵط������һ滭�����������������
 public int openNoMin(int ax,int ay)
 {
  int i,j;
 
  if(ax<1||ay<1||ax>bx||ay>by) return 0;  //����������������
  if(board[ax][ay].getStatu() != 0) return 0;  //�����������ˣ�����
  board[ax][ay].sendKey(1); //�������ֵ����-1����˵����Ϸ����
  draw(ax,ay);
  if(board[ax][ay].getFlag() == 1)
  //�����Ϸ�����������е��׶���ʾ����
  {
   for(i = 1;i<=bx;i++)
   {
    for(j = 1;j <= by;j++)
    {
     if(board[i][j].getFlag() == 1)
     {
      board[i][j].sendKey(1);
      draw(i,j);
     }
    }
   }
   return -1;
  }
  //�����Ϸû�н���
  if(board[ax][ay].getCount() > 0) 
  {
   ksum ++;
   return 1; //��Χ���ף��Ͳ��ô���Χ����
  }
  if(board[ax][ay].getCount() == 0 && board[ax][ay].getFlag() == 0)
  //��Χû���ף�����Χ������ֱ�����׵ĵ���
  {
   openNoMin(ax-1,ay-1);openNoMin(ax,ay-1);openNoMin(ax+1,ay-1);
   openNoMin(ax-1,ay  );     openNoMin(ax+1,ay  );
   openNoMin(ax-1,ay+1);openNoMin(ax,ay+1);openNoMin(ax+1,ay+1);
  }
  ksum ++;
  return 1;
 }
 
 //��������x,y����Χ�׵ĸ���
 public int getCount(int ai,int aj)
 {
  int sum = 0;
  if(board[ai][aj].getFlag() == 1)
  {
   return sum;
  }
  
  if(ai>1&&aj>1&&ai<bx&&aj<by)
  {
   sum =  board[ai-1][aj-1].getFlag()+ board[ai][aj-1].getFlag()+ board[ai+1][aj-1].getFlag()+
     board[ai-1][aj  ].getFlag()+        board[ai+1][aj  ].getFlag()+
     board[ai-1][aj+1].getFlag()+ board[ai][aj+1].getFlag()+ board[ai+1][aj+1].getFlag();
  }
  if(ai==1&&aj==1)
  {
   sum =         board[ai+1][aj  ].getFlag()+
     board[ai][aj+1].getFlag()+ board[ai+1][aj+1].getFlag();
  }
  if(ai==1&&aj==by)
  {
   sum =  board[ai][aj-1].getFlag()+ board[ai+1][aj-1].getFlag()+
            board[ai+1][aj  ].getFlag();
  }
  if(ai==bx&&aj==1)
  {
   sum =  board[ai-1][aj  ].getFlag()+       
     board[ai-1][aj+1].getFlag()+ board[ai][aj+1].getFlag();
  }
  if(ai==bx&&aj==by)
  {
   sum =  board[ai-1][aj-1].getFlag()+ board[ai][aj-1].getFlag()+ 
     board[ai-1][aj  ].getFlag();
  }
  if(ai==1&&aj>1&&aj<by)
  {
   sum =  board[ai][aj-1].getFlag()+ board[ai+1][aj-1].getFlag()+
           board[ai+1][aj  ].getFlag()+
     board[ai][aj+1].getFlag()+ board[ai+1][aj+1].getFlag();
  }
  if(ai==bx&&aj>1&&aj<by)
  {
   sum =  board[ai-1][aj-1].getFlag()+ board[ai][aj-1].getFlag()+
     board[ai-1][aj  ].getFlag()+      
     board[ai-1][aj+1].getFlag()+ board[ai][aj+1].getFlag();
  }
  if(ai>1&&ai<bx&&aj==1)
  {
   sum =  board[ai-1][aj  ].getFlag()+       board[ai+1][aj  ].getFlag()+
     board[ai-1][aj+1].getFlag()+ board[ai][aj+1].getFlag()+ board[ai+1][aj+1].getFlag();
  }
  if(ai>1&&ai<bx&&aj==by)
  {
   sum =  board[ai-1][aj-1].getFlag()+ board[ai][aj-1].getFlag()+ board[ai+1][aj-1].getFlag()+
     board[ai-1][aj  ].getFlag()+       board[ai+1][aj  ].getFlag();
  }
  return sum;
 }
 
 //������������У����У���ȣ�����
 public void initMin(int ax,int ay,int aw,int as)
 {
  int k = 1;  //���������ĵڼ�����
  Random r;  //�����

  f = 0;   //f=0��ʾ��Ϸ��û�н���
  ksum = 0;
  bx = ax;
  by = ay;
  bw = aw;
  msum = as;
  r = new Random();
  //��ʼ�����̵�ֵ
  for(i = 1;i <= bx;i++)
  {
   for(j=1;j<=by;j++)
   {
    board[i][j].setData(0,i,j,bw,0);
   }
  }
  //���������
  while(k <= msum)
  {
   i = r.nextInt(bx)+1;
   j = r.nextInt(by)+1;
   if(board[i][j].getFlag() != 1)
   {
    board[i][j].setFlag(1);
    k++;
   }
  }
  //����������Χ�м����ף���ʼ����ֵ
  for(i = 1;i <= bx;i++)
  {
   for(j=1;j<=by;j++)
   {
    board[i][j].setCount(getCount(i,j));
   }
  }
  
  setBackground(Color.white);
  repaint();
 }
 //���캯��
 public DrawPanel(int ax,int ay,int aw,int as)
 {
  initMin(ax,ay,aw,as);
  addMouseListener(new MouseAdapter()
  {
   public void mousePressed(MouseEvent me)
   {
    int r;
    if(f != 0) return;  //�����Ϸ����������
    chx  = me.getX();
    chy  = me.getY();
    if(me.getButton() != 1)
    {
     board[chx/bw+1][chy/bw+1].sendKey(me.getButton());
     draw(chx/bw+1,chy/bw+1);
    }
    else if(me.getButton() == 1)
    {
     if(openNoMin(chx/bw+1,chy/bw+1) == -1)
     {
      f = 1;
      repaint();
     }
     else if ( ksum + msum == bx*by )
     {
      f = 2;
      repaint();
     }
    }
   }
  }
  );
 }
 //�ػ����е�ͼ�Σ�����һЩ���ε�ͼ��
 public void paint(Graphics g)
 {
  int x,y,w;
  int s;
  int cx = bw/2 - 4;
  int cy = bw/2 + 4;
  
  g.clearRect(0,0,600,600);
  for(i=1;i<=bx;i++)
  {
   for(j=1;j<=by;j++)
   {
    draw(g,i,j);
   }
  }
  if(f == 1)
  {
   Font f = new Font("11",1,70);
   Font fo = g.getFont();
   g.setColor(Color.white);
   g.setFont(f);
   //g.setSize();
   g.drawString("Game Over",0,200);
   g.setFont(fo);
  }
  if( f == 2 )
  {
   Font f = new Font("11",1,70);
   Font fo = g.getFont();
   g.setColor(Color.white);
   g.setFont(f);
   //g.setSize();
   g.drawString("You win!",0,200);
   g.setFont(fo);
  }
 }

};
//����ͳ�������
public class Mine extends JFrame implements ActionListener
{
 Container  cp = getContentPane();
 JButton  bt = new JButton("����"); 
 Label l1 = new Label("��:");
 Label l2 = new Label("��:");
 Label l3 = new Label("���:");
 Label l4 = new Label("�׵ĸ���:");
 TextField tf1 = new TextField("10",2); //��
 TextField tf2 = new TextField("10",2); //��
 TextField tf3 = new TextField("40",2); //���
 TextField tf4 = new TextField("15",2); //�׵ĸ���
 int x=10,y=10,w=40,sum=15;
 DrawPanel  dp = new DrawPanel(x,y,w,sum); 

 public Mine()
 {
  setBackground(Color.white);
  cp.setLayout(null);
  cp.add(dp);
  cp.add(bt);
  cp.add(tf1);
  cp.add(tf2);
  cp.add(tf3);
  cp.add(tf4);
  cp.add(l1);
  cp.add(l2);
  cp.add(l3);
  cp.add(l4);
  
  l1.setBounds(20 ,10,20,20);
  tf1.setBounds(40,10,20,20);
  l2.setBounds(70,10,20,20);
  tf2.setBounds(90,10,20,20);
  l3.setBounds(120,10,40,20);
  tf3.setBounds(160,10,20,20);
  l4.setBounds(190,10,60,20);
  tf4.setBounds(250,10,20,20);
  bt.setBounds(300,10,80,20);
  dp.setBounds(20,40,x*w,y*w);
  setResizable(false);
  setSize(x*w+40,y*w+80);
  setTitle("ɨ��");
  show();
  bt.addActionListener(this);
  addWindowListener(new WindowAdapter()
  { public void windowClosing(WindowEvent e)
   {System.exit(0);}
  }
  );
 }
 public void actionPerformed(ActionEvent e)
 {
  if(e.getSource() == bt)
  {
   //x = Integer.parseInt(tf1.getText());
   //y = Integer.parseInt(tf2.getText());
   //w = Integer.parseInt(tf3.getText());
   sum = Integer.parseInt(tf4.getText());
   setSize(x*w+40,y*w+80);
   dp.setBounds(20,40,x*w,y*w);
   show();
   dp.initMin(x,y,w,sum);
  }
 }
 public static void main(String args[])
 {
  new Mine();
 }
};


