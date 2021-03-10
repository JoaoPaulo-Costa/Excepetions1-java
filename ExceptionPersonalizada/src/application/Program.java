package application;

import model.entities.Reserva;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.println("Número do quarto: ");
            int numeroQuarto = sc.nextInt();
            System.out.println("Data de check-in (DD/MM/YYYY): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.println("Data de check-out (DD/MM/YYYY): ");
            Date checkOut = sdf.parse(sc.next());

            Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Inserir datas para atualizar reseva: ");
            System.out.println("Data de check-in (DD/MM/YYYY): ");
            checkIn = sdf.parse(sc.next());
            System.out.println("Data de check-out (DD/MM/YYYY): ");
            checkOut = sdf.parse(sc.next());

            reserva.atualizarDatas(checkIn, checkOut);
            System.out.println("Reserva: " + reserva);

        }
        catch (ParseException e) {
            System.out.println("Data inválida.");
        }
        catch (DomainException e) {
            System.out.println("Erro na reserva: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Erro inesperado!");
        }
        
        sc.close();
    }

}
