package app.DATASTRUCTURE.HuffmanCoding.View;

/**
 *@name Home.java
 *@author 孔潇
 *@time 上午10:22:13
 *@description 
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Home extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Home() {
		setTitle("数据结构课程设计-Huffman编码/译码-孔潇");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 755);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("\"Huffman编译器\"");
		lblNewLabel_1.setForeground(new Color(0, 102, 204));
		lblNewLabel_1.setFont(new Font("方正有猫在简体", Font.BOLD, 39));
		lblNewLabel_1.setBounds(92, 70, 299, 54);
		lblNewLabel_1.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				// 处理鼠标点击
			}

			public void mouseEntered(MouseEvent e) {
				// 处理鼠标移入
			}

			public void mouseExited(MouseEvent e) {
				// 处理鼠标离开
			}

			public void mousePressed(MouseEvent e) {
				// 处理鼠标按下
			}

			public void mouseReleased(MouseEvent e) {
				// 处理鼠标释放
			}
		});
		contentPane.add(lblNewLabel_1);

		JLabel label = new JLabel("菜单");
		label.setForeground(new Color(0, 102, 204));
		label.setFont(new Font("方正手绘简体", Font.BOLD, 24));
		label.setBounds(195, 156, 67, 41);
		contentPane.add(label);

		JLabel label_1 = new JLabel("哈夫曼树创建");
		label_1.setForeground(new Color(0, 102, 204));
		label_1.setFont(new Font("方正有猫在简体", Font.BOLD, 32));
		label_1.setBounds(124, 231, 235, 54);
		label_1.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				// 处理鼠标点击
				CreatPanl frame = new CreatPanl();
				frame.setVisible(true);
			}

			public void mouseEntered(MouseEvent e) {
				// 处理鼠标移入
			}

			public void mouseExited(MouseEvent e) {
				// 处理鼠标离开
			}

			public void mousePressed(MouseEvent e) {
				// 处理鼠标按下
			}

			public void mouseReleased(MouseEvent e) {
				// 处理鼠标释放
			}
		});
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("导入密码本");
		label_2.setForeground(new Color(0, 102, 204));
		label_2.setFont(new Font("方正有猫在简体", Font.BOLD, 32));
		label_2.setBounds(143, 320, 235, 54);
		contentPane.add(label_2);

		JLabel label_3 = new JLabel("哈夫曼加密");
		label_3.setForeground(new Color(0, 102, 204));
		label_3.setFont(new Font("方正有猫在简体", Font.BOLD, 32));
		label_3.setBounds(143, 403, 235, 54);
		label_3.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				// 处理鼠标点击

				// codeIn frame = new codeIn();
				// frame.setVisible(true);
			}

			public void mouseEntered(MouseEvent e) {
				// 处理鼠标移入
			}

			public void mouseExited(MouseEvent e) {
				// 处理鼠标离开
			}

			public void mousePressed(MouseEvent e) {
				// 处理鼠标按下
			}

			public void mouseReleased(MouseEvent e) {
				// 处理鼠标释放
			}
		});
		contentPane.add(label_3);

		JLabel label_4 = new JLabel("哈夫曼译码");
		label_4.setForeground(new Color(0, 102, 204));
		label_4.setFont(new Font("方正有猫在简体", Font.BOLD, 32));
		label_4.setBounds(143, 487, 235, 54);
		label_4.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				// 处理鼠标点击
				Translate frame = new Translate();
				frame.setVisible(true);
			}

			public void mouseEntered(MouseEvent e) {
				// 处理鼠标移入
			}

			public void mouseExited(MouseEvent e) {
				// 处理鼠标离开
			}

			public void mousePressed(MouseEvent e) {
				// 处理鼠标按下
			}

			public void mouseReleased(MouseEvent e) {
				// 处理鼠标释放
			}
		});
		contentPane.add(label_4);

		JLabel label_5 = new JLabel("退出");
		label_5.setForeground(new Color(0, 102, 204));
		label_5.setFont(new Font("方正有猫在简体", Font.BOLD, 32));
		label_5.setBounds(193, 559, 235, 54);
		contentPane.add(label_5);
	}
}
