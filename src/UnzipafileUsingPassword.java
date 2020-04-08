import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class UnzipafileUsingPassword {

	/**
	 * @Author=AJAY
	 * @param args
	 */
	public static void main(String[] args) {

		String source = "E:\\Attachment\\15569-27022020.zip";
		String destination = "E:\\Attachment\\";
		String password = "HS5182";
		System.out.println("AJAY");

		try {
			ZipFile zipFile = new ZipFile(source);
			if (zipFile.isEncrypted()) {
				zipFile.setPassword(password);
			}
			zipFile.extractAll(destination);
		} catch (ZipException e) {
			e.printStackTrace();
		}

	}

}