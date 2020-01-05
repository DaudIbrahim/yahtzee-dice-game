package yahtzee_engine;

import java.util.Random;

public class GameEngine {

	public static Random dice = new Random();

	public static int[] diceResults = { dice.nextInt(6) + 1, dice.nextInt(6) + 1, dice.nextInt(6) + 1,
			dice.nextInt(6) + 1, dice.nextInt(6) + 1 };

	public static void willRollAllDices() {

		for (int i = 0; i < 5; i++) {

			diceResults[i] = dice.nextInt(6) + 1;

		}

	}

	public static void willRollDiceAtSpecifiedIndex(int i) {

		diceResults[i] = dice.nextInt(6) + 1;

	}

	// Logical Check for Scoring

	public static int upperScores(int diceFace, int[] diceResults) {

		int count = 0;

		for (int i : diceResults) {

			if (i == diceFace) {

				count++;

			}

		}

		return (diceFace * count);

	}

	// Logic set for 3 & 4
	public static int ofAKind(int kindOf, int[] diceResults) {

		int x = 0;
		int count = 0;
		int number = 0;

		for (int i = 0; i <= (diceResults.length - kindOf); i++) {

			x = diceResults[i];
			count = 0;

			for (int k = i; k <= (diceResults.length - 1); k++) {

				// Increasing count if number matched
				if (x == diceResults[k]) {

					count++;

				}

				// Checking if count is 3 or 4 of a kind
				if (count == kindOf) {

					// Adding all up and exit
					for (int m : diceResults) {

						number = number + m;

					}

					return number;

				}

			} // second loop end

		} // first loop end

		return 0;

	}

	public static int straightScore(int consecutiveDieFaces, int[] diceResults) {

		// consecutiveDieFaces should either 4 or 5

		StringBuilder text = new StringBuilder();

		for (int i = 0; i < diceResults.length; i++) {

			if (diceResults[i] == 1) {

				text.append("1");

			} else if (diceResults[i] == 2) {

				text.append("2");

			} else if (diceResults[i] == 3) {

				text.append("3");

			} else if (diceResults[i] == 4) {

				text.append("4");

			} else if (diceResults[i] == 5) {

				text.append("5");

			} else if (diceResults[i] == 6) {

				text.append("6");

			}

		}

		//////////////////////////////////////////////
		// Text.Added.to.String.Builder.Next.Check
		//////////////////////////////////////////////

		if (consecutiveDieFaces == 4) {

			if (text.toString().contains("1") && text.toString().contains("2") && text.toString().contains("3")
					&& text.toString().contains("4")) {

				return 30;

			} else if (text.toString().contains("2") && text.toString().contains("3") && text.toString().contains("4")
					&& text.toString().contains("5")) {

				return 30;

			} else if (text.toString().contains("3") && text.toString().contains("4") && text.toString().contains("5")
					&& text.toString().contains("6")) {

				return 30;
			} else
				return 0;

		} // consecutiveDieFaces = 4-check closing Bracket {

		else if (consecutiveDieFaces == 5) {

			if (text.toString().contains("1") && text.toString().contains("2") && text.toString().contains("3")
					&& text.toString().contains("4") && text.toString().contains("5")) {

				return 40;

			} else if (text.toString().contains("2") && text.toString().contains("3") && text.toString().contains("4")
					&& text.toString().contains("5") && text.toString().contains("6")) {

				return 40;

			} else
				return 0;

		} // consecutiveDieFaces = 5-check closing Bracket }

		else {

			System.out.println("You are using Straight method in incorrect way");
			return 0;

		}

	}

	public static int fullHouse(int[] diceResults) {

		if (ofAKind(3, diceResults) == 0) { // means if three of a kind does not exist then return 0

			return 0;

		} else { // means three of a kind exists. Now-Check if TwoOfAKind Exists

			int searchForThreeOfAKindNumber = 0; // First Have to searchForThreeOfAKindNumber and then exclude this to
													// search for two of a kind

			for (int i = 0; i <= 2; i++) { // 0,1,2

				int x = diceResults[i];
				int count = 0;

				for (int k = i; k < diceResults.length; k++) {

					if (x == diceResults[k]) {

						count++;

					}

				} // second for loop end

				if (count == 3) {

					searchForThreeOfAKindNumber = x;
					break;

				}

			} // first for loop end

			////////////////////////////////////
			// Now the search for two of a kind will begin and will exclude
			//////////////////////////////////// searchForThreeOfAKindNumber

			for (int i = 0; i <= 3; i++) { // 0,1,2

				int x = diceResults[i];
				int count = 0;

				for (int k = i; k < diceResults.length; k++) {

					if ((x == diceResults[k]) && (x != searchForThreeOfAKindNumber)) {

						count++;

					}

				} // second for loop end

				if (count == 2) {

					return 25;

				}

			} // first for loop end

		}

		return 0;
	}

	public static int chance(int[] diceResults) {

		int sum = 0;

		for (int i = 0; i < diceResults.length; i++) {

			sum = sum + diceResults[i];

		}
		return sum;

	}

	public static int yahtzee(int[] diceResults) {

		int yahtzee = diceResults[0];
		int count = 0;

		for (int i = 0; i < diceResults.length; i++) {

			if (yahtzee == diceResults[i]) {

				count++;

			}

		}

		if (count == 5) {

			return 50;

		} else
			return 0;

	}

	// Class bracket Below

}
