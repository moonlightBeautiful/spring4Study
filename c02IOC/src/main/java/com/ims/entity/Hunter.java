package com.ims.entity;

import java.util.*;

//abstract
public class Hunter {

    private int id;
    private String name;
    private int age;
    /*    private Dog dog;*/
    private Dog dog = new Dog();  //级联属性注入，需要先实例化
    private List<String> hobbies = new ArrayList<String>();
    private Set<String> loves = new HashSet<String>();
    private Map<String, String> works = new HashMap<String, String>();
    private Properties addresses = new Properties();

    public Hunter() {
        super();
        // TODO Auto-generated constructor stub
    }


    public Hunter(int id, String name, int age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    /**
     * 构造方法自动注入使用
     *
     * @param dog
     */
    public Hunter(Dog dog) {
        super();
        this.dog = dog;
    }

    public Set<String> getLoves() {
        return loves;
    }


    public void setLoves(Set<String> loves) {
        this.loves = loves;
    }


    public List<String> getHobbies() {
        return hobbies;
    }


    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }


    public Map<String, String> getWorks() {
        return works;
    }


    public void setWorks(Map<String, String> works) {
        this.works = works;
    }


    public Properties getAddresses() {
        return addresses;
    }


    public void setAddresses(Properties addresses) {
        this.addresses = addresses;
    }


    public Dog getDog() {
        return dog;
    }

    //方法注入用
    /*public abstract Dog getDog();*/

    public void setDog(Dog dog) {
        this.dog = dog;
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


    @Override
    public String toString() {
        return "People [id=" + id + ", name=" + name + ", age=" + age
                + ", dog=" + dog + ", hobbies=" + hobbies + ", loves=" + loves
                + ", works=" + works + ", addresses=" + addresses + "]";
    }


}
