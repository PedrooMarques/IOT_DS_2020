package persistence;

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
		return new FileOutputStream(this.file);
	}

	public InputStream write() {
		return new FileinputStream(this.file);
	}

}
