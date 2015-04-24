package utilities;

import instruction.Instruction;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * A global logger class. Useful for debugging.
 * When debugging, make sure to have the appropriate level set. 
 * 
 * Valid Levels:
 * SEVERE (highest value)
 * WARNING
 * INFO (appears by default)
 * CONFIG (static configuration messages)
 * FINE
 * FINER 
 * FINEST (lowest value)
 * 
 * Other Valid Levels:
 * ALL (displays all levels of logging)
 * OFF (turns off the logger)
 * @author heshamsalman
 *
 */
public class GameLog {
	public static final Logger log = Logger.getLogger(Instruction.class.getName());
	
	public static void setLevel(Level level) {
		log.setLevel(level);
	}
	
	public static void ALL() {
		log.setLevel(Level.ALL);
	}
	
	public static void FINE() {
		log.setLevel(Level.FINE);
	}
	
	public static void OFF() {
		log.setLevel(Level.OFF);
	}
	
}
