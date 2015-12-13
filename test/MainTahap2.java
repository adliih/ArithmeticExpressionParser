
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
/**
 *
 * @author adliih
 */
public class MainTahap2 {

    public static void main(String[] args) {
        ArrayList<Integer> lexics = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int n = 1;
        for (int i = 0; i < n; i++) {
            String input;
            input = sc.nextLine();
//            input = "44437358356443635835593";
            char[] inputToChar = input.toCharArray();
            System.out.print("Lexic: ");
            for (int j = 0; j < inputToChar.length; j++) {
                char c = inputToChar[j];
                if (c == '0') {
                    lexics.add(-1);
                } else {
                    lexics.add(Integer.parseInt(c + ""));
                }
                System.out.print(c);
            }
            boolean result = Tahap2.checkLexic(lexics);
            System.out.println(" # Result " + result);
            lexics.clear();
        }
//        int[] i = new int[5];
//        i['6'] = 7;

//        System.out.println('1' - 48 == 1);
    }
}
