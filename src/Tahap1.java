
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
public class Tahap1 {
    
    public static void Proses(String n, List<String>  str, List<Integer> lexic) {
        String temp = " ";
        char[] array = n.toCharArray();
        int tokenlexic = 0;
        str.clear();
        lexic.clear();
        String state = "q0";
        for (int i = 0; i < n.length(); i++) {
            switch (state) {
                case "q0":
                    if ((array[i] >= 65 && array[i] <= 90) || (array[i] >= 97 && array[i] <= 122)) {
                        state = "q7";
                        tokenlexic = 1;
                        temp = "";
                        i--;
                    } else if (array[i] - 48 >= 0 && array[i] - 48 <= 9) {
                        state = "q1";
                        tokenlexic = 3;
                        temp = "";
                        i--;
                    } else if (array[i] == '+') {
                        state = "q8";
                        i--;
                    } else if (array[i] == '-') {
                        state = "q9";
                        i--;
                    } else if (array[i] == '*') {
                        state = "q10";
                        i--;
                    } else if (array[i] == '/') {
                        state = "q11";
                        i--;
                    } else if (array[i] == '(') {
                        state = "q12";
                        i--;
                    } else if (array[i] == ')') {
                        state = "q13";
                        i--;
                    }
                    break;
                case "q1":
                    while (i < n.length() && isStillIntegerOrReal(state)) {
                        if (state.equals("q1")) {
                            if (array[i] - 48 >= 0 && array[i] - 48 <= 9) {
                                state = "q1";
                                tokenlexic = 3;
                            } else if (array[i] == 'E') {
                                state = "q2";
                            } else if (array[i] == ',' || array[i] == '.') {
                                state = "q3";
                            } else if (array[i] == '+' || array[i] == '-' || array[i] == '*' || array[i] == '/' || array[i] == '(' || array[i] == ')') {
                                state = "q0";
                                i--;
                                break;
                            } else {
                                tokenlexic = -1;
                                break;
                            }
                        } else if (state.equals("q2")) {
                            if (array[i] - 48 >= 0 && array[i] - 48 <= 9) {
                                state = "q6";
                                tokenlexic = 2;
                            } else if (array[i] == ',' || array[i] == '.') {
                                state = "q5";
                            } else {
                                tokenlexic = -1;
                            }
                        } else if (state.equals("q3")) {
                            if (array[i] - 48 >= 0 && array[i] - 48 <= 9) {
                                state = "q4";
                                tokenlexic = 2;
                            } else {
                                tokenlexic = -1;
                                break;
                            }
                        } else if (state.equals("q4")) {
                            if (array[i] - 48 >= 0 && array[i] - 48 <= 9) {
                                state = "q4";
                                tokenlexic = 2;
                            } else if (array[i] == 'E') {
                                state = "q2";
                            } else if (array[i] == '+' || array[i] == '-' || array[i] == '*' || array[i] == '/' || array[i] == '(' || array[i] == ')') {
                                state = "q0";
                                i--;
                                break;
                            } else {
                                tokenlexic = -1;
                                break;
                            }
                        } else if (state.equals("q5")) {
                            if (array[i] - 48 >= 0 && array[i] - 48 <= 9) {
                                state = "q6";
                                tokenlexic = 2;
                            } else {
                                tokenlexic = -1;
                                break;
                            }
                        } else if (state.equals("q6")) {
                            if (array[i] - 48 >= 0 && array[i] - 48 <= 9) {
                                state = "q6";
                                tokenlexic = 2;
                            } else if (array[i] == '+' || array[i] == '-' || array[i] == '*' || array[i] == '/' || array[i] == '(' || array[i] == ')') {
                                state = "q0";
                                i--;
                                break;
                            } else {
                                tokenlexic = -1;
                                break;
                            }
                        } else {
                            break;
                        }
                        temp += array[i];
                        i++;
                    }
                    str.add(temp);
                    lexic.add(tokenlexic);
                    break;
                case "q7":
                    while (i < n.length() && tokenlexic == 1) {
                        if ((array[i] >= 65 && array[i] <= 90) || (array[i] >= 97 && array[i] <= 122) || array[i] == '_') {
                            temp += array[i];
                            tokenlexic = 1;
                            i++;
                        } else if (array[i] - 48 >= 0 && array[i] - 48 <= 9) {
                            temp += array[i];
                            tokenlexic = 1;
                            i++;
                        } else {
                            state = "q0";
                            i--;
                            break;
                        }
                    }
                    str.add(temp);
                    lexic.add(tokenlexic);
                    break;
                case "q8":
                    if (array[i] == '+') {
                        temp = "+";
                        tokenlexic = 6;
                    } else {
                        state = "q0";
                        i--;
                        tokenlexic = -1;
                        break;
                    }
                    str.add(temp);
                    lexic.add(tokenlexic);
                    break;
                case "q9":
                    if (array[i] == '-') {
                        temp = "-";
                        tokenlexic = 7;
                    } else {
                        state = "q0";
                        i--;
                        tokenlexic = -1;
                        break;
                    }
                    str.add(temp);
                    lexic.add(tokenlexic);
                    break;
                case "q10":
                    if (array[i] == '*') {
                        temp = "*";
                        tokenlexic = 8;
                    } else {
                        state = "q0";
                        i--;
                        tokenlexic = -1;
                        break;
                    }
                    str.add(temp);
                    lexic.add(tokenlexic);
                    break;
                case "q11":
                    if (array[i] == '/') {
                        temp = "/";
                        tokenlexic = 9;
                    } else {
                        state = "q0";
                        i--;
                        tokenlexic = -1;
                        break;
                    }
                    str.add(temp);
                    lexic.add(tokenlexic);
                    break;
                case "q12":
                    if (array[i] == '(') {
                        temp = "(";
                        tokenlexic = 4;
                    } else {
                        state = "q0";
                        i--;
                        tokenlexic = -1;
                        break;
                    }
                    str.add(temp);
                    lexic.add(tokenlexic);
                    break;
                case "q13":
                    if (array[i] == ')') {
                        temp = ")";
                        tokenlexic = 5;
                    } else {
                        state = "q0";
                        i--;
                        tokenlexic = -1;
                        break;
                    }
                    str.add(temp);
                    lexic.add(tokenlexic);
                    break;
            }
        }
    }

    public static boolean isStillIntegerOrReal(String state) {
        switch (state) {
            case "q1":
                return true;
            case "q2":
                return true;
            case "q3":
                return true;
            case "q4":
                return true;
            case "q5":
                return true;
            case "q6":
                return true;
        }
        return false;
    }
    
}
