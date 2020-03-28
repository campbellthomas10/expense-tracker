package com.example.expensetracker.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "accounts")
@Entity
public class Account {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 3, max = 15)
    @Column(name = "username")
    private String username;

    @NotNull
    @Size(min = 3)
    @Column(name = "password")
    private String password;

    @OneToMany
    private List<Expense> expenses = new ArrayList<Expense>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
