package gr.hua.dit.ds.BloodBank.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "bloodtest")
public class BloodTest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    @NotBlank
    @Column(name="TestDate")
    private String TestDate;

    @NotBlank
    @Column(name="HemoglobinLevels")
    private String HemoglobinLevels;

    @NotBlank
    @Column(name="IronLevels")
    private String IronLevels;

    @NotBlank
    @Column(name="BloodPressureLevels")
    private String BloodPressureLevels;

    @NotBlank
    @Column(name="CholesterolLevels")
    private String CholesterolLevels;

    public BloodTest() {
    }

    public BloodTest(String TestDate, String HemoglobinLevels, String IronLevels, String BloodPressureLevels, String CholesterolLevels) {
        this.TestDate = TestDate;
        this.HemoglobinLevels = HemoglobinLevels;
        this.IronLevels = IronLevels;
        this.BloodPressureLevels = BloodPressureLevels;
        this.CholesterolLevels = CholesterolLevels;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "request_id")
    private Request request;

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Integer getId() {
        return id;
    }

    public String getTestDate() {
        return TestDate;
    }

    public String getHemoglobinLevels() {
        return HemoglobinLevels;
    }

    public String getIronLevels() {
        return IronLevels;
    }

    public String getBloodPressureLevels() {
        return BloodPressureLevels;
    }

    public String getCholesterolLevels() {
        return CholesterolLevels;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTestDate(String testDate) {
        TestDate = testDate;
    }

    public void setHemoglobinLevels(String hemoglobinLevels) {
        HemoglobinLevels = hemoglobinLevels;
    }

    public void setIronLevels(String ironLevels) {
        IronLevels = ironLevels;
    }

    public void setBloodPressureLevels(String bloodPressureLevels) {
        BloodPressureLevels = bloodPressureLevels;
    }

    public void setCholesterolLevels(String cholesterolLevels) {
        CholesterolLevels = cholesterolLevels;
    }

    @Override
    public String toString() {
        return "BloodTest{" +
                "id=" + id +
                ", TestDate='" + TestDate + '\'' +
                ", HemoglobinLevels='" + HemoglobinLevels + '\'' +
                ", IronLevels='" + IronLevels + '\'' +
                ", BloodPressureLevels='" + BloodPressureLevels + '\'' +
                ", CholesterolLevels='" + CholesterolLevels + '\'' +
                '}';
    }
}
