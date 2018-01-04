
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
// ������̳�JFrame��
	private BufferedReader reader; // ����BufferedReader����
	private PrintWriter writer; // ����PrintWriter�����
	Socket socket; // ����Socket����
//	private JTextArea ta = new JTextArea(); // ����JtextArea����
	private JTextField tf = new JTextField(); // ����JtextField����

	Container cc; // ����Container����
	private JTextPane textPane = new JTextPane();
	private SimpleAttributeSet set = new SimpleAttributeSet();
	Document doc;
	
	public MyClien(String title) { // ���췽��
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
		cc.add(tf, "South"); // ���ı�����ڴ���ĵײ�
		tf.addActionListener(new ActionListener() {
			// ���¼�
			public void actionPerformed(ActionEvent e) {
				// ���ı�������Ϣд����
				writer.println(tf.getText());
				// ���ı�������Ϣ��ʾ���ı�����
				Append(tf.getText()+'\n',Color.BLUE);
//				ta.append(tf.getText() + '\n');
//				ta.setSelectionEnd(ta.getText().length());
				tf.setText(""); // ���ı������
			}
		});
	}
	private void getTCPMessage(){
		try{
			while(true){	
				Append("������: "+reader.readLine()+'\n',Color.RED);
//				ta.setForeground(Color.BLUE);
//				ta.append("������:"+reader.readLine()+'\n');		
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
	
	private void connect() { // �����׽��ַ���
//		ta.append("��������\n"); // �ı�������ʾ��Ϣ
		Append("��������...\n",Color.BLACK);
		try { // ��׽�쳣
			socket = new Socket("127.0.0.1", 998); // ʵ����Socket����
			writer = new PrintWriter(socket.getOutputStream(), true);
			reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			ta.append("�������\n"); // �ı�������ʾ��Ϣ
			Append("������ӣ�\n",Color.BLACK);
			getTCPMessage();
		} catch (Exception e) {
			e.printStackTrace(); // ����쳣��Ϣ
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
	public static void main(String[] args) { // ������
		MyClien clien = new MyClien("MY_CLIENT"); // ������������
		clien.setSize(300, 200); // ���ô����С
		clien.setVisible(true); // ��������ʾ
		clien.connect(); // �������ӷ���
	}
}
