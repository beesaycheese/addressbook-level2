package seedu.addressbook.commands;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.testng.AssertJUnit.assertEquals;


public class SortCommandTest {
    
    private AddressBook addressBook;
    private List<ReadOnlyPerson> sortedList;
    private List<? extends ReadOnlyPerson> expectedList;
    
    @BeforeTest
    private void initialiseList() {
        Person AdamBrown;
        Person BetsyChoo;
        Person CharlieDickson;
        Person EstherPotato;
        
        try {
            AdamBrown = new Person(new Name("Adam Brown"), new Phone("111111", false),
                    new Email("adam@gmail.com", false), new Address("111 alpha street", false), Collections.emptySet());

            CharlieDickson = new Person(new Name("Charlie Dickson"), new Phone("333333", false),
                    new Email("charlie.d@nus.edu.sg", false), new Address("333 gamma street", false), Collections.emptySet());

            EstherPotato = new Person(new Name("EstherPotato"), new Phone("555555", false),
                    new Email("esther@not.a.real.potato", false), new Address("555 epsilon street", false), Collections.emptySet());

            BetsyChoo = new Person(new Name("Betsy Choo"), new Phone("222222", false),
                    new Email("benchoo@nus.edu.sg", false), new Address("222 beta street", false), Collections.emptySet());

            addressBook = new AddressBook(new UniquePersonList(AdamBrown, EstherPotato, CharlieDickson, BetsyChoo));
            
            UniquePersonList allPersonSorted = new UniquePersonList(AdamBrown, BetsyChoo, CharlieDickson, EstherPotato);
            expectedList = allPersonSorted.immutableListView();
            

        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    @Test
    public void testSort() {
        
        SortCommand sortCommand = new SortCommand();
        sortCommand.setData(addressBook, sortedList);
        CommandResult result = sortCommand.execute();
        Optional<List<? extends ReadOnlyPerson>> resultList = result.getRelevantPersons();
        
        assertEquals(Optional.ofNullable(expectedList), resultList);
    }
}
