package android.learning.trace.android_learning_trace.view.activity.XML;

import android.support.annotation.NonNull;

public class Person {

    private int id;
    private String name;
    private int age;
    private String gender;
    private String tel;

    public Person(int id, String name, int age, String gender, String tel) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.tel = tel;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @NonNull
    @Override
    public String toString() {
        return
                "id--"
                        + id
                        + " name--"
                        + name
                        + " age--"
                        + age
                        + " gender--"
                        + gender
                        + "  tel--"
                        + tel;
    }
}

