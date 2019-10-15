package com.example.demo.models;
public class SalaryExpenses {

    private long id;
    private long Employee_id;
    private long Expense_id;

    public SalaryExpenses(long id, long employee_id, long expense_id) {
        this.id = id;
        Employee_id = employee_id;
        Expense_id = expense_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEmployee_id() {
        return Employee_id;
    }

    public void setEmployee_id(long employee_id) {
        Employee_id = employee_id;
    }

    public long getExpense_id() {
        return Expense_id;
    }

    public void setExpense_id(long expense_id) {
        Expense_id = expense_id;
    }

}