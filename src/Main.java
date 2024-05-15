import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> mazzo = new ArrayList<Integer>();
		int numeriRandom = 0, manoGiocatore, manoBanco, cartaPescata;
		String risposta, pesca;
		double valoreMano, valoreBanco;
		int sommaGiocatore;
		boolean winBanco;
		
		do {
			
			for (int i = 0; i < 40; i++) {
				mazzo.add(i + 1);
				System.out.print(mazzo.get(i) + " ");
			}

			valoreMano = 0;
			valoreBanco = 0;

			do {

				winBanco = false;
				System.out.println();
				cartaPescata = r.nextInt(mazzo.size());
				mazzo.remove(cartaPescata);
				System.out.println(mazzo.get(cartaPescata));
				System.out.println();
				manoGiocatore = mazzo.get(cartaPescata);

				if (manoGiocatore >= 1 && manoGiocatore <= 7) {
					System.out.println(manoGiocatore + " di Bastoni");
					valoreMano += manoGiocatore;
				} else if (manoGiocatore >= 11 && manoGiocatore <= 17) {
					System.out.println(manoGiocatore - 10 + " di Denari");
					valoreMano += manoGiocatore - 10;
				} else if (manoGiocatore >= 21 && manoGiocatore <= 27) {
					System.out.println(manoGiocatore - 20 + " di Spade");
					valoreMano += manoGiocatore - 20;
				} else if (manoGiocatore >= 31 && manoGiocatore <= 37) {
					System.out.println(manoGiocatore - 30 + " di Coppe");
					valoreMano += manoGiocatore - 30;
				} else {
					System.out.println("Hai pescato una figura");
					valoreMano += 0.5;
				}

				System.out.println("La tua mano è di " + valoreMano);

				if (valoreMano > 7.5) {
					System.out.println("Vince il banco");
					winBanco = true;
					break;
				}

				// Stampa mazzo
				// for (int i = 0; i < mazzo.size(); i++) {
				// System.out.print(mazzo.get(i) + " ");
				// }

				System.out.println();
				System.out.println("Ripescare?");
				pesca = sc.nextLine();
				System.out.println();
			} while (pesca.equalsIgnoreCase("s"));

			System.out.println("Hai scelto di stare con punteggio di " + valoreMano);

			if (!winBanco) {

				do {

					System.out.println("Turno del banco");
					cartaPescata = r.nextInt(mazzo.size());
					mazzo.remove(cartaPescata);
					manoBanco = mazzo.get(cartaPescata);

					if (manoBanco >= 1 && manoBanco <= 7) {
						System.out.println(manoBanco + " di Bastoni");
						valoreBanco += manoBanco;
					} else if (manoBanco >= 11 && manoBanco <= 17) {
						System.out.println(manoBanco - 10 + " di Denari");
						valoreBanco += manoBanco - 10;
					} else if (manoBanco >= 21 && manoBanco <= 27) {
						System.out.println(manoGiocatore - 20 + " di Spade");
						valoreBanco += manoBanco - 20;
					} else if (manoBanco >= 31 && manoBanco <= 37) {
						System.out.println(manoGiocatore - 30 + " di Coppe");
						valoreBanco += manoBanco - 30;
					} else {
						System.out.println("Il banco pescato una figura");
						valoreBanco += 0.5;
					}

					if (valoreBanco > 7.5) {
						System.out.println("Vince il giocatore!");
						break;
					}

					if (valoreBanco > valoreMano)
						System.out.println("Vince il banco!");
					
				} while (valoreBanco <= valoreMano);
			}

			System.out.println("Partita finita con:");
			System.out.println("Punteggio Giocatore: " + valoreMano);
			System.out.println("Punteggio Banco: " + valoreBanco);
			
			System.out.println();
			System.out.println("Vuoi rigiocare?");
			risposta = sc.nextLine();
			while (!risposta.equalsIgnoreCase("s")) {
				System.out.println("Vuoi rigiocare?");
				risposta = sc.nextLine();
			}
			
		} while (risposta.equalsIgnoreCase("s"));
		
		System.out.println("Arrivederci");
	}

}
