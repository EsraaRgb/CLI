package com.company;

import java.security.PublicKey;

public class Parser {
    String commandName;
    String[] args=new String[10];
    //This method will divide the input into commandName and args
    // where "input" is the string command entered by the user
    public boolean parse(String input){
        String[] parts=input.split(" ");
        commandName=parts[0];
        for (int i=1;i<parts.length;i++)
        {
            args[i-1]=parts[i];

        }
        return true;
    }

    public String getCommandName(){
        return commandName;
    }
    public String[] getArgs(){
        return args;
    }


}
