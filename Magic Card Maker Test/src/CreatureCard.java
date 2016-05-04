 
public class CreatureCard extends Card{
	private int ATK;
	private int DEF;
	private int VIT;
	private int STR;
	private int INT;
	private int DEX;
	private int SPD;
	private int CHR;
	private int LCK;
	private EquipmentCard head = null;
	private EquipmentCard hands = null;
	private EquipmentCard torso = null;
	private EquipmentCard legs = null;
	private EquipmentCard boots = null;
	private EquipmentCard leftRing = null;
	private EquipmentCard rightRing = null;
	private EquipmentCard necklace = null;
	
	public CreatureCard() {
		this(0, 0, 0, 0, 0, 0, 0, 0, 0);
	}
	
	public CreatureCard(
			            int ATK, int DEF, int VIT,
			            int STR, int INT, int DEX,
			            int SPD, int CHR, int LCK
			           )
	{
		this("", "common", new Cost(), "", ATK, DEF, VIT, STR, INT, DEX, SPD, CHR, LCK);
	}
	
	public CreatureCard(
			String name, String rarity, Cost cost, String ability,
            int ATK, int DEF, int VIT,
            int STR, int INT, int DEX,
            int SPD, int CHR, int LCK
           )
{
super(name, rarity, cost, ability);
this.setATK(ATK);
this.setDEF(DEF);
this.setVIT(VIT);
this.setSTR(STR);
this.setINT(INT);
this.setDEX(DEX);
this.setSPD(SPD);
this.setCHR(CHR);
this.setLCK(LCK);
}

	public int getATK() {
		return ATK;
	}

	public void setATK(int aTK) {
		ATK = aTK;
	}

	public int getDEF() {
		return DEF;
	}

	public void setDEF(int dEF) {
		DEF = dEF;
	}

	public int getVIT() {
		return VIT;
	}

	public void setVIT(int vIT) {
		VIT = vIT;
	}

	public int getSTR() {
		return STR;
	}

	public void setSTR(int sTR) {
		STR = sTR;
	}

	public int getINT() {
		return INT;
	}

	public void setINT(int iNT) {
		INT = iNT;
	}

	public int getDEX() {
		return DEX;
	}

	public void setDEX(int dEX) {
		DEX = dEX;
	}

	public int getSPD() {
		return SPD;
	}

	public void setSPD(int sPD) {
		SPD = sPD;
	}

	public int getCHR() {
		return CHR;
	}

	public void setCHR(int cHR) {
		CHR = cHR;
	}

	public int getLCK() {
		return LCK;
	}

	public void setLCK(int lCK) {
		LCK = lCK;
	}

	public EquipmentCard getHead() {
		return head;
	}

	public void setHead(EquipmentCard head) {
		this.head = head;
	}

	public EquipmentCard getHands() {
		return hands;
	}

	public void setHands(EquipmentCard hands) {
		this.hands = hands;
	}

	public EquipmentCard getTorso() {
		return torso;
	}

	public void setTorso(EquipmentCard torso) {
		this.torso = torso;
	}

	public EquipmentCard getLegs() {
		return legs;
	}

	public void setLegs(EquipmentCard legs) {
		this.legs = legs;
	}

	public EquipmentCard getBoots() {
		return boots;
	}

	public void setBoots(EquipmentCard boots) {
		this.boots = boots;
	}

	public EquipmentCard getLeftRing() {
		return leftRing;
	}

	public void setLeftRing(EquipmentCard leftRing) {
		this.leftRing = leftRing;
	}

	public EquipmentCard getRightRing() {
		return rightRing;
	}

	public void setRightRing(EquipmentCard rightRing) {
		this.rightRing = rightRing;
	}

	public EquipmentCard getNecklace() {
		return necklace;
	}

	public void setNecklace(EquipmentCard necklace) {
		this.necklace = necklace;
	}

	
	@Override
	public String getCardText() {
		
		return "ATK:" + this.getATK() + "     " + "DEF:" + this.getDEF() + "     " + "VIT:" + this.getVIT() + "\n" +
		       "STR:" + this.getSTR() + "     " + "INT:" + this.getINT() + "     " + "DEX:" + this.getDEX() + "\n" +
		       "SPD:" + this.getSPD() + "     " + "CHR:" + this.getCHR() + "     " + "LCK:" + this.getLCK() + "\n";
		
	}
}
