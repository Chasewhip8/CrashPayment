package net.crashcraft.crashpayment.payment.providers;

import net.crashcraft.crashpayment.payment.PaymentProvider;
import net.crashcraft.crashpayment.payment.ProviderInitializationException;
import net.crashcraft.crashpayment.payment.TransactionRecipe;
import net.crashcraft.crashpayment.payment.TransactionType;

import java.util.UUID;
import java.util.function.Consumer;

public class FakePaymentProvider implements PaymentProvider {
    @Override
    public String getProviderIdentifier() {
        return "Fake Transaction Processor";
    }

    @Override
    public boolean checkRequirements() {
        return true;
    }

    @Override
    public void setup() throws ProviderInitializationException {

    }

    @Override
    public void makeTransaction(UUID user, TransactionType type, String comment, double amount, Consumer<TransactionRecipe> callback) {
        callback.accept(new TransactionRecipe(user, amount, comment));
    }

    @Override
    public void getBalance(UUID user, Consumer<Double> callback) {
        callback.accept(Double.MAX_VALUE);
    }
}
