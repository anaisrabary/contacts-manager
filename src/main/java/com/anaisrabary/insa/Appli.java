package com.anaisrabary.insa;

import com.anaisrabary.insa.core.UI.UIconsole;
import com.anaisrabary.insa.core.model.ManagerCSV;

public class Appli {
    private static final String filename = "managerdata.csv";

    public static void main(String[] args){
        new UIconsole(new ManagerCSV(filename)).start();
    }
}
