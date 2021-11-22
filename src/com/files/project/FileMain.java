package com.files.project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileMain {

    public static void main(String[] args) throws FileNotFoundException {
        FileSystems fileSystems=new FileSystems();
        Scanner scanner=new Scanner(System.in);
            int choose;


        System.out.println("Seciminiz:");
        choose=scanner.nextInt();

                if (choose==1){
                    fileSystems.writeFile();

                }
                else if(choose==2){
                    fileSystems.readFile();
                }
                else if(choose==3){
                    fileSystems.updateFile();
                }

    }
}
