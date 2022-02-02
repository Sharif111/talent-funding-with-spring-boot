package com.user.app.repository;

import com.user.app.entity.BankEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepo extends JpaRepository<BankEntity,Long> {
}
