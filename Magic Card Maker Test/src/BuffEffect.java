
public class BuffEffect extends Effect{
	private int [] whatToBuff;
	
	public BuffEffect() {
		whatToBuff = new int[9];
	}
	public BuffEffect(int [] stats) { //possible creeping bug here. We should make it where the argument has to be an array of length 9;
		whatToBuff = stats.clone();
	}
	
	
	@Override
	public void activateEffect(Card card) {
		activateBuffEffect((CreatureCard)card); //<-- this is bad. I need to find a better way to do effects...
	}
	
	private void activateBuffEffect(CreatureCard card) {
		card.setATK(card.getATK() + whatToBuff[0]);
		card.setDEF(card.getDEF() + whatToBuff[1]);
		card.setVIT(card.getVIT() + whatToBuff[2]);
		card.setSTR(card.getSTR() + whatToBuff[3]);
		card.setINT(card.getINT() + whatToBuff[4]);
		card.setDEX(card.getDEX() + whatToBuff[5]);
		card.setSPD(card.getSPD() + whatToBuff[6]);
		card.setCHR(card.getCHR() + whatToBuff[7]);
		card.setLCK(card.getLCK() + whatToBuff[8]);
	}
	
	public int [] getWhatToBuff() {
		return whatToBuff.clone();
	}
}
