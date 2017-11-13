package com.fredericboisguerin.insa;

public class Contact {
        private final String name ;
        private final String email ;
        private final String phoneNumber;

   public Contact (String name, String email, String phoneNumber){
        this.name = name ;
        this.email = email ;
        this.phoneNumber = phoneNumber ;
    }

    @Override
    public String toString() {
        return name + ", " + email + ", " + phoneNumber ;
    }

}
