package com.university.factory;

import com.university.evaluation.Evaluation;
import com.university.person.Student;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Factory {
    public abstract ArrayList<? extends Evaluation> createSelf(ArrayList<? extends String[]> DataList);


}
