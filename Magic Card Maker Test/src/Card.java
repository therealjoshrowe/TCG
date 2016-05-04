
public abstract class Card {
	private String name = "default";
	private String rarity;
	private Cost cost;
	private String ability;
	
	protected Card() {
		this("", "common", new Cost(), "");
	}
	
	protected Card(String name, String rarity, Cost cost, String ability) {
		this.name = name;
		this.setRarity(rarity);
		this.cost = cost;
		this.ability = ability;
	}
	public abstract String getCardText();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbility() {
		return ability;
	}

	public void setAbility(String ability) {
		this.ability = ability;
	}

	public String getRarity() {
		return rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}
}
