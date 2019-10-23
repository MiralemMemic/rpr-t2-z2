package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    double prvaTacka, drugaTacka;
    boolean prvaPripada, drugaPripada;

    Interval(double t1, double t2, boolean p1, boolean p2) {
        if(t1 > t2) throw new IllegalArgumentException("Pogresni parametri !");
        prvaTacka = t1;
        drugaTacka = t2;
        prvaPripada = p1;
        drugaPripada = p2;
    }

    Interval() {
        prvaTacka = 0;
        drugaTacka = 0;
        prvaPripada = false;
        drugaPripada = false;
    }

    public static Interval intersect(Interval i, Interval i2) {
        Interval presjek = new Interval();
        presjek = i.intersect(i2);
        return  presjek;
    }

    public boolean isIn(double tacka) {
        if(prvaTacka < tacka && tacka < drugaTacka) return true;
        if(prvaPripada && tacka == prvaTacka) return true;
        if(drugaPripada && tacka == drugaTacka) return true;
        return false;
    }

    public boolean isNull() {
        Interval test = new Interval();
        if(this.equals(test)) return true;
        return false;
    }


    public Interval intersect(Interval interval) {
        Interval presjek = new Interval();
        if(this.isIn(interval.prvaTacka) && this.isIn(interval.drugaTacka)) {
            presjek.prvaTacka = interval.prvaTacka;
            presjek.drugaTacka = interval.drugaTacka;
            presjek.prvaPripada = interval.prvaPripada;
            presjek.drugaPripada = interval.drugaPripada;
        }
        else if(this.isIn(interval.prvaTacka)) {
            presjek.prvaTacka = interval.prvaTacka;
            presjek.drugaTacka = this.drugaTacka;
            presjek.prvaPripada = interval.prvaPripada;
            presjek.drugaPripada = this.drugaPripada;
        }
        else if(this.isIn(interval.drugaTacka)) {
            presjek.prvaTacka = this.prvaTacka;
            presjek.drugaTacka = interval.drugaTacka;
            presjek.prvaPripada = this.prvaPripada;
            presjek.drugaPripada = interval.drugaPripada;
        }
        return presjek;
    }
    //@Override
    public boolean equals(Interval i) {
        if((this.prvaTacka == i.prvaTacka) && (this.drugaTacka == i.drugaTacka)
            && (this.prvaPripada == i.prvaPripada) && (this.drugaPripada == i.drugaPripada)) return  true;
        return  false;
    }
    @Override
    public String toString() {
        String rijec = new String();
        if(this.isNull()) return "()";
        if(this.prvaPripada) rijec = rijec + "[";
        else rijec = rijec + "(";
        rijec = rijec + this.prvaTacka + "," + this.drugaTacka;
        if(this.drugaPripada) rijec = rijec + "]";
        else rijec = rijec + ")";
        return rijec;
    }
}
