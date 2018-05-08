public class LCS {
	private static String lcs(String s1, String s2) {
		int l1 = s1.length();
		int l2 = s2.length();
		
		char[] str1 = s1.toCharArray();
		char[] str2 = s2.toCharArray();
		
		int[][] lengths = new int[l1][l2];
		int greatestL = 0;
		String result = "";
		
		for(int i = 0; i < l1; i++) {
			for(int j = 0; j < l2; j++) {
				
				if(str1[i] == str2[j]) {
					if(i == 0 || j == 0) {
						lengths[i][j] = 1;
					} else {
						lengths[i][j] = lengths[i - 1][j - 1] + 1;
					}
					
					if(lengths[i][j] > greatestL) {
						greatestL = lengths[i][j];
						//System.out.println(" i = " + i + ", greatest = " + greatestL);
						result = s1.substring(i - greatestL + 1, i + 1);
					}
				} else {
					lengths[i][j] = 0;
				}
			}
		}
		
		return result;	
	}
	
	public static void main(final String[] args) throws Exception {
			System.out.println(lcs("thisisatest", "testing123testing"));
	}
}