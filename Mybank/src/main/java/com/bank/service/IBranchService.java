package com.bank.service;

import com.bank.entity.BranchEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface IBranchService {

    List<BranchEntity> getAllBranches();

    BranchEntity getBranchById(Long id);

    BranchEntity createBranch(BranchEntity branch);

    void deleteBranch(Long id);

    List<BranchEntity> searchBranchByName(String name);

    List<BranchEntity> searchBranchByCreationDateBetween(LocalDateTime from, LocalDateTime to);
}
