package org.SuzyBarbieToy.models;

public class User {
    public Long getWalletId() {
        return walletId;
    }

    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", walletId=" + walletId +
                '}';
    }

    private Long id;
    private Long walletId;


}
