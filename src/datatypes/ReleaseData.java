package datatypes;
import java.sql.Timestamp;
public class ReleaseData {
	

		Timestamp year;
		Timestamp month ;
		Timestamp day;
public  ReleaseData(Timestamp year,Timestamp month,Timestamp day) {
	super();
	this.year=year;
	this.month=month;
	this.day=day;
}
public Timestamp getYear() {
	return year;
}
public void setYear(Timestamp year) {
	this.year = year;
}
public Timestamp getMonth() {
	return month;
}
public void setMonth(Timestamp month) {
	this.month = month;
}
public Timestamp getDay() {
	return day;
}
public void setDay(Timestamp day) {
	this.day = day;
}

}


