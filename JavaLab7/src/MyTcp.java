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
	private BufferedReader reader; // ����BufferedReader����
	private ServerSocket server; // ����ServerSocket����
	private Socket socket; // ����Socket����socket
	
	private PrintWriter writer; // ����PrintWriter�����
//	private JTextArea ta = new JTextArea(); // ����JtextArea����
	private JTextField tf = new JTextField(); // ����JtextField����
	
	private JTextPane textPane = new JTextPane();
//	private JPanel contPane = new JPanel(); 
	private SimpleAttributeSet set = new SimpleAttributeSet();
	Document doc;
	Container cc; // ����Container����
	
	public MyTcp(String title) { // ���췽��
		super(title); // ���ø���Ĺ��췽��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cc = this.getContentPane(); // ʵ��������

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		cc.setLayout(new BorderLayout());
		cc.add(new JScrollPane(textPane),"Center");
		setContentPane(cc);
//		setVisible(true);
		doc = textPane.getStyledDocument();
		
//		scrollPane.setViewportView(ta);
		cc.add(tf, "South"); // ���ı�����ڴ�����²�
		tf.addActionListener(new ActionListener() {
			// ���¼�
			public void actionPerformed(ActionEvent e) {
				// ���ı�������Ϣд����
				writer.println(tf.getText());
				// ���ı�������Ϣ��ʾ���ı�����
				Append(tf.getText()+'\n',Color.RED);
//				ta.append(tf.getText() + '\n');			
//				ta.setSelectionEnd(ta.getText().length());
				tf.setText(""); // ���ı������
			}
		});
	}
	void getserver() {
		try {
			server = new ServerSocket(998); // ʵ����Socket����
//			System.out.println("�������׽����Ѿ������ɹ�"); // �����Ϣ
//			ta.append("�������׽����Ѿ������ɹ���\n");
			Append("�������׽����Ѿ������ɹ���\n",Color.black);
			while (true) { // ����׽���������״̬
//				System.out.println("�ȴ��ͻ���������"); // �����Ϣ
//				ta.append("�ȴ��ͻ��������ӣ�\n");
				Append("�ȴ��ͻ���������...\n",Color.black);
				socket = server.accept(); // ʵ����Socket����
				writer = new PrintWriter(socket.getOutputStream(),true);
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); // ʵ����BufferedReader����	
				getClientMessage(); // ����getClientMessage()����
			}
		} catch (Exception e) {
			e.printStackTrace(); // ����쳣��Ϣ
		}
	}
	private void getClientMessage() {
		try {
			while (true) { // ����׽���������״̬					
				Append("�ͻ���: "+reader.readLine()+'\n',Color.blue);

//				ta.append("�ͻ���:" + reader.readLine() + '\n');
//				if (reader.ready()) {
//					// ��ÿͻ�����Ϣ
//					System.out.println("�ͻ���:" + reader.readLine());
//					writer = new PrintWriter(socket.getOutputStream(), true);
//					ta.append("�ͻ���:" + reader.readLine() + '\n');
//				}
			}
		} catch (Exception e) {
			e.printStackTrace(); // ����쳣��Ϣ
		}
		try {
			if (reader != null) {
				reader.close(); // �ر���
			}
			if (socket != null) {
				socket.close(); // �ر��׽���
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Append(String text , Color textColor)//���ݴ������ɫ�����֣������ֲ����ı���
	{	
		StyleConstants.setForeground(set, textColor);//����������ɫ	
		try{
			doc.insertString(doc.getLength(), text, set);//��������
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
