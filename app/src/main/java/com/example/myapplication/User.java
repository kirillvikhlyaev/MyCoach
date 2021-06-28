package com.example.myapplication;
import android.widget.Toast;

public class User {
    private int age;
    private int height;
    private double weight;
    private int AmountOfWater;
    private int TotalAmountOfWater;
    private int TotalAmountOfWorkouts;
    private int TotalAmountLostWeight;
    private int CompletedWorkouts;
    private int CompletedPrograms;
    private boolean ach1, ach2, ach3, ach4, ach5;
    private String name, sex, typeOfProgram;
    private String dayOfWeek;
    private double phStrain;

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setAmountOfWater(int amountOfWater) {
        AmountOfWater = amountOfWater;
    }

    public void setCompletedWorkouts(int completedWorkouts) {
        CompletedWorkouts = completedWorkouts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setTypeOfProgram(String typeOfProgram) {
        this.typeOfProgram = typeOfProgram;
    }

    public void setDayOfWeek(String dayOfWeek) {this.dayOfWeek = dayOfWeek; }

    public void setTotalAmountOfWater(int totalAmountOfWater) {TotalAmountOfWater = totalAmountOfWater;}

    public void setTotalAmountOfWorkouts(int totalAmountOfWorkouts) {TotalAmountOfWorkouts = totalAmountOfWorkouts;}

    public void setTotalAmountLostWeight(int totalAmountLostWeight) {TotalAmountLostWeight = totalAmountLostWeight;}

    public void setAch1(boolean ach1) {
        this.ach1 = ach1;
    }

    public void setAch2(boolean ach2) {
        this.ach2 = ach2;
    }

    public void setAch3(boolean ach3) {
        this.ach3 = ach3;
    }

    public void setAch4(boolean ach4) {
        this.ach4 = ach4;
    }

    public void setAch5(boolean ach5) {
        this.ach5 = ach5;
    }

    public void setCompletedPrograms(int completedPrograms) {
        CompletedPrograms = completedPrograms;
    }

    public int getCompletedPrograms() {
        return CompletedPrograms;
    }

    public boolean getAch1() {return ach1;}

    public boolean getAch2() {return ach2;}

    public boolean getAch3() {return ach3;}

    public boolean getAch4() {return ach4;}

    public boolean getAch5() {return ach5;}

    public int getTotalAmountOfWater() {return TotalAmountOfWater;}

    public int getTotalAmountOfWorkouts() {return TotalAmountOfWorkouts;}

    public int getTotalAmountLostWeight() {return TotalAmountLostWeight;}

    public String getDayOfWeek() {return dayOfWeek; }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public int getAmountOfWater() {
        return AmountOfWater;
    }

    public int getCompletedWorkouts() {
        return CompletedWorkouts;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getTypeOfProgram() {
        return typeOfProgram;
    }

    public int addWater (int ml, int max) {
        if (AmountOfWater < max) AmountOfWater += ml;
        return AmountOfWater;
    }
    public double calcIndex(double weight, int height) {
        return (weight / (height * height))*10000;
    }
    public void calcWater() {
        double howManyWaterIsNeeded;
        switch(sex) {
            case "мужской":
                howManyWaterIsNeeded = ((weight * 0.03) + (phStrain * 0.4)) * 100;
                break;
            case "женский":
                howManyWaterIsNeeded = ((weight * 0.04) + (phStrain * 0.6)) * 100;
                break;
        }
    } //Высчитывает количество воды, которое необходимо выпить
}
