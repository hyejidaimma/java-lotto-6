package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
//TODO : 각 메서드에 대한 예외 처리 및 재입력 구현
public class InputVIew {
    private static final String INPUT_TICKETS_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    //TODO : 무한루프 방지
    public static int inputTicketsAmount(){
        System.out.println(INPUT_TICKETS_AMOUNT);
        try {
            return validateNum(Console.readLine());
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputTicketsAmount();
        }
    }
    public static List<Integer> inputWinningNumbers(){
        System.out.println(INPUT_WINNING_NUMBERS);
        try {
            return toWinningNumbers(Console.readLine());
        } catch (IllegalArgumentException e){
            return inputWinningNumbers();
        }

    }
    public static int inputBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
        try {
            return validateNum(Console.readLine());
        } catch (IllegalArgumentException e){
            return inputBonusNumber();
        }
    }
    private static List<Integer> toWinningNumbers(String input){
        String[] strWinningNums = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for(String s : strWinningNums){
            winningNumbers.add(Integer.parseInt(s.trim()));
        }
        return winningNumbers;
    }

    private static int validateNum(String input){
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_INPUT_NUMBER);
        }
    }

}
