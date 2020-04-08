
import java.io.IOException;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class zipFilePasswordProtected {
	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) throws IOException {
		try {
			ZipFile zipFile = new ZipFile("E:\\Attachment\\15569-27022020.zip");
			if (zipFile.isEncrypted()) {
				zipFile.setPassword("HS5182");
			}
			zipFile.extractFile("15569-27022020.XSL", "E:\\Attachment\\");

		} catch (ZipException ex) {
			System.out.println("error " + ex);
		}
	}
}
