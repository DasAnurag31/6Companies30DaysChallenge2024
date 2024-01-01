class GfG
 {
	String encode(String s)
	{
	    StringBuilder str = new StringBuilder();
	    int n = s.length();
	    int i = 0,j=0;
	    while(i < n && j < n){
	        char ch = s.charAt(i);
	        while(j<n && s.charAt(j) == ch){
	            j++;
	        }
	        str.append(ch).append(j-i);
	        i = j;
	    }
	    return str.toString();
	}
	
 }