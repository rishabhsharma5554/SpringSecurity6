package com.rishabh.springcloud.controllers;

import com.rishabh.springcloud.entity.Coupon;
import com.rishabh.springcloud.repo.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/couponapi")
public class CouponController {

    @Autowired
    private CouponRepo couponRepo;

    @PostMapping("/coupons")
    public Coupon createCoupon(@RequestBody Coupon coupon)
    {
        return couponRepo.save(coupon);
    }

    @GetMapping("/coupons/{code}")
    public Coupon getCoupon(@PathVariable(name = "code") String code)
    {
        return couponRepo.findByCode(code);
    }
}
