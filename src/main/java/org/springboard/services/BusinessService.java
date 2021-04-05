
package org.springboard.services;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.springboard.entities.Business;

@ApplicationScoped
public class BusinessService {
    
    @Transactional
    public Business createBusinessAccount(Business businessAccount) {
        businessAccount.persist();  

        return businessAccount;
    }

    @Transactional
    public void setBusinessAccountWalletInfo(Long businessId, String walletAddress, String walletPKey) {
        Business business = Business.findById(businessId);
        business.bcAddress = walletAddress;
        business.bcPKey = walletPKey;

        business.persist();
    }
    
}
