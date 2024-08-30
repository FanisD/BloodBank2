package gr.hua.dit.ds.BloodBank.entity;

import jakarta.persistence.*;

@Entity
@Table(name="requests")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @Column(name="FirstName")
    private String FirstName;

    @Column(name="LastName")
    private String LastName;

    @Column(name="Age")
    private String Age;

    @Column(name="BloodType")
    private String BloodType;

    @Column(name="LivingArea")
    private String LivingArea;

    @Column(name="PhoneNumber")
    private String PhoneNumber;

    @Column(name="LastDonationDate")
    private String LastDonationDate;

    @Column(name="UserEmail")
    private String UserEmail;

    @Column(name="Status")
    private String Status;

    @Column(name="Ready")
    public Boolean Ready;

    public Request() {
    }

    public Request(String firstName, String lastName, String age, String bloodType, String livingArea, String phoneNumber, String lastDonationDate, String userEmail, String status, Boolean ready) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Age = age;
        this.BloodType = bloodType;
        this.LivingArea = livingArea;
        this.PhoneNumber = phoneNumber;
        this.LastDonationDate = lastDonationDate;
        this.UserEmail = userEmail;
        this.Status = status;
        this.Ready = ready;
    }

    @OneToOne(mappedBy = "request",cascade = CascadeType.ALL)
    private BloodTest bloodTest;

    public BloodTest getBloodTest() {
        return bloodTest;
    }

    public void setBloodTest(BloodTest bloodTest) {
        this.bloodTest = bloodTest;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getReady() {
        return Ready;
    }

    public void setReady(Boolean ready) {
        Ready = ready;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setAge(String age) {
        Age = age;
    }

    public void setBloodType(String bloodType) {
        BloodType = bloodType;
    }

    public void setLivingArea(String livingArea) {
        LivingArea = livingArea;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setLastDonationDate(String lastDonationDate) {
        LastDonationDate = lastDonationDate;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getAge() {
        return Age;
    }

    public String getBloodType() {
        return BloodType;
    }

    public String getLivingArea() {
        return LivingArea;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getLastDonationDate() {
        return LastDonationDate;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Age='" + Age + '\'' +
                ", BloodType='" + BloodType + '\'' +
                ", LivingArea='" + LivingArea + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", LastDonationDate='" + LastDonationDate + '\'' +
                ", UserEmail='" + UserEmail + '\'' +
                ", Status='" + Status + '\'' +
                ", bloodTest=" + bloodTest +
                '}';
    }
}
