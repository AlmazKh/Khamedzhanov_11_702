package ru.itis;

import com.sun.org.apache.xpath.internal.operations.Variable;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.util.LinkedList;
import java.util.List;

public class Analyzer {
    public boolean finish = false;
    void  analyze(String input) {
        int i = 0;
        int status = 0;
        while(i < input.length()) {
            switch (status) {
                case 0:
                    if(input.charAt(i) >= 'A' && input.charAt(i)<= 'Z') {
                        i++;
                        status = 1;
                        break;
                    } else {
                        throw new SyntaxException();
                    }
                case 1:
                    if(input.charAt(i) >= '0' && input.charAt(i)<= '9') {
                        i++;
                        status = 2;
                        break;
                    } else {
                        throw new SyntaxException();
                    }
                case 2:
                    if(input.charAt(i) == ':') {
                        i++;
                        status = 3;
                        break;
                    } else {
                        throw new SyntaxException();
                    }
                case 3:
                    if(input.charAt(i) == '=') {
                        i++;
                        if(i == input.length()) {
                            throw new SyntaxException();
                        }
                        status = 4;
                        break;
                    } else {
                        throw new SyntaxException();
                    }
                case 4:
                    if(input.charAt(i) >= 'A' && input.charAt(i)<= 'Z') {
                        i++;
                        status = 7;
                        break;
                    } else {
                        if(input.charAt(i) >= '0' && input.charAt(i)<= '9') {
                            i++;
                            status = 5;
                            break;
                        } else {
                            if(input.charAt(i-1) >= '0' && input.charAt(i-1)<= '9') {
                                if(input.charAt(i) == ';') {
                                    status = 6;
                                    i++;
                                    break;
                                }
                            } else {
                                throw new SyntaxException();
                            }

                        }
                    }
                case 5:
                    if(input.charAt(i) >= '0' && input.charAt(i)<= '9') {
                        i++;
                        status = 5;
                        break;
                    } else {
                        if(input.charAt(i) == ';') {
                            status = 0;
                            i++;
                            break;
                        } else {
                            throw new SyntaxException();
                        }
                    }
                case 6:
                    status = 0;
                    break;
                case 7:
                    if(input.charAt(i) >= '0' && input.charAt(i)<= '9') {
                        i++;
                        status = 8;
                        break;
                    } else {
                        throw new SyntaxException();
                    }
                case 8:
                    if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/') {
                        status = 4;
                        i++;
                        break;
                    } else {
                        if(input.charAt(i) == ';') {
                            i++;
                            if(i == input.length()) {
                                break;
                            }
                            status = 4;
                            break;
                        } else {
                            throw new SyntaxException();
                        }
                    }
            }
        }
        finish = true;
    }

    public List<String> process(String input) {
        List<String> list = new LinkedList();
        analyze(input);
        int i = 0;
        int status = 0;
        while(i < input.length()) {
            switch (status) {
                case 0:
                    if(input.charAt(i+4) >= 'A' && input.charAt(i+4)<= 'Z') {
                        status = 4;
                        break;
                    }

                    if(input.charAt(i) >= 'A' && input.charAt(i)<= 'Z') {
                        String str = "";
                        while (input.charAt(i) != ';') {
                            str += input.charAt(i);
                            i++;
                        }
                        list.add(str);
                        i++;
                        if(list.size() >= 2) {
                            status = 4;
                        } else {
                            status = 0;
                        }
                        break;
                    } else {
                        throw new VariableNotFoundException();
                    }

                case 4:
                    if(input.charAt(i+4) >= 'A' && input.charAt(i+4)<= 'Z') {
                        String str = "" + input.charAt(i) + input.charAt(i+1) + input.charAt(i+2) + input.charAt(i+3);
                        /*find(list, i + 4, input);
                        find(list, i + 7, input);*/
                        str += action(find(list, i + 4, input), find(list, i + 7, input), input.charAt(i+6));
                        list.add(str);
                        i += 10;
                        break;
                    } else {
                        if(input.charAt(i+4) >= '0' && input.charAt(i+4)<= '9') {
                            status = 0;
                            break;
                        } else {
                                throw new VariableNotFoundException();
                            }

                        }
                    }

            }
        return list;
    }


    public String find(List<String> list, int i, String input) {
        String str = "";
            for(int j = 0; j < list.size(); j++) {
                if(list.get(j).charAt(0) == input.charAt(i) && list.get(j).charAt(1) == input.charAt(i+1)) {
                    str = list.get(j);
                }
            }
        if(str.equals("")) {
                throw new VariableNotFoundException();
        }
        String newStr = "";
        int j = 4;
        while(j < str.length()) {
            newStr += str.charAt(j);
            j++;
        }
        return newStr;
    }

    public double action(String number1, String number2, char operation) {
       Double numb1 = Double.parseDouble(number1);
       Double numb2 = Double.parseDouble(number2);
       if(operation == '*') {
           return numb1 * numb2;
       }
       if(operation == '/') {
           return numb1 / numb2;
       }
        if (operation == '+') {
           return numb1 + numb2;
        }
        if(operation == '-') {
           return numb1 - numb2;
        }
        return 0;
    }
}
