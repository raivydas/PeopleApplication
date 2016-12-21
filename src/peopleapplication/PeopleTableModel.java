/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peopleapplication;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 *
 * @author Raivydas
 */
public class PeopleTableModel extends AbstractTableModel {

    private static final int ID = 0;
    private static final int LAST_NAME = 1;

    private String[] colNames = { "Id", "Last Name" };
    private List<Person> peopleList;

    public PeopleTableModel(List<Person> peopleList) {
        this.peopleList = peopleList;
    }

    @Override
    public String getColumnName(int col) {
        return colNames[col];
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public int getRowCount() {
        return peopleList.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch(col) {
            case ID:
                return peopleList.get(row).getId();
            case LAST_NAME:
                return peopleList.get(row).getLastName();
            default:
                return new Person();
        }
    }

    @Override
    public Class getColumnClass(int col) {
        return this.getValueAt(0, col).getClass();
    }
}
