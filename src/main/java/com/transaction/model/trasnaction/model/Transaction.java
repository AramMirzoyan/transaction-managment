package com.transaction.model.trasnaction.model;

import com.transaction.model.trasnaction.model.enums.TransactionStatus;
import com.transaction.model.trasnaction.model.enums.TransactionType;
import com.transaction.model.trasnaction.model.enums.converter.LocalDatePersistenceConverter;
import com.transaction.model.trasnaction.model.enums.converter.TransactionStatusConverter;
import com.transaction.model.trasnaction.model.enums.converter.TransactionTypeConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(generator = "uuid", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;

    @Convert(converter = TransactionStatusConverter.class)
    @Column(name = "status_id")
    private TransactionStatus status;

    @Convert(converter = TransactionTypeConverter.class)
    @Column(name = "type_id")
    private TransactionType type;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @Convert(converter = LocalDatePersistenceConverter.class)
    @Column(name = "creat_date")
    private LocalDate creatDate;

    @Column(name = "balance")
    private  int balance;

    public Transaction() {
    }

    public Transaction(TransactionStatus status, TransactionType type, User user, Account account, LocalDate creatDate, int balance) {
        this.status = status;
        this.type = type;
        this.user = user;
        this.account = account;
        this.creatDate = creatDate;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public LocalDate getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(LocalDate creatDate) {
        this.creatDate = creatDate;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
