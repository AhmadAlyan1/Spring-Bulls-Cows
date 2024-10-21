package hac.beans;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a table containing rows of type {TableRow}.
 */
@Component
public class Table implements Serializable {

    /**
     * ArrayList to save TableRows(guess, bulls, cows)
     */
    private ArrayList<TableRow> table;

    /**
     * Default constructor, Initializes an empty table.
     */
    public Table () {
        this.table = new ArrayList<>();
    }

    /**
     * Gets the list of rows in the table.
     *
     * @return The list of rows.
     */
    public ArrayList<TableRow> getTable() {
        return table;
    }

    /**
     * Sets the list of rows in the table.
     *
     * @param table The list of rows to set.
     */
    public void setTable(ArrayList<TableRow> table) {
        this.table = table;
    }

    /**
     * Adds a new row to the first of the table.
     *
     * @param tableRow The row to add.
     */
    public void add(TableRow tableRow) {
            this.table.add(0,tableRow);
    }

    /**
     * Clears the table by removing all rows.
     */
    public void clear() {
        this.table.clear();
    }

}
