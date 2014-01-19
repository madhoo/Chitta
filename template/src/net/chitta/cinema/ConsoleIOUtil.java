/**
 * 
 */
package net.chitta.cinema;

import java.util.Scanner;

/**
 * @author Madhoo
 * 
 */

public class ConsoleIOUtil {

	private ConsoleIOUtil() {

	}

	static void getMovieInputs() {

	}

	static void getScreenInput() {
		Scanner sc = new Scanner(System.in);
		
		int kbd = 0;
		boolean keepContinue = true;

		System.out.println("\ta - Screen Number:");

		while (keepContinue) {
			try {
				Scanner ss = new Scanner(sc.nextLine());
				if (!ss.hasNext()) {
					System.out.printf("blank line");
					continue;
				}
				if (ss.hasNext("[123456]")) {
					kbd = ss.nextInt();
					keepContinue = false;
					ss.close();
					System.out.printf("1-6   " + kbd);
					continue;
				} else {
					System.out.printf("only numbers 1-6 are allowed ");
					continue;
				}
			} catch (Exception e) {
				System.out.printf("There is an error");
//				sc.nextLine();
			}
		}
		System.out.println("Screen Number:  " + kbd);
	}
}
