package application;

import java.time.LocalDate;

import javafx.scene.control.DatePicker;
import javafx.util.converter.LocalDateStringConverter;

public class Date_Record implements Comparable<Date_Record> {

	private linked_List<Martyr> martyr = new linked_List<>();
	private LocalDate  date ;
	


	public Date_Record(int  year,int mounth,int day) {
		super();
		this.date = LocalDate.of(year, mounth, day);
	}

	@Override
	public String toString() {
		return "Martyr_Date [date=" + date + "]";
	}

	public linked_List<Martyr> getMartyr() {
		return martyr;
	}

	public void setMartyr(linked_List<Martyr> martyr) {
		this.martyr = martyr;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public int compareTo(Date_Record o) {
		// TODO Auto-generated method stub
		return this.date.compareTo(o.date);
	}

	

}
