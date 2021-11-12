package com.company;
import java.io.*;
public class Terminal {
    public Parser parser=new Parser();
    public static String currentDir = "C:\\";
    public String root = "c:\\";
    public void echo(Parser p) {
        int position = 0;
        boolean newLine = true;
        StringBuilder output = new StringBuilder();
        if (p.args.length > 0 && p.args[0].equals("-n")) {
            newLine = false;
            position = 1;
        }
        for (int i = position; i < p.args.length; i++) {
            if (p.args[i] != null) {
                System.out.print(p.args[i]+" ");
            }
        }
        if(newLine){
            System.out.println("");
        }
    }
    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public String getLocation() {
        return currentDir;
    }

    public void setLocation(String location, String currentDir) {
        this.currentDir = currentDir;
    }

    //Implement each command in a method, for example:
    //----------------------------------------------------------------------------------------

    /**
     * function implement PWD command that show current working DIR
     */
    public void pwd() {
        System.out.println(">The current working directory is " + currentDir);
    }

    //----------------------------------------------------------------------------------------
    public static void cp(String sourcePath, String destinationPath) throws FileNotFoundException, IOException {
        // copy text file to text file
        File file = new File(sourcePath);
        File file2 = new File(destinationPath);
        if (!file2.isDirectory())
            Terminal.FiletoFile(sourcePath, destinationPath, false);
        else
            Terminal.FiletoFile(sourcePath, (destinationPath + "//" + file.getName()), false);
    }

    private static void FiletoFile(String sourcePath, String destinationPath, boolean b) {
        // TODO Auto-generated method stub

    }

    //----------------------------------------------------------------------------------------

    /**
     * cd Function is to change current dir "working on dirctory" if it called with
     * know args it return to Root if it has argument it check if dir is exist and
     * make it "working dir" in case ".." it go back to its parent
     *
     * @param parameters "arguments of command"
     */
    public static void cd(String[] parameters) {
        boolean dirflag = false;
        if (parameters == null) {
            currentDir = "C:\\";
            return;
        } else if (parameters[0].equals("..")) {
            currentDir = new File(currentDir).getParent();
            return;
        } else if (!(new File(parameters[0]).isAbsolute())) {
            if (new File(currentDir + "\\" + parameters[0]).exists())
                currentDir = new File(currentDir + "\\" + parameters[0]).getAbsolutePath();
        } else if (new File(parameters[0]).isDirectory()) {

            dirflag = true;
            currentDir = new File(parameters[0]).getAbsolutePath();
            return;

        } else {
            if (!dirflag)
                System.out.println("bash: cd: " + parameters[0] + " not a directory");
            else
                System.out.println("bash: cd: " + parameters[0] + " no such file or directory");
            return;
        }
    }
//----------------------------------------------------------------------------------------

    /**
     * rm function is implement rm command that delete file
     * An absolute path is a path that doesn’t need to
     * be combined with other
     * path information in order to locate a file.
     *
     * @param sourcePath
     */
    public static void rm(String sourcePath) {
        String temp = currentDir;
        File remove;
        if (new File(sourcePath).isAbsolute()) {
            temp = new File(sourcePath).getParent();
        }
        remove = new File(temp, sourcePath);
        if (remove.delete()) {
            System.out.println("File deleted ");
        } else {
            System.out.println("Failed");
        }
    }

    private void printNewLine(boolean newLine) {
        if (newLine) {
            System.out.println("/n");
        }
    }



    //This method will choose the suitable command method to be called
    //public void chooseCommandAction(){}

}