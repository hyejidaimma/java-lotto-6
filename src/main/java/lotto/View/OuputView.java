package lotto.View;

public class OuputView {
    public static final String printTickets = "%d개를 구매했습니다.";

    public static void printNumOfTicket(int num) {
        System.out.printf((printTickets) + "%n", num);
    }
}
