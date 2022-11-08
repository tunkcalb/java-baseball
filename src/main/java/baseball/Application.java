package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        boolean game = true;
        start();

        while(game) {
            List<Integer> computer = make_number();
            int strike = 0;

            while(strike != 3){
            List<Integer> player = input_number();
            wrong_number(player);

            strike = check_strike(computer,player);
            int same = same(computer, player);
            }
        }
    }
    public static void start(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public static List<Integer> make_number(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3){
            int random_number = Randoms.pickNumberInRange(1,9);
            if (!computer.contains(random_number)){
                computer.add(random_number);
            }
        }
        return computer;
    }
    public static List<Integer> input_number(){
        System.out.println("숫자를 입력해주세요 : ");
        String player_number_string = Console.readLine();
        List<Integer> player_number = new ArrayList<>();
        for(String number : player_number_string.split("")){
            player_number.add(Integer.parseInt(number));
        }
        return player_number;
    }
    public static void wrong_number(List<Integer> player_number){
        if (player_number.size() != 3) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다. 종료합니다.");
        }
    }
    public static int check_strike(List<Integer> computer_number, List<Integer> player_number){
        int strike = 0;
        for(int i = 0; i < player_number.size(); i++){
            if(computer_number.get(i) == player_number.get(i)){
                strike += 1;
            }
        }
        return strike;
    }
    public static int same(List<Integer> computer_number, List<Integer> player_number){
        int result = 0;
        for (int i = 0; i <player_number.size(); i++){
            if(computer_number.contains(player_number.get(i)))
                result += 1;
        }
        return result;
    }
    public static int check_ball(){

    }
    public static void check_message(){

    }
    public static void end_message(){

    }
    public static int end_game(){

    }
}
