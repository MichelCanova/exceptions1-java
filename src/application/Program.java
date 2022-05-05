package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Entre com o Número do quarto:");
		int numQuart = sc.nextInt();
		System.out.println("Informe Check-in date (dd/MM/yyyy):");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Informe Check-Out date (dd/MM/yyyy):");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("### Erro na reserva: A data de check-out deve ser posterior à data de check-in");
		} else {
			Reservation reservation = new Reservation(numQuart, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Insira os dados para atualizar a reserva:");
			System.out.println("Informe Check-in date (dd/MM/yyyy):");
			checkIn = sdf.parse(sc.next());
			System.out.println("Informe Check-Out date (dd/MM/yyyy):");
			checkOut = sdf.parse(sc.next());
<<<<<<< HEAD

			String erro = reservation.updateDates(checkIn, checkOut);

			if (erro != null) {
				System.out.println("ERRO IN Reservation: " +erro);

=======
			reservation.updateDates(checkIn, checkOut);
			Date agora = new Date();
			if (checkIn.before(agora) || checkOut.before(agora)) {
				System.out.println("#### Erro na reserva: as datas de reserva para atualização devem ser datas futuras.");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("#### Erro na reserva: A data de check-out deve ser posterior à data de check-in");
>>>>>>> b2b24ad71d0a9c1171f7a67d56d43a4ccb856778
			} else {
				System.out.println("Reservation: " +reservation);
			}
		}
		sc.close();
	}

}
