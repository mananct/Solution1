
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CheckAndReadFile {

	public static void main(String[] argss) {
		String args = null;
		args = "file1.txt";      /*Available file*/
		checkAndReadFile(args);
		
	}

	private static void checkAndReadFile(String args) {
		String filePath = null;
		try {
			if (args!= null && args.trim().length() > 1) {
				filePath = args;
				Path path = doesFileExists(filePath);
				// read whole file now -
				Files.lines(path).forEach(line -> parseLineAndPring(line));

			} else {
				System.err.println("Please pass first arg as file path");
				System.exit(1);
			}
		} catch (Exception e) {
			System.out.println("Exception occurred!!" + e.getCause() + " : " + e.getMessage());
		}
	}

	private static void parseLineAndPring(String wholeLine) {

		String[] parts = wholeLine.split("-");
		System.out.println("WORD :: " + parts[0]);
		for (String meanings : parts[1].split(",")) {
			System.out.print("Meaning :: ");
			System.out.println(meanings);
		}
		System.out.println("-----------------------------------------------------------");
	}

	private static Path doesFileExists(String filePath) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Path path = Paths.get(filePath);

		if (Files.exists(path)) {
			return path;
		} else {
			throw new FileNotFoundException("File not found at path " + filePath);
		}

	}

}
