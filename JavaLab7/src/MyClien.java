
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class MyClien extends JFrame { /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
// 创建类继承JFrame类
	private BufferedReader reader; // 创建BufferedReader对象
	private PrintWriter writer; // 声明PrintWriter类对象
	Socket socket; // 声明Socket对象
//	private JTextArea ta = new JTextArea(); // 创建JtextArea对象
	private JTextField tf = new JTextField(); // 创建JtextField对象

	Container cc; // 声明Container对象
	private JTextPane textPane = new JTextPane();
	private SimpleAttributeSet set = new SimpleAttributeSet();
	Document doc;
	
	public MyClien(String title) { // 构造方法
		super(title); // 调用父类的构造方法
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cc = this.getContentPane(); // 实例化对象

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		cc.setLayout(new BorderLayout());
		cc.add(new JScrollPane(textPane),"Center");
		setContentPane(cc);
//		setVisible(true);
		doc = textPane.getStyledDocument();
//		scrollPane.setViewportView(ta);
		cc.add(tf, "South"); // 将文本框放在窗体的底部
		tf.addActionListener(new ActionListener() {
			// 绑定事件
			public void actionPerformed(ActionEvent e) {
				// 将文本框中信息写入流
				writer.println(tf.getText());
				// 将文本框中信息显示在文本域中
				Append(tf.getText()+'\n',Color.BLUE);
//				ta.append(tf.getText() + '\n');
//				ta.setSelectionEnd(ta.getText().length());
				tf.setText(""); // 将文本框清空
			}
		});
	}
	private void getTCPMessage(){
		try{
			while(true){	
				Append("服务器: "+reader.readLine()+'\n',Color.RED);
//				ta.setForeground(Color.BLUE);
//				ta.append("服务器:"+reader.readLine()+'\n');		
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		try{
			if(reader!=null){
				reader.close();
			}
			if(socket!=null){
				socket.close();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	private void connect() { // 连接套接字方法
//		ta.append("尝试连接\n"); // 文本域中提示信息
		Append("尝试连接...\n",Color.BLACK);
		try { // 捕捉异常
			socket = new Socket("127.0.0.1", 998); // 实例化Socket对象
			writer = new PrintWriter(socket.getOutputStream(), true);
			reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			ta.append("完成连接\n"); // 文本域中提示信息
			Append("完成连接！\n",Color.BLACK);
			getTCPMessage();
		} catch (Exception e) {
			e.printStackTrace(); // 输出异常信息
		}
	}
	public void Append(String text , Color textColor)//根据传入的颜色及文字，将文字插入文本域
	{
		StyleConstants.setForeground(set, textColor);//设置文字颜色	
		try{
			doc.insertString(doc.getLength(), text, set);//插入文字
		}catch (BadLocationException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) { // 主方法
		MyClien clien = new MyClien("MY_CLIENT"); // 创建本例对象
		clien.setSize(300, 200); // 设置窗体大小
		clien.setVisible(true); // 将窗体显示
		clien.connect(); // 调用连接方法
	}
}
