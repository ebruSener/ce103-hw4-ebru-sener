
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

public class FileUtility {
	public static boolean deleteFile(String path) {
		File file = new File(path);
		if (file.exists()) {
			return file.delete();
		}
		return true;
	}

	public static byte[] readBlock(int count, int blocksize, String path) throws IOException {

		byte[] buffer = new byte[blocksize];
		try (FileInputStream fileStream = new FileInputStream(path)) {
			fileStream.skip((count - 1) * blocksize);
			fileStream.read(buffer, 0, buffer.length);
		}
		return buffer;
	}

	public static boolean appendBlock(int count, int blocksize, String path, byte[] data) {
		try {
			RandomAccessFile file = new RandomAccessFile(path, "rw");
			file.seek((count - 1) * blocksize);
			file.write(data);
			file.close();
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public static boolean updateBlock(byte[] data, int count, int blocksize, String path) throws IOException {
		try (RandomAccessFile fileStream = new RandomAccessFile(path, "rw")) {
			fileStream.seek((count - 1) * blocksize);
			fileStream.write(data);
			fileStream.close();

			return true;
		}

		catch (Exception e) {

			return false;
		}
	}

	public static boolean deleteBlock(int count, int blocksize, String path) throws IOException {
		byte[] data = new byte[blocksize];
		try (RandomAccessFile fileStream = new RandomAccessFile(path, "rw")) {
			fileStream.seek((count - 1) * blocksize);
			fileStream.write(data);
		}
		return true;
	}

	public static byte[] readAllBytes(String filePath) throws IOException {
		try (InputStream in = new FileInputStream(filePath)) {
			return in.readAllBytes();
		}
	}

}
