package com.test.pultrik.repository;

import com.test.pultrik.model.Operator;
import com.test.pultrik.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoucherRepo extends JpaRepository<Voucher, Long> {

    List<Voucher> findByOperator(Operator operator);
    List<Voucher> findByOperatorIdOperator(long idOperator);
    Voucher findByIdVoucher(long idVoucher);
    
}
