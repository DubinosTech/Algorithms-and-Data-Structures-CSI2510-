package dev4;

import java.util.Vector;


public class Station implements Comparable<Station>{

    private boolean isDispo;//montrant la station est disponible
    private String stationNum;
    private String name;
    private int tempsArrivee;
    boolean visitee;
    Vector<Station> cheminStation;

    private Vector<Chemin> arrivee = new Vector<Chemin>();//stations entrantes
    private Vector<Chemin> sortie = new Vector<Chemin>();//stations sortantes

    public Station(String num, String nom){
        this.name = nom;
        this.stationNum = num;
        cheminStation=new Vector<Station>();
        isDispo=true;
        tempsArrivee = Integer.MAX_VALUE;
        this.visitee = false;
    }
public void setToNotdispo(){
    	this.isDispo=false;
    	}
    public void setTodispo(){
    	this.isDispo=true;
    	}

    public void isVisited(boolean drap){
    	this.visitee=drap;
    		}
    public void setcheminStation(Vector<Station> tt){
    	cheminStation=new Vector<Station>(tt);
    	}
   //getters et setters pour arrivee et sortie 
    public Vector<Chemin> getSortie(){
    	return sortie;}
    public Vector<Chemin> getArrivee(){
    	return arrivee;}
    public void addArrivee(Chemin in){
    	arrivee.add(in);
    	}
    public void addSortie(Chemin out){
    	sortie.add(out);
    	}
    public void setTempsArrivee(int time){
    	this.tempsArrivee=time;
    	}

    public boolean getIsAvilable(){
    	return this.isDispo;
    	}
    public Vector<Station> getcheminStation(){
    	
    	return new Vector<Station>(cheminStation);
    	}
    public boolean getIsVisited(){
    	return visitee;}
    public String getStationNum(){
    	return stationNum;}
    public String getName(){
    	return name;}
    public int getTempsArrivee(){return 
    		tempsArrivee;}

  
    //   comparer 2 stations
    public int compareTo(Station r){
        int tps= this.getTempsArrivee()>r.getTempsArrivee()?1:(this.getTempsArrivee()<r.getTempsArrivee()?-1:0);
        return  tps;}
}