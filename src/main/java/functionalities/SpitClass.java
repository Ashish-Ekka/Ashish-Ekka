package functionalities;

public class SpitClass {

	static String removeUnwantedCharacters(String input)
	{
		String temp = input.replace("\\n", " ");
		input = temp.replace("\\","");
		return input;
	}
	
	public static void main(String args[])
	{
		String str = "22 Mar 2020\\nNew cases\\: 66\\n7-day avg\\: 40";
		System.out.println(removeUnwantedCharacters(str));
	}
}
