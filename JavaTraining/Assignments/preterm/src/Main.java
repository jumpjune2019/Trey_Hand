import java.util.Random;


public class Main {

	
	public static void getInput() {
		ClientStore myStore = new ClientStore("clients_list.csv");
		Client[] store = myStore.getClientStore();
		System.out.println("Client List: ");
		for (int i = 0; i < store.length; i++) {
			System.out.println("Id: " + store[i].getClientId() + ", Name : " + store[i].getClientFirstName() + " " + store[i].getClientLastName());
		}
		System.out.println("Placing client list\n");
		
		Client[][] seating = new Client[10][10];
		seating = placeClients(seating, store);
		printSeating(seating);
		
	}
	
	public static Client[][] placeClients(Client[][] seating, Client[] clients) {
		int seat;
		int row;
		int seatInRow;
		
		for (int i = 0; i < clients.length; i++) {
			seat = getRandomNumberInRange(0, 99);
			row = (int) Math.floor(seat / 10);
			seatInRow = seat % 10;
			if (seating[row][seatInRow] != null) {
				i--;
				continue;
			} else {
				seating[row][seatInRow] = clients[i];
			}
			

		}
		
		return seating;
	}
	public static void printSeating(Client[][] seating) {
		String format = "%-16s";
		char row = 'A';
		System.out.printf("%-18s" , "\t\tSeat 1");
		for (int i = 1; i < 10; i++) {
			System.out.printf(format, "Seat " + (i + 1));
		}
		System.out.println();
		for (int i = 0; i < 10; i++) {
			System.out.printf(format, "Row " + row);
			row++;
			for (int j = 0; j < 10; j++) {
				if (seating[i][j] == null) {
					System.out.printf(format, "vacant");
				} else {
					System.out.printf(format, "id: " + seating[i][j].getClientId() + "/" + seating[i][j].getClientInitials());
				}
			}
			System.out.println();
		}
	}
	private static int getRandomNumberInRange(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	public static void main(String[] args) {
		getInput();
		
		
	}

}
