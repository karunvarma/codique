package main.java.com.fs;

public class FileSystemController {

	private FileSystem fs;
	
	private static final String LS = "ls";
	private static final String MKDIR = "mkdir";
	private static final String PWD = "pwd";
	private static final String CREATE = "create";
	private static final String CD = "cd";
	private static final String CAT = "cat";
	
	public FileSystemController() {
		this.fs = new FileSystem();
	}
	
	public void cdCmd(String [] args) {
		if (args.length < 2) {
			return;
		}
		this.fs.cd(args[1]);
	}
	
	public void lsCmd() {
		this.fs.ls();
	}
	
	public void createCmd(String [] args) {
		if (args.length < 2) {
			return;
		}
		this.fs.create(args[1].trim().toLowerCase());
	}
	
	public void mkdirCmd(String [] args) {
		if (args.length < 2) {
			return;
		}
		this.fs.mkdir(args[1].trim().toLowerCase());
	}
	
	private String [] parse(String input) {
		input = input.replaceAll(" +", " ");
		return input.split(" ");
	}
	
	public void pwdCmd() {
		this.fs.pwd();
	}
	
	public void execute(String cmd) {
		if (cmd == null || cmd.length() < 1) {
			return;
		}
		
		String [] args = parse(cmd);
		if (args.length < 1) {
			return;
		}
		
		switch(args[0].trim().toLowerCase()) {
		
		case PWD:
			pwdCmd();
			break;
			
		case LS:
			lsCmd();
			break;
			
		case MKDIR:
			mkdirCmd(args);
			break;
			
		case CREATE:
			createCmd(args);
			break;
			
		case CD:
			cdCmd(args);
			break;
			
			default:
				break;
		}
	}
}
