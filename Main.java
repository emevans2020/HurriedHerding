import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
	/**
	 * Read the contents of a file into a List of Strings (an ArrayList).
	 * 
	 * @param filename The filename to open and read.
	 * @return The contents of the file, each line an element of the list.
	 */

	public static List<String> readFile(String filename) {
		List<String> records = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = reader.readLine()) != null) {
				records.add(line);
			}
			reader.close();
		} catch (Exception e) {
			System.err.format("Exception occurred trying to read '%s'.", filename);
			e.printStackTrace();
		}
		return records;
	}

	/**
	 * Main method that gets a filename from STDIN, gets the contents, and prints
	 * out its first line.
	 */
	// few_cows_few_records_some_no_mwt.txt

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String filename = scanner.next();
		scanner.close();
		List<String> records = readFile(filename);

		/* <------------Code added in by myself starts here ---------------> */
		HashMap<String, Cow> cows = new HashMap<String,Cow>();

		String[] action = null;

		for (int i = 1; i < records.size(); i++) {
			action = records.get(i).split("\\s+");
			if (!cows.containsKey(action[0])){
				cows.put(action[0], new Cow(action[0]));
			} 
			Cow c = cows.get(action[0]);
			if (action[1].equals("W")) {
				if (c.ID.equals(action[0])) {
					c.setLowestWeight(Integer.parseInt(action[2]));
				}
			}
			if (action[1].equals("M")) {
				if (c.ID.equals(action[0])) {
					c.updateMilk(Integer.parseInt(action[2]));
				}
			}
			if (action[1].equals("T")) {
				continue;
			}
		}

		ArrayList<Cow> orderedCows = new ArrayList<Cow>();
		for (Cow c : cows.values()) {
			if (c.latestWeight != 0 && c.lowestWeight != 0 && c.numOfMilkings != 0 && c.allMilkings != 0) {
				orderedCows.add(c);
			}
		}
		orderedCows.sort(null);
		for (Cow c : orderedCows) {
			System.out.println(c);
		}
	}
}