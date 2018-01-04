# 实验七_JAVA网络编程

## 实验内容

改造教材19.2和19.3的例子，创建简单的聊天程序
- 服务器也具有类似客户端的UI界面
- 服务器也能够向客户端发送信息
- 客户端和服务器端UI界面要区分各自发送和接收到的信息，比如可以使用颜色区分彼此的聊天记录

## 主要源代码
### 服务器

```
public class MyTcp extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedReader reader; // 创建BufferedReader对象
	private ServerSocket server; // 创建ServerSocket对象
	private Socket socket; // 创建Socket对象socket
	
	private PrintWriter writer; // 声明PrintWriter类对象
	private JTextField tf = new JTextField(); // 创建JtextField对象
	private JTextPane textPane = new JTextPane();

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

		doc = textPane.getStyledDocument();

		cc.add(tf, "South"); // 将文本框放在窗体的下部
		tf.addActionListener(new ActionListener() {
			// 绑定事件
			public void actionPerformed(ActionEvent e) {
				// 将文本框中信息写入流
				writer.println(tf.getText());
				// 将文本框中信息显示在文本域中
				Append(tf.getText()+'\n',Color.RED);
				tf.setText(""); // 将文本框清空
			}
		});
	}
	void getserver() {
		try {
			server = new ServerSocket(998); // 实例化Socket对象
			Append("服务器套接字已经创建成功！\n",Color.black);
			while (true) { // 如果套接字是连接状态
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

```

### 客户端

```
public class MyClien extends JFrame { /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BufferedReader reader; // 创建BufferedReader对象
	private PrintWriter writer; // 声明PrintWriter类对象
	Socket socket; // 声明Socket对象
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
		doc = textPane.getStyledDocument();

		cc.add(tf, "South"); // 将文本框放在窗体的底部
		tf.addActionListener(new ActionListener() {
			// 绑定事件
			public void actionPerformed(ActionEvent e) {
				// 将文本框中信息写入流
				writer.println(tf.getText());
				// 将文本框中信息显示在文本域中
				Append(tf.getText()+'\n',Color.BLUE);
				tf.setText(""); // 将文本框清空
			}
		});
	}
	private void getTCPMessage(){
		try{
			while(true){	
				Append("服务器: "+reader.readLine()+'\n',Color.RED);
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
		Append("尝试连接...\n",Color.BLACK);
		try { // 捕捉异常
			socket = new Socket("127.0.0.1", 998); // 实例化Socket对象
			writer = new PrintWriter(socket.getOutputStream(), true);
			reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
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

```

## 实验截图
![image](https://note.youdao.com/yws/public/resource/c1eee1ea5aba9bb41e017858f53d2dec/xmlnote/25CA309D9D1F484887FD071CA528D90E/289)
![image](https://note.youdao.com/yws/public/resource/c1eee1ea5aba9bb41e017858f53d2dec/xmlnote/885130C2D845401D8995D46FED1AE936/292)
![image](https://note.youdao.com/yws/public/resource/c1eee1ea5aba9bb41e017858f53d2dec/xmlnote/48D3EFDF5DCE4DCAB6564BB413DE16CC/293)
![image](https://note.youdao.com/yws/public/resource/c1eee1ea5aba9bb41e017858f53d2dec/xmlnote/F67DE14401834C74B877939A6E97C796/291)