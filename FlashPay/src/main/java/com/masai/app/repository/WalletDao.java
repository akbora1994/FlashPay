package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.CurrentSessionUser;
import com.masai.model.Wallet;
@Repository
public interface WalletDao extends JpaRepository<Wallet, Integer>{

	public Optional<Wallet> findByWalletId(Integer  walletId);
}
