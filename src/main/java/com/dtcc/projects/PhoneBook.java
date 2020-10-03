package com.dtcc.projects;

import java.util.*;

public class PhoneBook {

    Map<String, List<String>> phoneBookMap;

    public PhoneBook(){
        this(new LinkedHashMap<String, List<String>>());
    }

    public PhoneBook(Map<String, List<String>> map){
        this.phoneBookMap = map;
    }

    public void add(String name, String phoneNumber){
        List<String> phoneNumberList = phoneBookMap.get(name);
        if(phoneNumberList !=null ){
            phoneNumberList.add(phoneNumber);
        }
        else{
            phoneBookMap.put(name,Collections.singletonList(phoneNumber));
        }
    }



    void addAll(String name, String[] phoneNumbers){
        phoneBookMap.put(name, Arrays.asList(phoneNumbers));
    }


    void remove(String name){
        phoneBookMap.remove(name);
    }

    boolean hasEntry(String name){
        return phoneBookMap.containsKey(name);
    }

    List<String> lookup(String name){
        List<String> number = phoneBookMap.get(name);
        return number;
    }


    String reverseLookup(String phoneNumber){
        Set<String> keys = phoneBookMap.keySet();
        String nameResult = "Does not exist";
        for(String name : keys){
            for (String number : phoneBookMap.get(name)){
                if(number.equals(phoneNumber)){
                    nameResult = name;
                }
            }
        }
        return nameResult;
    }

    List<String> getAllContactNames(){
        ArrayList<String> namesList = new ArrayList<>();
        Set<String> keys = phoneBookMap.keySet();
        for(String name : keys){
            namesList.add(name);
        }
        return namesList;
    }
}
