package com.example.firebasego.AddJob;

public class ItemDataModel {
    int ExpendeId;
    String ExpenseName;

    public ItemDataModel(int expendeId,String expenseName){
        ExpendeId=expendeId;
        ExpenseName=expenseName;
    }
    public int getExpendeId(){return ExpendeId;}

    public String getExpenseName(){return  ExpenseName;}
}
