import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Main {
	public static void main(String [] args) throws Exception {
		Card c = generateCard("Archer", "common");
		Card c2 = generateCard("Knight", "common");
		Card c3 = generateCard("Goldsmith", "common");
		Card c4 = generateCard("Templar", "common");
		Card c5 = generateCard("Blacksmith", "common");
		Card c6 = generateCard("Claymore", "common");
		Card c7 = generateCard("Bow", "common");
		printCardToImageFile(c);
		printCardToImageFile(c2);
		printCardToImageFile(c3);
		printCardToImageFile(c4);
		printCardToImageFile(c5);
		printCardToImageFile(c6);
		printCardToImageFile(c7);
	}
	
	public static void printCardToImageFile(Card card) {
		//TODO: Lift Ability field into Card class so we do not have to cast every time we want to use it.
		File templateFile = new File("template.jpg");
		File artworkFile = new File(card.getName().toLowerCase() + ".jpg");
		//File backgroundFile = new File(card.getName().toLowerCase() + "_background.jpg");
		
		BufferedImage template = null;
		BufferedImage artwork = null;
		BufferedImage background = null;
		BufferedImage cost = null;
		
		try {
			template = ImageIO.read(templateFile);
			artwork = ImageIO.read(artworkFile);
			//background = ImageIO.read(backgroundFile);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		BufferedImage joinedImage = null;
		
		int width = template.getWidth();
		int height =template.getHeight();
		
		joinedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		
		Graphics2D graphics = joinedImage.createGraphics();
		graphics.setFont(new Font("helvitica", 20, 20));
		graphics.setColor(Color.BLACK);
		
		int x = 0;
		int y = 0;
		
		graphics.drawImage(template, null, x, y);
		
		x += 36;
		y += 68;
		
		//graphics.drawImage(background,  null, x, y);
		graphics.drawImage(artwork, null, x, y);
		
		x = 37;
		
		graphics.drawString(card.getName(), 37, 52);
		
		String [] lines = card.getCardText().split("\n");
		
		FontRenderContext frc = graphics.getFontRenderContext();
	
		LineMetrics m = graphics.getFont().getLineMetrics(lines[0], frc);
		
		y = 370;
		
		for (int i = 0; i < lines.length; ++i) {
			graphics.drawString(lines[i], x, y);
			y += m.getHeight();
		}
		
		graphics.setFont(new Font("helvitica", 15, 15));
		
		if (card instanceof CreatureCard) {
			graphics.drawString(((CreatureCard) card).getAbility(), x, y); //need to change ot fit with CARd and not CreatureCard
		}
		
		
		File output = new File(card.getName() + ".png");
		
		try {
			ImageIO.write(joinedImage, "png", output);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
	public static Card generateCard(String name, String rarity) throws Exception {
		Card card = null;
		String [] traits = {"ATK", "DEF", "VIT", "STR", "INT", "DEX", "SPD", "CHR", "LCK"};
		String traitToBeBuffed = "";
		
		if (name.equals("Knight") || name.equals("Archer") || name.equals("Templar")) {
			if (name.equals("Knight")) {
				//knights have a bias towards strength and defense
				String [] bias = {"DEF", "STR"};
				String [] unbias = {"ATK", "VIT", "INT", "DEX", "SPD", "CHR", "LCK"};
				
				int num = (int)Math.random() * 100;
				
				if (num < 75) {
					num = num % bias.length;
					traitToBeBuffed = bias[num];
				}
				else {
					num = num % unbias.length;
					traitToBeBuffed = bias[num];
				}
				card = new CreatureCard(name, rarity, new Cost(),"", 0, 0, 10, 2, 0, 0, 1, 1, 0);
			}
			else if (name.equals("Archer")) {
				String [] bias = {"DEX", "SPD"};
				String [] unbias = {"ATK", "DEF", "VIT", "STR", "INT", "CHR", "LCK"};
				
				int num = (int)Math.random() * 100;
				
				if (num < 75) {
					num = num % bias.length;
					traitToBeBuffed = bias[num];
				}
				else {
					num = num % unbias.length;
					traitToBeBuffed = bias[num];
				}
				
				card = new CreatureCard(name, rarity, new Cost(),"Reach: This card may attack the backline", 0, 0, 6, 0, 0, 3, 4, 0, 0);
			}
			else if (name.equals("Templar")) {
				String [] bias = {"INT", "VIT"};
				String [] unbias = {"ATK", "DEF", "STR", "SPD", "DEX", "CHR", "LCK"};
				
				int num = (int)Math.random() * 100;
				
				if (num < 75) {
					num = num % bias.length;
					traitToBeBuffed = bias[num];
				}
				else {
					num = num % unbias.length;
					traitToBeBuffed = bias[num];
				}
				
				card = new CreatureCard(name, rarity, new Cost(),"", 0, 0, 13, 0, 5, 0, 0, 0, 0);
			}
			else {
				throw new Exception();
			}
			System.out.println(name + " gets + 1: " + traitToBeBuffed);
			switch(traitToBeBuffed) {
			case "ATK":
				((CreatureCard) card).setATK(((CreatureCard) card).getATK() + 1);
				break;
			case "DEF":
				((CreatureCard) card).setDEF(((CreatureCard) card).getDEF() + 1);
				break;
			case "VIT":
				((CreatureCard) card).setVIT(((CreatureCard) card).getVIT() + 1);
				break;
			case "STR":
				((CreatureCard) card).setSTR(((CreatureCard) card).getSTR() + 1);
				break;
			case "INT":
				((CreatureCard) card).setINT(((CreatureCard) card).getINT() + 1);
				break;
			case "DEX":
				((CreatureCard) card).setDEX(((CreatureCard) card).getDEX() + 1);
				break;
			case "SPD":
				((CreatureCard) card).setSPD(((CreatureCard) card).getSPD() + 1);
				break;
			case "CHR":
				((CreatureCard) card).setCHR(((CreatureCard) card).getCHR() + 1);
				break;
			case "LCK":
				((CreatureCard) card).setLCK(((CreatureCard) card).getLCK() + 1);
				break;
			default:
				throw new Exception();
			}
		}
		else if (name.equals("Goldsmith") || name.equals("Blacksmith")) {
			if (name.equals("Goldsmith")) {
				String [] bias = {"CHR", "LCK"};
				String [] unbias = {"ATK", "DEF", "VIT", "STR", "INT", "DEX", "SPD"};
				
				int num = (int)Math.random() * 100;
				
				if (num < 75) {
					num = num % bias.length;
					traitToBeBuffed = bias[num];
				}
				else {
					num = num % unbias.length;
					traitToBeBuffed = bias[num];
				}
				
				card = new CreatureCard(name, rarity, new Cost(),"Tap: Collect one gold from freestore", 0, 0, 3, 0, 0, 0, 2, 3, 0);
			}
			else if (name.equals("Blacksmith")){
				String [] bias = {"DEX", "CHR"};
				String [] unbias = {"ATK", "DEF", "VIT", "STR", "INT", "SPD", "LCK"};
				
				int num = (int)Math.random() * 100;
				
				if (num < 75) {
					num = num % bias.length;
					traitToBeBuffed = bias[num];
				}
				else {
					num = num % unbias.length;
					traitToBeBuffed = bias[num];
				}
				
				card = new CreatureCard(name, rarity, new Cost(),"Tap: Collect one steel from freestore", 0, 0, 3, 0, 0, 0, 2, 3, 0);
			}
			System.out.println(name + " gets + 1: " + traitToBeBuffed);
			switch(traitToBeBuffed) {
			case "ATK":
				((CreatureCard) card).setATK(((CreatureCard) card).getATK() + 1);
				break;
			case "DEF":
				((CreatureCard) card).setDEF(((CreatureCard) card).getDEF() + 1);
				break;
			case "VIT":
				((CreatureCard) card).setVIT(((CreatureCard) card).getVIT() + 1);
				break;
			case "STR":
				((CreatureCard) card).setSTR(((CreatureCard) card).getSTR() + 1);
				break;
			case "INT":
				((CreatureCard) card).setINT(((CreatureCard) card).getINT() + 1);
				break;
			case "DEX":
				((CreatureCard) card).setDEX(((CreatureCard) card).getDEX() + 1);
				break;
			case "SPD":
				((CreatureCard) card).setSPD(((CreatureCard) card).getSPD() + 1);
				break;
			case "CHR":
				((CreatureCard) card).setCHR(((CreatureCard) card).getCHR() + 1);
				break;
			case "LCK":
				((CreatureCard) card).setLCK(((CreatureCard) card).getLCK() + 1);
				break;
			default:
				throw new Exception();
			} 
		}
		else if (name.equals("Claymore") || name.equals("Bow")) {
			if (name.equals("Claymore")) {
				String [] bias = {"ATK"};
				String [] unbias = {"DEF", "VIT", "STR", "INT", "DEX", "SPD", "CHR", "LCK"};
				
				int num = (int)Math.random() * 100;
				
				if (num < 75) {
					num = num % bias.length;
					traitToBeBuffed = bias[num];
				}
				else {
					num = num % unbias.length;
					traitToBeBuffed = bias[num];
				}
				
				card = new EquipmentCard("Claymore", "common",  new Cost(), "", new BuffEffect(new int [] {2, 0, 0, 0, 0, 0, 0, 0, 0}));
			}
			if (name.equals("Bow")) {
				String [] bias = {"ATK"};
				String [] unbias = {"DEF", "VIT", "STR", "INT", "DEX", "SPD", "CHR", "LCK"};
				
				int num = (int)Math.random() * 100;
				
				if (num < 75) {
					num = num % bias.length;
					traitToBeBuffed = bias[num];
				}
				else {
					num = num % unbias.length;
					traitToBeBuffed = bias[num];
				}
				
				card = new EquipmentCard("Bow", "common",  new Cost(), "", new BuffEffect(new int [] {2, 0, 0, 0, 0, 0, 0, 0, 0}));
			}
		}
		else {
			card = null;
		}
		
		return card;
	}
}
