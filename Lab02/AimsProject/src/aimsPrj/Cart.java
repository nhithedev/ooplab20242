package aimsPrj;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered++] = disc;
			System.out.println("The disk \"" + disc.getTitle() + "\" has been added.");
		} else {
			System.out.println("Cart is almost full.");
		}
	}

	// Overloading 1
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		for (int i = 0; i < dvdList.length; i++) {
			if (qtyOrdered < MAX_NUMBERS_ORDERED) {
				itemsOrdered[qtyOrdered++] = dvdList[i];
				System.out.println("The list \"" + dvdList[i].getTitle() + "\" has been added.");
			} else {
				System.out.println("Cart is almost full.");
			}
		}
	}
	
	
	// Overloading 2
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered++] = dvd1;
			System.out.println("The disk \"" + dvd1.getTitle() + "\" has been added.");
		} else {
			System.out.println("Cart is almost full.");
		}
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered++] = dvd2;
			System.out.println("The disk \"" + dvd2.getTitle() + "\" has been added.");
		} else {
			System.out.println("Cart is almost full.");
		}
	}
	
	public void RemoveDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == 0) {
			System.out.println("Cart is empty.");
			return;
		}
		for (int i = 0; i < qtyOrdered && itemsOrdered[i] != null; i++) {
			if (itemsOrdered[i].equals(disc)) {
				for (int j = i; j < qtyOrdered - 1; j++) {
					itemsOrdered[j] = itemsOrdered[j + 1];
				}
				itemsOrdered[qtyOrdered - 1] = null;
				System.out.println("The disk \"" + disc.getTitle() + "\" has been removed from the cart.");
				qtyOrdered--;
				return;
			}
		}
		System.out.println("The disk \"" + disc.getTitle() + "\" is not in the cart.");
	}

    public void displayCart() {
        System.out.println("Cart Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc disc = itemsOrdered[i];
            System.out.println((i + 1) + ". " + disc.getTitle() + " " + disc.getCost());
        }
    }

	
	public float TotalCost() {
		if (qtyOrdered == 0) {
			return 0;
		}
		float totalCost = 0;
		for (int i = 0; i < qtyOrdered && itemsOrdered[i] != null; i++) {
			totalCost += itemsOrdered[i].getCost();
		}
		return totalCost;
	}
}

