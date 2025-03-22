package aimsPrj;

public class Aims {

	public static void main(String[] args) {
		Cart anOrder = new Cart();

		DigitalVideoDisc dvd_1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd_1);

		DigitalVideoDisc dvd_2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd_2);

		DigitalVideoDisc dvd_3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd_3);

		anOrder.displayCart();
		
		System.out.print("Total Cost: ");
		System.out.println(anOrder.TotalCost());

		System.out.println("Removing disks...");
		anOrder.RemoveDigitalVideoDisc(dvd_1);
		anOrder.RemoveDigitalVideoDisc(dvd_2);
		anOrder.RemoveDigitalVideoDisc(dvd_3);
	}

}
