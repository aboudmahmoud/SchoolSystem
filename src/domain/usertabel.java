
package domain;


public class usertabel {
    private String user_name; 
     private  String pass; 
      private  String dap; 

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDap() {
        return dap;
    }

    public void setDap(String dap) {
        this.dap = dap;
    }

    public usertabel(String user_name, String pass, String dap) {
        this.user_name = user_name;
        this.pass = pass;
        this.dap = dap;
    }
}
