package info.kausar.psapi.reposityory;

import info.kausar.psapi.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    Payment findByOrderId(int orderId);
}
