
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
/**
 *
 *
 * Token Lexic 
  1 : Variabel 
  2 : Real 
  3 : Integer 
  4 : ( 
  5 : ) 
  6 : + 
  7 : - 
  8 : * 
  9 : /
 *
 * Variabel, Real, Inteer dapat dianggap satu = A ( = B ) = C +, -, *, / = D ~ =
 * finish
 *
 * -- PDA -- 
 * S = 1AS | 2AS | 3AS | 4S5 | ~ 
 * A = 6 | 7 | 8 | 9 | ~
 *
 * @author adliih
 */
public class Tahap2 {

    static String[][] tableModel;

    public static boolean checkLexic(List<Integer> lexics) {
        Stack pdaStack = new Stack();
        pdaStack.push("#");
        pdaStack.push("S");

        Iterator<Integer> it = lexics.iterator();
        Integer symbol = it.next();
        while (pdaStack.top() != '#') {
            if (symbol == -1) {
                return false;
            }
            if (pdaStack.isTerminal(pdaStack.top())) {
                if (pdaStack.top() - 48 == symbol) {
                    pdaStack.pop();
                    if (it.hasNext()) {
                        symbol = it.next();
                    } else if (symbol == '5') {
                        pdaStack.pop();
                    } else {
                        symbol = 0;
                    }
                } else {
                    return false;
                }
            } else {
                int idx = -1;
                if (pdaStack.top() == 'S') {
                    idx = 0;
                } else {
                    idx = 1;
                }
                String temp = tableModel[idx][symbol];
                if (temp.equals("err")) {
                    return false;
                } else if (temp.equals("success")) {
                    return true;
                } else if (temp.equals("blank")) {
                    pdaStack.pop();
                } else {
                    pdaStack.pop();
                    pdaStack.push(temp);
                }
            }
        }
        return true;
    }

    public static void createTableModel() {
        tableModel = new String[2][];
        for (int i = 0; i < 2; i++) {
            tableModel[i] = new String[10];
            // Index ke 0 adalah End Of String
        }
        tableModel[0][1] = "1AS";
        tableModel[0][2] = "2AS";
        tableModel[0][3] = "3AS";
        tableModel[0][4] = "4S5AS";
        tableModel[0][5] = "blank";
        tableModel[0][6] = "err";
        tableModel[0][7] = "err";
        tableModel[0][8] = "err";
        tableModel[0][9] = "err";
        tableModel[0][0] = "err";

        tableModel[1][1] = "err";
        tableModel[1][2] = "err";
        tableModel[1][3] = "err";
        tableModel[1][4] = "err";
        tableModel[1][5] = "blank";
        tableModel[1][6] = "6";
        tableModel[1][7] = "7";
        tableModel[1][8] = "8";
        tableModel[1][9] = "9";
        tableModel[1][0] = "success";
    }

    public static class Stack {

        private ArrayList<Character> list = new ArrayList<>();

        public Stack() {
            createTableModel();
        }

        public char pop() {
            Character poped = null;
            try {
                poped = list.get(list.size() - 1); // Get Last Index
                list.remove(list.size() - 1); // Remove last index
            } catch (Exception e) {
                e.printStackTrace();
            }
            return poped;
        }

        public void push(String lexic) {
            char[] lexicChars = lexic.toCharArray();
            for (int i = lexicChars.length - 1; i >= 0; i--) {
                list.add(lexicChars[i]);
            }
        }

        @Override
        public String toString() {
            String result = "";
            for (Character character : list) {
                result += character + ",";
            }
            return result;
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public char top() {
            return list.get(list.size() - 1);
        }

        public boolean isTerminal(char x) {
            if ((x == 'A') || (x == 'S') || (x == '#')) {
                return false;
            }
            return true;
        }
    }

}
