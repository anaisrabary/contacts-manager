package com.fredericboisguerin.insa;

public class Contact {
        private final String name ;
        private final String email ;
        private final String phoneNumber;

   public Contact (String name, String email, String phoneNumber){
           this.name = name ;
           this.email = email ;
           this.phoneNumber = phoneNumber;
    }


    public Boolean Is_part_of_name(String contains){
        return (this.name.toLowerCase()).contains(contains) ;
    }


    @Override
    public String toString() {
       if (email==null){
           if (phoneNumber==null)
               return name;
           else
               return name + ", "+ phoneNumber;
       }else
           return name + ", " + email + ", " + phoneNumber ;
    }

}
