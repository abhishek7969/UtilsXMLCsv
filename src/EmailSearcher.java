import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.AndTerm;
import javax.mail.search.FlagTerm;
import javax.mail.search.SearchTerm;
 
/**
 * This program demonstrates how to search for e-mail messages which satisfy
 * a search criterion.
 * @author www.codejava.net
 *
 */
public class EmailSearcher {
 
    /**
     * Searches for e-mail messages containing the specified keyword in
     * Subject field.
     * @param host
     * @param port
     * @param userName
     * @param password
     * @param keyword
     */
    public void searchEmail(String host, String port, String userName,String password, final String keyword) {
        Properties properties = new Properties();
 
        // server setting
        properties.put("mail.imap.host", host);
        properties.put("mail.imap.port", port);
 
        // SSL setting
        properties.setProperty("mail.imap.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.imap.socketFactory.fallback", "false");
        properties.setProperty("mail.imap.socketFactory.port",String.valueOf(port));
 
        Session session = Session.getDefaultInstance(properties);
 
        try {
            // connects to the message store
            Store store = session.getStore("imap");
            store.connect(userName, password);
 
            // opens the inbox folder
            Folder folderInbox = store.getFolder("INBOX");
            folderInbox.open(Folder.READ_ONLY);
 
            Flags seen = new Flags(Flags.Flag.SEEN);
            FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
            
            Flags recent = new Flags(Flags.Flag.RECENT);
            FlagTerm recentFlagTerm = new FlagTerm(recent, true);
            
            SearchTerm searchTerm = new AndTerm(unseenFlagTerm, recentFlagTerm);


            // creates a search criterion
            SearchTerm searchCondition = new SearchTerm() {
                @Override
                public boolean match(Message message) {
                    try {
                        if (message.getSubject().contains(keyword)) {
                            return true;
                        }
                    } catch (MessagingException ex) {
                        ex.printStackTrace();
                    }
                    return false;
                }
            };
 
            // performs search through the folder
            Message[] foundMessages = folderInbox.search(searchTerm);
 
            for (int i = 0; i < foundMessages.length; i++) {
                Message message = foundMessages[i];
                String subject = message.getSubject();
                System.out.println("Found message #" + i + ": " + subject);
            }
 
            // disconnect
            folderInbox.close(false);
            store.close();
        } catch (NoSuchProviderException ex) {
            System.out.println("No provider.");
            ex.printStackTrace();
        } catch (MessagingException ex) {
            System.out.println("Could not connect to the message store.");
            ex.printStackTrace();
        }
    }
 
    /**
     * Test this program with a Gmail's account
     */
    public static void main(String[] args) {
        String host = "imap.gmail.com";
        String port = "993";
        String userName = "abhishek.kumar1@innoviti.com";
        String password = "Temp@123";
        EmailSearcher searcher = new EmailSearcher();
        String keyword = "FW: 'Corporate Email MPR as of 27-Feb-2020";
        searcher.searchEmail(host, port, userName, password, keyword);
    }
 
}