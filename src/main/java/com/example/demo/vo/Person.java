package com.example.demo.vo;

/**
 * Created by Administrator on 2017/6/4.
 */
public class Person {

    private int personId;

    private String personNm;

    public Person() {
        super();
    }

    public Person(int personId, String personNm) {
        this.personId = personId;
        this.personNm = personNm;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getPersonNm() {
        return personNm;
    }

    public void setPersonNm(String personNm) {
        this.personNm = personNm;
    }
}
