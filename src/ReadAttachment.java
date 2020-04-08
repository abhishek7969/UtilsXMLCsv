import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;

class ReadAttachment{
  public static void main(String [] args)throws Exception{
   
   String host="mail.javatpoint.com";
   final String user="unipaysupport@innoviti.com";
   final String password="hlvvnqxndmlceadn";//change accordingly

   Properties properties = System.getProperties();
   properties.setProperty("mail.smtp.host",host );
   properties.put("mail.smtp.auth", "true");
   properties.put("mail.smtp.port", "587");


   Session session = Session.getDefaultInstance(properties,
    new javax.mail.Authenticator() {
    protected PasswordAuthentication getPasswordAuthentication() {
     return new PasswordAuthentication(user,password);
    }
   });
   
      
     Store store = session.getStore("pop3");
     store.connect(host,user,password);

     Folder folder = store.getFolder("inbox");
     folder.open(Folder.READ_WRITE);

     Message[] message = folder.getMessages();


  for (int a = 0; a < message.length; a++) {
    System.out.println("-------------" + (a + 1) + "-----------");
    System.out.println(message[a].getSentDate());

    Multipart multipart = (Multipart) message[a].getContent();
 
    for (int i = 0; i < multipart.getCount(); i++) {
     BodyPart bodyPart = multipart.getBodyPart(i);
     InputStream stream = bodyPart.getInputStream();
     BufferedReader br = new BufferedReader(new InputStreamReader(stream));

      while (br.ready()) {
       System.out.println(br.readLine());
      }
     System.out.println();
    }
   System.out.println();
  }

  folder.close(true);
  store.close();
  }
}
