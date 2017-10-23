package xformation_Food;

public class ItemFromMenu {

	String name;
	float price;

	public ItemFromMenu() {
		name = "meal";
		price = 0.0f;
	}

	public ItemFromMenu(String name, float price) {
		this.name = name;
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}

	public boolean equals(ItemFromMenu x) {
		if (name.equals(x.getName()))
			return true;
		else
			return false;
	}

	public String toString() {
		return name + " -- " + price + " $";
	}

}