package app.DATASTRUCTURE.HuffmanCoding.View;

/**
 *@name CreatSecc.java
 *@author 孔潇
 *@time 上午11:21:52
 *@description 
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextArea;

public class CreatSecc extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public CreatSecc(String result, String tree) {
		setTitle("创建成功");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 805);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("创建成功，详情如下：");
		lblNewLabel.setForeground(new Color(51, 153, 204));
		lblNewLabel.setFont(new Font("方正像素12", Font.BOLD, 26));
		lblNewLabel.setBounds(37, 10, 285, 52);
		contentPane.add(lblNewLabel);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(37, 72, 442, 249);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 17));
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(37, 72, 442, 249);
		textArea.append(result);
		// textArea.setCaretPosition(textArea.getText().length());
		contentPane.add(scroll);

		JLabel label = new JLabel("哈夫曼树为：");
		label.setForeground(new Color(51, 153, 204));
		label.setFont(new Font("方正像素12", Font.BOLD, 26));
		label.setBounds(37, 333, 285, 52);
		contentPane.add(label);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(37, 395, 442, 314);
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 17));
		JScrollPane scroll2 = new JScrollPane(textArea_1);
		scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll2.setBounds(37, 395, 442, 314);
		textArea_1.append(tree);
		// textArea.setCaretPosition(textArea.getText().length());
		contentPane.add(scroll2);
	}
}
