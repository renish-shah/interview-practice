import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.WordUtils;

/**
 * 
 */

/**
 * @author s0176953
 *
 */
public class TestWordUtils {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String sample="test kenoby";
		System.out.println("capitalizeFully: "+WordUtils.capitalizeFully(sample));
		System.out.println("capitalize: "+WordUtils.capitalize(sample));
		sample="TEST KENOBY";
		System.out.println("==============\ncapitalizeFully: "+WordUtils.capitalizeFully(sample));
		System.out.println("capitalize: "+WordUtils.capitalize(sample));
		sample="TeSt kEnOBy";
		System.out.println("==============\ncapitalizeFully: "+WordUtils.capitalizeFully(sample));
		System.out.println("capitalize: "+WordUtils.capitalize(sample));
		
		sample="STANFORD EXPRESS CARE, HOOVER";
		System.out.println("==============\ncapitalizeFully: "+WordUtils.capitalizeFully(sample));
		System.out.println("capitalize: "+WordUtils.capitalize(sample));
		
		sample="stanford express care, hoover";
		
		System.out.println("==============\ncapitalizeFully: "+WordUtils.capitalizeFully(sample));
		System.out.println("Upper Case: "+StringUtils.upperCase(sample));
		System.out.println("capitalize: "+WordUtils.capitalize(sample));
		
		

		
	}
}
