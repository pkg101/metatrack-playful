package dataContainer;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RestResourceURL {
	static final String baseurl = "/services/data/v42.0/";
	public static String getSobjectDescribeURL(String objectname)
	{
		return baseurl+"sobjects/" + objectname + "/describe";
	}
	public static String getToolingQueryURL(String query)
	{
		return baseurl+"tooling/query/?q="+query;
	}
	public static String getSobjectURL()
	{
		return baseurl+"sobjects";
	}
	public static String getApexTriggerURL(String id)
	{
		return baseurl+"tooling/sobjects/ApexTrigger/"+id;
	}
	
	public static String getRestQueryURL(String query)
	{
		return baseurl+"query/?q="+query;
	}
	
	public static String NumSuffix(final Object number) {
		int n = Integer.parseInt(number.toString());
		if (n >= 11 && n <= 13) {
			return "th";
		}
		switch (n % 10) {
		case 1:
			return "st";
		case 2:
			return "nd";
		case 3:
			return "rd";
		default:
			return "th";
		}
	}
	public static String getSuffixDate(String date1) {
		String date = date1.split("T")[0]+" "+(date1.split("T")[1]).split("\\.")[0];
		Date today;
		StringBuffer sb = new StringBuffer();
		try {
			today = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);		
			Format formatter = new SimpleDateFormat("EEE dd MMM yyyy, HH:mm a");
			String m_date[] = formatter.format(today).split(" ");
			m_date[1] = m_date[1] + NumSuffix(m_date[1]);
			for (int i = 0; i < m_date.length; i++)
				sb.append(m_date[i]+" ");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sb.toString();

	}
}
