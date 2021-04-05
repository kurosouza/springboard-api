package org.springboard.services;

import javax.enterprise.context.ApplicationScoped;

import io.nem.symbol.sdk.model.account.Account;
import io.nem.symbol.sdk.model.network.NetworkType;

@ApplicationScoped
public class SymbolBlockchainService {

    public Account generateSymbolWallet() {
        Account account = Account.generateNewAccount(NetworkType.TEST_NET);
        return account;
    }

}
