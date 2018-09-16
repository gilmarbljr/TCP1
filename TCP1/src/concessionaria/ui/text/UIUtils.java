package concessionaria.ui.text;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UIUtils {
	public static final String DATE_FORMAT = "dd/MM/yyyy";
	public static final UIUtils INSTANCE = new UIUtils();
	
	private final BufferedReader reader;
	private final SimpleDateFormat sdf;
	
	public UIUtils() {
		this.reader = new BufferedReader(new InputStreamReader(System.in));
		this.sdf = new SimpleDateFormat(DATE_FORMAT);
	}
	
	public String formatDate(Date value) {
		return sdf.format(value);
	}
	
	public Date readDate() {
		return readDate(false);
	}

	public Date readDate(boolean allowsEmpty) {
		Date value = null;
		while (value == null) {
			try {
				String str = reader.readLine();
				if ((str == null || str.isEmpty()) && allowsEmpty) {
					return null;
				} else {
					value = sdf.parse(str);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return value;
	}
	
	public Integer readInteger() {
		Integer value = null;
		while (value == null) {
			try {
				value = new Integer(reader.readLine());
			} catch (NumberFormatException nfe) {
				System.out.println(nfe);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return value;
	}
	
	public Double readDouble() {
		Double value = null;
		while (value == null) {
			try {
				value = new Double(reader.readLine());
			} catch (NumberFormatException nfe) {
				System.out.println(nfe);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return value;
	}
	
	public String readString() {
		String value = null;
		while (value == null) {
			try {
				value = reader.readLine();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return value;
	}
}
