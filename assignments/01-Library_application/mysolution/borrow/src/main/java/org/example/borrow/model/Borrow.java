package org.example.borrow.model;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "borrows")
public class Borrow {

    @Id
    private Long borrowId;

    private String customerId;

    private String bookId;

    private String notifyToPhoneNr;


}
