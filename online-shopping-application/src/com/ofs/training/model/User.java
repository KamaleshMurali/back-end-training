/**
 * 
 */
package com.ofs.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;


/**
 * @author kamalesh.murali
 * @since Mar 4, 2019
 */
@Entity
@Table(name="USER")
@Proxy(lazy=false)
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name="email")
    private String email;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="address")
    private String address;
//    @Column(name="birth_date")
//    private Date birthDate;


    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

//    /**
//     * @return the birthDate
//     */
//    public Date getBirthDate() {
//        return birthDate;
//    }
//
//    /**
//     * @param birthDate the birthDate to set
//     */
//    public void setBirthDate(Date birthDate) {
//        this.birthDate = birthDate;
//    }

//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        builder.append("User [id=");
//        builder.append(id);
//        builder.append(", email=");
//        builder.append(email);
//        builder.append(", firstName=");
//        builder.append(firstName);
//        builder.append(", lastName=");
//        builder.append(lastName);
//        builder.append(", address=");
//        builder.append(address);
//        builder.append(", birthDate=");
//        builder.append(birthDate);
//        builder.append("]");
//        return builder.toString();
//    }
}
