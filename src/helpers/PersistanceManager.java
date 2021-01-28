package helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PersistanceManager<T extends Serializable> {

	private String fileName;
	private File file;

	public PersistanceManager(String fileName) {
		this.fileName = fileName;
		this.file = new File(fileName);
	}

	public String getFileName() {
		return this.fileName;
	}

	@SuppressWarnings("unchecked")
	public T read() throws IOException, ClassNotFoundException {
	    FileInputStream fos = new FileInputStream(this.file);
	    ObjectInputStream oos = new ObjectInputStream(fos);   
	    Object object = oos.readObject();
	    oos.close();
	    return (T)object;
	}

	public void write(T object) throws IOException {
	    FileOutputStream fos = new FileOutputStream(this.file);
	    ObjectOutputStream oos = new ObjectOutputStream(fos);   
	    oos.writeObject(object);
	    oos.close();
	}

}
