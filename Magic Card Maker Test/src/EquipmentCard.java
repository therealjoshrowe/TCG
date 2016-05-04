
public class EquipmentCard extends Card{
	BuffEffect buffEffect; //may need to change this to something like Buff
	
	public EquipmentCard() {
		super();
	}
	
	public EquipmentCard(String name, String rarity, Cost cost, String ability, BuffEffect effect) { //Note ability field probably needs to be removed from Card and possibly replaced by Effect
		super(name,rarity, cost, ability);
		this.buffEffect = effect;
	}

	@Override
	public String getCardText() {
		// TODO Auto-generated method stub
		int [] buffs = buffEffect.getWhatToBuff();
		String ret = "";
		
		String [] stats = {"ATK", "DEF", "VIT", "STR", "INT", "DEX", "SPD", "CHR", "LCK"};
		
		ret += "Equipment adds:\n";
		
		for (int i = 0; i < stats.length; ++i) {
			ret += stats[i] + ":";
			
			if (buffs[i] < 10) {
				ret += "0";
			}
			
			ret += buffs[i] + "     ";
			
			if (i % 3 == 2) {
				ret += "\n";
			}
		}
		
		return ret;
	}
	
	public void equip(Card card) {
		buffEffect.activateEffect(card);
	}
}
