package org.xproce.service;
import org.xproce.stubs.BankServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.xproce.stubs.Banck;
import org.xproce.stubs.BankServiceGrpc;

public class BankGrpcService extends BankServiceGrpc.BankServiceImplBase {
    @Override public void convert(Banck.ConvertCurrencyRequest request, StreamObserver<Banck.ConvertCurrencyResponse> responseObserver) {
        String currencyFrom = request.getCurrencyFrom();
        String currencyTo = request.getCurrencyTo();
        double amount = request.getAmount();
        Banck.ConvertCurrencyResponse response = Banck.ConvertCurrencyResponse.newBuilder()
                .setCurrencyFrom(currencyFrom)
                .setCurrencyTo(currencyTo)
                .setAmount(amount)
                .setResult(amount * 12.14)
                .build(); responseObserver.onNext(response); responseObserver.onCompleted();
    }
}
