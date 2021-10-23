package huawei;

import java.util.*;

public class HJ66 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        Map<String,String> command= new HashMap<String, String>();
        command.put("reset","reset what");
        command.put("reset board","board fault");
        command.put("board add","where to add");
        command.put("reboot backplane","impossible");
        command.put("backplane abort","install first");
        command.put("board delet","no board at all");

        Set<String[]> order = new HashSet<>();
        for (String s :
                command.keySet()) {
            order.add(s.split(" "));
        }
        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            String[] inputChange = input.split(" ");
            for (String s:
                 inputChange) {

            }
        }
    }


}
