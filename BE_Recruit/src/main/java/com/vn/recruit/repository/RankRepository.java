package com.vn.recruit.repository;

import com.vn.recruit.entity.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankRepository extends JpaRepository<Rank,Long> {

    Rank findRankById(Long rankId);
}
