
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author adliih
 */
public class DriverTest {

    public static void main(String[] args) {
        ArrayList<Integer> lexics = new ArrayList<>();
        ArrayList<String> str = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int n = 30;
        for (int i = 0; i < n; i++) {
            String input;
            input = sc.nextLine();
            Tahap1.Proses(input, str, lexics);
            boolean result = Tahap2.checkLexic(lexics);
            System.out.println(str + "\t" + lexics + "\t" + result);
            lexics.clear();
            str.clear();
        }
    }
}
