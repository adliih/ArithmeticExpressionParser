
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andri-Dhika
 */
public class MainTahap1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> str = new ArrayList<>();
        List<Integer> lexic = new ArrayList<>();

        int len = 30;
        for (int i = 0; i < len; i++) {
            String n = sc.next();
            Tahap1.Proses(n, str, lexic);
            System.out.println(str + " " + lexic + " " + Tahap2.checkLexic(lexic));
        }

    }
}
