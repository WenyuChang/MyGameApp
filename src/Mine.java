import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.*;

class Min extends JPanel  //雷的类
{
 //备注：鼠标的左键 = 1；右键 = 3；中键 = 2
 private int flag = 0,statu = 0; //定义雷的属性 0:没有打开 1:打开 2:标示为雷 3:不确定
         //flag = 0 不是雷  ； flag = 1是雷
 private int but,count = 0; //but:哪一个鼠标键被按下去了   count:这个区域周围有多少个雷
 private int mx = 0,my = 0,mw = 10; //定义雷的坐标和宽度
 
 public Min()  //构造函数
 {
  statu = 0;
 }
 public Min(int f,int x,int y,int w)
 //构造函数
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
 //传递值
 {
  flag = f;
  mx  = (x-1)*w;
  my  = (y-1)*w;
  mw  = w-1;
  statu = s;
 }
 //根据你点击鼠标的不同来改变雷的属性
 public int sendKey(int key)
 {
 //返回值，如果游戏结束则返回-1 
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
 private int chx = 0,chy = 0; //专门记录坐标x,y的值
 private int msum = 6,ksum = 0; //msum:雷的个数,ksum:标示雷的个数
 private int bx = 10,by = 10,bw = 40; //bx,by:棋盘的大小，bw:棋子的大小
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
 //画坐标为ax,ay区域的雷的状态
 public void draw(Graphics g,int ax,int ay)
 {
  int x,y,w; //坐标x,y;和宽度:w
  int s,c,flag; //状态；雷的个数；
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
   case 0: //没有打开状态
   {
    g.setColor(Color.black);
    g.fillRect(x,y,w,w);
    break;
   }
   case 1: //打开状态
   {
    g.setColor(Color.blue);
    g.fillRect(x,y,w,w);
    if(c != 0 && flag == 0) //此处没有雷
    {
     g.setColor(Color.red);
     g.drawString(String.valueOf(c),x + cx,y + cy);
    }
    if(flag == 1) //此处有雷
    {
     g.setColor(Color.red);
     g.fillRect(x,y,w,w);
     g.setColor(Color.blue);
     g.drawString("雷",x + cx,y + cy);
    }
    break;
   }
   case 2: //标雷状态
   {
    g.setColor(Color.green);
    g.fillRect(x,y,w,w);
    g.setColor(Color.blue);
    g.drawString("旗",x + cx,y + cy);
    break;
   }
   case 3: //不确定状态
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
 //没有图形器的绘图函数：画出坐标ax,ay的雷的状态和图形
 public void draw(int ax,int ay)
 {
  Graphics g;
  g = this.getGraphics();
  draw(g,ax,ay);
 }

 //打开周围没有雷的地方，并且绘画所在区域点击左键触发
 public int openNoMin(int ax,int ay)
 {
  int i,j;
 
  if(ax<1||ay<1||ax>bx||ay>by) return 0;  //鼠标点击的区域出界了
  if(board[ax][ay].getStatu() != 0) return 0;  //如果此区域打开了，返回
  board[ax][ay].sendKey(1); //如果返回值等于-1，就说明游戏结束
  draw(ax,ay);
  if(board[ax][ay].getFlag() == 1)
  //如果游戏结束，把所有的雷都显示出来
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
  //如果游戏没有结束
  if(board[ax][ay].getCount() > 0) 
  {
   ksum ++;
   return 1; //周围有雷，就不用打开周围地区
  }
  if(board[ax][ay].getCount() == 0 && board[ax][ay].getFlag() == 0)
  //周围没有雷，打开周围地区，直到有雷的地区
  {
   openNoMin(ax-1,ay-1);openNoMin(ax,ay-1);openNoMin(ax+1,ay-1);
   openNoMin(ax-1,ay  );     openNoMin(ax+1,ay  );
   openNoMin(ax-1,ay+1);openNoMin(ax,ay+1);openNoMin(ax+1,ay+1);
  }
  ksum ++;
  return 1;
 }
 
 //计算坐标x,y的周围雷的个数
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
 
 //传入参数：几列，几行，宽度，雷数
 public void initMin(int ax,int ay,int aw,int as)
 {
  int k = 1;  //表明产生的第几个雷
  Random r;  //随机数

  f = 0;   //f=0表示游戏还没有结束
  ksum = 0;
  bx = ax;
  by = ay;
  bw = aw;
  msum = as;
  r = new Random();
  //初始化底盘的值
  for(i = 1;i <= bx;i++)
  {
   for(j=1;j<=by;j++)
   {
    board[i][j].setData(0,i,j,bw,0);
   }
  }
  //随机产生雷
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
  //非雷区的周围有几个雷，初始化其值
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
 //构造函数
 public DrawPanel(int ax,int ay,int aw,int as)
 {
  initMin(ax,ay,aw,as);
  addMouseListener(new MouseAdapter()
  {
   public void mousePressed(MouseEvent me)
   {
    int r;
    if(f != 0) return;  //如果游戏结束，返回
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
 //重画所有的图形，包括一些修饰的图形
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
//主类和程序的入口
public class Mine extends JFrame implements ActionListener
{
 Container  cp = getContentPane();
 JButton  bt = new JButton("开局"); 
 Label l1 = new Label("列:");
 Label l2 = new Label("行:");
 Label l3 = new Label("宽度:");
 Label l4 = new Label("雷的个数:");
 TextField tf1 = new TextField("10",2); //列
 TextField tf2 = new TextField("10",2); //行
 TextField tf3 = new TextField("40",2); //宽度
 TextField tf4 = new TextField("15",2); //雷的个数
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
  setTitle("扫雷");
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


