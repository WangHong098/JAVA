import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

import javax.swing.JFrame;
//import javax.swing.JPanel;
import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class MyTcp extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedReader reader; // 创建BufferedReader对象
	private ServerSocket server; // 创建ServerSocket对象
	private Socket socket; // 创建Socket对象socket
	
	private PrintWriter writer; // 声明PrintWriter类对象
//	private JTextArea ta = new JTextArea(); // 创建JtextArea对象
	private JTextField tf = new JTextField(); // 创建JtextField对象
	
	private JTextPane textPane = new JTextPane();
//	private JPanel contPane = new JPanel(); 
	private SimpleAttributeSet set = new SimpleAttributeSet();
	Document doc;
	Container cc; // 声明Container对象
	
	public MyTcp(String title) { // 构造方法
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
		cc.add(tf, "South"); // 将文本框放在窗体的下部
		tf.addActionListener(new ActionListener() {
			// 绑定事件
			public void actionPerformed(ActionEvent e) {
				// 将文本框中信息写入流
				writer.println(tf.getText());
				// 将文本框中信息显示在文本域中
				Append(tf.getText()+'\n',Color.RED);
//				ta.append(tf.getText() + '\n');			
//				ta.setSelectionEnd(ta.getText().length());
				tf.setText(""); // 将文本框清空
			}
		});
	}
	void getserver() {
		try {
			server = new ServerSocket(998); // 实例化Socket对象
//			System.out.println("服务器套接字已经创建成功"); // 输出信息
//			ta.append("服务器套接字已经创建成功！\n");
			Append("服务器套接字已经创建成功！\n",Color.black);
			while (true) { // 如果套接字是连接状态
//				System.out.println("等待客户机的连接"); // 输出信息
//				ta.append("等待客户机的连接！\n");
				Append("等待客户机的连接...\n",Color.black);
				socket = server.accept(); // 实例化Socket对象
				writer = new PrintWriter(socket.getOutputStream(),true);
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 实例化BufferedReader对象	
				getClientMessage(); // 调用getClientMessage()方法
			}
		} catch (Exception e) {
			e.printStackTrace(); // 输出异常信息
		}
	}
	private void getClientMessage() {
		try {
			while (true) { // 如果套接字是连接状态					
				Append("客户机: "+reader.readLine()+'\n',Color.blue);

//				ta.append("客户机:" + reader.readLine() + '\n');
//				if (reader.ready()) {
//					// 获得客户端信息
//					System.out.println("客户机:" + reader.readLine());
//					writer = new PrintWriter(socket.getOutputStream(), true);
//					ta.append("客户机:" + reader.readLine() + '\n');
//				}
			}
		} catch (Exception e) {
			e.printStackTrace(); // 输出异常信息
		}
		try {
			if (reader != null) {
				reader.close(); // 关闭流
			}
			if (socket != null) {
				socket.close(); // 关闭套接字
			}
		} catch (IOException e) {
			e.printStackTrace();
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTcp tcp=new MyTcp("MY_TCP");
		tcp.setSize(300, 200);
		tcp.setVisible(true);
		tcp.getserver();
	}

}
