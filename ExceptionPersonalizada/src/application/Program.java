package application;

import model.entities.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Número do quarto: ");
        int numeroQuarto = sc.nextInt();
        System.out.println("Data de check-in (DD/MM/YYYY): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.println("Data de check-out (DD/MM/YYYY): ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Erro na reserava: Check-out deve ser depois de Check-in!");
        }
        else {
            Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Inserir datas para atualizar reseva: ");
            System.out.println("Data de check-in (DD/MM/YYYY): ");
            checkIn = sdf.parse(sc.next());
            System.out.println("Data de check-out (DD/MM/YYYY): ");
            checkOut = sdf.parse(sc.next());

            Date agora = new Date();
            if (checkIn.before(agora) || checkOut.before(agora)) {
                System.out.println("Erro na reserava: Datas atualizadas devem ser futuras!");

            }
            else if (!checkOut.after(checkIn)) {
                System.out.println("Erro na reserava: Check-out atualizado deve ser depois de Check-in atualizado!");
            }
            else {
                reserva.atualizarDatas(checkIn, checkOut);
                System.out.println("Reserva: " + reserva);
            }


        }






    }

}