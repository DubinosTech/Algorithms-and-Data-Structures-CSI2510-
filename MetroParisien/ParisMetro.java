package dev4;
import java.util.Vector;


import java.util.PriorityQueue;


public class ParisMetro{
	 protected  static Vector<Station> stations = new Vector<Station>();
	 protected static Vector<Chemin> chemins = new Vector<Chemin>();
     protected static Station[] voisins =new Station[400];

    //methode pour imprimer les Stations Nom et Numero
    public static String printStation(Vector<Station> station){


        String sortie = "";

        for (Station v:station){
            if (v!=station.lastElement()){

            sortie+= "("+v.getStationNum()+")"+v.getName()+" -> ";

            }
            else{
           	 sortie+="("+v.getStationNum()+")"+v.getName();
           	 }
        }

        System.out.println("--------Nombre de Stations reliees  "+station.size()+"------------\n");

        System.out.println("Numero de stations");
    	printStationNum(station);
    	System.out.println(printStationNum(station));
    	System.out.println("");
    	System.out.println("");

        System.out.println("Nom et Numero de stations");

        return sortie;
   }
    //methode pour imprimer les Stations Numero seulement
    public static String printStationNum(Vector<Station> s){
         String sortie = " ";
         for (Station v:s){
             if (v!=s.lastElement()){
             sortie+=v.getStationNum()+" -> ";}
             else{sortie+=v.getStationNum();}
         }
         return sortie;
    }



    //methode qui genere les stations sur la meme ligne
    //-------------Question 2i---------------
    static public Vector<Station> memeLigne(int VertexId){
        Vector<Station> line = new Vector<Station>();//to accumulate stations
        Vector<Station> tempVec = new Vector<Station>();


        Boolean isFirst = true;

        Station root = voisins[VertexId];

        for (Chemin e:root.getSortie()){
            if (e.getTime()!=-1){
                root.isVisited(true);

                tempVec= ParisMetro.memeLigne(e.getNext(),tempVec,isFirst);
                line.addAll(tempVec);
                if (isFirst){
                    isFirst=false;
                    line.add(root);
                }
                tempVec.clear();
            }
        }
      //boucle qui remets tous a false comme on l a jamais visitee
        for (Station v:stations){
            v.isVisited(false);
        }
        return line;
    }

    //methode recursive sameline
    static private Vector<Station> memeLigne(Station s,Vector<Station>l,Boolean drap){

        s.isVisited(true);
        if (!drap){
        l.add(s);}
        else{l.add(0,s);}

            for (Chemin e:s.getSortie()){
                if ((e.getTime()!=-1)&&(!e.getNext().getIsVisited())){

                    memeLigne(e.getNext(),l,drap);
                }
            }

            return l;
    }


    // Algorithm de Dijkstra utulisee pour trouver le chemin court
    //------------------Question 2ii---------------

    public static Vector <Station> cheminCourte(int num1,int num2){


    	PriorityQueue<Station> queue = new PriorityQueue<Station>();
    	for (Station v:stations){//boucle pour mettre toutes les visites a false
            v.isVisited(false);
        }
        Metro.readMetro(Metro.file);
        int tps=90;

        Vector <Station> acctuel = new Vector<Station>();
        Station debut = voisins[num1];

        debut.setTempsArrivee(0);
        Integer temps=debut.getTempsArrivee();


        int visitNbr=0;//nombre de visite

        queue.add(debut);

        while (visitNbr<stations.size()){
            debut = queue.remove();

            debut.isVisited(true);
            acctuel = debut.getcheminStation();

            acctuel.add(debut);

            temps = debut.getTempsArrivee();

            for (Chemin che:debut.getSortie()){
                if (che.getTime()==-1){
                	boolean drap=((tps+temps)<che.getNext().getTempsArrivee())&&(che.getNext().getIsAvilable());
                    if(drap==true)
                    {
                        che.getNext().setTempsArrivee(tps+temps);
                        che.getNext().setcheminStation(acctuel);
                    }
                }
                else{
                	boolean dra=((che.getTime()+temps)<che.getNext().getTempsArrivee())&&(che.getNext().getIsAvilable());
                    if(dra==true)
                    {
                        che.getNext().setTempsArrivee(che.getTime()+temps);
                        che.getNext().setcheminStation(acctuel);
                    }
                }
                che.getNext().setcheminStation(acctuel);
                if(!che.getNext().getIsVisited()){queue.add(che.getNext());}
            }
            visitNbr++;
            if (Integer.parseInt(debut.getStationNum())==num2){debut.setcheminStation(acctuel);break;}
        }
        for (Station v:stations){//boucle pour mettre toutes les visites a false
            v.isVisited(false);
        }
        return voisins[num2].getcheminStation();
    }



    //methode permettant de trouver les chemins courtes si certains chemins sont fermes
    //------------------Question 2iii---------------
    public static Vector<Station> courteDistance(int id1,int id2, int id3){
        Metro.readMetro(Metro.file);
        Vector<Station> lineToDisable = memeLigne(id3);
        for (Station v:lineToDisable)//boucle pour mettre toutes les isdispo a false
        	v.setToNotdispo();

        for (Station v:stations){//boucle pour mettre toutes les visites a false
            v.isVisited(false);
        }
        Vector <Station> out = cheminCourte(id1, id2);
        for (Station v:stations){//boucle pour mettre toutes les is dispo a false
            v.isVisited(false);
        }
        for (Station v:lineToDisable)//boucle pour mettre toutes les isdispo a true
        	v.setTodispo();

        return out;
    }

    public static void main(String[] args1){
        //in this part ,u can add the path of where is ur file in the desktop

        Metro.readMetro("C:/Users/Acer/Desktop/CSI/dev4/Metro.txt");

       int size=args1.length;

        if (size==1){
        	int num0=Integer.parseInt(args1[0]);
        	System.out.println("---------Trouver la ligne a la station "+num0+": ---------"+"\n");

        	System.out.println(ParisMetro.printStation(memeLigne(num0)));
        	}
        else if (size==2){
        	int num0=Integer.parseInt(args1[0]);
        	int num1=Integer.parseInt(args1[1]);

        Vector<Station> tempo = cheminCourte(num0,num1);
        Station a = null;
        for (Station t:tempo){
        	if (t!=null)
        	      a=t;}
        if (a!=null){
        System.out.println("le trajet le plus rapide entre deux stations "+"("+ num0+") et (" + num1 +")  en secondes  ----------->"+
        		a.getTempsArrivee()+" secondes\n"+"\n chemin courte : "+"\n"+ParisMetro.printStation(tempo));
        }
        else
        	System.out.println("------Desolee-----");
        	}
        else if (args1.length==3){
        	int num0=Integer.parseInt(args1[1]);
        	int num1=Integer.parseInt(args1[0]);
        	int num2=Integer.parseInt(args1[2]);
            Vector<Station> temp0 =courteDistance(num0,num1,num2);

            Station a = null;
            for (Station t:temp0){
            	if (t!=null)
            	      a=t;}
            if (a!=null){
            System.out.println("-------------------->La duree du trajet  entre : station("+ num0+") et station(" + num1 +")   avec extremite station ("+num2+")----------->"+
            +a.getTempsArrivee()+" secondes  "+
            		"\n"+"\n  le trajet le plus rapide entre deux stations lorsque l’une des lignes"+
"est hors-fonction (cette ligne étant identifiée par l’une de ses extrémités) : "+"\n"+ParisMetro.printStation(temp0));}
            else
            	System.out.println("------Desolee-----");

        }

        	}}
