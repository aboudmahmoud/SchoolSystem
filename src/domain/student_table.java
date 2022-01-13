
package domain;

public class student_table {
    private String fname ,lname ,dep,ader; 

    public String getAder() {
        return ader;
    }

    public void setAder(String ader) {
        this.ader = ader;
    }
    private int id;
    
   public student_table(int id,String fname, String lname, String dep,String ader) {
         this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.dep = dep;
        this.ader=ader;
       
    }
  

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

 
    
}
