/*
 * @Author: 孔潇
 * @Date: 2020-07-02 17:26:53
 * @LastEditTime: 2020-07-02 17:57:31
 * @Description:  
 * @FilePath: \Data Structure\Algorithm\src\app\DATASTRUCTURE\HuffmanCoding\View\Translate.java
 */
package app.DATASTRUCTURE.HuffmanCoding.View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.DATASTRUCTURE.HuffmanCoding.Entity.codeBook;
import app.DATASTRUCTURE.HuffmanCoding.Service.TransLate;
import app.DATASTRUCTURE.Test.node;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Translate extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public Translate() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 520, 780);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("请输入二进制码：");
        lblNewLabel.setFont(new Font("方正有猫在简体", Font.BOLD, 23));
        lblNewLabel.setBounds(10, 79, 184, 45);
        contentPane.add(lblNewLabel);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(20, 122, 450, 178);
        contentPane.add(textArea);

        JLabel label = new JLabel("译文：");
        label.setFont(new Font("方正有猫在简体", Font.BOLD, 23));
        label.setBounds(10, 328, 184, 45);
        contentPane.add(label);

        JTextArea textArea_1 = new JTextArea();
        textArea_1.setBounds(20, 378, 450, 287);
        contentPane.add(textArea_1);

        JLabel label_1 = new JLabel("\"哈夫曼译码\"");
        label_1.setFont(new Font("方正标致简体", Font.BOLD, 28));
        label_1.setBounds(153, 23, 196, 56);
        contentPane.add(label_1);

        JButton btnNewButton = new JButton("翻   译");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String code = textArea.getText();
                codeBook node = new codeBook();
                node n = node.get(0);
                String word = TransLate.fanyi(code, n);
                textArea_1.setText(word);
            }
        });
        btnNewButton.setFont(new Font("黑体", Font.BOLD, 18));
        btnNewButton.setBounds(177, 318, 110, 43);
        contentPane.add(btnNewButton);
    }

}
