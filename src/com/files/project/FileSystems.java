package com.files.project;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileSystems {
    File file = new File("src\\com\\files\\project\\students.txt");
    Person person=new Person();


    public  void createFile(){
        try {
            if (file.createNewFile()){
                System.out.println("Dosya Olusturma Basarili!!!");
            }else {
                System.out.println("Dosya Olusturma İslemi Basarisiz!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readFileDate(){
        if (file.exists()){
            System.out.println("Dosya Adi: "+file.getName());
            System.out.println("Dosya dizini:"+file.getAbsolutePath());
            System.out.println("Dosya Yazilabilir mi:"+file.canRead());
            System.out.println("Dosya Okunabilir mi:"+file.canWrite());
            System.out.println("Dosya Boyutu:"+file.length());
        }

    }
    public String readFile() throws FileNotFoundException {

        String read="";

         try(Scanner fileRead=new Scanner(new FileReader(file))) {
                while (fileRead.hasNextLine()){
                    read+=(fileRead.nextLine());
                    read+="\n";
                }
                return read;
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         }

         return null;
    }
    public void writeFile(){
        Scanner keyboard=new Scanner(System.in);
        System.out.print("\nID:");
        person.setID(keyboard.nextInt());
        keyboard.nextLine();
        System.out.print("Adi:");
        person.setName(keyboard.nextLine());
        System.out.print("Soyadi:");
        person.setSurName(keyboard.nextLine());
        System.out.print("Yasi:");
        person.setAge(keyboard.nextInt());
        keyboard.nextLine();
        keyboard.close();
        try {
            FileWriter fileWrite=(new FileWriter(file,true));
            fileWrite.write("ID:"+person.getID()+"\n"+
                            "Adi:"+person.getName()+"\n"+
                            "Soyadi:"+person.getSurName()+"\n"+
                             "Yasi:"+person.getAge()+"\n");
            fileWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void updateFile() throws FileNotFoundException {
        FileWriter fileWrite=null;

                String readerFile=readFile();
                if (readerFile.contains("benim")){
                    readerFile=readerFile.replace("benim","benimdir");
                    try {
                        fileWrite=(new FileWriter(file,false));
                        fileWrite.write(readerFile);
                        fileWrite.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


            }




    }
    }

