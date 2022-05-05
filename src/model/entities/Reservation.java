package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	private static SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
	
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	
	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff=checkOut.getTime()-checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);//converte a diferençã entre as datas que estao em milesegundos em dias
	}
	
	public String updateDates(Date checkIn, Date checkOut) {
		Date agora = new Date();
		System.out.println("-----"+agora);
		if (checkIn.before(agora) || checkOut.before(agora)) {
			return "Erro na reserva: as datas de reserva para atualização devem ser datas futuras.";
		}if (!checkOut.after(checkIn)) {
			return "Erro na reserva: A data de check-out deve ser posterior à data de check-in";
		}
		this.checkIn=checkIn;
		this.checkOut=checkOut;
		return null;
	}
	
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", checkIn: "
				+ sdf.format(checkIn)
				+ ", checkOut: "
				+  sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " nights";
	}
	
}
