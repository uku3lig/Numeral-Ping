package me.mcblueparrot.numeralping.util;

import java.awt.Color;

import me.mcblueparrot.numeralping.config.NumeralConfig;

public final class Utils {

	public static String unicodeShift(String string, int by) {
		char[] characters = string.toCharArray();

		for(int i = 0; i < characters.length; i++) {
			characters[i] += by;
		}

		return String.valueOf(characters);
	}

	public static int getPingGrade(int latency) {
		int level;

		if(latency < 0) {
			level = 5;
		}
		else if(latency < 150) {
			level = 0;
		}
		else if(latency < 300) {
			level = 1;
		}
		else if(latency < 600) {
			level = 2;
		}
		else if(latency < 1000) {
			level = 3;
		}
		else {
			level = 4;
		}

		NumeralConfig config = NumeralConfig.instance();

		// What is this crazy syntax?
		// Thanks IntelliJ
		Color colour = switch(level) {
			case 1 -> config.levelOnePingColour;
			case 2 -> config.levelTwoPingColour;
			case 3 -> config.levelThreePingColour;
			case 4 -> config.levelFourPingColour;
			case 5 -> config.levelFivePingColour;
			default -> config.defaultPingColour;
		};

		return colour.getRGB();
	}
}
