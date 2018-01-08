# JAVA的IO操作
## 实验一 基本IO操作
- 从键盘接收字节流
- 写入到当前目录下的src.txt文件中
- 将src.txt文件内容复制到当前目录下dest.txt文件中
- 将dest.txt文件内容显示到屏幕上

### I. 工程名
Based_IO.java
### II. 主要源代码

```
public class Based_IO {
	public static void write(String f,String s) throws IOException{
		File file=new File(f);
		FileWriter fw=new FileWriter(file);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write(s);
		bw.flush();
		bw.close();
	}
	public static String read(String f) throws IOException{
		File file=new File(f);
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String s="";
		String line="";
		while(line!=null) {
			s=s+line;
			line=br.readLine();
		}
		return s;
	}

	public static void main(String args[]) throws IOException {  
		System.out.println("please input :");
		Scanner scanner=new Scanner(System.in);
		String s=scanner.nextLine();
		s=read("src.txt");
		write("dest.txt",s);
		s=read("dest.txt");
		System.out.println("output :");
		System.out.println(s);
	}
}
```

### III. 实验截图
![image](https://note.youdao.com/yws/public/resource/c1eee1ea5aba9bb41e017858f53d2dec/xmlnote/D7922ED90B62440EAC52DD6FA1F6F58D/491)
![image](https://note.youdao.com/yws/public/resource/c1eee1ea5aba9bb41e017858f53d2dec/xmlnote/D2449042ED1543CD9514767A73DA9AF7/492)
## 实验二 获取系统的文件树
- 获取某个目录下的目录信息，目录从控制台输入。
- 目录信息包括该目录下的所有文件和文件夹的列表。对于每个文件夹显示其名称，修改日期。对于每个文件显示其名称，修改日期和大小。
- 目录的信息写出到文件中。注意，文件信息首先按类型分类，文件夹在前，文件在后，并且他们各自按照文件名字符串的顺序排序。
- 扩展以及自学部分：利用JAVA的GUI（Swing等）创建一个简易的文件浏览器。

### I. 工程名
    FileTree.java
    MyComparator.java
### II. 主要源代码

```
public class FileTree {
	public void FileTree_Test() {
		Scanner scan=new Scanner(System.in);
		System.out.println("please enter filepath");
		String str=scan.nextLine();		
        String fileName=str;       
        File file = new File(fileName);
        print(file);
        scan.close();
	}

	public void print(File f) {
        if (f != null) {
            	TreeSet ts=new TreeSet(new MyComparator());
            	File t;
                File [] arr = f.listFiles();
                File out=new File("filename.txt");
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
                
                if (arr != null) {
                	for(int i=0;i<arr.length;i++)
                			ts.add(arr[i]);
                	try {
                		PrintWriter fout=new PrintWriter(out);
                		Iterator it1=ts.iterator();
                    	Iterator it2=ts.iterator();
	                	String b;
	                	for(int i=0;i<arr.length;i++) {
	                		t=(File)it1.next();
	                    	if (t.isDirectory()) {
		                    	System.out.println(b=(t.getName()+"\t\t修改时间："+df.format( new Date(t.lastModified()))));
		                    	fout.write(b+"\r\n");
	                    		
	                        }
	                    }
	                	for(int i=0;i<arr.length;i++) {
	                		t=(File)it2.next();
	                    	if (!t.isDirectory())  {	
	                            System.out.println(b=(t.getName()+"\t\t修改时间："+df.format( new Date(t.lastModified())))+"\t大小:"+t.length()+"字节");
	                            fout.write(b+"\r\n");
	                        }
	                    }
	                	fout.close();
                	}catch (IOException e){
                		System.out.println(e.toString());
                	}
                }          
        }
	}
	public static void main(String [] args) {
		FileTree f=new FileTree();
		f.FileTree_Test();	
	}
}
```

### III. 实验截图
![image](https://note.youdao.com/yws/public/resource/c1eee1ea5aba9bb41e017858f53d2dec/xmlnote/18DD6C68CB7C4237BB65B8EBCA554E3B/454)
![image](https://note.youdao.com/yws/public/resource/c1eee1ea5aba9bb41e017858f53d2dec/xmlnote/0DB5DC14F189436281B63D5D07DE3C33/449)
## 实验三 带缓冲区的IO
- 用带缓冲和不带缓冲的字符流实现文件复制，并比较耗时情况。

### I. 工程名
Buffered_IO.java
### II. 主要源代码

```
public class Buffered_IO {

	public void withoutBuffer() {
		try{
			int c;
			File inFile=new File("iris.txt");
			File outFile=new File("withoutBuffer.txt");
			Reader finS=new FileReader(inFile);
			Writer foutS=new FileWriter(outFile);
			while((c=finS.read())!=-1) {
				foutS.write(c);
			}
			foutS.close();
			finS.close();
		} catch (IOException e) {
			System.err.println("FileStreamTest:"+e);
		}
	}
	public void withBuffer() {
		try {
			int c;
			File inFile=new File("iris.txt");
			File outFile=new File("withBuffer.txt");
			Reader finS=new FileReader(inFile);
			Writer foutS=new FileWriter(outFile);
			BufferedReader bfinS=new BufferedReader(finS);
			BufferedWriter bfoutS=new BufferedWriter(foutS);
			while((c=bfinS.read())!=-1) {
				bfoutS.write(c);
			}
			bfoutS.close();
			bfinS.close();
		} catch (IOException e) {
			System.err.println("FileStreamTest:"+e);
		}
	}
	public static void main(String [] args)
	{
		Buffered_IO io=new Buffered_IO();
		long startTime = System.currentTimeMillis();
		io.withoutBuffer();
		long endTime = System.currentTimeMillis();
		System.out.println("不带缓冲区的IO: "+(endTime-startTime)+"ms");
		long startTime1 = System.currentTimeMillis();
		io.withBuffer();
		long endTime1 = System.currentTimeMillis();
		System.out.println("带缓冲区的IO: "+(endTime1-startTime1)+"ms");
	}

}
```

### III. 实验截图
![image](https://note.youdao.com/yws/public/resource/c1eee1ea5aba9bb41e017858f53d2dec/xmlnote/EF0D37C1E60747F195ADDC7AD120E6E1/443)
## 实验四 对象序列化
- 类Student表示学生，属性包括{studentID, name, sex} (学号，姓名，性别)，使用序列化技术定义Student。学生信息从文件list.txt读入，并按照学号升序排列。注意，这里姓名和性别可以组织成String类型，而学号可以是String也可以是Long。
- 使用ObjectOutputStream将已经排序的学生信息写出到文件“student.bin”中。
- 使用ObjectInputStream将“student.bin”中的对象信息读入程序，显示在控制台中。

### I. 工程名
    Student.java 
    Serialization.java
### II. 主要源代码

```
public class Serialization {
	public void readFile(SortedSet<Student> ts) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("list.txt"),"UTF-8"));
		String s;
		while((s=br.readLine())!=null) {			
			String [] str=s.split(" ");			
			Student stu=new Student(Long.parseLong(str[0]),str[1],str[2]);			
			ts.add(stu);
		}
		br.close();
	}
	public void ObjectIO(SortedSet<Student> ts) throws Exception {
		Student s=new Student();
		Student t=null;
		String filename = "student.bin";
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fos = new FileOutputStream(filename);
			out = new ObjectOutputStream(fos);
			Iterator it=ts.iterator();
			while(it.hasNext()) 
				out.writeObject((Student)it.next());
			out.writeObject(t);
			out.close();
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			while((s=(Student)in.readObject())!=null)
				System.out.println(s.toString());
			in.close();
			} catch (IOException ex) {
			   ex.printStackTrace();
			}

	}
	public static void main(String[] args) throws Exception {
		SortedSet<Student> ts=new TreeSet<>();
		Serialization stu=new Serialization();
		stu.readFile(ts);
		stu.ObjectIO(ts);
	}
}
```


### III. 实验截图
![image](https://note.youdao.com/yws/public/resource/c1eee1ea5aba9bb41e017858f53d2dec/xmlnote/302547A9FE974ECBB8D5CDBB4E5B7061/494)