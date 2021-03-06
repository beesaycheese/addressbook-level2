package seedu.addressbook.commands;
import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;

import java.util.List;


/**
 * Sorts all persons in the address book to the user.
 */
public class SortCommand extends Command {

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts all persons in the address book in alphabetical order.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        UniquePersonList allPersons = addressBook.getAllPersons();
        allPersons.sorts();
        List<ReadOnlyPerson> sortedList = allPersons.immutableListView();
        return new CommandResult(getMessageForPersonListShownSummary(sortedList), sortedList);
    }

}
