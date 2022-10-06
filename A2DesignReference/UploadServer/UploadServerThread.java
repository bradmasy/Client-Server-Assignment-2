import java.net.*;
import java.io.*;
import java.time.Clock;
public class UploadServerThread extends Thread {
   private Socket socket = null;
   public UploadServerThread(Socket socket) {
      super("DirServerThread");
      this.socket = socket;
   }
   public void run() {
      try {
         InputStream in = socket.getInputStream(); 
         HttpServletRequest req = new HttpServletRequest(in);  
         OutputStream baos = new ByteArrayOutputStream(); 
         HttpServletResponse res = new HttpServletResponse(baos); 
         Class<?> c = Class.forName("UploadServlet");
         System.out.println(c);
         HttpServlet upload = (UploadServlet) c.getDeclaredConstructor().newInstance();
         System.out.println(upload);
         HttpServlet httpServlet = upload; //new UploadServlet(); // where reflection has to work, different server names, all classes must extend http servlet
         httpServlet.doPost(req, res);
         OutputStream out = socket.getOutputStream(); 
         out.write(((ByteArrayOutputStream) baos).toByteArray());
         socket.close();
      } catch (Exception e) { e.printStackTrace(); }
   }
}

//    Class<?> c = Class.forName("reflection.Dog");
	//	Dog d = (Dog) c.getDeclaredConstructor().newInstance();
