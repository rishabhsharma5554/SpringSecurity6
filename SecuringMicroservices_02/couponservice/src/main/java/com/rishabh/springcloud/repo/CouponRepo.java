package com.rishabh.springcloud.repo;

import com.rishabh.springcloud.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepo extends JpaRepository<Coupon,Long> {
}
