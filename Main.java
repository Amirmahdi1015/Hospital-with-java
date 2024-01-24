import java.util.*;
import java.util.ArrayList;
public class Main {
        static ArrayList<String> drugs= new ArrayList<>();
        static ArrayList<String> doctors=new ArrayList<>();
        static ArrayList<Nurse> nurse= new ArrayList<>();
        static ArrayList<Patients> patients= new ArrayList<>();  
    public static void main(String []args){
        int code = 0;
        int choose2 = 0;
        int patient_code=0;
        //drugs.add("");
        drugs.add("staminophen");
        drugs.add("codein");
        drugs.add("dicklofenak");
        drugs.add("piroxikam");
        drugs.add("serom");
        Patients patient1=new Patients(1000,"amir hassani","hassan rezaei",20231016,drugs);
        Patients patient2=new Patients(2000,"ali hassani","rasol rezaei",20231015,drugs );
        Patients patient3=new Patients(3000,"aref hassani","mohammad rezaei",20231014,drugs );
        Patients patient4=new Patients(4000,"reza hassani","hossein rezaei",20231013,drugs );
        Patients patient5=new Patients(5000,"mahdi hassani","behrooz rezaei",20231012,drugs );
        
        
        Nurse nurse1=new Nurse(10,111);
        
        Nurse nurse2=new Nurse(20,222);
        
        Nurse nurse3=new Nurse(30,333);
        
        Nurse nurse4=new Nurse(40,444);
        
        Nurse nurse5 = new Nurse(50,555);
        
        patients.add(patient1);
        patients.add(patient2);
        patients.add(patient3);
        patients.add(patient4);
        patients.add(patient5);
        nurse.add(nurse1);
        nurse.add(nurse2);
        nurse.add(nurse3);
        nurse.add(nurse4);
        nurse.add(nurse5);
        //doctors.add("");
        doctors.add("Amir Hassani");
        doctors.add("Ali Hassani");
        doctors.add("Aref Hassani");
        doctors.add("Reza Hassani");
        doctors.add("Mahdi Hassani");
        

        System.out.println("Welcom UUT`s Hospital\nplease choose one of them:");
        System.out.print("1)Nurse\n2)Recpies\n\nplease Enter your choose:");
        Scanner input=new Scanner(System.in);
        int choose=input.nextInt();

        while(true){
            int counter=0;
            try{
                if(choose==1){
                for(int i=0;i<3;i++){
                    System.out.print("Enter your nurse code:");
       
                    code=input.nextInt();
                    System.out.print("Enter your nurse password:");
                    int password=input.nextInt();
                    if (check(code, password)){
                        break;
                    }
                    if(check(code, password)==false){
                        throw new MyException("your code or password not correct!!!");
                    }
                    counter++;
                }
                if(counter == 3){
                System.out.println("*You do not have premision to access the appliation*");
                break;
                }
            
            System.out.print("Choose one of them:\n1)Updating the patient file\n2)Change password\nyour choise:");
            choose2=input.nextInt();
            try{
                if(choose2==1){
                System.out.print("please enter the desired patient code:");
                patient_code = input.nextInt();
                if(check(patient_code)){
                    System.out.print("Choose an option:\n1)add drug\n2)remove drug\n3)edit drug\nYour choise:");
                    int entekhab = input.nextInt();
                    try{
                       if(entekhab==1){ 
                        System.out.print("Choose the name of the desired drug:\n1)Staminophen\n2)codeein\n3)diclofenak\n4)piroxikam\n5)serom\nyour choise:");
                        int drug=input.nextInt();
                        String newdrug=drugs.get(drug-1);
                        for(Patients i:patients){
                            if(i.get_code() == patient_code){
                                
                                i.addDrug(newdrug);
            
                            }
                            if(i.get_code() != patient_code){
                                throw new MyException("you cant add drug!!");
                            }
                                
                        }
                    }

                    if(entekhab==2){
                        for(Patients i: patients){
                            if(i.get_code() == patient_code){
                                int index=patients.indexOf(i);
                                System.out.println("Do you want to delete the drugs:(yes/no)\nyour choise:");
                                String start=input.nextLine();
                                if( "yes".equals(start)) {
                                    i.removeDrug(index);
                                }
                            }
                            if(i.get_code() != patient_code){
                                throw new MyException("you cant remove the drugs!!!");
                            }
                        }
            
                    }
                    if(entekhab==3){
                                    for(Patients i: patients){
                                        if(i.get_code() == patient_code){
                                            int index=patients.indexOf(i);
                                            System.out.print("Enter new drug:\n1)Staminophen\n2)codeein\n3)diclofenak\n4)piroxikam\n5)serom\nyour choise:");
                                            int drug=input.nextInt();
                                            String edit=drugs.get(drug-1);
                                            i.editDrug(index, edit);
                                        }
                                        if(i.get_code() != patient_code){
                                            throw new MyException("you cant edit the drugs");
                                        }
                                    }
            
                                }
                                     
                            
                            }catch(Exception e){
                                System.out.println("Error:"+e.getMessage());
                            } 
                    }
                    else{
                    throw new MyException("your choise not correct!!!");
                    }
                if(check(patient_code)){
                        throw new MyException("the patient code is not correct!!");
                    }
                    
            }   
                if(choose2 == 2){
                        try{
                           System.out.println("\t<<CHANGING PASSWORD>>");
                            System.out.print("Enter your current password:");
                            int current_pass=input.nextInt();
                            if(check(code,current_pass)){
                                System.out.print("Enter new password:");
                                int new_pass=input.nextInt();
                                for(Nurse i:nurse){
                                    if(i.getcode()==code && i.getpass()==current_pass){
                                         i.changepass(new_pass); 
                                    }
                                } 
                            }
                            if(check(code,current_pass)==false){
                            throw new MyException("your current password is not correct!!");
                            }
                        }catch(Exception e){ 
                            System.out.println("error:"+e.getMessage());
                        }
                
                    }
                else{
                    throw new MyException("you entered wrong number!!!");
                }
                
            }catch(Exception e){
                System.out.println("Error:"+e.getMessage());
            }
                
                     
            }
            


            if(choose==2){
               System.out.print("Choose one of the options below:\n1)Add new patient\n2)Remove the  patient\n3)Patient search\n4)Display all patients`record\nYour choise:"); 
               int choose3 = input.nextInt();
               if(choose3==1){
                   
                       ArrayList<String> newdrugs = new ArrayList<>();
                       System.out.print("\t<<ADDING PATIENT>>");
                       System.out.print("Please enter patient information...\nEnter patient code:");
                       int new_patient_code=input.nextInt();
                       System.out.print("First Name & last name:");
                       String pname=input.next();
                       System.out.print("Enter doctor name:\n1)Amir Hassani\n2)Ali Hassani\n3)Aref Hassani\n4)Reza Hassani\n5)Mahdei Hassani\nyour choise:");
                       int doctorname=input.nextInt();
                       String pdoctor =doctors.get(doctorname-1);
                       System.out.print("Date of hospitalization:");
                       int pdate=input.nextInt();
                       System.out.print("Enter the drugs:\n1)Staminophen\n2)codeein\n3)diclofenak\n4)piroxikam\n5)serom\nyour choise:");                      
                       int drug=input.nextInt();
                       String newdrug=drugs.get(drug-1);
                       newdrugs.add(newdrug);
                       Patients patient = new Patients(new_patient_code,pname,pdoctor,pdate,newdrugs);
                       System.out.println("The new patient was added!!!");
                          
               }
                else if(choose3==2){
                       System.out.println("\t<<REMOVE PATIENT>>");
                       System.out.print("Enter patient code:");
                       int code1=input.nextInt();
                       for(Patients i:patients){
                           if(i.get_code()==code1){
                               patients.remove(i);
                               System.out.println("your patient was removed!!!");
                            if(i.get_code()!=code1)  {
                                throw new MyException("you cant remove the patient");
                            }
                        break;   
                           }
                       }
               }
                else if(choose3==3){
                    System.out.println("\t<<Patient search>>");
                    System.out.print("Enter patient code:");
                    int code2=input.nextInt();
                    for(Patients i:patients){
                        if(i.get_code()==code2){
                            System.out.println("the patient name:"+i.get_name());
                            System.out.println("the doctor name:"+i.get_doctor());
                            System.out.println("the date of hospitalization:"+i.get_date());
                            System.out.println("the patient`drug:"+i.get_drug());                                   
                        }
                        if(i.get_code()!=code2){
                            throw new MyException("you entered wrong code!!");
                        }
                    }
                               
                }
                else if(choose3==4){
                    System.out.println("\t<<Display all patients`record>>");
                    for(Patients i:patients){
                        System.out.println(i.get_name());
                       }   
                }
                else{
                    counter++;
                    throw new MyException("you entered wrong number!!!");
                    
                    
                }
                       
                           
                       }

                
            }catch(Exception e){
                System.out.println("Error:"+e.getMessage());
            }
                                   
               }
            }       
                                    
                      
                        
                    
                    

                        
//                    }
//                    else{
//                        counter++;
//                    }
                    
                
                


    public static  boolean  check(int code, int password){
        for(Nurse i:nurse){
            if(i.getcode() == code && i.getpass() == password){
                return true;
            }
        }
        return false;
    }
    public static  boolean  check(int patient_code){
        for(Patients i: patients){
            if(i.get_code() == patient_code){
                return true;
            }
        }
        return false;
        }

    
    
}
