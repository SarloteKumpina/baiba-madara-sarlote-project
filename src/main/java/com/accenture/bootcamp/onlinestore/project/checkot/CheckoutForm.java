package com.accenture.bootcamp.onlinestore.project.checkot;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class CheckoutForm {

    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phoneNumber;;

    @Override
    public String toString() {
        return "CheckoutForm{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
