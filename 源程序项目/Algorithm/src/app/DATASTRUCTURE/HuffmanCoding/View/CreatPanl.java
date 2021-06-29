/*
 * @Author: 孔潇
 * @Date: 2020-07-02 12:56:16
 * @LastEditTime: 2020-07-02 17:11:22
 * @Description:  
 * @FilePath: \Data Structure\Algorithm\src\app\DATASTRUCTURE\HuffmanCoding\View\CreatPanl.java
 */
package app.DATASTRUCTURE.HuffmanCoding.View;

/**
 *@name CreatPanl.java
 *@author 孔潇
 *@time 上午11:09:32
 *@description 
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import app.DATASTRUCTURE.HuffmanCoding.Dao.Result;
import app.DATASTRUCTURE.HuffmanCoding.Entity.codeBook;
import app.DATASTRUCTURE.HuffmanCoding.Entity.codeBook2;
import app.DATASTRUCTURE.Test.GetMessage;
import app.DATASTRUCTURE.Test.Tree;
import app.DATASTRUCTURE.Test.TreeOperation;
import app.DATASTRUCTURE.Test.node;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreatPanl extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	public CreatPanl() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 619, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("创建哈夫曼树");
		lblNewLabel.setFont(new Font("方正有猫在简体", Font.BOLD, 33));
		lblNewLabel.setBounds(176, 20, 236, 63);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("请输入关键字：");
		label.setFont(new Font("方正有猫在简体", Font.BOLD, 20));
		label.setBounds(31, 82, 198, 55);
		contentPane.add(label);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(41, 133, 520, 191);
		contentPane.add(textArea);

		JLabel label_1 = new JLabel("或选择文件：");
		label_1.setFont(new Font("方正有猫在简体", Font.BOLD, 20));
		label_1.setBounds(31, 337, 198, 42);
		contentPane.add(label_1);

		textField = new JTextField();
		textField.setBounds(90, 396, 385, 23);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel label_2 = new JLabel("位置：");
		label_2.setFont(new Font("方正有猫在简体", Font.BOLD, 17));
		label_2.setBounds(41, 389, 51, 35);
		contentPane.add(label_2);

		JButton btnNewButton = new JButton("浏览");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileOperation fil = new FileOperation();
				fil.showFileOpenDialog(btnNewButton, textField);
			}
		});
		btnNewButton.setFont(new Font("方正有猫在简体", Font.BOLD, 15));
		btnNewButton.setBounds(494, 392, 67, 30);
		contentPane.add(btnNewButton);

		// 创建
		JButton button = new JButton("完成");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Path = "";
				String message = "";
				String result = "";
				if (textField.getText().length() != 0) {
					Path = textField.getText();
					GetMessage g = new GetMessage();
					message = g.getMessageForFile(Path);

				} else {
					message = textArea.getText();
				}
				Tree c = new Tree();
				node n = c.creat(message);
				codeBook code = new codeBook();
				codeBook2 book = new codeBook2();
				code.add(n);
				Result res = new Result();
				n.printcode(res);
				result = res.getRes();
				book.add(result);
				String Tree = TreeOperation.show(n);
				System.out.print(Tree);
				CreatSecc ses = new CreatSecc(result, Tree);
				ses.setVisible(true);
			}
		});
		button.setFont(new Font("方正有猫在简体", Font.BOLD, 15));
		button.setBounds(526, 460, 67, 30);
		contentPane.add(button);

		JButton button_1 = new JButton("取消");
		button_1.setFont(new Font("方正有猫在简体", Font.BOLD, 15));
		button_1.setBounds(459, 460, 67, 30);
		contentPane.add(button_1);
	}
}
