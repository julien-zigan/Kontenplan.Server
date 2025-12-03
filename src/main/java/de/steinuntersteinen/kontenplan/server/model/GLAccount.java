package de.steinuntersteinen.kontenplan.server.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name="gl_accounts")
public class GLAccount {

    @Id
    @Column(name="no")
    private String no;

    @Column(columnDefinition="ENUM('class', 'category', 'account')", name="type")
    @Enumerated(EnumType.STRING)
    private GLAccountType type;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="balance")
    private BigDecimal balance;

    @Column(name="parent_no")
    private String parentNo;

    public GLAccount() {}

    public GLAccount(String no, GLAccountType type, String name, String description, BigDecimal balance, String parentNo) {
        this.no = no;
        this.type = type;
        this.name = name;
        this.description = description;
        this.balance = balance;
        this.parentNo = parentNo;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public GLAccountType getType() {
        return type;
    }

    public void setType(GLAccountType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getParentNo() {
        return parentNo;
    }

    public void setParentNo(String parentNo) {
        this.parentNo = parentNo;
    }

    @Override
    public String toString() {
        return "GLAccount{" +
                "no='" + no + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", balance=" + balance +
                ", parentNo='" + parentNo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GLAccount glAccount = (GLAccount) o;
        return Objects.equals(no, glAccount.no) && type == glAccount.type && Objects.equals(name, glAccount.name) && Objects.equals(description, glAccount.description) && Objects.equals(balance, glAccount.balance) && Objects.equals(parentNo, glAccount.parentNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, type, name, description, balance, parentNo);
    }
}
