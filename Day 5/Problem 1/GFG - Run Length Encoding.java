class GfG
{
	String encode(String str)
	{
	    StringBuilder sb = new StringBuilder();   
        int count = 0;
        char lastChar = '\0';
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if (ch != lastChar)
            {
                if (count > 0)
                    sb.append(count);
                count = 0;
                lastChar = ch;
                sb.append(ch);
            }
            count++;
        }
        sb.append(count);
        return sb.toString();
	}
	
}