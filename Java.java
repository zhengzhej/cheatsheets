// interate int 

// int to string(len, charAt), then to charArray (access with index)
String s = String.valueof(num);
int len = s.length();
char [] charArray = s.toCharArray();
char si = charArray[indexi];
charArray[indexi] = si;

max = Math.max(max, Integer.parseInt(new String(charArray))); // charArray back to string, then to integer 
