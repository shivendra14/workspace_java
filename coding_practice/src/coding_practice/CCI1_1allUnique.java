package coding_practice;

public class CCI1_1allUnique {
	public static void main (String args[])
	{
		String input="he";
		int arr[]=new int[26];
		for (int i=0;i<input.length();i++)
		{
			int c = (int)(input.charAt(i) -'a');
			arr[c]++;
		}
		
		for (int j=0;j<26;j++)
		{
			if (arr[j]>1)
			{
				System.out.println("False");
				System.exit(0);;
			}
		}
		System.out.println("True");
	}

}
