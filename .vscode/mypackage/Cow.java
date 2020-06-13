package mypackage;
public class Cow{
    private int id;
    private int latest_weight;
    private int highest_weight;
    private int num_milks;
    private int gal_milk;
    private int temp;

    public Cow(int id){
        this.id = id; 
    }
    public String toString(){//allows for a printable Cow object
        return "Cow id = " + id + ". Number " + id + "'s last weight was " + latest_weight + " with a maximum weight of " + highest_weight + ". They produced  " + gal_milk + " gallons in " + num_milks + "time(s) milked. Lastly their temperature comes in at " + temp;
    }
    public int getid(){
        return this.id;
    }
    public int getlatest_weight(){//gets the Cow's latest weight
        return this.latest_weight;
    }
    public int gethighest_weight(){//get the Cow's highest weight
        return this.highest_weight;
    }
    public void setlatest_weight(int weight){// get most recent weigh and update highest if need be
        this.latest_weight = weight;
        if(weight > this.highest_weight){
            this.highest_weight = weight;
        }
    }
    public void setgal_milk(int milk){
        this.gal_milk += milk;
        this.num_milks++;
    }
    public void settemp(int temp){
        this.temp = temp;
    }
}