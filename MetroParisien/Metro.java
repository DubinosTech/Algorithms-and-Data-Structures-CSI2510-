package dev4;


import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileNotFoundException;
import java.lang.String;
import java.io.FileReader;


public class Metro{
    
    
    
    //Methode to get the Metro Graph
    
    public static void readMetro(String ligne){
        file=ligne;
        try{
            Metro.readGraph();
            }
            catch (FileNotFoundException e){
                System.out.println("It's not the file you're looking for.");
            }
        ;
    } 
    static String file="";
    
    //Method to read graph
    private static void readGraph() throws FileNotFoundException{   

     @SuppressWarnings("resource")
	Scanner scan = new Scanner (new FileReader(file)); 
     scan.nextLine();

     while (scan.hasNextLine()){
         
         String ligne = scan.nextLine();

         if (ligne.equals("$")){break;}

        
         String num1=ligne.substring(0,4);
         String num2=ligne.substring(4,ligne.length());

         Station st = new Station (num1,num2);
         //remplir les stations voisines ds le tableau Array
         ParisMetro.voisins[Integer.parseInt(st.getStationNum())]= st;
       //remplir les stations 
         ParisMetro.stations.add(st);
         
     }
    

     while(scan.hasNextLine()){
        String temp = scan.nextLine();
        
        StringTokenizer st; 
		 st=new StringTokenizer(temp);
		 
		 int num =Integer.parseInt(st.nextToken());
		 int voisinNum =Integer.parseInt(st.nextToken());
		 int time=Integer.parseInt(st.nextToken());
		
        
        Chemin che  = new Chemin (ParisMetro.voisins[num],ParisMetro.voisins[voisinNum],time);//create a new edge
       
        
        //ajout des chemins
        ParisMetro.chemins.add(che); 
        //ajout des sorties stations voisines
        ParisMetro.voisins[num].addSortie(che);
        //ajout des sorties stations voisines
        ParisMetro.voisins[voisinNum].addArrivee(che);
 }
    
    }
  

}