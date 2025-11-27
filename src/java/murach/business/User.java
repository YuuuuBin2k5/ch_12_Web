package murach.business;

import java.io.Serializable;

public class User implements Serializable {
    //implements Serializable
    //Quy tắc get - set
    // Quy tắc Name Conventions
    
    // Trường cơ bản
    private String firstName;
    private String lastName;
    private String email;
    
    // Constructor mặc định
    public User() {
        firstName = "";
        lastName = "";
        email = "";
     
    }
    
    public User(String firstName,String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
     
    }
    
  
    
    // Constructor đầy đủ (Bạn có thể bỏ qua nếu chỉ dùng constructor mặc định và setters)
    // Tôi chỉ liệt kê các getters/setters cho mục đích này

    // --- GETTERS VÀ SETTERS CŨ ---
    public String getFirstName() { 
        return firstName; 
    }
    
    public void setFirstName(String firstName) { 
        this.firstName = firstName; 
    }

    public String getLastName() { 
        return lastName; 
    }
    
    public void setLastName(String lastName) { 
        this.lastName = lastName; 
    }

    public String getEmail() { 
        return email; 
    }
    
    public void setEmail(String email) { 
        this.email = email; 
    }

}