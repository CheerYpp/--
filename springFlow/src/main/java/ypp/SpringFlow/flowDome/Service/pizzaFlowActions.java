package ypp.SpringFlow.flowDome.Service;

import org.springframework.stereotype.Service;
import ypp.SpringFlow.flowDome.domain.Order;
import ypp.SpringFlow.flowDome.domain.PaymentDetails;

@Service
public class pizzaFlowActions {
    public void  lookupCustomer(String phoneNumber){
        System.out.println("pizzaFlowActions Running ");
    }

    public void saveOrder(Order order) {
        System.out.println("Save Order Start ....");
    }

    public void verifyPayment(PaymentDetails paymentDetails) {
        System.out.println("Verify Payment Start ...");
    }
}
