package persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class PersistanceManager {

	private String fileName;
	private File file;

	public PersistanceManager(String fileName) {
		this.fileName = fileName;
		this.file = new File(fileName);
	}

	public String getFileName() {
		return this.fileName;
	}

	public OutputStream read() {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(this.file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fos;
	}

	public InputStream write() {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(this.file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fis;
	}

}
