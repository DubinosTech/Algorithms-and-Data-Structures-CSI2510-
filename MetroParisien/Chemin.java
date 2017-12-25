package dev4;



public class Chemin{
    private int time;
    private Station prec;
    private Station next;

    public Chemin(Station arr,Station fin,int timee){
        this.prec=arr;
        this.next=fin;
        this.time = timee;
    }

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Station getPrec() {
		return prec;
	}

	public void setPrec(Station prec) {
		this.prec = prec;
	}

	public Station getNext() {
		return next;
	}

	public void setNext(Station next) {
		this.next = next;
	}
    

    

}