package cn.itcast.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import cn.itcast.util.FrameUtil;

public class SnakeView  extends JPanel{

	//��ͼ�Ŀ�(����)
	public static final int WIDTH = 40;
	
	//��ͼ�ߣ�������
	public static final int HEIGHT = 30;	
	
	
	//���ӿ�
	public static final int CELLWIDTH = 20;
	
	//���Ӹ�
	public static final int CELLHEIGHT = 20;
	
	//��ͼ
	private boolean[][] background = new boolean[HEIGHT][WIDTH];
	

	//ʹ�ü��ϱ����߽ڵ��������Ϣ
	LinkedList<Point>  snake = new LinkedList<Point>(); 
	
	
	//��ʼ����
	public void initSnake(){
		int x = WIDTH/2;
		int y = HEIGHT/2;
		snake.addFirst(new Point(x-1,y));
		snake.addFirst(new Point(x,y));
		snake.addFirst(new Point(x+1,y));
	}
		
	
	//�����ƶ�
	public void moveUp(){
		//��ȡԭ����ͷ 
		Point head = snake.getFirst();
		//����µ���ͷ
		snake.addFirst(new Point(head.x,head.y-1));
		//ɾ����β
		snake.removeLast();
	}
	
	
	//��ʼ����ͼ
	public void initBackground(){
		for(int rows = 0 ; rows<background.length ; rows++){
			for(int cols = 0  ; cols<background[rows].length ; cols++ ){
				if(rows==0||rows==(HEIGHT-1)||cols==0||cols==(WIDTH-1)){  //��һ�С����һ�С� ��һ�������һ��
					background[rows][cols] = true;
				}
			}
		}
	}
		
	
	@Override
	public void paint(Graphics g) {
		//����ͼ		
		for(int rows = 0 ; rows<background.length ; rows++){ // rows =0 
			for(int cols = 0  ; cols<background[rows].length ; cols++ ){
				if(background[rows][cols]){
					//ʯͷ
					g.setColor(Color.GRAY);
				}else{
					//�յ�
					g.setColor(Color.WHITE);
				}
				//������
				g.fill3DRect(cols*CELLWIDTH, rows*CELLHEIGHT, CELLWIDTH, CELLHEIGHT, true);
			}
		}
		
		//����
		
		//ȡ����ͷ
		Point head = snake.getFirst();
		g.setColor(Color.RED);
		g.fill3DRect(head.x*CELLWIDTH, head.y*CELLHEIGHT, CELLWIDTH, CELLHEIGHT, true);
		//������
		g.setColor(Color.GREEN);
		for(int i =1; i<snake.size() ; i++ ){
			Point body = snake.get(i);
			g.fill3DRect(body.x*CELLWIDTH, body.y*CELLHEIGHT, CELLWIDTH, CELLHEIGHT, true);
		}
		
		
		
	
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("̰����");
		final SnakeView snakeView = new SnakeView();
		snakeView.initBackground();
		snakeView.initSnake();
		frame.add(snakeView);
		FrameUtil.initFrame(frame, WIDTH*CELLWIDTH+20, HEIGHT*CELLHEIGHT+35);
		
		//����������¼�����
		frame.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				switch (code) {
				case KeyEvent.VK_UP:
						snakeView.moveUp();
						//�ػ���Ϸ
						snakeView.repaint(); //����repaint������ʱ��ʵ���Ͼ��ǵ�����paint������
					break;

				default:
					break;
				}
				
				
			}
			
			
			
		});
		
		
		
		
		
	}
	
}
