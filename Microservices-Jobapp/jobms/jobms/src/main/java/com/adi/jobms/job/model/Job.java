package com.adi.jobms.job.model;

import jakarta.persistence.*;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private double Salary;
    private String location;
    private long companyId;

    public Job(){
        // this(System.currentTimeMillis() + new Random().nextInt(10000),"DEfault","Default",0,"Default");
    }

    public Job(long id, String title, String description, double salary, String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.Salary = salary;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", Salary=" + Salary +
                ", location='" + location + '\'' +
                '}';
    }
}
