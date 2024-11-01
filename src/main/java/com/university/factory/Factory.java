package com.university.factory;

import java.util.ArrayList;

public interface Factory <T extends Factorable> {

    public  ArrayList<T> createSelfList(ArrayList<String[]> dataList);
}
