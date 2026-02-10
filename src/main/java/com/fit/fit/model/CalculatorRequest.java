package com.fit.fit.model;

import com.fit.fit.enums.Activity;
import com.fit.fit.enums.Gender;

import java.util.Objects;

public class CalculatorRequest {

    private final int weight;
    private final int height;
    private final int age;
    private final Activity activity;
    private final Gender gender;

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public Activity getActivity() {
        return activity;
    }

    public Gender getGender() {
        return gender;
    }

    public CalculatorRequest(int weight, int height, int age, Activity activity, Gender gender) {
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.activity = activity;
        this.gender = gender;


    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CalculatorRequest that = (CalculatorRequest) o;
        return getWeight() == that.getWeight() && getHeight() == that.getHeight() && getAge() == that.getAge() && getActivity() == that.getActivity() && getGender() == that.getGender();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWeight(), getHeight(), getAge(), getActivity(), getGender());
    }
}
