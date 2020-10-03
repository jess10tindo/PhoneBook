package com.dtcc.projects;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PhoneBookTest {


    @Test
    public void addTest(){
        PhoneBook phoneBook = new PhoneBook();
        String name = "Zan";
        String phoneNumber = "978-857-8677";
        phoneBook.add(name, phoneNumber);
        Assert.assertTrue(phoneBook.phoneBookMap.containsKey(name));
        Assert.assertEquals(phoneNumber, phoneBook.phoneBookMap.get(name).get(0));
    }

    @Test
    public void addAllTest(){
        PhoneBook phoneBook = new PhoneBook();
        String name = "Zan";
        String[] numberArray = {"978-857-2345", "864-463-8245", "147-523-8134"};

        phoneBook.addAll(name, numberArray);

        Assert.assertTrue(phoneBook.phoneBookMap.containsKey(name));
        Assert.assertEquals(Arrays.asList(numberArray), phoneBook.phoneBookMap.get(name));
    }

    @Test
    public void removeTest() {
        PhoneBook book = new PhoneBook();
        String name1 = "Zan";
        String[] numberArray1 = {"978-857-2345", "864-463-8245", "147-523-8134"};
        String name2 = "Cedric";
        String[] numberArray2 = {"978-857-7345"};

        book.addAll(name1, numberArray1);
        book.addAll(name2, numberArray2);

        book.remove(name2);

        Assert.assertFalse(book.phoneBookMap.containsKey(name2));
    }

    @Test
    public void hasEntryTest(){
        PhoneBook book = new PhoneBook();
        String name1 = "Zan";
        String[] numberArray1 = {"978-857-2345", "864-463-8245", "147-523-8134"};
        book.addAll(name1, numberArray1);

        Assert.assertEquals(true, book.hasEntry(name1));
    }

    @Test
    public void lookupTest(){
        PhoneBook book = new PhoneBook();
        String name1 = "Zan";
        String[] numberArray1 = {"978-857-2345", "864-463-8245", "147-523-8134"};
        String name2 = "Cedric";
        String[] numberArray2 = {"978-857-7345"};

        book.addAll(name1, numberArray1);
        book.addAll(name2, numberArray2);

        Assert.assertEquals(Arrays.asList(numberArray2), book.lookup(name2));
    }

    @Test
    public void reverseLookupTest(){
        PhoneBook book = new PhoneBook();
        String name1 = "Zan";
        String[] numberArray1 = {"978-857-2345", "864-463-8245", "147-523-8134"};
        String name2 = "Cedric";
        String[] numberArray2 = {"978-857-7345"};

        book.addAll(name1, numberArray1);
        book.addAll(name2, numberArray2);

        Assert.assertEquals(name2, book.reverseLookup("978-857-7345"));
    }

    @Test
    public void getAllContactNamesTest(){
        PhoneBook book = new PhoneBook();
        String name1 = "Zan";
        String[] numberArray1 = {"978-857-2345", "864-463-8245", "147-523-8134"};
        String name2 = "Cedric";
        String[] numberArray2 = {"978-857-7345"};

        book.addAll(name1, numberArray1);
        book.addAll(name2, numberArray2);

        ArrayList<String> namesList = new ArrayList<>();
        namesList.add(name1);
        namesList.add(name2);

        Assert.assertEquals(namesList, book.getAllContactNames());
    }

}
