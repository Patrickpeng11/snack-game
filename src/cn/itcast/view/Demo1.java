package cn.itcast.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import cn.itcast.util.FrameUtil;

public class Demo1 extends JPanel {  //Demo1 Ҳ��һ�����
	
	
	@Override
	public void paint(Graphics g) {  // Graphics g ����  ʹ�øû��ʿ��Ի��κεĶ�����
		//���û��ʵ���ɫ
		g.setColor(Color.GRAY);
		//������
		g.fill3DRect(0, 0, 20, 20, true);
		g.fill3DRect(20, 0, 20, 20, true);
		g.setColor(Color.GREEN);
		g.fill3DRect(20,20, 20, 20, true);
		
		//д��
		g.setColor(Color.RED);
		//���û��� ������
		g.setFont(new Font("����", Font.BOLD, 30));
		g.drawString("GAME OVER", 300, 200);
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("����");
		Demo1 d = new Demo1();
		frame.add(d);
		FrameUtil.initFrame(frame,700, 500);
		
	}

	
	
	

}
