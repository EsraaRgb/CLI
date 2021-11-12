package com.company;

public class Main {

    public static void main(String[] args) {
        Terminal t=new Terminal();
        t.parser.parse("echo my name is esraa");
        t.echo(t.parser);
    }
}
