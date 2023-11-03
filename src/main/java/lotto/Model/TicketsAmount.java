package lotto.Model;

import lotto.View.ExceptionMessage;
import lotto.View.InputVIew;

public class TicketsAmount {
//TODO : 1000원 이상, 1000원 단위인지 검증
    // 1. 정수변환 2. 1000원 이상 3. 1000으로 나누어 떨어짐
    private static final int TICKETS_MIN_PRICE = 1000;
    private  final int tickets;

    public TicketsAmount(int tickets) {
        validate(tickets);
        this.tickets = tickets;
    }
    public int getTickets(){
        return tickets/1000;
    }
    public int getTicketsPrice(){
        return tickets;
    }
    private void validate(int tickets){
        try {
            validateMinimum(tickets);
            validateUnit(tickets);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            InputVIew.inputTicketsAmount();
        }
    }
    private void validateMinimum(int tickets){
        if(tickets < TICKETS_MIN_PRICE ){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_AMOUNT);
        }
    }
    private void validateUnit(int tickets){
        if(tickets % TICKETS_MIN_PRICE != 0 ){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_AMOUNT);
        }
    }
}



