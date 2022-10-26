
public class Date212 {
	private int year, month, day, fullname;
	/**
	 * 
	 * @param name The date, Passes a date which is given properties of Date212
	 * @param x The date being compared to, Pass a date which is then compared to the the current date
	 */
	
	public Date212(String name) {
			fullname = Integer.parseInt(name);
			if(fullname > 99999999 || fullname < 10000000) {
				System.out.println(name + " : The Date is invalid" );
				throw new IllegalDate212Exception(name + " : The Date is invalid");
			}
			

			year = Integer.parseInt(name.substring(0, 4));
			
			
			
			month = Integer.parseInt(name.substring(4, 6));
			if(month < 1 || month > 12) {
				throw new IllegalDate212Exception( name + " Has Invalid Month");
	
			}
			
			day = Integer.parseInt(name.substring(6, 8));
			if(day < 1 || day > 31) {
				throw new IllegalDate212Exception(name + " Has Invlaid Day");
			}

	}
	
	public int getYear() {
		return year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getDay() {
		return day;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public boolean equals(Date212 x) {
		if(this.month == x.month && this.day == x.day && this.year == x.year){
			return true;
		}
		else {
			return false;
		}
	}
	
	public int compareTo(Date212 x) {
		if(this.year < x.year) {
			return -1;
		}
		else if(this.year > x.year) {
			return 1;
		}
		else {
			if(this.month < x.month) {
				return -1;
			}
			else if(this.month > x.month) {
				return 1;
			}
			else {
				if(this.day < x.day) {
					return -1;
				}
				else if(this.day > x.day) {
					return 1;
				}
				else {
					return 0;
				}
			}
		}
	}
	
	public String toString() {
		String mName;
		switch(month){
			case 12: 
				mName = "Dec ";
				break;
			case 11: 
				mName = "Nov ";
				break;
			case 10:
				mName = "Oct ";
				break;
			case 9:
				mName = "Sept ";
				break;
			case 8:
				mName = "Aug ";
				break;
			case 7:
				mName = "Jul ";
				break;
			case 6:
				mName = "Jun ";
				break;
			case 5:
				mName = "May ";
				break;
			case 4:
				mName = "Apr ";
				break;
			case 3:
				mName = "Mar ";
				break;
			case 2:
				mName = "Feb ";
				break;
			default:
				mName = "Jan ";
				break; 
		
		}
		int q = day;
		int m = month;
		int tyear = year;
		if(m == 1 || m == 2) {
			m += 12;
			tyear--;
		}
		int k = tyear % 100;
		int j = tyear / 100;
		int h = q + (13*(m+1) / 5) + k + (k / 4) + (j / 4) + (5 * j);
		h = h % 7;
		
		String dayOfweek = null;
		switch(h) {
		case 6:
			dayOfweek = "Sunday";
			break;
		case 5:
			dayOfweek = "Saturday";
			break;
		case 4:
			dayOfweek = "Friday";
			break;
		case 3:
			dayOfweek = "Thursday";
			break;
		case 2:
			dayOfweek = "Wednesday";
			break;
		case 1:
			dayOfweek = "Tuesday";
			break;
		default:
			dayOfweek = "Monday";
			break;
		}
		
		return dayOfweek + " " + mName + day + ", " + year;
	}
	
	public String staySame() {						//method will return the the data as raw
		return year + "/" + month + "/" + day;
	}
	
}
