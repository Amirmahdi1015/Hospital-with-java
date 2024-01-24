import java.util.ArrayList;
public class Patients {
    private int pcode;
    private String name;
    private String doctor;
    private int date;
    
    public static ArrayList<String> drugs;
    public Patients(int pcode,String name,String doctor,int date,ArrayList<String> drugs){
        this.pcode=pcode;
        this.name=name;
        this.doctor=doctor;
        this.date=date; 
        this.drugs=drugs;
    }

    public int get_code() {
        return this.pcode;
    }
    public void addDrug(String drug){
        this.drugs.add(drug);
        System.out.println(" The desired drug was added!!!");
    }
    public void removeDrug(int index){
        this.drugs.remove(index);
        System.out.println(" The desired patient`drug was removed!!!");
    }
    public void editDrug(int index,String edit){
        this.drugs.set(index, edit);
        System.out.println(" The desired patient`drug was changesd!!!");
    }
    public String get_name(){
        return this.name;
    }
    public String get_doctor(){
        return this.doctor;
    }
    public int get_date(){
        return this.date;
    }
    public ArrayList get_drug(){
        for(Patients i:Main.patients){
            if(i.get_code()==this.pcode){
                return this.drugs;   
            }
        }
        return this.drugs;
    }
        
        
}