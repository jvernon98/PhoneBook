package com.zipcodewilmington.phonebook;

import java.security.cert.CertPath;
import java.util.*;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;
//    private Map<String,ArrayList<String>> book = new HashMap<>(); //a map to hold every persons info
//    private ArrayList<String> allCArray = new ArrayList<>();
//    final static String entryError = "No such entry exists"; //final to represent an error if the key/value does not exist
//
//    private final Map<String, List<String>> phonebook;


    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = (Map<String, List<String>>) map;
    }

    public PhoneBook() {
       this(new LinkedHashMap<>());
//        this.phonebook = new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber) {
        phonebook.putIfAbsent(name, Collections.singletonList(phoneNumber));
//        this.phonebook.put(name, Collections.singletonList(phoneNumber));
    }

    public void addAll(String name, String... phoneNumbers) {
        phonebook.putIfAbsent(name, List.of(phoneNumbers));
    }

    public void remove(String name) {
        phonebook.remove(name);
        //        if(hasEntry(name)){
//            phonebook.remove(name);
//        }
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }//method to check if entry exists in book field

//        return book.containsKey(name); //simplified if statement!! returns true


    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

//        String result = ""; //store the resulting string - all nums this person has
//        if (hasEntry(name)) { //if this name is an entry
//            ArrayList<String> returnNumbers = book.get(name); //create a new arraylist to store the list of numbers
//            for (String number : returnNumbers) { //for each number this person has
//                result += number + " "; // add to a string separated by spaces
//            }
//            result = result.trim(); //trim the ending and leading spaces
//            return result; //return the result after trimming
//        }
//        return entryError; //and if the entry does not exist, return error

    public String reverseLookup(String phoneNumber) {
        List<String> pn = Collections.singletonList(phoneNumber);
        Map<List<String>, String> inverseMap = new HashMap<>();
        phonebook.forEach((n, p) -> inverseMap.put(p, n));
        return inverseMap.get(pn);
    }

//        for(String key : book.keySet()){ // loop through every key in the book
//            ArrayList<String> numbers = book.get(key); //store the numbers for the current person
//            for (String num : numbers){ //loop through each number this person has
//                if(num.equals(phoneNumber)){ // if the current number in the loop is the same as the num being searched
//                    return key; //return the persons name
//                }
//            }
//        }
//        return entryError;
//    }


//    public void printAllC(){
//        Map<String, ArrayList<String>> allCBook = new TreeMap<>(book); //creates a new tree map to get all the entries
//        for (String key : allCBook.keySet()){ //loop through each key
//            String contactCard = key + " ";
//            ArrayList<String> numbers = allCBook.get(key); //grab the list of nums for the person at this iteration
//            for(String number : numbers){ //for each number they have
//                contactCard += number + " "; //add it to the string separated by a space
//            }
//            contactCard = contactCard.trim(); //trim the ending and leading white space from the contact card string
//            allCArray.add(contactCard); //add the string to the array
//            System.out.println(contactCard);//print out the contact card
//        }
    public List<String> getAllContactNames() {
        List<String> answer = new ArrayList<>(phonebook.keySet());
        return answer;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}

