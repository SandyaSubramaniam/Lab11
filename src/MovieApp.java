import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MovieApp {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);
		char userChoice = 'Y';
		Map<Integer, String> categories1 = new HashMap<>();
		categories1.put(1, "Animated");
		categories1.put(2, "Drama");
		categories1.put(3, "Scifi");
		categories1.put(4, "Horror");
		ArrayList<Movie> movies = new ArrayList<>();
		movies.add(new Movie("Toy Story 4", "Animated"));
		movies.add(new Movie("Shrek", "Animated"));
		movies.add(new Movie("Moana", "Animated"));
		movies.add(new Movie("Harry Potter", "Drama"));
		movies.add(new Movie("Black Swan", "Drama"));
		movies.add(new Movie("Halloween", "Horror"));
		movies.add(new Movie("Child's Play", "Horror"));
		movies.add(new Movie("A Quiet Place", "Horror"));
		movies.add(new Movie("Inception", "Scifi"));
		movies.add(new Movie("Gravity", "Scifi"));
		System.out.println("Welcome to the Movie List Application!");
		System.out.println("There are 10 movies in the list.");
		do {
			System.out.printf("%-15s %s\n", "Number", "Category");
			System.out.printf("%-10s\n", "==========================");
			for (Map.Entry<Integer, String> me : categories1.entrySet()) {
				System.out.printf("%-15s %s\n", me.getKey(), me.getValue());
			}
			System.out.println("What category are you interested in? Enter a number from the menu:");
			int categoryNumber = scnr.nextInt();
			if (!categories1.containsKey(categoryNumber)) {
				System.out.println("That is not a valid category number.  Please try again.");
				scnr.nextLine();
				continue;
			} else {
				String categoryType = categories1.get(categoryNumber);
				for (Movie movie : movies) {
					if (movie.getCategory().equalsIgnoreCase(categoryType)) {
						System.out.println(movie.getTitle());
					}
				}
			}
			System.out.println("Continue?(y/n)");
			userChoice = scnr.next().charAt(0);
		} while ((userChoice == 'Y') || (userChoice == 'y'));
		System.out.println("GoodBye!");
		scnr.close();
	}
}
