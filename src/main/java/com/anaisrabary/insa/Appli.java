package com.anaisrabary.insa;

public class Appli {
    private static final String filename = "managerdata.csv";

    public static void main(String[] args){
        new UIconsole(new ManagerCSV(filename)).start();
    }
}
