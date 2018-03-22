package calculator2021;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP-
 */
public class Calculator2021 implements Calculator{
    String current;
    ArrayList<String> pastOperations;
    int index;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }

    public Calculator2021() {
        pastOperations= new ArrayList<>();
        index=0;
    }

    @Override
    public void input(String s) {
        this.current=s;
    }

    @Override
    public String getResult() {
        int operationIndex=0;
        double result=0;
        while( operationIndex<current.length()
                && !"+-*/".contains(current.substring(operationIndex, operationIndex+1))
                ){
            operationIndex++;
        }
        
        double firstOperand = Double.parseDouble(current.substring(0,operationIndex));
        char operation = current.charAt(operationIndex);
        double secondOperand = Double.parseDouble(current.substring(operationIndex+1,current.length()));
        
        switch(operation){
            case '+':
                result = firstOperand+secondOperand; 
                break;
            case '*':
                result = firstOperand*secondOperand; 
                break;
            case '/':
                if(secondOperand==0) return "Error: Division by zero";
                result = firstOperand/secondOperand; 
                break;
            case '-':
                result = firstOperand-secondOperand; 
                break;
            default:
                return "Error";
        }
        current=current +" = "+ result; 
        pastOperations.add(current);
        index=pastOperations.size()-1;
        return current; 
    }

    @Override
    public String current() {
        return current;
    }

    @Override
    public String prev() {
        if(index<=0 && pastOperations.size()>0) return pastOperations.get(0);
        else if(pastOperations.size()==0) return "No previous equations";
        return pastOperations.get(--index);
    }

    @Override
    public String next() {
        if(index<0) index=0;
        if (index >= pastOperations.size()-1) return pastOperations.get(pastOperations.size()-1);
        else return pastOperations.get(++index);
    }
    
}
