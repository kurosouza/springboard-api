package org.springboard;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Qualifier;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springboard.entities.Business;
import org.springboard.services.BusinessService;
import org.springboard.services.SymbolBlockchainService;

import io.nem.symbol.sdk.model.account.Account;

@Path("/api")
public class ApiResource {

    @Inject
    BusinessService businessService;

    @Inject
    SymbolBlockchainService blockchainService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }

    @POST
    @Path("/business")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerBusinessAccount(Business businessInfo) {
        try {
            Business business = businessService.createBusinessAccount(businessInfo);
            return Response.ok(business).build();
        } catch (Exception ex) {
            return Response.serverError().build();
        }
    }

    @GET
    public Map<String, String> generateWallet(Long businessId) {
        Map<String, String> result = new HashMap<>();
        Account account = blockchainService.generateSymbolWallet();
        businessService.setBusinessAccountWalletInfo(businessId, account.getAddress().plain(), account.getPrivateKey());
        result.put("WALLET_ADDRESS", account.getAddress().plain());
        // result.put("WALLET_PKEY", account.getPrivateKey())
        return result;
    }
}