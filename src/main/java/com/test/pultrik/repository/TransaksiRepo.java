package com.test.pultrik.repository;

import com.test.pultrik.model.Transaksi;
import com.test.pultrik.model.User;
import com.test.pultrik.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransaksiRepo extends JpaRepository<Transaksi, Long> {

    List<Transaksi> findByUser(User user);
    List<Transaksi> findByVoucher(Voucher voucher);
    List<Transaksi> findByUserAndVoucher(User user, Voucher voucher);

}
